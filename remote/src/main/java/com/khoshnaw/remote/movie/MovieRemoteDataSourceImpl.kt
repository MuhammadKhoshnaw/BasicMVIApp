package com.khoshnaw.remote.movie

import com.khoshnaw.entity.Movie
import com.khoshnaw.remote.api.MovieApi
import com.khoshnaw.remote.util.bodyOrException
import com.khoshnaw.gateway.remoteDataSource.MovieRemoteDataSource
import com.khoshnaw.remote.mapper.toEntity
import javax.inject.Inject

class MovieRemoteDataSourceImpl @Inject constructor(
    private val movieApi: MovieApi
) : MovieRemoteDataSource {
    override suspend fun loadMovieList(): List<Movie> =
        movieApi.loadPostList().bodyOrException().movieList.toEntity()
}
