package com.khoshnaw.remote.dto

import com.squareup.moshi.Json

data class MovieRemoteDTO(
    val id: String,
    @Json(name = "poster_path") val posterPath: String,
    @Json(name = "original_title") val title: String,
    @Json(name = "vote_average") val voteAverage: Double,
)
