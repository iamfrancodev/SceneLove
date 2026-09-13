package com.example.jmovie.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jmovie.ui.MainScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = MainRoute
    ) {
        composable<SplashRoute> {

        }

        composable<LoginRoute> {

        }

        composable<SignUpRoute> {

        }

        composable<MainRoute> {
            MainScreen()
        }
    }
}
