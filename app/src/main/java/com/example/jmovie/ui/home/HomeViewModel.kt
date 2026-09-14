package com.example.jmovie.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jmovie.domain.common.NetworkResult
import com.example.jmovie.domain.model.Movie
import com.example.jmovie.domain.usecase.GetNowPlayingMoviesUseCase
import com.example.jmovie.domain.usecase.GetPopularMoviesUseCase
import com.example.jmovie.domain.usecase.GetTopRatedMoviesUseCase
import com.example.jmovie.domain.usecase.GetTrendingMoviesUseCase
import com.example.jmovie.domain.usecase.GetUpcomingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getTrendingMoviesUseCase: GetTrendingMoviesUseCase,
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase,
    private val getNowPlayingMoviesUseCase: GetNowPlayingMoviesUseCase,
    private val getTopRatedMoviesUseCase: GetTopRatedMoviesUseCase,
    private val getUpcomingUseCase: GetUpcomingUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    fun fetchMovies() {
        if (_uiState.value.isLoading) return

        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, error = null) }

            try {
                val trendingDeferred = async { getTrendingMoviesUseCase("day") }
                val popularDeferred = async { getPopularMoviesUseCase() }
                val nowPlayingDeferred = async { getNowPlayingMoviesUseCase() }
                val topRatedDeferred = async { getTopRatedMoviesUseCase() }
                val upcomingDeferred = async { getUpcomingUseCase() }

                val trendingResult = trendingDeferred.await()
                val popularResult = popularDeferred.await()
                val nowPlayingResult = nowPlayingDeferred.await()
                val topRatedResult = topRatedDeferred.await()
                val upcomingResult = upcomingDeferred.await()

                val trendingMovies = if (trendingResult is NetworkResult.Success) {
                    trendingResult.data
                } else {
                    emptyList()
                }

                // popular and now playing data is same same, so off popular
                val popularMovies = emptyList<Movie>()

                val nowPlayingMovies = if (nowPlayingResult is NetworkResult.Success) {
                    nowPlayingResult.data
                } else {
                    emptyList()
                }

                val topRatedMovies = if (topRatedResult is NetworkResult.Success) {
                    topRatedResult.data
                } else {
                    emptyList()
                }

                val upcomingMovies = if (upcomingResult is NetworkResult.Success) {
                    upcomingResult.data
                } else {
                    emptyList()
                }

                _uiState.update {
                    it.copy(
                        isLoading = false,
                        movieCatalogs = listOf(
                            MovieCatalog(
                                id = 1,
                                title = "Trending",
                                movies = trendingMovies
                            ),
                            MovieCatalog(
                                id = 2,
                                title = "Popular",
                                movies = popularMovies
                            ),
                            MovieCatalog(
                                id = 3,
                                title = "Now Playing",
                                movies = nowPlayingMovies
                            ),
                            MovieCatalog(
                                id = 4,
                                title = "Top Rated",
                                movies = topRatedMovies
                            ),
                            MovieCatalog(
                                id = 5,
                                title = "Upcoming",
                                movies = upcomingMovies
                            )
                        )
                    )
                }
            } catch (e: Exception) {
                _uiState.update { it.copy(isLoading = false, error = e.message) }
            } finally {
                _uiState.update { it.copy(isLoading = false) }
            }
        }
    }
}

