package com.example.jmovie.ui.movie_detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.jmovie.domain.model.MovieDetail

@Composable
fun MovieDetailScreen(
    viewModel: MovieDetailViewModel = hiltViewModel(),
    movieId: Int
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    LaunchedEffect(movieId) {
        viewModel.fetchMovieDetail(movieId)
    }

    when {
        uiState.isLoading -> {
            Box(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.Center)
                )
            }
        }

        uiState.movieDetail != null -> {

        }

        else -> {
            Column(modifier = Modifier.fillMaxSize().padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center) {
                Text("Không có dữ liệu, vui lòng thử lại sau!")
                Spacer(modifier = Modifier.padding(2.dp))
                Button(
                    onClick = {  },
                    shape = RoundedCornerShape(4.dp)
                ) {
                    Text("Thử lại")
                }
            }
        }
    }
}

@Composable
fun MovieDetailUI(movieDetail: MovieDetail) {

}


@Preview
@Composable
fun MovieDetailScreenPreview() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Text("Không có dữ liệu, vui lòng thử lại sau!", color = Color.White)
        Spacer(modifier = Modifier.padding(2.dp))
        Button(
            onClick = {  },
            shape = RoundedCornerShape(4.dp)
        ) {
            Text("Thử lại")
        }
    }
}
