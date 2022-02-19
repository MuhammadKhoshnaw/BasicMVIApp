package com.khoshnaw.viewmodel.mapper

import com.khoshnaw.entity.Movie
import com.khoshnaw.viewmodel.BuildConfig
import com.khoshnaw.viewmodel.dto.MovieUIDTO

internal fun Movie.toDTO() = MovieUIDTO(
    id = id,
    posterPath = BuildConfig.TMDB_API_BASE_IMG_URL + posterPath,
    title = title,
    voteAverage = voteAverage.toString(),
)

internal fun List<Movie>.toDTO() = map { it.toDTO() }
