package com.khoshnaw.usecase.movie.loadMovieList

import com.khoshnaw.usecase.movie.base.UseCase
import com.khoshnaw.usecase.movie.gateway.MovieGateway
import com.khoshnaw.usecase.utils.tryTo
import kotlinx.coroutines.delay
import javax.inject.Inject

class LoadMovieList @Inject constructor(
    private val movieGateway: MovieGateway,
) : UseCase<LoadMovieListOutputPort>(), LoadMovieListInputPort {

    override suspend fun onReady() {
        observeMovies()
        loadMoviesIfNeeded()
    }

    override suspend fun startUpdatingMovieList() {
        showLoading()
        val e = tryTo { updateMovies() }
        hideLoading()
        e?.let { throw e }
    }

    private suspend fun loadMoviesIfNeeded() {
        if (movieGateway.loadMovieSize() <= 0) startUpdatingMovieList()
    }

    private suspend fun observeMovies() = outputPort.observeMovies(movieGateway.observeMovies())

    private fun showLoading() = outputPort.showLoading(true)

    private fun hideLoading() = outputPort.showLoading(false)

    private suspend fun updateMovies() = movieGateway.updateMovieList()

}
