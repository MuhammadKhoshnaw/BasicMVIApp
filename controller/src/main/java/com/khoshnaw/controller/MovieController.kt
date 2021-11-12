package com.khoshnaw.controller

import com.khoshnaw.usecase.movie.loadMovieList.LoadMovieListInputPort
import javax.inject.Inject

class MovieController @Inject constructor(
    private val loadMovieListInputPort: LoadMovieListInputPort
) {

    suspend fun loadMoviesList() = loadMovieListInputPort.startLoadingMovieList()

}
