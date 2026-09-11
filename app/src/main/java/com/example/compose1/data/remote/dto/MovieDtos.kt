package com.example.compose1.data.remote.dto

import com.google.gson.annotations.SerializedName

data class PopularMoviesResponseDto(
    @SerializedName("results")
    val results: List<MovieDto>
)

data class MovieDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("poster_path")
    val posterPath: String?
)

