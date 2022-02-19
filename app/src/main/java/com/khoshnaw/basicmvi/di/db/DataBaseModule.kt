package com.khoshnaw.basicmvi.di.db

import android.content.Context
import androidx.room.Room
import com.khoshnaw.db.AppDatabase
import com.khoshnaw.db.movie.MovieDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DataBaseModule {
    private const val DATA_BASE_NAME = "application_data_base"

    @Singleton
    @Provides
    fun provideAppDataBase(
        @ApplicationContext applicationContext: Context
    ): AppDatabase = Room.databaseBuilder(
        applicationContext,
        AppDatabase::class.java,
        DATA_BASE_NAME
    ).build()

    @Singleton
    @Provides
    fun provideMovieDao(appDatabase: AppDatabase): MovieDao = appDatabase.movieDao()
}
