package com.khoshnaw.gateway.repoImpl.movie

import com.khoshnaw.entity.Movie
import com.khoshnaw.gateway.gatewayImp.MovieGatewayImp
import com.khoshnaw.gateway.localDataSource.MovieLocalDataSource
import com.khoshnaw.gateway.remoteDataSource.MovieRemoteDataSource
import io.mockk.MockKAnnotations
import io.mockk.Ordering
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class MovieGatewayImpTest {
    @MockK
    lateinit var movieRemoteDataSource: MovieRemoteDataSource

    @MockK
    lateinit var movieLocalDataSource: MovieLocalDataSource

    @InjectMockKs
    lateinit var gateway: MovieGatewayImp

    @Before
    fun setUp() = MockKAnnotations.init(this, relaxUnitFun = true)

    @Test
    fun `use remote data source to load movie list`() = runBlocking {
        coEvery { movieRemoteDataSource.loadMovieList() } returns DUMMY_MOVIE_REMOTE_LIST

        gateway.updateMovieList()

        coVerify(exactly = 1) { movieRemoteDataSource.loadMovieList() }
    }

    @Test
    fun `use local data source to update movie list`() = runBlocking {
        coEvery { movieRemoteDataSource.loadMovieList() } returns DUMMY_MOVIE_REMOTE_LIST

        gateway.updateMovieList()

        coVerify(exactly = 1) { movieLocalDataSource.updateMovieList(DUMMY_MOVIE_REMOTE_LIST) }
    }

    @Test
    fun `load movies from remote and update local`() = runBlocking {
        coEvery { movieRemoteDataSource.loadMovieList() } returns DUMMY_MOVIE_REMOTE_LIST

        gateway.updateMovieList()

        coVerify(ordering = Ordering.SEQUENCE) {
            movieRemoteDataSource.loadMovieList()
            movieLocalDataSource.updateMovieList(DUMMY_MOVIE_REMOTE_LIST)
        }
    }

    @Test
    fun `use local data source to observe movies`() = runBlocking {
        coEvery { movieLocalDataSource.observeMovies() } returns DUMMY_MOVIE_LIST_FLOW

        gateway.observeMovies()

        coVerify(exactly = 1) { movieLocalDataSource.observeMovies() }
    }

    companion object {
        private val DUMMY_MOVIE_REMOTE_LIST = listOf(
            Movie("", "", "", 0.0),
            Movie("", "", "", 0.0),
            Movie("", "", "", 0.0),
            Movie("", "", "", 0.0),
            Movie("", "", "", 0.0),
            Movie("", "", "", 0.0),
            Movie("", "", "", 0.0),
            Movie("", "", "", 0.0)
        )

        private val DUMMY_MOVIE_LIST_FLOW = flow {
            emit(DUMMY_MOVIE_REMOTE_LIST)
        }
    }

}
