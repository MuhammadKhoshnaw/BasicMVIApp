package com.khoshnaw.viewmodel.dto

data class MovieUIDTO(
    override val id: String,
    val posterPath: String,
    val title: String,
    val voteAverage: String,
) : StandardStateListItem
