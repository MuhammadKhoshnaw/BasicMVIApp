package com.khoshnaw.controller

import com.khoshnaw.controller.movie.MovieController
import com.khoshnaw.usecase.movie.loadMovieList.LoadMovieListInputPort
import io.mockk.MockKAnnotations
import io.mockk.coVerify
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class MovieControllerTest {

    @MockK
    lateinit var inputPort: LoadMovieListInputPort

    @InjectMockKs()
    lateinit var controller: MovieController

    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true)
    }

    @Test
    fun `use input port to load movies list`() = runTest {
        controller.loadMoviesList()

        coVerify(exactly = 1) { inputPort.startUpdatingMovieList() }
    }

}
