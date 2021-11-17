package com.khoshnaw.db.movie

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import com.khoshnaw.db.dto.MovieLocalDTO

@Dao
interface MovieDao {
    @Insert(onConflict = REPLACE)
    fun insertAll(list: List<MovieLocalDTO>)
}
