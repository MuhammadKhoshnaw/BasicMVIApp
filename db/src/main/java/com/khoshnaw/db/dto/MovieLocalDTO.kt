package com.khoshnaw.db.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MovieLocalDTO(
    @PrimaryKey val id: String,
    val posterPath: String,
    val title: String,
    val voteAverage: Double
)