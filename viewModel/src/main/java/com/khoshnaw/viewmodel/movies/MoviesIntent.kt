package com.khoshnaw.viewmodel.movies

import com.khoshnaw.viewmodel.mvi.MVIIntent

sealed class MoviesIntent : MVIIntent {
    object RefreshMovies : MoviesIntent()
}
