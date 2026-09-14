package com.example.jmovie.domain.usecase

import com.example.jmovie.domain.repository.MovieRepository
import javax.inject.Inject

class GetTrendingMoviesUseCase @Inject constructor(
    private val repository: MovieRepository
) {

    suspend operator fun invoke(timeWindow: String = "day") =
        repository.getTrendingMovies(timeWindow = timeWindow)
}

