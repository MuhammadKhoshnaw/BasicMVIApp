package com.khoshnaw.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.khoshnaw.ui.base.adapter.BaseHolder
import com.khoshnaw.ui.databinding.MovieItemBinding
import com.khoshnaw.ui.dto.MovieUIDTO
import com.khoshnaw.ui.standard.adapter.StandardAdapter
import com.khoshnaw.ui.standard.adapter.StandardHolder

class MovieAdapter : StandardAdapter<MovieUIDTO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MovieHolder(
        MovieItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: BaseHolder<MovieUIDTO>, position: Int) =
        holder.bind(items[position])

    inner class MovieHolder(
        val binding: MovieItemBinding
    ) : StandardHolder<MovieUIDTO>(binding) {

        override fun bind(item: MovieUIDTO) {
            Glide.with(binding.root.context)
                .load(item.posterPath)
                .into(binding.moviePoster);
        }

    }
}
