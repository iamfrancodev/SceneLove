package com.example.jmovie.data.repository

import com.example.jmovie.data.mapper.toDomain
import com.example.jmovie.data.remote.api.TmdbApiService
import com.example.jmovie.domain.common.NetworkResult
import com.example.jmovie.domain.model.Movie
import com.example.jmovie.domain.repository.MovieRepository
import javax.inject.Inject
import retrofit2.HttpException

class MovieRepositoryImpl @Inject constructor(
    private val apiService: TmdbApiService
) : MovieRepository {
    override suspend fun getTrendingMovies(timeWindow: String): NetworkResult<List<Movie>> {
        return try {
            val response = apiService.getTrendingMovies(timeWindow = timeWindow)
            NetworkResult.Success(response.results.map { it.toDomain() })
        } catch (t: Throwable) {
            val message = when (t) {
                is HttpException -> "TMDB request failed (HTTP ${t.code()})."
                else -> t.message ?: "Unable to load movies from TMDB"
            }
            NetworkResult.Error(message = message, throwable = t)
        }
    }

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

    override suspend fun getNowPlayingMovies(page: Int): NetworkResult<List<Movie>> {
        return try {
            val response = apiService.getNowPlayingMovies(page = page)
            NetworkResult.Success(response.results.map { it.toDomain() })
        } catch (t: Throwable) {
            val message = when (t) {
                is HttpException -> "TMDB request failed (HTTP ${t.code()})."
                else -> t.message ?: "Unable to load movies from TMDB"
            }
            NetworkResult.Error(message = message, throwable = t)
        }
    }

    override suspend fun getTopRatedMovies(page: Int): NetworkResult<List<Movie>> {
        return try {
            val response = apiService.getTopRatedMovies(page = page)
            NetworkResult.Success(response.results.map { it.toDomain() })
        } catch (t: Throwable) {
            val message = when (t) {
                is HttpException -> "TMDB request failed (HTTP ${t.code()})."
                else -> t.message ?: "Unable to load movies from TMDB"
            }
            NetworkResult.Error(message = message, throwable = t)
        }
    }

    override suspend fun getUpcomingMovies(page: Int): NetworkResult<List<Movie>> {
        return try {
            val response = apiService.getUpcomingMovies(page = page)
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


