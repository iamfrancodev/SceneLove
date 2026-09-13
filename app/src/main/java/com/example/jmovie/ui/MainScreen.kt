package com.example.jmovie.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.jmovie.navigation.main.AppNavigationBar
import com.example.jmovie.navigation.main.HomeTopAppBar
import com.example.jmovie.navigation.main.MainNavHost
import com.example.jmovie.navigation.main.NotificationRoute
import com.example.jmovie.navigation.main.SearchRoute
import com.example.jmovie.navigation.main.TopLevelDestination
import com.example.jmovie.navigation.main.navigateToTopLevel
import com.example.jmovie.navigation.main.toTopLevelDestination

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val currentTopLevelDestination = currentDestination.toTopLevelDestination()
    val isShowTopAppBar = currentTopLevelDestination != null && currentTopLevelDestination == TopLevelDestination.HOME
    val isShowNavigationBar = currentTopLevelDestination != null
    Scaffold(
        topBar = {
            if (isShowTopAppBar) {
                HomeTopAppBar(
                    onSearchBarClick = {
                        navController.navigate(SearchRoute)
                    },
                    onNotificationClick = {
                        navController.navigate(NotificationRoute)
                    }
                )
            }
        },
        bottomBar = {
            if (isShowNavigationBar) {
                AppNavigationBar(
                    currentDestination = currentTopLevelDestination,
                    onNavigate = { destination ->
                        navController.navigateToTopLevel(destination)
                    }
                )
            }
        }
    ) { innerPadding ->
        MainNavHost(
            navController = navController,
            modifier = Modifier.padding(innerPadding)
        )
    }
}

