package com.example.jmovie.data.remote.api

import com.example.jmovie.data.remote.dto.PopularMoviesResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface TmdbApiService {
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("page") page: Int = 1,
        @Query("language") language: String = "en-US"
    ): PopularMoviesResponseDto
}

