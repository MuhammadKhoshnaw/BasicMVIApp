package com.khoshnaw.ui.view.movies

import androidx.fragment.app.viewModels
import com.khoshnaw.ui.R
import com.khoshnaw.ui.adapters.MovieAdapter
import com.khoshnaw.ui.databinding.FragmentMoviesBinding
import com.khoshnaw.ui.extenstion.dataBindings
import com.khoshnaw.ui.mapper.toDTO
import com.khoshnaw.ui.standard.fragment.StandardFragment
import com.khoshnaw.viewmodel.movies.MoviesIntent
import com.khoshnaw.viewmodel.movies.MoviesState
import com.khoshnaw.viewmodel.movies.MoviesViewModel
import com.khoshnaw.viewmodel.mvi.MVIState
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MoviesFragment : StandardFragment<FragmentMoviesBinding, MoviesViewModel>(
    R.layout.fragment_movies
) {
    override val binding by dataBindings(FragmentMoviesBinding::bind)
    override val viewModel: MoviesViewModel by viewModels()
    private val moviesAdapter by lazy { MovieAdapter() }

    override fun onViewReady() {
        binding.movieRV.setHasFixedSize(true)
        binding.movieRV.adapter = moviesAdapter

        binding.swipeRefresh.setOnRefreshListener {
            viewModel.runIntent(MoviesIntent.RefreshMovies)
        }
    }

    override fun handleState(state: MVIState) {
        when (state) {
            is MoviesState.MovieList -> handleMovieList(state)
        }
    }

    private fun handleMovieList(moviesState: MoviesState.MovieList) {
        binding.swipeRefresh.isRefreshing = moviesState.isLoading
        moviesAdapter.items = moviesState.movies.toDTO()
    }

}
