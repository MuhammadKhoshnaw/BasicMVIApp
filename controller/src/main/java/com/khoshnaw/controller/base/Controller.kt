package com.khoshnaw.controller.base

import com.khoshnaw.usecase.movie.base.OutputPort

abstract class Controller<in O : OutputPort> {

    abstract suspend fun registerOutputPort(outputPort: O)
}
