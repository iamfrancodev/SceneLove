package com.example.jmovie.domain.usecase

import com.example.jmovie.domain.repository.MovieRepository
import javax.inject.Inject

class GetTopRatedMoviesUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    suspend operator fun invoke(page: Int = 1) = repository.getTopRatedMovies(page = page)
}

