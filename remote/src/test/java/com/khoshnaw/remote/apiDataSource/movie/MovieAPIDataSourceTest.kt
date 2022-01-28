package com.khoshnaw.remote.apiDataSource.movie

import com.google.common.truth.Truth
import com.khoshnaw.entity.MovieDummies
import com.khoshnaw.remote.api.MovieApi
import com.khoshnaw.remote.dummy.GetMoviesResponseDummies
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import retrofit2.Response

@ExperimentalCoroutinesApi
class MovieAPIDataSourceTest {

    @MockK
    lateinit var movieApi: MovieApi

    @InjectMockKs
    lateinit var dataSource: MovieAPIDataSource

    @Before
    fun setUp() = MockKAnnotations.init(this, relaxUnitFun = true)

    @Test
    fun `use movie api to load movie list`() = runTest {
        coEvery { movieApi.loadMovieList() } returns Response.success(DUMMY_GET_MOVIES_RESPONSE)

        val result = dataSource.loadMovieList()

        coVerify(exactly = 1) { movieApi.loadMovieList() }
        Truth.assertThat(result).isEqualTo(DUMMY_MOVIE_LIST)
    }

    companion object {
        private val DUMMY_GET_MOVIES_RESPONSE = GetMoviesResponseDummies.dummyGetMoviesResponse
        private val DUMMY_MOVIE_LIST = MovieDummies.dummyMovieList
    }

}
