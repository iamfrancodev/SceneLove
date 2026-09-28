package com.example.jmovie.domain.model

data class MovieDetail(
    val adult: Boolean,
    val backdropPath: String?,
    val budget: Long,
    val genres: List<Genre>,
    val homepage: String?,
    val id: Int,
    val imdbId: String?,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String?,
    val releaseDate: String,
    val status: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int,
)

data class Genre (
    val id: Int,
    val name: String
)
