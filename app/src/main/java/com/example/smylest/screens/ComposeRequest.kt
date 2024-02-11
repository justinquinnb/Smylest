package com.example.smylest.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.smylest.DEMO_MODE
import com.example.smylest.components.BasicPage
import com.example.smylest.components.ComposeMessageBubble
import com.example.smylest.components.SmylestWideTextButton
import com.example.smylest.ui.theme.SmylestTheme

/*
Col:
    Text for header
    ComposeMessageBubble
    Button to send
    Text for disclosure
 */

@Preview
@Composable
private fun PreviewComposeRequestScreen() {
    ComposeRequestScreen(rememberNavController())
}

@Composable
fun ComposeRequestScreen(navController: NavController) {
    BasicPage{
        Column() {
            Spacer(Modifier.weight(.2f))
            Text(
                text = "That's okay, we're here to help!",
                style = SmylestTheme.typography.displayLarge,
                color = SmylestTheme.colors.onBackgroundPrimary,
                modifier = Modifier
                    .fillMaxWidth(0.75f)
                    .padding(bottom = 30.dp)
            )
            ComposeMessageBubble(
                prompt = "What's on your mind?",
                hint = "Type your message..."
            )

            // TODO consider adding a remember-by value here to toggle button functionality
            // based on whether the above text field has been filled out
            Spacer(Modifier.weight(.2f))

            SmylestWideTextButton(
                text = "Make me smile!",
                onClick = {navController.navigate(Screen.InboxScreen.route)},
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(Modifier.weight(.2f))
        }
    }
}