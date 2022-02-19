package com.khoshnaw.viewmodel.movies

import com.khoshnaw.controller.movie.MovieController
import com.khoshnaw.entity.Movie
import com.khoshnaw.usecase.movie.loadMovieList.LoadMovieListOutputPort
import com.khoshnaw.viewmodel.standard.StandardViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
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
        is MoviesIntent.RefreshMovies -> handleRefreshMovies()
        is MoviesIntent.OnMovieClicked -> handleMovieClicked(intent)
    }

    private suspend fun handleRefreshMovies() {
        movieController.loadMoviesList()
    }

    private suspend fun handleMovieClicked(intent: MoviesIntent.OnMovieClicked) {
        state.value?.movies?.getOrNull(intent.position)?.takeIf { it.id == intent.id }?.let {
            movieController.showMovie(it)
        }
    }

    override suspend fun observeMovies(flow: Flow<List<Movie>>) {
        flow.collectResult {
            updateState(MoviesState.MovieList(it))
        }
    }

    override suspend fun showLoading(loading: Boolean) {
        state.value?.movies?.let { movies ->
            updateState(MoviesState.MovieList(movies, loading))
        }
    }
}
