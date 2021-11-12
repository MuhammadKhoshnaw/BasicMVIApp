package com.khoshnaw.db.mapper

import com.khoshnaw.db.dto.MovieLocalDTO
import com.khoshnaw.entity.Movie

fun MovieLocalDTO.toEntity() = Movie(
    id = id,
    posterPath = posterPath,
    title = title,
    voteAverage = voteAverage,
)

fun List<MovieLocalDTO>.toEntity() = map { it.toEntity() }

fun Movie.toLocalDTO() = MovieLocalDTO(
    id = id,
    posterPath = posterPath,
    title = title,
    voteAverage = voteAverage,
)

fun List<Movie>.toLocalDTO() = map { it.toLocalDTO() }



