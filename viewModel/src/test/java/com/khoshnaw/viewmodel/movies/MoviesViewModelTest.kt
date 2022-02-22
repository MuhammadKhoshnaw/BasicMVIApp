package com.khoshnaw.viewmodel.movies

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.viewModelScope
import com.khoshnaw.usecase.movie.loadMovieList.LoadMovieListInputPort
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
class MoviesViewModelTest {

    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val coroutinesDispatcherRule = CoroutineTestRule()

    @MockK
    lateinit var loadMovieListInputPort: LoadMovieListInputPort

    @InjectMockKs
    lateinit var viewModel: MoviesViewModel

    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        viewModel.viewModelScope
    }

    @Test
    fun `use movie controller to refresh movies`() = runTest(StandardTestDispatcher()) {
        viewModel.intents.send(MoviesIntent.RefreshMovies)

        coVerify { loadMovieListInputPort.startUpdatingMovieList() }
    }
}
