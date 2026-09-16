package com.example.jmovie.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import com.example.jmovie.domain.model.Movie

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    onMovieClick: (Int) -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        if (uiState.movieCatalogs.isEmpty()) {
            viewModel.fetchMovies()
        }
    }

    when {
        uiState.isLoading -> {
            Box(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }

        uiState.error != null -> {
            Box(modifier = Modifier.fillMaxSize()) {
                Column(
                    modifier = Modifier.align(Alignment.Center),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Có lỗi kết nối, vui lòng thử lại!")
                    Spacer(modifier = Modifier.height(12.dp))
                    Button(onClick = { viewModel.fetchMovies() }) {
                        Text(text = "Thử lại")
                    }
                }
            }
        }

        else -> {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 12.dp)
            ) {
                item(key = "header") {
                    HotMovieBanner(
                        movies = uiState.movieCatalogs.firstOrNull()?.movies?.takeLast(3)
                            ?: emptyList()
                    )
                }
                items(
                    items = uiState.movieCatalogs,
                    key = { it.id }
                ) { movieCatalog ->
                    if (!movieCatalog.movies.isEmpty()) {
                        MovieCatalogItem(movieCatalog = movieCatalog)
                        Spacer(modifier = Modifier.height(12.dp))
                    }
                }
                item(key = "footer") {
                    Spacer(modifier = Modifier.height(12.dp))
                }
            }
        }
    }
}

@Composable
fun HotMovieBanner(movies: List<Movie>) {
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { movies.size })
    HorizontalPager(
        state = pagerState,
        contentPadding = PaddingValues(
            end = if (pagerState.currentPage == movies.size - 1) 12.dp else 24.dp
        ),
        pageSpacing = 12.dp,
    ) { page ->
        HotMovieItem(movie = movies[page])
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(movies.size) { index ->
            Box(
                modifier = Modifier
                    .padding(4.dp)
                    .size(8.dp)
                    .clip(CircleShape)
                    .background(
                        color = if (pagerState.currentPage == index) Color.Black else Color.Gray
                    )
            )
        }
    }
}

@Composable
fun HotMovieItem(movie: Movie) {
    AsyncImage(
        model = movie.backdropUrl,
        contentDescription = movie.title,
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .clip(RoundedCornerShape(12.dp)),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun MovieCatalogItem(
    movieCatalog: MovieCatalog
) {
    if (movieCatalog.movies.isEmpty()) return
    Column {
        Text(
            text = movieCatalog.title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 6.dp)
        )
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            itemsIndexed(
                items = movieCatalog.movies,
                key = { index, item -> item.id }
            ) { index, movie ->
                val isUpComing = movieCatalog.title == "Upcoming"
                MovieItem(movie, isUpComing)
                if (index == movieCatalog.movies.size - 1) {
                    Spacer(modifier = Modifier.width(12.dp))
                }
            }
        }
    }
}

@Composable
fun MovieItem(movie: Movie, isUpComing: Boolean = false) {
    Column(
        modifier = Modifier.width(IntrinsicSize.Min)
    ) {
        AsyncImage(
            model = movie.posterUrl,
            contentDescription = movie.title,
            modifier = Modifier
                .width(145.dp)
                .height(185.dp)
                .clip(shape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp)),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(bottomStart = 4.dp, bottomEnd = 4.dp))
                .background(Color.Black)
                .padding(4.dp),
        ) {
            Text(
                text = movie.title,
                modifier = Modifier.fillMaxWidth(),
                fontSize = 12.sp,
                lineHeight = 12.sp,
                maxLines = 1,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                overflow = TextOverflow.Ellipsis
            )
            val descriptionText = if (isUpComing) {
                "Dự kiến: ${movie.releaseDate}"
            } else {
                "★ ${movie.voteAverage} • ${movie.releaseDate}"
            }
            Text(
                text = descriptionText,
                fontSize = 10.sp,
                lineHeight = 10.sp,
                maxLines = 1,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Preview
@Composable
fun MovieItemPreview() {
    MovieItem(
        Movie(
            id = 1,
            title = "Moana",
            overview = "Teenage Moana answers the Ocean's call and, for the first time, voyages beyond the reef of her island of Motunui with infamous demigod Maui on an unforgettable journey to restore prosperity to her people.",
            posterUrl = "https://image.tmdb.org/t/p/w342/gaet1xQ2nxrG0V1Ep9T20ZMNEIC.jpg",
            backdropUrl = "",
            voteAverage = 7.85,
            releaseDate = "2023-11-23"
        )
    )
}
