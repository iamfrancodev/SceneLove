package com.example.compose1.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.example.compose1.theme.JFrancoTheme
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(onNavigateToMain: () -> Unit) {

    LaunchedEffect(Unit) {
        delay(2000)
        onNavigateToMain()
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Text(text = "Splash Screen", modifier = Modifier.align(Alignment.Center))
    }
}

@Preview(showSystemUi = true)
@PreviewLightDark
@Composable
fun SplashScreenPreview() {

    JFrancoTheme() {
        Surface() {
            SplashScreen {}
        }
    }
}
