package com.example.compose1

import com.example.compose1.data.mapper.toDomain
import com.example.compose1.data.remote.dto.MovieDto
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class ExampleUnitTest {
    @Test
    fun movie_mapper_builds_expected_domain_model() {
        val dto = MovieDto(
            id = 1,
            title = "Interstellar",
            overview = "Space exploration",
            posterPath = "/poster.jpg"
        )

        val movie = dto.toDomain()

        assertEquals(1, movie.id)
        assertEquals("Interstellar", movie.title)
        assertEquals("Space exploration", movie.overview)
        assertEquals("https://image.tmdb.org/t/p/w500/poster.jpg", movie.posterUrl)
    }

    @Test
    fun movie_mapper_handles_null_poster_path() {
        val dto = MovieDto(
            id = 2,
            title = "No Poster",
            overview = "No poster available",
            posterPath = null
        )

        val movie = dto.toDomain()

        assertNull(movie.posterUrl)
    }
}
