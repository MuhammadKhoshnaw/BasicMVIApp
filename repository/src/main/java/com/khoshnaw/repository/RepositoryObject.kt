package com.khoshnaw.repository

import com.khoshnaw.entity.EntityObject
import com.khoshnaw.usecase.UseCaseObject

class RepositoryObject {
    fun repositoryTest() {
        UseCaseObject.test()
        EntityObject.entityTest()
    }
}
