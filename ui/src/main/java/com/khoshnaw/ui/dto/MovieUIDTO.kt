package com.khoshnaw.ui.dto

import com.khoshnaw.ui.standard.adapter.StandardStateListItem

data class MovieUIDTO(
    override val id: String,
    val posterPath: String,
    val title: String,
    val voteAverage: String,
) : StandardStateListItem
