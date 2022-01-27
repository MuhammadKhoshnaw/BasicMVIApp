package com.khoshnaw.ui.dto

import com.khoshnaw.entity.Movie
import com.khoshnaw.ui.standard.adapter.StandardListItem

data class MovieUIDTO(
    override val id: String,
    val posterPath: String,
    val title: String,
    val voteAverage: String,
    val entity: Movie
) : StandardListItem
