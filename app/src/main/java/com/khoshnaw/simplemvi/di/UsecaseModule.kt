package com.khoshnaw.simplemvi.di

import com.khoshnaw.usecase.movie.loadMovieList.LoadMovieList
import com.khoshnaw.usecase.movie.loadMovieList.LoadMovieListInputPort
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
interface UsecaseModule {

    @Binds
    fun provide(loadMovieList: LoadMovieList): LoadMovieListInputPort

}
