package com.khoshnaw.db.roomDB

import androidx.room.Database
import androidx.room.RoomDatabase
import com.khoshnaw.repository.local.dto.MovieLocalDTO
import com.khoshnaw.db.dao.MovieDao

@Database(entities = [MovieLocalDTO::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}
