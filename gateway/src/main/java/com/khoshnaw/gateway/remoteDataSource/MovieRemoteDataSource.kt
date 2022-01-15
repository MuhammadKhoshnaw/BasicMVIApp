package com.khoshnaw.gateway.remoteDataSource

import com.khoshnaw.entity.Movie

interface MovieRemoteDataSource {
    suspend fun loadMovieList(): List<Movie>
}
