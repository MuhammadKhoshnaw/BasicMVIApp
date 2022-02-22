package com.khoshnaw.repository.local.mapper

import com.khoshnaw.repository.local.dto.MovieLocalDTO
import com.khoshnaw.entity.Movie

internal fun MovieLocalDTO.toEntity() = Movie(
    id = id,
    posterPath = posterPath,
    title = title,
    voteAverage = voteAverage,
)

internal fun List<MovieLocalDTO>.toEntity() = map { it.toEntity() }

internal fun Movie.toLocalDTO() = MovieLocalDTO(
    id = id,
    posterPath = posterPath,
    title = title,
    voteAverage = voteAverage,
)

internal fun List<Movie>.toLocalDTO() = map { it.toLocalDTO() }
