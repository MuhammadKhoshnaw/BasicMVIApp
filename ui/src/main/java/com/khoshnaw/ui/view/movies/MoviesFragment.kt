package com.khoshnaw.ui.view.movies

import androidx.fragment.app.viewModels
import com.khoshnaw.ui.R
import com.khoshnaw.ui.base.fragment.MVIFragment
import com.khoshnaw.ui.databinding.FragmentMoviesBinding
import com.khoshnaw.ui.extenstion.dataBindings
import com.khoshnaw.viewmodel.movies.MoviesIntent
import com.khoshnaw.viewmodel.movies.MoviesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesFragment : MVIFragment<FragmentMoviesBinding, MoviesViewModel>(
    R.layout.fragment_movies
) {
    override val binding by dataBindings(FragmentMoviesBinding::bind)
    override val viewModel: MoviesViewModel by viewModels()

    override fun onViewReady() {
        viewModel.runIntent(MoviesIntent.RefreshMovies)
    }
}
