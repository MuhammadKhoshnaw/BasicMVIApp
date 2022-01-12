package com.khoshnaw.controller

import com.khoshnaw.usecase.movie.base.InputPort
import com.khoshnaw.usecase.movie.base.OutputPort

abstract class Controller<I : InputPort<O>, O : OutputPort> {
    abstract val inputPort: I

    suspend fun registerOutPutPort(outputPort: O) = inputPort.registerOutPutPort(outputPort)
}
