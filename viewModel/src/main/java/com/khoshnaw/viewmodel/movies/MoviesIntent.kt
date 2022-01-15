package com.khoshnaw.viewmodel.movies

import com.khoshnaw.viewmodel.base.Intent

sealed class MoviesIntent : Intent {
    object RefreshMovies : MoviesIntent()
}
