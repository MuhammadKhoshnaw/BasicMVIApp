package com.khoshnaw.repository.remote.dummy

import com.khoshnaw.entity.MovieDummies
import com.khoshnaw.repository.remote.dto.MovieRemoteDTO

@Suppress("MemberVisibilityCanBePrivate", "unused")
object MovieRemoteDTODummies {

    val dummyMovieRemoteDTO = MovieRemoteDTO(
        id = MovieDummies.dummyMovie.id,
        posterPath = MovieDummies.dummyMovie.posterPath,
        title = MovieDummies.dummyMovie.title,
        voteAverage = MovieDummies.dummyMovie.voteAverage
    )

    val dummyMovieRemoteDTO1 = MovieRemoteDTO(
        id = MovieDummies.dummyMovie1.id,
        posterPath = MovieDummies.dummyMovie1.posterPath,
        title = MovieDummies.dummyMovie1.title,
        voteAverage = MovieDummies.dummyMovie1.voteAverage
    )

    val dummyMovieRemoteDTO2 = MovieRemoteDTO(
        id = MovieDummies.dummyMovie2.id,
        posterPath = MovieDummies.dummyMovie2.posterPath,
        title = MovieDummies.dummyMovie2.title,
        voteAverage = MovieDummies.dummyMovie2.voteAverage
    )

    val dummyMovieRemoteDTO3 = MovieRemoteDTO(
        id = MovieDummies.dummyMovie3.id,
        posterPath = MovieDummies.dummyMovie3.posterPath,
        title = MovieDummies.dummyMovie3.title,
        voteAverage = MovieDummies.dummyMovie3.voteAverage
    )

    val dummyMovieRemoteDTO4 = MovieRemoteDTO(
        id = MovieDummies.dummyMovie4.id,
        posterPath = MovieDummies.dummyMovie4.posterPath,
        title = MovieDummies.dummyMovie4.title,
        voteAverage = MovieDummies.dummyMovie4.voteAverage
    )

    val dummyMovieRemoteDTO5 = MovieRemoteDTO(
        id = MovieDummies.dummyMovie5.id,
        posterPath = MovieDummies.dummyMovie5.posterPath,
        title = MovieDummies.dummyMovie5.title,
        voteAverage = MovieDummies.dummyMovie5.voteAverage
    )

    val dummyMovieRemoteDTOList = listOf(
        dummyMovieRemoteDTO,
        dummyMovieRemoteDTO1,
        dummyMovieRemoteDTO2,
        dummyMovieRemoteDTO3,
        dummyMovieRemoteDTO4,
        dummyMovieRemoteDTO5,
    )

}
