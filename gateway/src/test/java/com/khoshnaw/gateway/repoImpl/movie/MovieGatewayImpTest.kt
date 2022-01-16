package com.khoshnaw.gateway.repoImpl.movie

import com.khoshnaw.entity.Movie
import com.khoshnaw.gateway.localDataSource.MovieLocalDataSource
import com.khoshnaw.gateway.remoteDataSource.MovieRemoteDataSource
import com.khoshnaw.gateway.repoImpl.MovieGatewayImp
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before

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
