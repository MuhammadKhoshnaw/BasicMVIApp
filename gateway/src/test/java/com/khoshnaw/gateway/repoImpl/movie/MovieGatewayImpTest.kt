package com.khoshnaw.gateway.repoImpl.movie

import com.khoshnaw.entity.Movie
import com.khoshnaw.gateway.localDataSource.MovieLocalDataSource
import com.khoshnaw.gateway.remoteDataSource.MovieRemoteDataSource
import com.khoshnaw.gateway.repoImpl.MovieGatewayImp
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
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
    fun setUp() = MockKAnnotations.init(this)

    @Test
    fun `use remote data source to load new movies`() = runBlockingTest {
        coEvery { movieRemoteDataSource.loadMovieList() } returns DUMMY_MOVIE_REMOTE_LIST
        gateway.updateMovieList()
        coVerify { movieRemoteDataSource.loadMovieList() }
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
    }

}
