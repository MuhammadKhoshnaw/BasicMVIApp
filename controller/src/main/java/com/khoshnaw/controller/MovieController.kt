package com.khoshnaw.controller

import com.khoshnaw.entity.Movie
import com.khoshnaw.usecase.movie.loadMovieList.LoadMovieListInputPort
import com.khoshnaw.usecase.movie.loadMovieList.LoadMovieListOutputPort
import javax.inject.Inject

class MovieController @Inject constructor(
    override val inputPort: LoadMovieListInputPort,
) : Controller<LoadMovieListInputPort, LoadMovieListOutputPort>() {

    suspend fun loadMoviesList() = inputPort.startUpdatingMovieList()

    suspend fun showMovie(movie: Movie) {
        println("showing movie : $movie")
    }

}
