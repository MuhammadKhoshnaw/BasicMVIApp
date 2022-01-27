package com.khoshnaw.basicmvi.di

import com.khoshnaw.usecase.movie.loadMovieList.LoadMovieList
import com.khoshnaw.usecase.movie.loadMovieList.LoadMovieListInputPort
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
interface InputPortsModule {

    @Binds
    @ViewModelScoped
    fun provideLoadMovieListInputPort(inputPort: LoadMovieList): LoadMovieListInputPort

}
