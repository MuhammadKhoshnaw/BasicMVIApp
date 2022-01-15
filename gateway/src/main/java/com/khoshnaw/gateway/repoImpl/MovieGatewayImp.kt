package com.khoshnaw.gateway.repoImpl

import com.khoshnaw.gateway.localDataSource.MovieLocalDataSource
import com.khoshnaw.gateway.remoteDataSource.MovieRemoteDataSource
import com.khoshnaw.usecase.movie.gateway.MovieGateway
import javax.inject.Inject

class MovieGatewayImp @Inject constructor(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
) : MovieGateway {
    override suspend fun updateMovieList() =
        movieLocalDataSource.updateMovieList(movieRemoteDataSource.loadMovieList())

    override suspend fun observeMovies() = movieLocalDataSource.observeMovies()

}
