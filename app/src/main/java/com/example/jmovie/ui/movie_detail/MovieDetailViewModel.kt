package com.example.jmovie.ui.movie_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jmovie.domain.common.NetworkResult
import com.example.jmovie.domain.usecase.GetMovieDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val getMovieDetailUseCase: GetMovieDetailUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(MovieDetailUIState())
    val uiState: StateFlow<MovieDetailUIState> = _uiState.asStateFlow()

    fun fetchMovieDetail(movieId: Int) {
        if (_uiState.value.isLoading) return
        viewModelScope.launch {
            try {
                _uiState.update { it.copy(isLoading = true, error = null) }
                val result = getMovieDetailUseCase(movieId)
                val data = if (result is NetworkResult.Success) {
                    result.data
                } else {
                    null
                }

                _uiState.update { it.copy(isLoading = false, movieDetail = data) }
            } catch (e: Exception) {
                _uiState.update { it.copy(isLoading = false, error = e.message ?: "Unknown error")}
            }
        }
    }
}
