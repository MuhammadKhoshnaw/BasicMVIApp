package com.khoshnaw.controller.movie

import com.khoshnaw.controller.standard.StandardController
import com.khoshnaw.usecase.movie.loadMovieList.LoadMovieListInputPort
import com.khoshnaw.usecase.movie.loadMovieList.LoadMovieListOutputPort
import javax.inject.Inject

class MovieController @Inject constructor(
    private val movieInputPort: LoadMovieListInputPort,
) : StandardController<LoadMovieListOutputPort>() {

    suspend fun loadMoviesList() = movieInputPort.startUpdatingMovieList()

    fun showMovie(id: String) = println("showing movie : $id")
}
