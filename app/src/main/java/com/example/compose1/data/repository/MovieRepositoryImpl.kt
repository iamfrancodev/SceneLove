package com.example.compose1.data.repository

import com.example.compose1.data.mapper.toDomain
import com.example.compose1.data.remote.api.TmdbApiService
import com.example.compose1.domain.common.NetworkResult
import com.example.compose1.domain.model.Movie
import com.example.compose1.domain.repository.MovieRepository
import javax.inject.Inject
import retrofit2.HttpException

class MovieRepositoryImpl @Inject constructor(
    private val apiService: TmdbApiService
) : MovieRepository {
    override suspend fun getPopularMovies(page: Int): NetworkResult<List<Movie>> {
        return try {
            val response = apiService.getPopularMovies(page = page)
            NetworkResult.Success(response.results.map { it.toDomain() })
        } catch (t: Throwable) {
            val message = when (t) {
                is HttpException -> "TMDB request failed (HTTP ${t.code()})."
                else -> t.message ?: "Unable to load movies from TMDB"
            }
            NetworkResult.Error(message = message, throwable = t)
        }
    }
}


