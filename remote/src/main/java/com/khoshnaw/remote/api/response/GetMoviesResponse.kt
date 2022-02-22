package com.khoshnaw.remote.api.response

import com.khoshnaw.repository.remote.dto.MovieRemoteDTO
import com.squareup.moshi.Json

data class GetMoviesResponse(
    val page: Int,
    @Json(name = "total_results") val totalResults: Int,
    @Json(name = "total_pages") val totalPages: Int,
    @Json(name = "results") val movieList: List<MovieRemoteDTO>,
)
