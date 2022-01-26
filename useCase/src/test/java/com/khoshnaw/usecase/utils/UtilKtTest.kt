package com.khoshnaw.usecase.utils

import com.google.common.truth.Truth
import com.khoshnaw.exception.ExceptionDummies
import org.junit.Test

class UtilKtTest {

    @Test
    fun `when try to do some thing and failed return the exception`() {
        var result: Exception? = null

        try {
            throwException()
        } catch (e: Exception) {
            result = e
        }

        Truth.assertThat(result).isEqualTo(DUMMY_EXCEPTION)
    }

    private fun throwException(): Unit = throw DUMMY_EXCEPTION

    companion object {
        private val DUMMY_EXCEPTION = ExceptionDummies.dummyException
    }

}
