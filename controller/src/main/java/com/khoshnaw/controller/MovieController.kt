package com.khoshnaw.controller

import com.khoshnaw.usecase.movie.loadMovieList.LoadMovieListInputPort
import com.khoshnaw.usecase.movie.loadMovieList.LoadMovieListOutputPort
import javax.inject.Inject

class MovieController @Inject constructor(
    private val loadMovieListInputPort: LoadMovieListInputPort,
) {

    suspend fun setOutPutPort(outputPort: LoadMovieListOutputPort) =
        loadMovieListInputPort.setOutPutPort(outputPort)

    suspend fun loadMoviesList() = loadMovieListInputPort.startLoadingMovieList()

}
