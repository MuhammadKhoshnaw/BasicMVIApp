package com.khoshnaw.repository.repositoryImp

import com.khoshnaw.repository.base.RepositoryImp
import com.khoshnaw.repository.local.dataSource.MovieLocalDataSource
import com.khoshnaw.repository.local.mapper.toEntity
import com.khoshnaw.repository.local.mapper.toLocalDTO
import com.khoshnaw.repository.remote.dataSource.MovieRemoteDataSource
import com.khoshnaw.repository.remote.mapper.toEntity
import com.khoshnaw.usecase.movie.repository.MovieRepository
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MovieRepositoryImp @Inject constructor(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
) : RepositoryImp(), MovieRepository {

    override suspend fun updateMovieList() = movieLocalDataSource.updateMovieList(
        movieRemoteDataSource.loadMovieList().toEntity().toLocalDTO()
    )

    override suspend fun observeMovies() = movieLocalDataSource.observeMovies().map {
        it.toEntity()
    }

    override suspend fun loadMovieSize(): Int = movieLocalDataSource.loadMovieSize()

}
