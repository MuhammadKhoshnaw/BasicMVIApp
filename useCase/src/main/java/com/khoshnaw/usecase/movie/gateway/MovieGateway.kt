package com.khoshnaw.usecase.movie.gateway

import com.khoshnaw.entity.Movie
import com.khoshnaw.usecase.movie.base.Gateway
import kotlinx.coroutines.flow.Flow

interface MovieGateway : Gateway {
    suspend fun updateMovieList()
    suspend fun observeMovies(): Flow<List<Movie>>
    suspend fun loadMovieSize(): Int
}
