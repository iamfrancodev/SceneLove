package com.example.compose1.domain.usecase

import com.example.compose1.domain.repository.MovieRepository
import javax.inject.Inject

class GetPopularMoviesUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    suspend operator fun invoke(page: Int = 1) = repository.getPopularMovies(page = page)
}

