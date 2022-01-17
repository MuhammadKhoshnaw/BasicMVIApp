package com.khoshnaw.controller

import com.khoshnaw.usecase.movie.base.InputPort
import com.khoshnaw.usecase.movie.base.OutputPort

abstract class Controller<I : InputPort<O>, O : OutputPort> {
    abstract val inputPort: I

    suspend fun registerOutputPort(outputPort: O) = inputPort.registerOutputPort(outputPort)
}
