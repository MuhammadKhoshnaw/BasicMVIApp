package com.khoshnaw.simplemvi.di

import com.khoshnaw.remote.interseptor.AuthenticationInterceptor
import com.khoshnaw.simplemvi.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object OkhttpModule {
    private const val LOGGING_INTERCEPTOR_TAG = "okhttp"
    private const val TIMEOUT_ONE_MINUTE = 60L

    @Provides
    @Named(DiNames.TMDB_API)
    fun provideTMDBApiPath(): String = BuildConfig.TMDB_API_BASE_URL

    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor {
        Timber.tag(LOGGING_INTERCEPTOR_TAG).i(it)
    }.setLevel(HttpLoggingInterceptor.Level.BODY)

    @Singleton
    @Provides
    @Named(DiNames.TMDB_API)
    fun provideWordPressOkHttpClient(
        authenticationInterceptor: AuthenticationInterceptor,
        httpLoggingInterceptor: HttpLoggingInterceptor,
    ): OkHttpClient = OkHttpClient().newBuilder()
        .addInterceptor(authenticationInterceptor)
        .addInterceptor(httpLoggingInterceptor)
        .connectTimeout(TIMEOUT_ONE_MINUTE, TimeUnit.SECONDS)
        .readTimeout(TIMEOUT_ONE_MINUTE, TimeUnit.SECONDS)
        .writeTimeout(TIMEOUT_ONE_MINUTE, TimeUnit.SECONDS)
        .build()

}
