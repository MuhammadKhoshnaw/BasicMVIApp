package com.khoshnaw.remote.interseptor

import com.google.common.truth.Truth
import com.khoshnaw.remote.module.TMDBApiKey
import io.mockk.*
import io.mockk.impl.annotations.MockK
import okhttp3.Interceptor
import okhttp3.Protocol
import okhttp3.Request
import okhttp3.Response
import org.junit.Before
import org.junit.Test

class AuthenticationInterceptorTest {

    @MockK
    lateinit var chain: Interceptor.Chain

    lateinit var interceptor: AuthenticationInterceptor

    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true)

        interceptor = spyk(AuthenticationInterceptor(DUMMY_TMDB_API_KEY))
    }

    @Test
    fun `add api key as query parameter`() {
        val resultRequestSlot = slot<Request>()
        every { chain.request() } returns DUMMY_REQUEST
        every { chain.proceed(capture(resultRequestSlot)) } returns DUMMY_RESPONSE

        interceptor.intercept(chain)

        Truth.assertThat(resultRequestSlot.apikeyQueryParameter).isEqualTo(DUMMY_API_KEY)
    }

    private val CapturingSlot<Request>.apikeyQueryParameter: String
        get() = captured.url.queryParameter(AuthenticationInterceptor.TMDB_API_KEY_HEADER_NAME)!!

    companion object {
        private const val DUMMY_API_KEY = "dummyKey"
        private val DUMMY_TMDB_API_KEY = TMDBApiKey("dummyKey")
        private const val DUMMY_URL = "https://somedomain.com/test"

        private val DUMMY_REQUEST = Request.Builder()
            .url(DUMMY_URL)
            .build()

        private val DUMMY_RESPONSE = Response.Builder()
            .code(200)
            .request(DUMMY_REQUEST)
            .protocol(Protocol.HTTP_1_0)
            .message("some message")
            .build()
    }
}
