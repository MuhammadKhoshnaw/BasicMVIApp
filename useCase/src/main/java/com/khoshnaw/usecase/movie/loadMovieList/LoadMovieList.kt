package com.khoshnaw.usecase.movie.loadMovieList

import com.khoshnaw.usecase.movie.base.UseCase
import com.khoshnaw.usecase.movie.gateway.MovieGateway
import javax.inject.Inject

class LoadMovieList @Inject constructor(
    override val outputPort: LoadMovieListOutputPort,
    private val movieGateway: MovieGateway
) : UseCase<LoadMovieListOutputPort>(), LoadMovieListInputPort {

    override suspend fun startLoadingMovieList() {
        showLoading()
        updateMovies()
    }

    private fun showLoading() = outputPort.showLoading(true)

    private suspend fun updateMovies() = movieGateway.updateMovieList()

}
