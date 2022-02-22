package com.khoshnaw.repository.local.dataSource

import com.khoshnaw.entity.Movie
import com.khoshnaw.repository.local.dto.MovieLocalDTO
import kotlinx.coroutines.flow.Flow

interface MovieLocalDataSource {
    suspend fun updateMovieList(movieList: List<MovieLocalDTO>)
    suspend fun observeMovies(): Flow<List<MovieLocalDTO>>
    suspend fun loadMovieSize(): Int
}
