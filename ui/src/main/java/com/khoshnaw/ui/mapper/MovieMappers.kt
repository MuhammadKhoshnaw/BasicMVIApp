package com.khoshnaw.ui.mapper

import com.khoshnaw.entity.Movie
import com.khoshnaw.ui.BuildConfig
import com.khoshnaw.ui.dto.MovieUIDTO

fun Movie.toDTO() = MovieUIDTO(
    id = id,
    posterPath = BuildConfig.TMDB_API_BASE_IMG_URL + posterPath,
    title = title,
    voteAverage = voteAverage.toString(),
)

fun List<Movie>.toDTO() = map { it.toDTO() }



