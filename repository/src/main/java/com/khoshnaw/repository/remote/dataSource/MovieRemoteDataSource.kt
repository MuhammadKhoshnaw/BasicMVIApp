package com.khoshnaw.repository.remote.dataSource

import com.khoshnaw.repository.remote.dto.MovieRemoteDTO

interface MovieRemoteDataSource {
    suspend fun loadMovieList(): List<MovieRemoteDTO>
}
