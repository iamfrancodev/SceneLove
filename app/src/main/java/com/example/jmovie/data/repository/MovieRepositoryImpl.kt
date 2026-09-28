package com.example.jmovie.data.repository

import android.graphics.Region
import com.example.jmovie.data.mapper.toDomain
import com.example.jmovie.data.remote.api.TmdbApiService
import com.example.jmovie.domain.common.NetworkResult
import com.example.jmovie.domain.model.Movie
import com.example.jmovie.domain.model.MovieDetail
import com.example.jmovie.domain.repository.MovieRepository
import org.intellij.lang.annotations.Language
import javax.inject.Inject
import retrofit2.HttpException
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class MovieRepositoryImpl @Inject constructor(
    private val apiService: TmdbApiService
) : MovieRepository {
    override suspend fun getTrendingMovies(
        page: Int,
        language: String,
        region: String,
        timeWindow: String
    ): NetworkResult<List<Movie>> {
        return try {
            val response = apiService.getTrendingMovies(
                page = page,
                language = language,
                region = region,
                timeWindow = timeWindow
            )
            NetworkResult.Success(response.results.map { it.toDomain() })
        } catch (t: Throwable) {
            val message = when (t) {
                is HttpException -> "TMDB request failed (HTTP ${t.code()})."
                else -> t.message ?: "Unable to load movies from TMDB"
            }
            NetworkResult.Error(message = message, throwable = t)
        }
    }

    override suspend fun getPopularMovies(
        page: Int,
        language: String,
        region: String,
    ): NetworkResult<List<Movie>> {
        return try {
            val response =
                apiService.getPopularMovies(page = page, language = language, region = region)
            NetworkResult.Success(response.results.map { it.toDomain() })
        } catch (t: Throwable) {
            val message = when (t) {
                is HttpException -> "TMDB request failed (HTTP ${t.code()})."
                else -> t.message ?: "Unable to load movies from TMDB"
            }
            NetworkResult.Error(message = message, throwable = t)
        }
    }

    override suspend fun getNowPlayingMovies(
        page: Int,
        language: String,
        region: String
    ): NetworkResult<List<Movie>> {
        return try {
            val response =
                apiService.getNowPlayingMovies(page = page, language = language, region = region)
            NetworkResult.Success(response.results.map { it.toDomain() })
        } catch (t: Throwable) {
            val message = when (t) {
                is HttpException -> "TMDB request failed (HTTP ${t.code()})."
                else -> t.message ?: "Unable to load movies from TMDB"
            }
            NetworkResult.Error(message = message, throwable = t)
        }
    }

    override suspend fun getTopRatedMovies(
        page: Int,
        language: String,
        region: String,
    ): NetworkResult<List<Movie>> {
        return try {
            val response =
                apiService.getTopRatedMovies(page = page, language = language, region = region)
            NetworkResult.Success(response.results.map { it.toDomain() })
        } catch (t: Throwable) {
            val message = when (t) {
                is HttpException -> "TMDB request failed (HTTP ${t.code()})."
                else -> t.message ?: "Unable to load movies from TMDB"
            }
            NetworkResult.Error(message = message, throwable = t)
        }
    }

    override suspend fun getUpcomingMovies(
        page: Int,
        language: String,
        region: String,
    ): NetworkResult<List<Movie>> {
        return try {
            val formatter = DateTimeFormatter.ISO_LOCAL_DATE

            val fromDate = LocalDate.now().format(formatter)
            val toDate = LocalDate.now()
                .plusMonths(3)
                .format(formatter)
            val response = apiService.getUpcomingMovies(
                page = page,
                language = language,
                region = region,
                fromDate = fromDate,
                toDate = toDate
            )
            NetworkResult.Success(response.results.map { it.toDomain() })
        } catch (t: Throwable) {
            val message = when (t) {
                is HttpException -> "TMDB request failed (HTTP ${t.code()})."
                else -> t.message ?: "Unable to load movies from TMDB"
            }
            NetworkResult.Error(message = message, throwable = t)
        }
    }

    override suspend fun getMovieDetail(movieId: Int): NetworkResult<MovieDetail> {
        return try {
            val response = apiService.getMovieDetail(movieId = movieId)
            NetworkResult.Success(response.toDomain())
        } catch (t: Throwable) {
            val message = when (t) {
                is HttpException -> "TMDB request failed (HTTP ${t.code()})."
                else -> t.message ?: "Unable to load movie detail from TMDB"
            }
            NetworkResult.Error(message = message, throwable = t)
        }
    }
}


