package com.khoshnaw.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.khoshnaw.db.dto.MovieLocalDTO
import com.khoshnaw.db.movie.MovieDao

@Database(entities = [MovieLocalDTO::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}
