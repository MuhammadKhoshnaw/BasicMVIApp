package com.khoshnaw.viewmodel.movies

import android.app.Application
import com.khoshnaw.controller.MovieController
import com.khoshnaw.entity.Movie
import com.khoshnaw.usecase.movie.loadMovieList.LoadMovieListOutputPort
import com.khoshnaw.viewmodel.mvi.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val movieController: MovieController,
    application: Application,
) : BaseViewModel<MoviesState, MoviesIntent>(application),
    LoadMovieListOutputPort {

    init {
        init()
    }

    override suspend fun handleIntent(intent: MoviesIntent) = when (intent) {
        MoviesIntent.RefreshMovies -> movieController.loadMoviesList()
    }

    override fun showLoading(boolean: Boolean) {
        Timber.i("showLoading")
    }

    override fun updateMovieList(movieList: List<Movie>) {
        Timber.i("updateMovieList")
    }

}
