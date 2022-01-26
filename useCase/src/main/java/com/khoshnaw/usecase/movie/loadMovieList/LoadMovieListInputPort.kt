package com.khoshnaw.usecase.movie.loadMovieList

import com.khoshnaw.usecase.movie.base.InputPort

interface LoadMovieListInputPort : InputPort<LoadMovieListOutputPort> {
    suspend fun startUpdatingMovieList()
}
