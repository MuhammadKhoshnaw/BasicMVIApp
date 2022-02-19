package com.khoshnaw.db.movie

import com.google.common.truth.Truth
import com.khoshnaw.db.dummy.MovieLocalDTODummies
import com.khoshnaw.entity.MovieDummies
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class MovieDBDataSourceTest {

    @MockK
    lateinit var movieDao: MovieDao

    @InjectMockKs
    lateinit var dataSource: MovieDBDataSource

    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true)
    }

    @Test
    fun `use movieDao to update movies`() = runTest {
        dataSource.updateMovieList(DUMMY_MOVIE_LIST)

        verify(exactly = 1) { movieDao.insertAll(DUMMY_MOVIE_LOCAL_DTO_LIST) }
    }

    @Test
    fun `use movieDao to observe movies`() = runTest {
        every { movieDao.observeMovies() } returns DUMMY_MOVIE_LOCAL_DTO_LIST_FLOW

        val result = dataSource.observeMovies()

        verify(exactly = 1) { movieDao.observeMovies() }
        Truth.assertThat(result.toList()).isEqualTo(DUMMY_MOVIE_LIST_FLOW.toList())
    }

    companion object {
        private val DUMMY_MOVIE_LIST = MovieDummies.dummyMovieList
        private val DUMMY_MOVIE_LOCAL_DTO_LIST = MovieLocalDTODummies.dummyMovieLocalDTOList

        private val DUMMY_MOVIE_LOCAL_DTO_LIST_FLOW = flow {
            emit(DUMMY_MOVIE_LOCAL_DTO_LIST)
        }

        private val DUMMY_MOVIE_LIST_FLOW = flow {
            emit(DUMMY_MOVIE_LIST)
        }
    }
}
