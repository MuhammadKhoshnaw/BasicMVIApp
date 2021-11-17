package com.khoshnaw.simplemvi.di

import com.khoshnaw.remote.api.MovieApi
import com.khoshnaw.remote.authentication.TMDBApiKey
import com.khoshnaw.simplemvi.BuildConfig
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
    fun provideTMDBAPI(@Named(DiNames.TMDB_API) retrofit: Retrofit): MovieApi =
        retrofit.create(MovieApi::class.java)

    @Provides
    fun provideTMDBAPIKey(): TMDBApiKey = TMDBApiKey(
        apiKey = BuildConfig.TMDB_API_KEY
    )
}