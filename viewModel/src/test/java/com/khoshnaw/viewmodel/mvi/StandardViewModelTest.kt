package com.khoshnaw.viewmodel.mvi

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth
import com.khoshnaw.entity.ErrorMessage
import com.khoshnaw.entity.ErrorMessageDummies
import com.khoshnaw.exception.ExceptionDummies
import com.khoshnaw.usecase.movie.base.InputPort
import com.khoshnaw.usecase.movie.base.OutputPort
import com.khoshnaw.viewmodel.standard.StandardViewModel
import com.khoshnaw.viewmodel.util.CoroutineTestRule
import io.mockk.MockKAnnotations
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import io.mockk.mockkObject
import io.mockk.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import timber.log.Timber
import kotlin.coroutines.CoroutineContext

@ExperimentalCoroutinesApi
class StandardViewModelTest {

    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val coroutinesDispatcherRule = CoroutineTestRule()

    @MockK
    lateinit var inputPort1: DummyInputPort1

    @MockK
    lateinit var inputPort2: DummyInputPort2

    @MockK
    lateinit var inputPort3: DummyInputPort3

    @MockK
    lateinit var inputPort4: DummyInputPort4

    @MockK
    lateinit var inputPort5: DummyInputPort5

    lateinit var viewModel: DummyViewModel

    private val dispatcher = coroutinesDispatcherRule.dispatcher

    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        mockkObject(Timber)

        viewModel = DummyViewModel(
            backgroundDispatcher = dispatcher,
            inputPort1 = inputPort1,
            inputPort2 = inputPort2,
            inputPort3 = inputPort3,
            inputPort4 = inputPort4,
            inputPort5 = inputPort5,
        )
    }

    //region intent
    @Test
    fun `on calling intents, consume flow`() = runTest {
        viewModel.intents.send(DummyIntent.DummyAction)
        coVerify(exactly = 1) { inputPort1.doSomeThing() }
    }
    //endregion intent

    //region injection
    @Test
    fun `on init, register output port to all inputPorts`() = runTest {
        delay(100)
        coVerify(exactly = 1) {
            inputPort1.registerOutputPort(outputPort = viewModel)
            inputPort2.registerOutputPort(outputPort = viewModel)
            inputPort3.registerOutputPort(outputPort = viewModel)
            inputPort4.registerOutputPort(outputPort = viewModel)
            inputPort5.registerOutputPort(outputPort = viewModel)
        }
    }
    //endregion injection

    //region error
    @Test
    fun `on update exception error, update error channel`() = runTest {
        viewModel.updateError(Exception())

        val result = viewModel.error.receive()

        Truth.assertThat(result).isEqualTo(ErrorMessage.DEFAULT)
    }

    @Test
    fun `on update message error, update error channel with the message`() = runTest {
        viewModel.updateError(DUMMY_ERROR_MESSAGE)

        val result = viewModel.error.receive()

        Truth.assertThat(result).isEqualTo(DUMMY_ERROR_MESSAGE)
    }
    //endregion error

    //region utils
    @Test
    fun `when some thing go wrong in tryTo callback, update error state`() = runTest {
        viewModel.tryToDoSomeThingWrong(DUMMY_EXCEPTION)

        val result = viewModel.error.receive()
        Truth.assertThat(result).isEqualTo(ErrorMessage.DEFAULT)
    }

    @Test
    fun `when some thing go wrong in tryTo callback, log the error`() = runTest {
        viewModel.tryToDoSomeThingWrong(DUMMY_EXCEPTION)

        verify { Timber.e(DUMMY_EXCEPTION) }
    }

    //endregion utils

    companion object {
        private val DUMMY_ERROR_MESSAGE = ErrorMessageDummies.dummyErrorMessage
        private val DUMMY_EXCEPTION = ExceptionDummies.dummyException

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
            backgroundDispatcher: CoroutineContext,
            private val inputPort1: DummyInputPort1,
            private val inputPort2: DummyInputPort2,
            private val inputPort3: DummyInputPort3,
            private val inputPort4: DummyInputPort4,
            private val inputPort5: DummyInputPort5,
        ) : StandardViewModel<DummyState, DummyIntent>(backgroundDispatcher),
            DummyOutputPort {

            public override suspend fun handleIntent(intent: DummyIntent) = when (intent) {
                DummyIntent.DummyAction -> inputPort1.doSomeThing()
            }

            suspend fun tryToDoSomeThingWrong(exception: Exception) = tryTo {
                throw exception
            }
        }
    }
}
