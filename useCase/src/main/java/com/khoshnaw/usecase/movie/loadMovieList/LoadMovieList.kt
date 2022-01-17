package com.khoshnaw.usecase.movie.loadMovieList

import com.khoshnaw.usecase.movie.base.UseCase
import com.khoshnaw.usecase.movie.gateway.MovieGateway
import javax.inject.Inject

class LoadMovieList @Inject constructor(
    private val movieGateway: MovieGateway,
) : UseCase<LoadMovieListOutputPort>(), LoadMovieListInputPort {

    override suspend fun onReady() {
        observeMovies()
    }

    override suspend fun startLoadingMovieList() {
        showLoading()
        updateMovies()
        hideLoading()
    }

    private suspend fun observeMovies() = outputPort.observeMovies(movieGateway.observeMovies())

    private fun showLoading() = outputPort.showLoading(true)

    private fun hideLoading() = outputPort.showLoading(false)

    private suspend fun updateMovies() = movieGateway.updateMovieList()

}
