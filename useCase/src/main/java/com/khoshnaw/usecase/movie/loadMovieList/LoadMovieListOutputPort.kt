package com.khoshnaw.usecase.movie.loadMovieList

import com.khoshnaw.entity.Movie
import com.khoshnaw.usecase.movie.base.OutputPort
import kotlinx.coroutines.flow.Flow

interface LoadMovieListOutputPort : OutputPort {
    suspend fun showLoading(loading: Boolean)
    suspend fun startObserveMovies(flow: Flow<List<Movie>>)
}
