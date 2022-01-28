package com.khoshnaw.controller

import com.khoshnaw.controller.base.Controller
import com.khoshnaw.usecase.movie.base.InputPort
import com.khoshnaw.usecase.movie.base.OutputPort
import io.mockk.MockKAnnotations
import io.mockk.coVerify
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class ControllerTest {

    @MockK
    lateinit var inputPort: DummyInputPort

    @MockK
    lateinit var outputPort: DummyOutputPort

    @InjectMockKs
    lateinit var controller: DummyController

    @Before
    fun setup() {
        MockKAnnotations.init(this,  relaxUnitFun = true)
    }

    @Test
    fun `use input port to register outputPort`() = runTest {
        controller.registerOutputPort(outputPort)

        coVerify(exactly = 1) { inputPort.registerOutputPort(outputPort) }
    }

    companion object {
        interface DummyInputPort : InputPort<DummyOutputPort>
        interface DummyOutputPort : OutputPort

        class DummyController(
            override val inputPort: DummyInputPort
        ) : Controller<DummyInputPort, DummyOutputPort>()
    }
}
