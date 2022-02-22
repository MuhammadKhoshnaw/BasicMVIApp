package com.khoshnaw.remote.apiDataSource.movie

import com.khoshnaw.remote.api.MovieApi
import com.khoshnaw.remote.apiDataSource.base.APIDataSource
import com.khoshnaw.remote.util.bodyOrException
import com.khoshnaw.repository.remote.dataSource.MovieRemoteDataSource
import com.khoshnaw.repository.remote.dto.MovieRemoteDTO
import javax.inject.Inject

class MovieAPIDataSource @Inject constructor(
    private val movieApi: MovieApi
) : APIDataSource(), MovieRemoteDataSource {

    override suspend fun loadMovieList(
    ): List<MovieRemoteDTO> = movieApi.loadMovieList().bodyOrException().movieList

}
