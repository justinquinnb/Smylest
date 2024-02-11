package com.example.smylest.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import com.example.smylest.components.InboundMessageBubble
import com.example.smylest.types.InboundMessage
import com.example.smylest.types.MessageType
import com.example.smylest.types.MessageVisibility
import com.example.smylest.ui.theme.SmylestTheme

@Preview
@Composable
private fun PreviewBrowseRequestsScreen() {
    BrowseRequestsScreen(rememberNavController())
}

/**
 * A screen where users can browse smile requests they may want to respond to
 */
@Composable
fun BrowseRequestsScreen(navController: NavController) {
    BasicPage {
        Column() {
            Column(
                Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(vertical = 50.dp)
                    .fillMaxWidth(0.75f)
            ) {
                Text(
                    text = if (DEMO_MODE) "That's great to hear, Justin!" else "That's great to hear!",
                    style = SmylestTheme.typography.displayLarge,
                    color = SmylestTheme.colors.onBackgroundPrimary,
                )
                Text(
                    text = "Let's find someone who could use one...",
                    style = SmylestTheme.typography.displayMedium,
                    color = SmylestTheme.colors.onBackgroundSecondary
                )
            }

            val inboundMessages: List<InboundMessage> = listOf(
                InboundMessage(
                    "Hey, I'm not feeling so great. I recently failed some important" +
                            " finals, and now...",
                    MessageType.INBOUND_REQUEST,
                    MessageVisibility.GLOBAL
                ),
                InboundMessage(
                    "Hey, I could really use someone's help. It feels like everyone" +
                            " I know is coming...",
                    MessageType.INBOUND_REQUEST,
                    MessageVisibility.MY_SEX
                ),
                InboundMessage(
                    "Why is it that every time I try to put myself out there, it" +
                            " feels like I'm a...",
                        MessageType.INBOUND_REQUEST,
                        MessageVisibility.MY_AGE_GROUP
                ),
                InboundMessage(
                    "Why is it that every time I try to put myself out there, it" +
                            " feels like I'm a...",
                    MessageType.INBOUND_REQUEST,
                    MessageVisibility.MY_AGE_GROUP
                ),
                InboundMessage(
                    "Why is it that every time I try to put myself out there, it" +
                            " feels like I'm a...",
                    MessageType.INBOUND_REQUEST,
                    MessageVisibility.MY_LOCATION
                )
            )

            Column(
                verticalArrangement = Arrangement.spacedBy(15.dp),
                modifier = Modifier.verticalScroll(rememberScrollState())
            ){
                inboundMessages.forEach {inboundMessage ->
                    InboundMessageBubble(
                        inboundMessage
                    ) { navController.navigate(Screen.ComposeResponseScreen.route) }
                }
            }
        }
    }
}