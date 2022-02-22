package com.khoshnaw.repository.local.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie")
data class MovieLocalDTO(
    @PrimaryKey val id: String,
    val posterPath: String,
    val title: String,
    val voteAverage: Double
)
