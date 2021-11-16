package com.khoshnaw.simplemvi.di

import com.khoshnaw.remote.api.MovieApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object ApiModule {
    @Singleton
    @Provides
    fun provideWordpressAPI(@Named(DiNames.TMDB_API) retrofit: Retrofit): MovieApi =
        retrofit.create(MovieApi::class.java)
}
