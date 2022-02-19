package com.khoshnaw.viewmodel.movies

import com.khoshnaw.viewmodel.dto.MovieUIDTO
import com.khoshnaw.viewmodel.mvi.MVIState

sealed class MoviesState(
    open val movies: List<MovieUIDTO> = listOf(),
) : MVIState {

    class MovieList(
        override val movies: List<MovieUIDTO>,
        val isLoading: Boolean = false
    ) : MoviesState(movies)

}
