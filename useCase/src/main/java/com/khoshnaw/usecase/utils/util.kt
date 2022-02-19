package com.khoshnaw.usecase.utils

suspend inline fun tryTo(crossinline action: suspend () -> Unit): Exception? = try {
    action()
    null
} catch (e: Exception) {
    e
}
