package com.example.jmovie.navigation.main

import kotlinx.serialization.Serializable

/*
* Top Level Destinations
* */

@Serializable
data object HomeRoute

@Serializable
data object DiscussRoute

@Serializable
data object MatchRoute

@Serializable
data object LibraryRoute

@Serializable
data object ProfileRoute

/*
* Child Destinations
* */

@Serializable
data object SearchRoute

@Serializable
data object NotificationRoute

@Serializable
data class MovieDetailRoute(val movieId: Int)

@Serializable
data class  PostDetailRoute(val postId: Int)

@Serializable
data class MatchResultRoute(val movieId: Int)

@Serializable
data object SettingsRoute

@Serializable
data object EditProfileRoute

