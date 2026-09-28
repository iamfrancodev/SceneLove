package com.example.jmovie.domain.repository

import com.example.jmovie.domain.common.NetworkResult
import com.example.jmovie.domain.model.Movie
import com.example.jmovie.domain.model.MovieDetail
import org.intellij.lang.annotations.Language

interface MovieRepository {
    suspend fun getTrendingMovies(page: Int, language: String, region: String, timeWindow: String = "day"): NetworkResult<List<Movie>>
    suspend fun getPopularMovies(page: Int, language: String, region: String ): NetworkResult<List<Movie>>
    suspend fun getNowPlayingMovies(page: Int, language: String, region: String ): NetworkResult<List<Movie>>
    suspend fun getTopRatedMovies(page: Int,  language: String, region: String ): NetworkResult<List<Movie>>
    suspend fun getUpcomingMovies(page: Int,  language: String, region: String): NetworkResult<List<Movie>>

    suspend fun getMovieDetail(movieId: Int): NetworkResult<MovieDetail>
}

