package com.khoshnaw.viewmodel.movies

import com.khoshnaw.controller.MovieController
import com.khoshnaw.entity.Movie
import com.khoshnaw.usecase.movie.loadMovieList.LoadMovieListOutputPort
import com.khoshnaw.viewmodel.standard.StandardViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val movieController: MovieController
) : StandardViewModel<MoviesState, MoviesIntent>(),
    LoadMovieListOutputPort {

    init {
        init()
    }

    override suspend fun handleIntent(intent: MoviesIntent) = when (intent) {
        MoviesIntent.RefreshMovies -> movieController.loadMoviesList()
        is MoviesIntent.OnMovieClicked -> movieController.showMovie(intent.movie)
    }

    override fun observeMovies(flow: Flow<List<Movie>>) {
        flow.collectResult {
            updateState(MoviesState.MovieList(it))
        }
    }

    override fun showLoading(loading: Boolean) {
        state.value?.movies?.let { movies ->
            updateState(MoviesState.MovieList(movies, loading))
        }
    }
}
