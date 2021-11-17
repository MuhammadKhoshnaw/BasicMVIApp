package com.khoshnaw.usecase.movie.loadMovieList

import com.khoshnaw.usecase.movie.base.UseCase
import com.khoshnaw.usecase.movie.gateway.MovieGateway
import dagger.Lazy
import javax.inject.Inject

class LoadMovieList @Inject constructor(
    override val outputPort: Lazy<LoadMovieListOutputPort>,
    private val movieGateway: MovieGateway
) : UseCase<LoadMovieListOutputPort>(), LoadMovieListInputPort {

    override suspend fun startLoadingMovieList() {
        showLoading()
        updateMovies()
    }

    private fun showLoading() = outputPort.get().showLoading(true)

    private suspend fun updateMovies() = movieGateway.updateMovieList()

}
