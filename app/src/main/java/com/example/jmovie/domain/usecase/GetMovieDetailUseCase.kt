package com.example.jmovie.domain.usecase

import com.example.jmovie.domain.repository.MovieRepository
import javax.inject.Inject

class GetMovieDetailUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    suspend operator fun invoke(movieId: Int) = repository.getMovieDetail(movieId)
}
