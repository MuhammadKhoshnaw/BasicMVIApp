package com.khoshnaw.basicmvi.di.repository

import com.khoshnaw.repository.repositoryImp.MovieRepositoryImp
import com.khoshnaw.usecase.movie.repository.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
interface RepositoryModule {

    @Binds
    fun provide(movieGateway: MovieRepositoryImp): MovieRepository

}
