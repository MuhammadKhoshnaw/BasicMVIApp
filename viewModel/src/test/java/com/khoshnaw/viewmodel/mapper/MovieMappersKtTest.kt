package com.khoshnaw.viewmodel.mapper

import com.google.common.truth.Truth
import com.khoshnaw.entity.MovieDummies
import com.khoshnaw.viewmodel.dummy.MovieUIDTODummies
import org.junit.Test

class MovieMappersKtTest {

    @Test
    fun `mapping entity to dto`() {
        val dto = DUMMY_MOVIE_UI_DTO
        val entity = DUMMY_MOVIE

        val result = entity.toUIDTO()

        Truth.assertThat(result).isEqualTo(dto)
    }

    @Test
    fun `mapping entity list to dto list`() {
        val dtoList = DUMMY_MOVIE_UI_DTO_LIST
        val entityList = DUMMY_MOVIE_LIST

        val result = entityList.toUIDTO()

        Truth.assertThat(result).isEqualTo(dtoList)
    }

    companion object {
        private val DUMMY_MOVIE = MovieDummies.dummyMovie
        private val DUMMY_MOVIE_UI_DTO = MovieUIDTODummies.dummyMovieUIDTO

        private val DUMMY_MOVIE_LIST = MovieDummies.dummyMovieList
        private val DUMMY_MOVIE_UI_DTO_LIST = MovieUIDTODummies.dummyMovieUIDTOList
    }
}
