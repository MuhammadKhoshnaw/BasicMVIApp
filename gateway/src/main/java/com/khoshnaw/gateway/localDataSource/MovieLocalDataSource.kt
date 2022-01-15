package com.khoshnaw.gateway.localDataSource

import com.khoshnaw.entity.Movie
import kotlinx.coroutines.flow.Flow

interface MovieLocalDataSource {
    suspend fun updateMovieList(movieList: List<Movie>)
    suspend fun observeMovies(): Flow<List<Movie>>
}
