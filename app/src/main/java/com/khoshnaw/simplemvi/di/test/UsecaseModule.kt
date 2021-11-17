package com.khoshnaw.simplemvi.di.test

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
object DummyUsecaseModule {

/*    @Provides
    @ViewModelScoped
    fun provideLoadMovieListOutputPort(outputPort: MoviesViewModel): MoviesViewModel {
        viewModels
    }*/

}
