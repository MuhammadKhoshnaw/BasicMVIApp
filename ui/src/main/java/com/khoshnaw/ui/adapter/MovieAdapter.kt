package com.khoshnaw.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.khoshnaw.ui.databinding.MovieItemBinding
import com.khoshnaw.viewmodel.dto.MovieUIDTO
import com.khoshnaw.ui.standard.adapter.StandardAdapter
import com.khoshnaw.ui.standard.adapter.StandardHolder
import com.khoshnaw.viewmodel.movies.MoviesIntent
import com.khoshnaw.viewmodel.movies.MoviesViewModel

class MovieAdapter(
    private val viewModel: MoviesViewModel
) : StandardAdapter<MovieUIDTO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MovieHolder(
        MovieItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    inner class MovieHolder(
        val binding: MovieItemBinding
    ) : StandardHolder<MovieUIDTO>(binding) {

        override fun bind(item: MovieUIDTO) {
            binding.movie = item
            binding.containerCV.setOnClickListener {
                viewModel.runIntent(MoviesIntent.OnMovieClicked(adapterPosition, item.id))
            }
        }
    }
}
