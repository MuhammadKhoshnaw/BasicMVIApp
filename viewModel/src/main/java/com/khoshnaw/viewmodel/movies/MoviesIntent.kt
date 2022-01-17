package com.khoshnaw.viewmodel.movies

import com.khoshnaw.viewmodel.mvi.Intent

sealed class MoviesIntent : Intent {
    object RefreshMovies : MoviesIntent()
}
