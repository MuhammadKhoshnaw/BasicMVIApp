package com.khoshnaw.usecase.movie.base

abstract class UseCase<O : OutputPort> : InputPort<O> {
    protected lateinit var outputPort: O

    protected open suspend fun onReady() = Unit

    override suspend fun registerOutPutPort(outputPort: O) {
        this.outputPort = outputPort
        onReady()
    }
}
