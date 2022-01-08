package com.khoshnaw.usecase.movie.gateway

import com.khoshnaw.entity.Movie
import kotlinx.coroutines.flow.Flow

interface MovieGateway {
    suspend fun updateMovieList()
    suspend fun observeMovies(): Flow<List<Movie>>
}
