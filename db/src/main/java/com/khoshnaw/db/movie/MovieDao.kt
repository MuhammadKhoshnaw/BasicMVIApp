package com.khoshnaw.db.movie

import androidx.room.Dao
import androidx.room.Insert
import com.khoshnaw.db.dto.MovieLocalDTO

@Dao
interface MovieDao {
    @Insert
    fun insertAll(list: List<MovieLocalDTO>)
}
