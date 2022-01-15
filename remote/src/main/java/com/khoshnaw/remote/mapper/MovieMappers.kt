package com.khoshnaw.remote.mapper

import com.khoshnaw.entity.Movie
import com.khoshnaw.remote.dto.MovieRemoteDTO

fun MovieRemoteDTO.toEntity() = Movie(
    id = id,
    posterPath = posterPath,
    title = title,
    voteAverage = voteAverage,
)

fun List<MovieRemoteDTO>.toEntity() = map { it.toEntity() }
