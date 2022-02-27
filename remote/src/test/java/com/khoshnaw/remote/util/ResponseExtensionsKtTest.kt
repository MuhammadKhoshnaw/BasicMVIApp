package com.khoshnaw.remote.util

import com.google.common.truth.Truth.assertThat
import com.khoshnaw.remote.exception.ApiExceptionApp
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Test
import retrofit2.Response

class ResponseExtensionsKtTest {

    @Test
    fun `when response is successful, and body is not null, return body`() {
        val response = DUMMY_SUCCESSFUL_WITH_BODY_RESPONSE

        val result = response.bodyOrException()

        assertThat(result).isEqualTo(DUMMY_GET_MOVIES_RESPONSE)
    }

    @Test
    fun `when response is successful, but body is null, throw exception`() {
        val response = DUMMY_SUCCESSFUL_WITH_NO_BODY_RESPONSE
        var exception: Exception? = null

        try {
            response.bodyOrException()
        } catch (e: Exception) {
            exception = e
        }

        assertThat(exception).isInstanceOf(ApiExceptionApp::class.java)
    }


    @Test
    fun `when response is error, throw exception`() {
        val response = DUMMY_ERROR_RESPONSE
        var exception: Exception? = null

        try {
            response.bodyOrException()
        } catch (e: Exception) {
            exception = e
        }

        assertThat(exception).isInstanceOf(ApiExceptionApp::class.java)
    }


    companion object {
        private const val DUMMY_GET_MOVIES_RESPONSE = "Some Response"
        private val DUMMY_SUCCESSFUL_WITH_BODY_RESPONSE =
            Response.success(DUMMY_GET_MOVIES_RESPONSE)

        private val DUMMY_SUCCESSFUL_WITH_NO_BODY_RESPONSE =
            Response.success<String>(null)

        private val DUMMY_ERROR_RESPONSE = Response.error<String>(
            400,
            "error".toResponseBody()
        )
    }
}
