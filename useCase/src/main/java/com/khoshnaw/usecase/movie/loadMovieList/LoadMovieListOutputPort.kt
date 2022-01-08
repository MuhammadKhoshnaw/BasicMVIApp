package com.khoshnaw.usecase.movie.loadMovieList

import com.khoshnaw.entity.Movie
import com.khoshnaw.usecase.movie.base.OutputPort
import kotlinx.coroutines.flow.Flow

interface LoadMovieListOutputPort : OutputPort {
    fun showLoading(loading: Boolean)
    fun observeMovies(flow: Flow<List<Movie>>)
}
