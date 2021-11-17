package com.khoshnaw.remote.api

import com.khoshnaw.remote.movie.GetMoviesResponse
import retrofit2.Response
import retrofit2.http.GET

interface MovieApi {
    @GET("movie/popular")
    suspend fun loadPostList(): Response<GetMoviesResponse>
}