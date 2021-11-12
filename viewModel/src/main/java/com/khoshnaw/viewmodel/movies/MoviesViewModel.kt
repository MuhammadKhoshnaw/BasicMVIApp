package com.khoshnaw.viewmodel.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.khoshnaw.controller.MovieController
import com.khoshnaw.entity.Movie
import com.khoshnaw.usecase.movie.loadMovieList.LoadMovieListOutputPort
import com.khoshnaw.viewmodel.mvi.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val movieController: MovieController
) : BaseViewModel<MoviesState, MoviesIntent>(),
    LoadMovieListOutputPort {

    override val intents: Channel<MoviesIntent> = Channel()
    private val _state = MutableLiveData<MoviesState>()
    override val state: LiveData<MoviesState> = _state

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
