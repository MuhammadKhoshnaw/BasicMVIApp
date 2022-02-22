package com.khoshnaw.viewmodel.mvi

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.khoshnaw.usecase.movie.base.InputPort
import com.khoshnaw.usecase.movie.base.OutputPort
import com.khoshnaw.viewmodel.standard.StandardViewModel
import com.khoshnaw.viewmodel.util.CoroutineTestRule
import io.mockk.MockKAnnotations
import io.mockk.coVerify
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

@ExperimentalCoroutinesApi
class StandardViewModelTest {

    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val coroutinesDispatcherRule = CoroutineTestRule()

    @MockK
    lateinit var controller1: DummyInputPort1

    @MockK
    lateinit var controller2: DummyInputPort2

    @MockK
    lateinit var controller3: DummyInputPort3

    @MockK
    lateinit var controller4: DummyInputPort4

    @MockK
    lateinit var controller5: DummyInputPort5

    @InjectMockKs
    lateinit var viewModel: DummyViewModel

    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true)
    }

    @Test
    fun `on init register output port to all controllers`() = runTest(StandardTestDispatcher()) {
        coVerify(exactly = 1) {
            controller1.registerOutputPort(outputPort = viewModel)
            controller2.registerOutputPort(outputPort = viewModel)
            controller3.registerOutputPort(outputPort = viewModel)
            controller4.registerOutputPort(outputPort = viewModel)
            controller5.registerOutputPort(outputPort = viewModel)
        }
    }

    @Test
    fun `on init consume flow`() = runTest(StandardTestDispatcher()) {
        viewModel.intents.send(DummyIntent.DummyAction)

        coVerify(exactly = 1) { controller1.doSomeThing() }
    }


    companion object {

        interface DummyOutputPort : OutputPort

        abstract class BaseDummyInputPort : InputPort<DummyOutputPort> {
            override suspend fun registerOutputPort(outputPort: DummyOutputPort) = Unit

        }

        class DummyInputPort1 : BaseDummyInputPort() {
            fun doSomeThing() = Unit
        }

        class DummyInputPort2 : BaseDummyInputPort()

        class DummyInputPort3 : BaseDummyInputPort()

        class DummyInputPort4 : BaseDummyInputPort()

        class DummyInputPort5 : BaseDummyInputPort()

        sealed class DummyIntent : MVIIntent {
            object DummyAction : DummyIntent()
        }

        sealed class DummyState : MVIState

        @Suppress("unused")
        class DummyViewModel(
            private val inputPort1: DummyInputPort1,
            private val inputPort2: DummyInputPort2,
            private val inputPort3: DummyInputPort3,
            private val inputPort4: DummyInputPort4,
            private val inputPort5: DummyInputPort5,
        ) : StandardViewModel<DummyState, DummyIntent>(),
            DummyOutputPort {

            public override suspend fun handleIntent(intent: DummyIntent) = when (intent) {
                DummyIntent.DummyAction -> inputPort1.doSomeThing()
            }
        }
    }
}
