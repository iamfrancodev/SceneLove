package com.example.jmovie.domain.repository

import com.example.jmovie.domain.common.NetworkResult
import com.example.jmovie.domain.model.Movie

interface MovieRepository {
    suspend fun getTrendingMovies(timeWindow: String = "day"): NetworkResult<List<Movie>>
    suspend fun getPopularMovies(page: Int = 1): NetworkResult<List<Movie>>
    suspend fun getNowPlayingMovies(page: Int = 1): NetworkResult<List<Movie>>
    suspend fun getTopRatedMovies(page: Int = 1): NetworkResult<List<Movie>>
    suspend fun getUpcomingMovies(page: Int = 1): NetworkResult<List<Movie>>
}

