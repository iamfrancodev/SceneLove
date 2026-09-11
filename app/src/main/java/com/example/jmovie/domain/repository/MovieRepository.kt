package com.example.jmovie.domain.repository

import com.example.jmovie.domain.common.NetworkResult
import com.example.jmovie.domain.model.Movie

interface MovieRepository {
    suspend fun getPopularMovies(page: Int = 1): NetworkResult<List<Movie>>
}

