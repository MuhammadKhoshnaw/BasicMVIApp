package com.khoshnaw.db.movie

import com.khoshnaw.db.mapper.toLocalDTO
import com.khoshnaw.entity.Movie
import com.khoshnaw.gateway.localDataSource.MovieLocalDataSource
import javax.inject.Inject

class MovieLocalDataSourceImpl @Inject constructor(
    private val movieDao: MovieDao
) : MovieLocalDataSource {

    override suspend fun updateMovieList(movieList: List<Movie>) =
        movieDao.insertAll(movieList.toLocalDTO())
}
