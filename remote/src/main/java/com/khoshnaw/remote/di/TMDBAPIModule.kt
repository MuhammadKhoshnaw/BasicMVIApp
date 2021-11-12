package com.khoshnaw.remote.di

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
object TMDBAPIModule {
    @Singleton
    @Provides
    fun provideWordpressAPI(@Named(APIModule.TMDB_API) retrofit: Retrofit): MovieApi =
        retrofit.create(MovieApi::class.java)
}
