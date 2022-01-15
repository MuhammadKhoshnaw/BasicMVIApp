package com.khoshnaw.basicmvi.di

import com.khoshnaw.gateway.remoteDataSource.MovieRemoteDataSource
import com.khoshnaw.remote.movie.MovieRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
interface RemoteDataSourceModule {

    @Binds
    fun provide(movieRemoteDataSource: MovieRemoteDataSourceImpl): MovieRemoteDataSource

}
