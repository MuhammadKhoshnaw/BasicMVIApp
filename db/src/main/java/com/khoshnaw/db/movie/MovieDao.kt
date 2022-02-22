package com.khoshnaw.db.movie

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.khoshnaw.repository.local.dto.MovieLocalDTO
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
    @Insert(onConflict = REPLACE)
    fun insertAll(list: List<MovieLocalDTO>)

    @Query("SELECT * FROM movie")
    fun observeMovies(): Flow<List<MovieLocalDTO>>

    @Query("SELECT COUNT(*) FROM movie")
    fun loadMovieSize(): Int
}
