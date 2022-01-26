package com.khoshnaw.viewmodel.movies

import com.khoshnaw.entity.Movie
import com.khoshnaw.viewmodel.mvi.MVIState

sealed class MoviesState(
    open val movies: List<Movie>
) : MVIState {

    class MovieList(
        override val movies: List<Movie>,
        val isLoading: Boolean = false
    ) : MoviesState(movies)

}
