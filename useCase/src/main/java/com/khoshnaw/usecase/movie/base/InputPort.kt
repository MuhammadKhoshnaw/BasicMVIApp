package com.khoshnaw.usecase.movie.base

interface InputPort<O : OutputPort> {
    suspend fun registerOutPutPort(outputPort: O)
}
