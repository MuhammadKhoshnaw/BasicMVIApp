package com.khoshnaw.basicmvi.di

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RetrofitModule {

    @Singleton
    @Provides
    @Named(DiNames.TMDB_API)
    fun provideWordPressRetrofit(
        @Named(DiNames.TMDB_API) wordPressOkHttpClient: OkHttpClient,
        moshi: Moshi,
        @Named(DiNames.TMDB_API) baseURL: String
    ): Retrofit {
        return Retrofit.Builder()
            .client(wordPressOkHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(baseURL)
            .build()
    }

}
