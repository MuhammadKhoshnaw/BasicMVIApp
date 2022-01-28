package com.khoshnaw.basicmvi.di

import com.khoshnaw.db.movie.MovieDBDataSource
import com.khoshnaw.gateway.localDataSource.MovieLocalDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
interface LocalDataSourceModule {

    @Binds
    fun provide(movieRemoteDataSource: MovieDBDataSource): MovieLocalDataSource

}
