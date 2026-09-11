package com.example.compose1.data.mapper

import com.example.compose1.data.remote.dto.MovieDto
import com.example.compose1.domain.model.Movie

private const val TMDB_IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500"

fun MovieDto.toDomain(): Movie {
    val posterUrl = posterPath?.let { "$TMDB_IMAGE_BASE_URL$it" }
    return Movie(
        id = id,
        title = title,
        overview = overview,
        posterUrl = posterUrl
    )
}

