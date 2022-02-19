package com.khoshnaw.remote.api

import com.khoshnaw.remote.apiDataSource.movie.GetMoviesResponse
import retrofit2.Response
import retrofit2.http.GET

interface MovieApi {
    @GET("movie/popular")
    suspend fun loadMovieList(): Response<GetMoviesResponse>
}
