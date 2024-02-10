package com.example.smylest.screens

import androidx.compose.runtime.Composable

sealed class Screen(val route: String) {
    object HomeScreen : Screen("home_screen")
    object ComposeRequestScreen : Screen("compose_request_screen")
    object ComposeResponseScreen : Screen("compose_response_screen")
    object InboxScreen : Screen("inbox_screen")
    object BrowseRequestsScreen : Screen("browse_requests_screen")
}