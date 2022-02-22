package com.khoshnaw.repository.local.dummy

import com.khoshnaw.repository.local.dto.MovieLocalDTO
import com.khoshnaw.entity.MovieDummies.dummyMovie
import com.khoshnaw.entity.MovieDummies.dummyMovie1
import com.khoshnaw.entity.MovieDummies.dummyMovie2
import com.khoshnaw.entity.MovieDummies.dummyMovie3
import com.khoshnaw.entity.MovieDummies.dummyMovie4
import com.khoshnaw.entity.MovieDummies.dummyMovie5

@Suppress("MemberVisibilityCanBePrivate", "unused")
object MovieLocalDTODummies {

    val dummyMovieLocalDTO = MovieLocalDTO(
        id = dummyMovie.id,
        posterPath = dummyMovie.posterPath,
        title = dummyMovie.title,
        voteAverage = dummyMovie.voteAverage
    )

    val dummyMovieLocalDTO1 = MovieLocalDTO(
        id = dummyMovie1.id,
        posterPath = dummyMovie1.posterPath,
        title = dummyMovie1.title,
        voteAverage = dummyMovie1.voteAverage
    )

    val dummyMovieLocalDTO2 = MovieLocalDTO(
        id = dummyMovie2.id,
        posterPath = dummyMovie2.posterPath,
        title = dummyMovie2.title,
        voteAverage = dummyMovie2.voteAverage
    )

    val dummyMovieLocalDTO3 = MovieLocalDTO(
        id = dummyMovie3.id,
        posterPath = dummyMovie3.posterPath,
        title = dummyMovie3.title,
        voteAverage = dummyMovie3.voteAverage
    )

    val dummyMovieLocalDTO4 = MovieLocalDTO(
        id = dummyMovie4.id,
        posterPath = dummyMovie4.posterPath,
        title = dummyMovie4.title,
        voteAverage = dummyMovie4.voteAverage
    )

    val dummyMovieLocalDTO5 = MovieLocalDTO(
        id = dummyMovie5.id,
        posterPath = dummyMovie5.posterPath,
        title = dummyMovie5.title,
        voteAverage = dummyMovie5.voteAverage
    )

    val dummyMovieLocalDTOList = listOf(
        dummyMovieLocalDTO,
        dummyMovieLocalDTO1,
        dummyMovieLocalDTO2,
        dummyMovieLocalDTO3,
        dummyMovieLocalDTO4,
        dummyMovieLocalDTO5,
    )
}
