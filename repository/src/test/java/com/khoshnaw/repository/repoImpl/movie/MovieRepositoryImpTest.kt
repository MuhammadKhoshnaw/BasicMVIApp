package com.khoshnaw.repository.repoImpl.movie

import com.khoshnaw.repository.local.dataSource.MovieLocalDataSource
import com.khoshnaw.repository.local.dummy.MovieLocalDTODummies
import com.khoshnaw.repository.remote.dataSource.MovieRemoteDataSource
import com.khoshnaw.repository.remote.dummy.MovieRemoteDTODummies
import com.khoshnaw.repository.repositoryImp.MovieRepositoryImp
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
class MovieRepositoryImpTest {
    @MockK
    lateinit var movieRemoteDataSource: MovieRemoteDataSource

    @MockK
    lateinit var movieLocalDataSource: MovieLocalDataSource

    @InjectMockKs
    lateinit var repository: MovieRepositoryImp

    @Before
    fun setUp() = MockKAnnotations.init(this, relaxUnitFun = true)

    @Test
    fun `use remote data source to load movie list`() = runBlocking {
        coEvery { movieRemoteDataSource.loadMovieList() } returns DUMMY_MOVIE_REMOTE_LIST

        repository.updateMovieList()

        coVerify(exactly = 1) { movieRemoteDataSource.loadMovieList() }
    }

    @Test
    fun `use local data source to update movie list`() = runBlocking {
        coEvery { movieRemoteDataSource.loadMovieList() } returns DUMMY_MOVIE_REMOTE_LIST

        repository.updateMovieList()

        coVerify(exactly = 1) { movieLocalDataSource.updateMovieList(DUMMY_MOVIE_LOCAL_LIST) }
    }

    @Test
    fun `load movies from remote and update local`() = runBlocking {
        coEvery { movieRemoteDataSource.loadMovieList() } returns DUMMY_MOVIE_REMOTE_LIST

        repository.updateMovieList()

        coVerify(ordering = Ordering.SEQUENCE) {
            movieRemoteDataSource.loadMovieList()
            movieLocalDataSource.updateMovieList(DUMMY_MOVIE_LOCAL_LIST)
        }
    }

    @Test
    fun `use local data source to observe movies`() = runBlocking {
        coEvery { movieLocalDataSource.observeMovies() } returns DUMMY_MOVIE_LIST_FLOW

        repository.observeMovies()

        coVerify(exactly = 1) { movieLocalDataSource.observeMovies() }
    }

    companion object {
        private val DUMMY_MOVIE_REMOTE_LIST = MovieRemoteDTODummies.dummyMovieRemoteDTOList
        private val DUMMY_MOVIE_LOCAL_LIST = MovieLocalDTODummies.dummyMovieLocalDTOList
        private val DUMMY_MOVIE_LIST_FLOW = flow {
            emit(DUMMY_MOVIE_LOCAL_LIST)
        }
    }
}
