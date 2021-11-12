package com.khoshnaw.usecase.movie.loadMovieList

import com.khoshnaw.entity.Movie
import com.khoshnaw.usecase.movie.base.OutputPort

interface LoadMovieListOutputPort : OutputPort {
    fun showLoading(boolean: Boolean)
    fun updateMovieList(movieList: List<Movie>)
}
