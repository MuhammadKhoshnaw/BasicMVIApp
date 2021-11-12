package com.khoshnaw.gateway.localDataSource

import com.khoshnaw.entity.Movie

interface MovieLocalDataSource {
    suspend fun updateMovieList(movieList: List<Movie>)
}
