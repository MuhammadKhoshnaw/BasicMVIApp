package com.khoshnaw.viewmodel.movies

import com.khoshnaw.entity.Movie
import com.khoshnaw.viewmodel.mvi.MVIIntent

sealed class MoviesIntent : MVIIntent {

    object RefreshMovies : MoviesIntent()

    class OnMovieClicked(val movie: Movie) : MoviesIntent()

}
