package com.example.compose1.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.compose1.ui.MainScreen
import com.example.compose1.ui.SplashScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "splash")
    {
        composable("splash") {
            SplashScreen(
                onNavigateToMain = {
                    navController.navigate("main") {
                        popUpTo("splash") {
                            inclusive = true
                        }
                    }
                }
            )
        }
        composable("main") { MainScreen() }
    }
}
