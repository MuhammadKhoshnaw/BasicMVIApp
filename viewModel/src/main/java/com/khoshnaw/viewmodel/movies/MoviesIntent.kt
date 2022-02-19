package com.khoshnaw.viewmodel.movies

import com.khoshnaw.viewmodel.mvi.MVIIntent

sealed class MoviesIntent : MVIIntent {

    object RefreshMovies : MoviesIntent()

    class OnMovieClicked(
        val position: Int,
        val id: String,
    ) : MoviesIntent()

}
