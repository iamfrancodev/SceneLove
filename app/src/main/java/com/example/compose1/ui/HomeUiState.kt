package com.example.compose1.ui

import com.example.compose1.domain.model.Movie

data class HomeUiState(
    val isLoading: Boolean = false,
    val movies: List<Movie> = emptyList(),
    val error: String? = null
)

