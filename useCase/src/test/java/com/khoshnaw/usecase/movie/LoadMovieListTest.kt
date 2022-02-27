package com.khoshnaw.usecase.movie

import com.google.common.truth.Truth
import com.khoshnaw.entity.MovieDummies
import com.khoshnaw.exception.ExceptionDummies
import com.khoshnaw.usecase.movie.loadMovieList.LoadMovieList
import com.khoshnaw.usecase.movie.loadMovieList.LoadMovieListOutputPort
import com.khoshnaw.usecase.movie.repository.MovieRepository
import io.mockk.MockKAnnotations
import io.mockk.Ordering
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class LoadMovieListTest {

    @RelaxedMockK
    lateinit var outputPort: LoadMovieListOutputPort

    @RelaxedMockK
    lateinit var movieRepository: MovieRepository

    @InjectMockKs
    lateinit var useCase: LoadMovieList

    @Before
    fun setUp() = MockKAnnotations.init(this)

    @Test
    fun `when usecase is ready, start observing movies`() = runTest {
        coEvery { movieRepository.observeMovies() } returns DUMMY_MOVIE_LIST_FLOW

        useCase.registerOutputPort(outputPort)

        coVerify(exactly = 1) {
            movieRepository.observeMovies()
            outputPort.startObserveMovies(DUMMY_MOVIE_LIST_FLOW)
        }
    }

    @Test
    fun `when usecase is ready, and there is no local movies, load new movies`() = runTest {
        coEvery { movieRepository.loadMovieSize() } returns 0
        coEvery { movieRepository.observeMovies() } returns DUMMY_MOVIE_LIST_FLOW

        useCase.registerOutputPort(outputPort)

        coVerify(exactly = 1) { movieRepository.loadMovieSize() }
        coVerify(
            ordering = Ordering.ORDERED
        ) {
            outputPort.showLoading(true)
            movieRepository.updateMovieList()
            outputPort.showLoading(false)
        }
    }

    @Test
    fun `when usecase is ready, and there is some local movies, do nothing`() = runTest {
        coEvery { movieRepository.loadMovieSize() } returns 10
        coEvery { movieRepository.observeMovies() } returns DUMMY_MOVIE_LIST_FLOW

        useCase.registerOutputPort(outputPort)

        coVerify(exactly = 1) { movieRepository.loadMovieSize() }
        coVerify(exactly = 0) {
            outputPort.showLoading(any())
            movieRepository.updateMovieList()
        }
    }

    @Test
    fun `on start loading movies, show loading, then update movies, then hide loading`() = runTest {
        useCase.startUpdatingMovieList()

        coVerify(
            ordering = Ordering.SEQUENCE
        ) {
            outputPort.showLoading(true)
            movieRepository.updateMovieList()
            outputPort.showLoading(false)
        }
    }

    @Test
    fun `if update failed hide loading and throw the exception`() = runTest {
        coEvery { movieRepository.updateMovieList() } throws DUMMY_EXCEPTION

        var result: Exception? = null
        try {
            useCase.startUpdatingMovieList()
        } catch (e: Exception) {
            result = e
        }

        Truth.assertThat(result).isEqualTo(DUMMY_EXCEPTION)
        coVerify(
            ordering = Ordering.SEQUENCE
        ) {
            outputPort.showLoading(true)
            movieRepository.updateMovieList()
            outputPort.showLoading(false)
        }
    }

    companion object {
        private val DUMMY_MOVIE_LIST = MovieDummies.dummyMovieList
        private val DUMMY_MOVIE_LIST_FLOW = flow {
            emit(DUMMY_MOVIE_LIST)
        }

        private val DUMMY_EXCEPTION = ExceptionDummies.dummyException
    }
}
