package com.khoshnaw.basicmvi.di.remote

import com.khoshnaw.repository.remote.dataSource.MovieRemoteDataSource
import com.khoshnaw.remote.apiDataSource.movie.MovieAPIDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
interface RemoteDataSourceModule {

    @Binds
    fun provide(movieAPIDataSource: MovieAPIDataSource): MovieRemoteDataSource

}
