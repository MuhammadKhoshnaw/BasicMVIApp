package com.khoshnaw.controller.movie

import com.khoshnaw.controller.base.Controller
import com.khoshnaw.usecase.movie.loadMovieList.LoadMovieListInputPort
import com.khoshnaw.usecase.movie.loadMovieList.LoadMovieListOutputPort
import javax.inject.Inject

class MovieController @Inject constructor(
    override val inputPort: LoadMovieListInputPort,
) : Controller<LoadMovieListInputPort, LoadMovieListOutputPort>() {

    suspend fun loadMoviesList() = inputPort.startUpdatingMovieList()

    fun showMovie(id: String) = println("showing movie : $id")
}
