package com.khoshnaw.ui.mapper

import com.khoshnaw.entity.Movie
import com.khoshnaw.ui.dto.MovieUIDTO

fun Movie.toDTO() = MovieUIDTO(
    id = id,
    posterPath = "https://image.tmdb.org/t/p/w500$posterPath",
    title = title,
    voteAverage = voteAverage.toString(),
)

fun List<Movie>.toDTO() = map { it.toDTO() }



