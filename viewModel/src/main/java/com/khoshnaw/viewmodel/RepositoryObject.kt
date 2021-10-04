package com.khoshnaw.viewmodel

import com.khoshnaw.entity.EntityObject
import com.khoshnaw.usecase.UseCaseObject

class ViewModelObject {
    fun viewModelTest() {
        UseCaseObject.test()
        EntityObject.entityTest()
    }
}
