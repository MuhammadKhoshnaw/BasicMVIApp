package com.khoshnaw.usecase.movie.base

import com.google.common.truth.Truth
import com.google.common.truth.Truth.assertThat
import io.mockk.MockKAnnotations
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.SpyK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class UseCaseTest {

    @MockK
    lateinit var outputPort: DummyOutputPort

    @SpyK
    var useCase = DummyUseCase()

    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true)
    }

    @Test
    fun `when output port is registered call on ready`() = runBlocking {
        useCase.registerOutputPort(outputPort)

        coVerify { useCase.onReady() }
    }

    @Test
    fun `when output port is registered, outputPort is available`() = runBlocking {
        useCase.registerOutputPort(outputPort)

        assertThat(useCase.registeredOutputPort).isEqualTo(outputPort)
    }

    @Test
    fun `when onReady Called and output not registered throw exception`() = runBlocking {
        var exception: Exception? = null

        try {
            useCase.onReady()
        } catch (e: Exception) {
            exception = e
        }

        assertThat(exception).isInstanceOf(UninitializedPropertyAccessException::class.java)
    }

    companion object {
        interface DummyOutputPort : OutputPort

        interface DummyInputPort : InputPort<DummyOutputPort>

        class DummyUseCase : UseCase<DummyOutputPort>(), DummyInputPort {
            lateinit var registeredOutputPort: OutputPort

            public override suspend fun onReady() {
                super.onReady()
                registeredOutputPort = outputPort
            }
        }
    }
}
