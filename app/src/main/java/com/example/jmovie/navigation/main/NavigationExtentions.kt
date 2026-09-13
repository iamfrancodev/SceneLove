package com.example.jmovie.navigation.main

import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavOptionsBuilder

fun NavDestination?.toTopLevelDestination(): TopLevelDestination? {

    val currentDestination = this ?: return null
    return when {
        currentDestination.hierarchy.any { it.hasRoute<HomeRoute>() } -> TopLevelDestination.HOME
        currentDestination.hierarchy.any { it.hasRoute<DiscussRoute>() } -> TopLevelDestination.DISCUSS
        currentDestination.hierarchy.any { it.hasRoute<MatchRoute>() } -> TopLevelDestination.MATCH
        currentDestination.hierarchy.any { it.hasRoute<LibraryRoute>() } -> TopLevelDestination.LIBRARY
        currentDestination.hierarchy.any { it.hasRoute<ProfileRoute>() } -> TopLevelDestination.PROFILE
        else -> null
    }
}

fun NavHostController.navigateToTopLevel(
    destination: TopLevelDestination
) {

    val navOptions: NavOptionsBuilder.() -> Unit = {

        popUpTo(
            graph.findStartDestination().id
        ) {
            saveState = true
        }

        launchSingleTop = true

        restoreState = true
    }

    when (destination) {

        TopLevelDestination.HOME -> {
            navigate(
                route = HomeRoute,
                builder = navOptions
            )
        }

        TopLevelDestination.DISCUSS -> {
            navigate(
                route = DiscussRoute,
                builder = navOptions
            )
        }

        TopLevelDestination.MATCH -> {
            navigate(
                route = MatchRoute,
                builder = navOptions
            )
        }

        TopLevelDestination.LIBRARY -> {
            navigate(
                route = LibraryRoute,
                builder = navOptions
            )
        }

        TopLevelDestination.PROFILE -> {
            navigate(
                route = ProfileRoute,
                builder = navOptions
            )
        }
    }
}


