package com.khoshnaw.controller.standard

import com.khoshnaw.controller.base.Controller
import com.khoshnaw.usecase.movie.base.InputPort
import com.khoshnaw.usecase.movie.base.OutputPort
import kotlin.reflect.full.memberProperties
import kotlin.reflect.jvm.isAccessible

abstract class StandardController<in O : OutputPort> : Controller<O>() {

    override suspend fun registerOutputPort(outputPort: O) = this::class.memberProperties.map {
        it.isAccessible = true
        it.getter.call(this)
    }.filterIsInstance<InputPort<O>>().forEach {
        it.registerOutputPort(outputPort)
    }

}
