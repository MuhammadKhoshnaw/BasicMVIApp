package com.khoshnaw.usecase.movie.loadMovieList

import com.khoshnaw.usecase.movie.base.UseCase
import com.khoshnaw.usecase.movie.repository.MovieRepository
import com.khoshnaw.usecase.utils.tryTo
import javax.inject.Inject

class LoadMovieList @Inject constructor(
    private val movieRepository: MovieRepository,
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
        if (movieRepository.loadMovieSize() <= 0) startUpdatingMovieList()
    }

    private suspend fun observeMovies() = outputPort.observeMovies(movieRepository.observeMovies())

    private suspend fun showLoading() = outputPort.showLoading(true)

    private suspend fun hideLoading() = outputPort.showLoading(false)

    private suspend fun updateMovies() = movieRepository.updateMovieList()

}
