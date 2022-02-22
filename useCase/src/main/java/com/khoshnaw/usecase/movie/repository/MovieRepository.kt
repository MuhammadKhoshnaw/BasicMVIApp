package com.khoshnaw.usecase.movie.repository

import com.khoshnaw.entity.Movie
import com.khoshnaw.usecase.movie.base.Repository
import kotlinx.coroutines.flow.Flow

interface MovieRepository : Repository {
    suspend fun updateMovieList()
    suspend fun observeMovies(): Flow<List<Movie>>
    suspend fun loadMovieSize(): Int
}
