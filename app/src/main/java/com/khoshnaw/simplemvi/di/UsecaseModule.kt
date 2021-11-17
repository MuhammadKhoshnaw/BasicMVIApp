package com.khoshnaw.simplemvi.di

import com.khoshnaw.usecase.movie.loadMovieList.LoadMovieList
import com.khoshnaw.usecase.movie.loadMovieList.LoadMovieListInputPort
import com.khoshnaw.usecase.movie.loadMovieList.LoadMovieListOutputPort
import com.khoshnaw.viewmodel.movies.MoviesViewModel
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
interface UsecaseModule {

    @Binds
    @ViewModelScoped
    fun provideLoadMovieListInputPort(inputPort: LoadMovieList): LoadMovieListInputPort

    @Binds
    @ViewModelScoped
    fun provideLoadMovieListOutputPort(outputPort: MoviesViewModel): LoadMovieListOutputPort

}
