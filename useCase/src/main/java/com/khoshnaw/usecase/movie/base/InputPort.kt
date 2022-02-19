package com.khoshnaw.usecase.movie.base

interface InputPort<in O : OutputPort> {
    suspend fun registerOutputPort(outputPort: O)
}
