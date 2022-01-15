package com.khoshnaw.remote.interseptor

import com.khoshnaw.remote.authentication.TMDBApiKey
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject

class AuthenticationInterceptor @Inject constructor(
    private val TMDBApiKey: TMDBApiKey
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response = chain.proceedWithAuthentication()

    private fun Interceptor.Chain.proceedWithAuthentication(): Response = proceed(
        generateRequestWithAuthentication()
    )

    private fun Interceptor.Chain.generateRequestWithAuthentication(): Request =
        request().newBuilder().url(generateUrlWithApiKey()).build()

    private fun Interceptor.Chain.generateUrlWithApiKey(): HttpUrl = request().url.newBuilder()
        .addQueryParameter(TMDB_API_KEY_HEADER_NAME, TMDBApiKey.apiKey)
        .build()

    companion object {
        private const val TMDB_API_KEY_HEADER_NAME = "api_key"
    }
}
