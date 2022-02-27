package com.khoshnaw.viewmodel.dummy

import com.khoshnaw.entity.MovieDummies
import com.khoshnaw.viewmodel.BuildConfig
import com.khoshnaw.viewmodel.dto.MovieUIDTO

@Suppress("MemberVisibilityCanBePrivate", "unused")
object MovieUIDTODummies {

    val dummyMovieUIDTO = MovieUIDTO(
        id = MovieDummies.dummyMovie.id,
        posterPath = BuildConfig.TMDB_API_BASE_IMG_URL + MovieDummies.dummyMovie.posterPath,
        title = MovieDummies.dummyMovie.title,
        voteAverage = MovieDummies.dummyMovie.voteAverage.toString()
    )

    val dummyMovieUIDTO1 = MovieUIDTO(
        id = MovieDummies.dummyMovie1.id,
        posterPath = BuildConfig.TMDB_API_BASE_IMG_URL + MovieDummies.dummyMovie1.posterPath,
        title = MovieDummies.dummyMovie1.title,
        voteAverage = MovieDummies.dummyMovie1.voteAverage.toString()
    )

    val dummyMovieUIDTO2 = MovieUIDTO(
        id = MovieDummies.dummyMovie2.id,
        posterPath = BuildConfig.TMDB_API_BASE_IMG_URL + MovieDummies.dummyMovie2.posterPath,
        title = MovieDummies.dummyMovie2.title,
        voteAverage = MovieDummies.dummyMovie2.voteAverage.toString()
    )

    val dummyMovieUIDTO3 = MovieUIDTO(
        id = MovieDummies.dummyMovie3.id,
        posterPath = BuildConfig.TMDB_API_BASE_IMG_URL + MovieDummies.dummyMovie3.posterPath,
        title = MovieDummies.dummyMovie3.title,
        voteAverage = MovieDummies.dummyMovie3.voteAverage.toString()
    )

    val dummyMovieUIDTO4 = MovieUIDTO(
        id = MovieDummies.dummyMovie4.id,
        posterPath = BuildConfig.TMDB_API_BASE_IMG_URL + MovieDummies.dummyMovie4.posterPath,
        title = MovieDummies.dummyMovie4.title,
        voteAverage = MovieDummies.dummyMovie4.voteAverage.toString()
    )

    val dummyMovieUIDTO5 = MovieUIDTO(
        id = MovieDummies.dummyMovie5.id,
        posterPath = BuildConfig.TMDB_API_BASE_IMG_URL + MovieDummies.dummyMovie5.posterPath,
        title = MovieDummies.dummyMovie5.title,
        voteAverage = MovieDummies.dummyMovie5.voteAverage.toString()
    )

    val dummyMovieUIDTOList = listOf(
        dummyMovieUIDTO,
        dummyMovieUIDTO1,
        dummyMovieUIDTO2,
        dummyMovieUIDTO3,
        dummyMovieUIDTO4,
        dummyMovieUIDTO5,
    )
}
