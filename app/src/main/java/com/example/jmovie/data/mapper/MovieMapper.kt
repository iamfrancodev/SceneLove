package com.example.jmovie.data.mapper

import com.example.jmovie.data.remote.dto.MovieDto
import com.example.jmovie.domain.model.Movie

private const val TMDB_POSTER_IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500"
private const val TMDB_BACK_DROP_IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w1280"

fun MovieDto.toDomain(): Movie {
    val posterUrl = posterPath?.let { "$TMDB_POSTER_IMAGE_BASE_URL$it" }
    val backdropUrl = backdropPath?.let { "$TMDB_BACK_DROP_IMAGE_BASE_URL$it" }
    return Movie(
        id = id,
        title = title,
        overview = overview,
        posterUrl = posterUrl,
        backdropUrl = backdropUrl,
    )
}

