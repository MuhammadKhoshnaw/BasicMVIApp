package com.khoshnaw.usecase.utils

suspend inline fun tryTo(crossinline block: suspend () -> Unit): Exception? = try {
    block()
    null
} catch (e: Exception) {
    e
}
