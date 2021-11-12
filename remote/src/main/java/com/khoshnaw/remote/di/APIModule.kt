package com.khoshnaw.remote.di

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.CertificatePinner
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object APIModule {
    private const val LOGGING_INTERCEPTOR_TAG = "okhttp"
    private const val TIMEOUT_ONE_MINUTE = 60L

    const val TMDB_API = "TMDB_API"

    @Provides
    @Named(TMDB_API)
//    fun provideKeycloakApiPath(): String = BuildConfig.WORDPRESS_API_BASE_URL
    fun provideTMDBApiPath(): String = "https://api.themoviedb.org/3/"

    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor {
        Timber.tag(LOGGING_INTERCEPTOR_TAG).i(it)
    }.setLevel(HttpLoggingInterceptor.Level.BODY)

    @Singleton
    @Provides
    @Named(TMDB_API)
    fun provideWordPressOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        @Named(TMDB_API) certificatePinner: CertificatePinner,
    ): OkHttpClient = OkHttpClient().newBuilder()
        .addInterceptor(httpLoggingInterceptor)
        .certificatePinner(certificatePinner)
        .connectTimeout(TIMEOUT_ONE_MINUTE, TimeUnit.SECONDS)
        .readTimeout(TIMEOUT_ONE_MINUTE, TimeUnit.SECONDS)
        .writeTimeout(TIMEOUT_ONE_MINUTE, TimeUnit.SECONDS)
        .build()

    @Singleton
    @Provides
    @Named(TMDB_API)
    fun provideWordPressRetrofit(
        @Named(TMDB_API) wordPressOkHttpClient: OkHttpClient,
        moshi: Moshi,
        @Named(TMDB_API) baseURL: String
    ): Retrofit {
        return Retrofit.Builder()
            .client(wordPressOkHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(baseURL)
            .build()
    }
}
