package com.khoshnaw.db.movie

import com.khoshnaw.db.mapper.toEntity
import com.khoshnaw.db.mapper.toLocalDTO
import com.khoshnaw.entity.Movie
import com.khoshnaw.gateway.localDataSource.MovieLocalDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MovieDBDataSource @Inject constructor(
    private val movieDao: MovieDao
) : MovieLocalDataSource {

    override suspend fun updateMovieList(movieList: List<Movie>): Unit =
        movieDao.insertAll(movieList.toLocalDTO())

    override suspend fun observeMovies(): Flow<List<Movie>> =
        movieDao.observeMovies().map { it.toEntity() }

    override suspend fun loadMovieSize(): Int = movieDao.loadMovieSize()
}
