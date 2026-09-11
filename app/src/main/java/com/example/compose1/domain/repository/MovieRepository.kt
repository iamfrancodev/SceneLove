package com.example.compose1.domain.repository

import com.example.compose1.domain.common.NetworkResult
import com.example.compose1.domain.model.Movie

interface MovieRepository {
    suspend fun getPopularMovies(page: Int = 1): NetworkResult<List<Movie>>
}

