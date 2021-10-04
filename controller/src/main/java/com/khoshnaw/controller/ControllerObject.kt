package com.khoshnaw.controller

import com.khoshnaw.entity.EntityObject
import com.khoshnaw.usecase.UseCaseObject

object ControllerObject {
    fun controllerTest() {
        UseCaseObject.test()
        EntityObject.entityTest()
    }
}
