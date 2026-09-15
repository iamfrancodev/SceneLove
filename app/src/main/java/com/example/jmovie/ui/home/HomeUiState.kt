package com.example.jmovie.ui.home

import com.example.jmovie.domain.model.Movie

data class HomeUiState(
    val isLoading: Boolean = false,
    var movieCatalogs: List<MovieCatalog> = emptyList(),
    val error: String? = null,
    val isRefreshing: Boolean = false
)

data class MovieCatalog(
    val id: Int,
    val title: String,
    val movies: List<Movie> = emptyList()
)

