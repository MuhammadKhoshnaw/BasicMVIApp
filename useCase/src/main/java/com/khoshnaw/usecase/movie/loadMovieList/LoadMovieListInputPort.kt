package com.khoshnaw.usecase.movie.loadMovieList

import com.khoshnaw.usecase.movie.base.InputPort

interface LoadMovieListInputPort : InputPort {
    suspend fun setOutPutPort(outputPort: LoadMovieListOutputPort)
    suspend fun startLoadingMovieList()
}
