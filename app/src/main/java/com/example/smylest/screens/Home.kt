package com.example.smylest.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.smylest.PERSONAL_MODE
import com.example.smylest.R
import com.example.smylest.components.BasicPage
import com.example.smylest.components.SmylestWideTextButton
import com.example.smylest.types.MessageType
import com.example.smylest.types.MessageVisibility
import com.example.smylest.types.OutboundMessage
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
private fun PreviewHomeScreen() {
    HomeScreen(rememberNavController())
}

/**
 * Home screen, allowing users to choose what they need
 */
@Composable
fun HomeScreen(navController: NavController) {
    BasicPage {
        Column() {
            Spacer(Modifier.weight(.2f))

            // Welcome message
            Column(
                Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth(0.75f)
            ){
                Text(
                    text = if (PERSONAL_MODE) "How's it going, Justin!" else "How's it going!",
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
                // Main flow buttons
                SmylestWideTextButton(text = "I need a smile!") {
                    navController.navigate(Screen.ComposeRequestScreen.route)
                }
                SmylestWideTextButton(text = "I want to share smiles!") {
                    navController.navigate(Screen.BrowseRequestsScreen.route)
                }

                // Inbox button
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(0.dp),
                    modifier = Modifier
                        .fillMaxWidth(0.75f)
                        .clickable(){
                            navController.navigate(Screen.InboxScreen.route)
                        }
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.squigglyline),
                        contentDescription = "Divider",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .weight(.4f)
                            .graphicsLayer(translationY = 5f)
                    )
                    Text(
                        text = "Inbox",
                        style = SmylestTheme.typography.labelLarge,
                        color = SmylestTheme.colors.onBackgroundPrimary,
                        modifier = Modifier
                            .weight(.2f)
                            .wrapContentWidth()
                    )
                    Image(
                        painter = painterResource(id = R.drawable.squigglyline),
                        contentDescription = "Divider",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .weight(.4f)
                            .graphicsLayer(translationY = 5f)
                    )
                }
            }

            Spacer(Modifier.weight(.2f))

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