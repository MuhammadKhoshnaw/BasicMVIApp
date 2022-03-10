package com.khoshnaw.db.dbDataSource.movie

import com.khoshnaw.db.dao.MovieDao
import com.khoshnaw.db.dbDataSource.base.DBDataSource
import com.khoshnaw.repository.local.dataSource.MovieLocalDataSource
import com.khoshnaw.repository.local.dto.MovieLocalDTO
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieDBDataSource @Inject constructor(
    private val movieDao: MovieDao
) : DBDataSource(), MovieLocalDataSource {

    override suspend fun updateMovieList(movieList: List<MovieLocalDTO>): Unit =
        movieDao.insertAll(movieList)

    override suspend fun observeMovies(): Flow<List<MovieLocalDTO>> =
        movieDao.observeMovies()

    override suspend fun loadMovieSize(): Int = movieDao.loadMovieSize()
}
