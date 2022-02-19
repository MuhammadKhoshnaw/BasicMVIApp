package com.khoshnaw.viewmodel.movies

import com.khoshnaw.controller.movie.MovieController
import io.mockk.MockKAnnotations
import io.mockk.coVerify
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class MoviesViewModelTest {

    @MockK
    lateinit var movieController: MovieController

    @InjectMockKs
    lateinit var viewModel: MoviesViewModel

    @Before
    fun setup() = MockKAnnotations.init(this, relaxUnitFun = true)

    @Test
    fun `use movie controller to refresh movies`() = runBlocking {
        viewModel.intents.send(MoviesIntent.RefreshMovies)

        coVerify { movieController.loadMoviesList() }
    }
}
