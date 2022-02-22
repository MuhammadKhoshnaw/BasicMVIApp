package com.khoshnaw.repository.remote.mapper

import com.khoshnaw.entity.Movie
import com.khoshnaw.repository.remote.dto.MovieRemoteDTO

internal fun MovieRemoteDTO.toEntity() = Movie(
    id = id,
    posterPath = posterPath,
    title = title,
    voteAverage = voteAverage,
)

internal fun List<MovieRemoteDTO>.toEntity() = map { it.toEntity() }
