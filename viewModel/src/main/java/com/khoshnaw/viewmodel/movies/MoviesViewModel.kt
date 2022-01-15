package com.khoshnaw.viewmodel.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.khoshnaw.controller.MovieController
import com.khoshnaw.entity.Movie
import com.khoshnaw.usecase.movie.loadMovieList.LoadMovieListOutputPort
import com.khoshnaw.viewmodel.mvi.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val movieController: MovieController
) : BaseViewModel<MoviesState, MoviesIntent>(),
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

        viewModelScope.launch {
            flow.collect {
                Timber.i("new movies : $it")
                _movies.postValue(it)
            }
        }
    }

    override fun showLoading(loading: Boolean) {
        Timber.i("showLoading $loading")
    }
}
