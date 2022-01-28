package com.khoshnaw.controller.base

import com.khoshnaw.usecase.movie.base.InputPort
import com.khoshnaw.usecase.movie.base.OutputPort

abstract class Controller<out I : InputPort<O>, in O : OutputPort> {
    abstract val inputPort: I

    suspend fun registerOutputPort(outputPort: O) = inputPort.registerOutputPort(outputPort)
}
