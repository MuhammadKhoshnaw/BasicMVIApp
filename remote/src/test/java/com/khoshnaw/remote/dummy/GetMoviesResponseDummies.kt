package com.khoshnaw.remote.dummy

import com.khoshnaw.remote.api.response.GetMoviesResponse

object GetMoviesResponseDummies {

    private val dummyMovieRemoteDTOList = MovieRemoteDTODummies.dummyMovieRemoteDTOList

    val dummyGetMoviesResponse = GetMoviesResponse(
        page = 1,
        totalResults = 100,
        totalPages = 10,
        movieList = dummyMovieRemoteDTOList
    )

}
