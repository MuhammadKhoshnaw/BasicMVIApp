package com.khoshnaw.remote.util

import com.khoshnaw.remote.exception.ApiExceptionApp
import retrofit2.Response

fun <A : Any> Response<A>.bodyOrException(): A = body().let { body ->
    if (isSuccessful && body != null) body else throw ApiExceptionApp("api request failed")
}

fun <A : Any> Response<A>.bodyOrNull(): A? = try {
    body().let { body -> if (isSuccessful && body != null) body else null }
} catch (e: Exception) {
    null
}
