package com.example.jmovie.ui.library

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight

@Composable
fun LibraryScreen(onMovieClick: (Int) -> Unit) {
    Text(text = "Library Screen", fontWeight = FontWeight.Bold)
}
