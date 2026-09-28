package com.example.jmovie.data.remote.api

import com.example.jmovie.data.remote.dto.MovieDetailResponseDto
import com.example.jmovie.data.remote.dto.MoviesResponseDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TmdbApiService {

    @GET("trending/movie/{time_window}")
    suspend fun getTrendingMovies(
        @Path("time_window") timeWindow: String = "day",
        @Query("page") page: Int = 1,
        @Query("language") language: String = "vi-VN",
        @Query("region") region: String = "VN",
    ): MoviesResponseDto

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("page") page: Int = 1,
        @Query("language") language: String = "vi-VN",
        @Query("region") region: String = "VN",
    ): MoviesResponseDto

    @GET("movie/now_playing")
    suspend fun getNowPlayingMovies(
        @Query("page") page: Int = 1,
        @Query("language") language: String = "vi-VN",
        @Query("region") region: String = "VN",
    ): MoviesResponseDto

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(
        @Query("page") page: Int = 1,
        @Query("language") language: String = "vi-VN",
        @Query("region") region: String = "VN",
    ): MoviesResponseDto

    @GET("discover/movie")
    suspend fun getUpcomingMovies(
        @Query("page") page: Int = 1,
        @Query("language") language: String = "vi-VN",
        @Query("region") region: String = "VN",
        @Query("with_release_type") releaseType: String = "2|3",
        @Query("release_date.gte") fromDate: String,
        @Query("release_date.lte") toDate: String,
        @Query("sort_by") sortBy: String = "popularity.desc",
    ): MoviesResponseDto

    @GET("movie/{movie_id}")
    suspend fun getMovieDetail(
        @Path("movie_id") movieId: Int = 0
    ): MovieDetailResponseDto

}

