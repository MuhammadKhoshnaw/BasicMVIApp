package com.khoshnaw.db.mapper

import com.google.common.truth.Truth.assertThat
import com.khoshnaw.db.dummy.MovieLocalDTODummies
import com.khoshnaw.entity.MovieDummies
import org.junit.Test

class MovieMappersKtTest {

    @Test
    fun `mapping dto to entity`() {
        val localDTO = DUMMY_MOVIE_LOCAL_DTO
        val entity = DUMMY_MOVIE

        val result = localDTO.toEntity()

        assertThat(result).isEqualTo(entity)
    }

    @Test
    fun `mapping dto list to entity list`() {
        val localDTOList = DUMMY_MOVIE_LOCAL_DTO_LIST
        val entityList = DUMMY_MOVIE_LIST

        val result = localDTOList.toEntity()

        assertThat(result).isEqualTo(entityList)
    }

    @Test
    fun `mapping entity to dto`() {
        val localDTO = DUMMY_MOVIE_LOCAL_DTO
        val entity = DUMMY_MOVIE

        val result = entity.toLocalDTO()

        assertThat(result).isEqualTo(localDTO)
    }

    @Test
    fun `mapping entity list to dto list`() {
        val localDTOList = DUMMY_MOVIE_LOCAL_DTO_LIST
        val entityList = DUMMY_MOVIE_LIST

        val result = entityList.toLocalDTO()

        assertThat(result).isEqualTo(localDTOList)
    }

    companion object {
        private val DUMMY_MOVIE = MovieDummies.dummyMovie
        private val DUMMY_MOVIE_LOCAL_DTO = MovieLocalDTODummies.dummyMovieLocalDTO

        private val DUMMY_MOVIE_LIST = MovieDummies.dummyMovieList
        private val DUMMY_MOVIE_LOCAL_DTO_LIST = MovieLocalDTODummies.dummyMovieLocalDTOList
    }
}
