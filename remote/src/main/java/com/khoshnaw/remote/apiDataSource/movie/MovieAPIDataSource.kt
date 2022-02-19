package com.khoshnaw.remote.apiDataSource.movie

import com.khoshnaw.entity.Movie
import com.khoshnaw.gateway.remoteDataSource.MovieRemoteDataSource
import com.khoshnaw.remote.api.MovieApi
import com.khoshnaw.remote.apiDataSource.base.APIDataSource
import com.khoshnaw.remote.mapper.toEntity
import com.khoshnaw.remote.util.bodyOrException
import javax.inject.Inject

class MovieAPIDataSource @Inject constructor(
    private val movieApi: MovieApi
) : APIDataSource(), MovieRemoteDataSource {
    override suspend fun loadMovieList(): List<Movie> =
        movieApi.loadMovieList().bodyOrException().movieList.toEntity()
}
