package com.khoshnaw.viewmodel.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.khoshnaw.controller.MovieController
import com.khoshnaw.entity.Movie
import com.khoshnaw.usecase.movie.loadMovieList.LoadMovieListOutputPort
import com.khoshnaw.viewmodel.mvi.StandardViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val movieController: MovieController
) : StandardViewModel<MoviesState, MoviesIntent>(),
    LoadMovieListOutputPort {

    private val _movies = MutableLiveData<List<Movie>>()
    val movie: LiveData<List<Movie>> = _movies

    init {
        init()
    }

    override suspend fun handleIntent(intent: MoviesIntent) = when (intent) {
        MoviesIntent.RefreshMovies -> movieController.loadMoviesList()
    }

    override fun observeMovies(flow: Flow<List<Movie>>) {
        Timber.i("observeMovies")
    }

    override fun showLoading(loading: Boolean) {
        Timber.i("showLoading $loading")
    }
}
