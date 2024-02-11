package com.example.smylest.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Preview
@Composable
private fun PreviewBrowseRequestsScreen() {
    ComposeResponseScreen(rememberNavController())
}

/**
 * A screen where users can browse smile requests they may want to respond to
 */
@Composable
fun BrowseRequestsScreen(navController: NavController) {}