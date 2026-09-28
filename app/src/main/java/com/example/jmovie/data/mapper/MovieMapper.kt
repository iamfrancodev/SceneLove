package com.example.jmovie.data.mapper

import com.example.jmovie.data.remote.dto.MovieDetailResponseDto
import com.example.jmovie.data.remote.dto.MovieDto
import com.example.jmovie.domain.model.Genre
import com.example.jmovie.domain.model.Movie
import com.example.jmovie.domain.model.MovieDetail
import com.example.jmovie.util.dateFormat
import java.math.RoundingMode

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
        voteAverage = voteAverage.toBigDecimal().setScale(1, RoundingMode.HALF_UP).toDouble(),
        releaseDate = releaseDate.dateFormat()
    )
}

fun MovieDetailResponseDto.toDomain(): MovieDetail {
    val posterUrl = posterPath?.let { "$TMDB_POSTER_IMAGE_BASE_URL$it" }
    val backdropUrl = backdropPath?.let { "$TMDB_BACK_DROP_IMAGE_BASE_URL$it" }
    return MovieDetail(
        adult = adult,
        backdropPath = backdropUrl,
        budget = budget,
        genres = genres.map { Genre(it.id, it.name) },
        homepage = homepage,
        id = id,
        imdbId = imdbId,
        originalLanguage = originalLanguage,
        originalTitle = originalTitle,
        overview = overview,
        popularity = popularity,
        posterPath = posterUrl,
        releaseDate = releaseDate.dateFormat(),
        status = status,
        title = title,
        video = video,
        voteAverage = voteAverage.toBigDecimal().setScale(1, RoundingMode.HALF_UP).toDouble(),
        voteCount = voteCount
    )
}

