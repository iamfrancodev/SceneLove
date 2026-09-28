package com.example.jmovie.navigation.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.jmovie.ui.movie_detail.MovieDetailScreen
import com.example.jmovie.ui.discuss.DiscussScreen
import com.example.jmovie.ui.home.HomeScreen
import com.example.jmovie.ui.home.notification.NotificationScreen
import com.example.jmovie.ui.home.search.SearchScreen
import com.example.jmovie.ui.library.LibraryScreen
import com.example.jmovie.ui.match.MatchScreen
import com.example.jmovie.ui.profile.ProfileScreen

@Composable
fun MainNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {

    NavHost(navController = navController, startDestination = HomeRoute, modifier = modifier)
    {

        // =====================================
        // HOME
        // =====================================
        composable<HomeRoute> {
            HomeScreen(
                onMovieClick = { movieId ->

                    navController.navigate(
                        MovieDetailRoute(
                            movieId = movieId
                        )
                    )
                }
            )
        }

        // =====================================
        // Search
        // =====================================

        composable<SearchRoute> {
            SearchScreen()
        }

        // =====================================
        // Notification
        // =====================================

        composable<NotificationRoute> {
            NotificationScreen()
        }

        // =====================================
        // Discuss
        // =====================================
        composable<DiscussRoute> {
            DiscussScreen(
                onPostClick = { postId ->
                    navController.navigate(PostDetailRoute(postId = postId))
                }
            )
        }

        // =====================================
        // MATCH
        // =====================================

        composable<MatchRoute> {

            MatchScreen(
                onMovieMatched = { movieId ->

                    navController.navigate(
                        MatchResultRoute(
                            movieId = movieId
                        )
                    )
                }
            )
        }


        // =====================================
        // LIBRARY
        // =====================================

        composable<LibraryRoute> {

            LibraryScreen(
                onMovieClick = { movieId ->

                    navController.navigate(
                        MovieDetailRoute(
                            movieId = movieId
                        )
                    )
                }
            )
        }


        // =====================================
        // PROFILE
        // =====================================

        composable<ProfileRoute> {

            ProfileScreen(
                onSettingsClick = {

                    navController.navigate(
                        SettingsRoute
                    )
                },

                onEditProfileClick = {

                    navController.navigate(
                        EditProfileRoute
                    )
                }
            )
        }

        composable<MovieDetailRoute> {
            MovieDetailScreen(
                movieId = it.arguments?.getInt("movieId") ?: 0
            )
        }
    }
}
