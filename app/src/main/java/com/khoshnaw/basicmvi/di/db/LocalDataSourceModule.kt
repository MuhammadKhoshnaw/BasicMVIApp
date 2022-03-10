package com.khoshnaw.basicmvi.di.db

import com.khoshnaw.db.dbDataSource.movie.MovieDBDataSource
import com.khoshnaw.repository.local.dataSource.MovieLocalDataSource
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
