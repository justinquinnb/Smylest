package com.example.smylest.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation(contentPadding: PaddingValues) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
        composable(route = Screen.HomeScreen.route) {
            HomeScreen(navController = navController)
        }

        composable(route = Screen.ComposeRequestScreen.route) {
            ComposeRequestScreen(navController = navController)
        }

        composable(route = Screen.ComposeResponseScreen.route) {
            ComposeResponseScreen(navController = navController)
        }

        composable(route = Screen.InboxScreen.route) {
            InboxScreen(navController = navController)
        }

        composable(route = Screen.BrowseRequestsScreen.route) {
            BrowseRequestsScreen(navController = navController)
        }
    }
}