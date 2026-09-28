package com.example.jmovie.data.remote.dto

import com.google.gson.annotations.SerializedName

data class MovieDetailResponseDto(
    @SerializedName("adult")
    val adult: Boolean,

    @SerializedName("backdrop_path")
    val backdropPath: String?,

    @SerializedName("belongs_to_collection")
    val belongsToCollection: MovieCollectionDto?,

    @SerializedName("budget")
    val budget: Long,

    @SerializedName("genres")
    val genres: List<GenreDto>,

    @SerializedName("homepage")
    val homepage: String?,

    @SerializedName("id")
    val id: Int,

    @SerializedName("imdb_id")
    val imdbId: String?,

    @SerializedName("origin_country")
    val originCountry: List<String>,

    @SerializedName("original_language")
    val originalLanguage: String,

    @SerializedName("original_title")
    val originalTitle: String,

    @SerializedName("overview")
    val overview: String,

    @SerializedName("popularity")
    val popularity: Double,

    @SerializedName("poster_path")
    val posterPath: String?,

    @SerializedName("production_companies")
    val productionCompanies: List<ProductionCompanyDto>,

    @SerializedName("production_countries")
    val productionCountries: List<ProductionCountryDto>,

    @SerializedName("release_date")
    val releaseDate: String,

    @SerializedName("revenue")
    val revenue: Long,

    @SerializedName("runtime")
    val runtime: Int?,

    @SerializedName("softcore")
    val softcore: Boolean,

    @SerializedName("spoken_languages")
    val spokenLanguages: List<SpokenLanguageDto>,

    @SerializedName("status")
    val status: String,

    @SerializedName("tagline")
    val tagline: String?,

    @SerializedName("title")
    val title: String,

    @SerializedName("video")
    val video: Boolean,

    @SerializedName("vote_average")
    val voteAverage: Double,

    @SerializedName("vote_count")
    val voteCount: Int,
)

data class MovieCollectionDto(
    val id: Int,
    val name: String,

    @SerializedName("poster_path")
    val posterPath: String?,

    @SerializedName("backdrop_path")
    val backdropPath: String?,
)

data class GenreDto(
    val id: Int,
    val name: String,
)

data class ProductionCompanyDto(
    val id: Int,

    @SerializedName("logo_path")
    val logoPath: String?,

    val name: String,

    @SerializedName("origin_country")
    val originCountry: String,
)

data class ProductionCountryDto(
    @SerializedName("iso_3166_1")
    val countryCode: String,

    val name: String,
)

data class SpokenLanguageDto(
    @SerializedName("english_name")
    val englishName: String,

    @SerializedName("iso_639_1")
    val languageCode: String,

    val name: String,
)
