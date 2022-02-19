package com.khoshnaw.viewmodel.mvi

import com.khoshnaw.controller.base.Controller
import com.khoshnaw.usecase.movie.base.InputPort
import com.khoshnaw.usecase.movie.base.OutputPort
import com.khoshnaw.viewmodel.standard.StandardViewModel
import io.mockk.MockKAnnotations
import io.mockk.coVerify
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class StandardViewModelTest {

    @MockK
    lateinit var controller1: DummyController1

    @MockK
    lateinit var controller2: DummyController2

    @MockK
    lateinit var controller3: DummyController3

    @MockK
    lateinit var controller4: DummyController4

    @MockK
    lateinit var controller5: DummyController5

    @InjectMockKs
    lateinit var viewModel: DummyViewModel

    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true)
    }

    @Test
    fun `on init register output port to all controllers`() = runTest {
        coVerify(exactly = 1) {
            controller1.registerOutputPort(outputPort = viewModel)
            controller2.registerOutputPort(outputPort = viewModel)
            controller3.registerOutputPort(outputPort = viewModel)
            controller4.registerOutputPort(outputPort = viewModel)
            controller5.registerOutputPort(outputPort = viewModel)
        }
    }

    @Test
    fun `on init consume flow`() = runTest {
        viewModel.intents.send(DummyIntent.DummyAction)

        coVerify(exactly = 1) { controller1.doSomeThing() }
    }


    companion object {

        interface DummyInputPort : InputPort<DummyOutputPort>
        interface DummyOutputPort : OutputPort
        class DummyController1(
            override val inputPort: DummyInputPort
        ) : Controller<DummyInputPort, DummyOutputPort>() {
            fun doSomeThing() = Unit
        }

        class DummyController2(
            override val inputPort: DummyInputPort
        ) : Controller<DummyInputPort, DummyOutputPort>()

        class DummyController3(
            override val inputPort: DummyInputPort
        ) : Controller<DummyInputPort, DummyOutputPort>()

        class DummyController4(
            override val inputPort: DummyInputPort
        ) : Controller<DummyInputPort, DummyOutputPort>()

        class DummyController5(
            override val inputPort: DummyInputPort
        ) : Controller<DummyInputPort, DummyOutputPort>()

        sealed class DummyIntent : MVIIntent {
            object DummyAction : DummyIntent()
        }

        sealed class DummyState : MVIState

        @Suppress("unused")
        class DummyViewModel(
            private val controller1: DummyController1,
            private val controller2: DummyController2,
            private val controller3: DummyController3,
            private val controller4: DummyController4,
            private val controller5: DummyController5,
        ) : StandardViewModel<DummyState, DummyIntent>(),
            DummyOutputPort {

            init {
                init()
            }

            public override suspend fun handleIntent(intent: DummyIntent) = when (intent) {
                DummyIntent.DummyAction -> controller1.doSomeThing()
            }
        }
    }
}
