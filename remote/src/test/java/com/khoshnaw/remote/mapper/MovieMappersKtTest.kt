package com.khoshnaw.remote.mapper

import com.google.common.truth.Truth
import com.khoshnaw.entity.MovieDummies
import com.khoshnaw.remote.dummy.MovieRemoteDTODummies
import org.junit.Test

class MovieMappersKtTest {

    @Test
    fun `mapping dto to entity`() {
        val dto = DUMMY_MOVIE_DTO
        val entity = DUMMY_MOVIE

        val result = dto.toEntity()

        Truth.assertThat(result).isEqualTo(entity)
    }

    @Test
    fun `mapping dto list to entity list`() {
        val dtoList = DUMMY_MOVIE_DTO_LIST
        val entityList = DUMMY_MOVIE_LIST

        val result = dtoList.toEntity()

        Truth.assertThat(result).isEqualTo(entityList)
    }

    companion object {
        private val DUMMY_MOVIE = MovieDummies.dummyMovie
        private val DUMMY_MOVIE_DTO = MovieRemoteDTODummies.dummyMovieRemoteDTO

        private val DUMMY_MOVIE_LIST = MovieDummies.dummyMovieList
        private val DUMMY_MOVIE_DTO_LIST = MovieRemoteDTODummies.dummyMovieRemoteDTOList
    }
}
