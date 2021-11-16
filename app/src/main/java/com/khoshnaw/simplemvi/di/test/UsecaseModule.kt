package com.khoshnaw.simplemvi.di.test

import com.khoshnaw.entity.Movie
import com.khoshnaw.usecase.movie.loadMovieList.LoadMovieListOutputPort
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DummyUsecaseModule {
    @Provides
    fun provideLoadMovieListOutputPort(): LoadMovieListOutputPort {
        return object : LoadMovieListOutputPort {
            override fun showLoading(boolean: Boolean) = Unit

            override fun updateMovieList(movieList: List<Movie>) = Unit
        }
    }
}
