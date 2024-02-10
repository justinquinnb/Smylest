package com.example.smylest.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.smylest.DEMO_MODE
import com.example.smylest.R
import com.example.smylest.components.BasicPage
import com.example.smylest.components.SmylestWideTextButton
import com.example.smylest.ui.theme.SmylestTheme

/*
Col:
    Header
    Subheader
    WideTextButton
    WideTextButton
    SquigglyTextButton
    Spacer
    Logo
 */
@Preview
@Composable
fun PreviewHomeScreen() {
    HomeScreen(rememberNavController(), PaddingValues(0.dp))
}

/**
 * Home screen, allowing users to choose what they need
 */
@Composable
fun HomeScreen(navController: NavController, contentPadding: PaddingValues) {
    BasicPage {
        Column(modifier = Modifier
            .padding(contentPadding)
            .padding(15.dp)
        ) {
            Spacer(Modifier.height(200.dp))

            // Welcome message
            Column(
                Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth(0.75f)
            ){
                Text(
                    text = if (DEMO_MODE) "How's it going, Justin!" else "How's it going!",
                    style = SmylestTheme.typography.displayLarge,
                    color = SmylestTheme.colors.onBackgroundPrimary,
                )
                Text(
                    text = "What are you looking for today?",
                    style = SmylestTheme.typography.displayMedium,
                    color = SmylestTheme.colors.onBackgroundSecondary
                )
            }

            // Page selection
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(20.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top=30.dp)
            ) {
                SmylestWideTextButton(text = "I need a smile!") {
                    navController.navigate(Screen.ComposeRequestScreen.route)
                }
                SmylestWideTextButton(text = "I want to share smiles!") {
                    navController.navigate(Screen.BrowseRequestsScreen.route)
                }
            }

            Spacer(Modifier.height(200.dp))

            val logotype: Int = if (isSystemInDarkTheme()) R.drawable.smylestlogotype_dark_ else R.drawable.smylestlogotype_light_
            Image(
                painter = painterResource(id = logotype),
                contentDescription = "Smylest Wordmark",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxWidth(0.6f)
                    .align(Alignment.CenterHorizontally)
            )
        }
    }
}