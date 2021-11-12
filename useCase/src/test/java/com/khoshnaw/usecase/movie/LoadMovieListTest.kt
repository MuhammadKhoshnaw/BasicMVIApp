package com.khoshnaw.usecase.movie

import com.khoshnaw.entity.Movie
import com.khoshnaw.usecase.movie.gateway.MovieGateway
import com.khoshnaw.usecase.movie.loadMovieList.LoadMovieList
import com.khoshnaw.usecase.movie.loadMovieList.LoadMovieListOutputPort
import io.mockk.*
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class LoadMovieListTest {

    @RelaxedMockK
    lateinit var outputPort: LoadMovieListOutputPort

    @RelaxedMockK
    lateinit var movieGateway: MovieGateway

    @InjectMockKs
    lateinit var useCase: LoadMovieList

    @Before
    fun setUp() = MockKAnnotations.init(this)

    @Test
    fun `while loading movie show loading to user`() = runBlockingTest {
        useCase.startLoadingMovieList()
        verify { outputPort.showLoading(true) }
    }

    @Test
    fun `when loading movie started load from repository`() = runBlockingTest {
        coEvery { movieGateway.updateMovieList() } just Runs
        useCase.startLoadingMovieList()
        coVerify { movieGateway.updateMovieList() }
    }

    @Test
    fun `when movie loaded update output port`() = runBlockingTest {
        coEvery { movieGateway.updateMovieList() } just Runs
        useCase.startLoadingMovieList()
        coVerify { outputPort.updateMovieList(DUMMY_MOVIE_LIST) }
    }

    companion object {
        private val DUMMY_MOVIE_LIST = listOf(
            Movie("", "", "", 0.0),
            Movie("", "", "", 0.0),
            Movie("", "", "", 0.0),
            Movie("", "", "", 0.0),
            Movie("", "", "", 0.0),
            Movie("", "", "", 0.0),
            Movie("", "", "", 0.0),
            Movie("", "", "", 0.0)
        )
    }
}
