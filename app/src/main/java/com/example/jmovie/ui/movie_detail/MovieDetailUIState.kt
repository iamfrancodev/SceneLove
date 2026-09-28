package com.example.jmovie.ui.movie_detail

import com.example.jmovie.domain.model.MovieDetail

data class MovieDetailUIState(
    val isLoading: Boolean = false,
    val movieDetail: MovieDetail? = null,
    val error: String? = null
)
