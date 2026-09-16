package com.example.jmovie.domain.usecase

import com.example.jmovie.domain.repository.MovieRepository
import com.example.jmovie.util.UserRegion
import javax.inject.Inject

class GetTrendingMoviesUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    val defaultUserRegion = UserRegion(
        countryCode = "VN",
        languageCode = "vi-VN",
    )

    suspend operator fun invoke(page: Int = 1, timeWindow: String = "day") =
        repository.getTrendingMovies(
            page = page,
            language = defaultUserRegion.languageCode,
            region = defaultUserRegion.countryCode,
            timeWindow = timeWindow
        )
}

