package com.khoshnaw.basicmvi.di

import com.khoshnaw.gateway.repoImpl.MovieGatewayImp
import com.khoshnaw.usecase.movie.gateway.MovieGateway
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
interface GatewayModule {

    @Binds
    fun provide(movieGateway: MovieGatewayImp): MovieGateway

}
