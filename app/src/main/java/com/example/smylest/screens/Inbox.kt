package com.example.smylest.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.smylest.components.BasicPage
import com.example.smylest.components.ComposeMessageBubble
import com.example.smylest.components.InboundMessageBubble
import com.example.smylest.components.OutboundMessageBubble
import com.example.smylest.components.SmylestWideTextButton
import com.example.smylest.types.OutboundMessage
import com.example.smylest.ui.theme.SmylestTheme

/*
Col:
    Text for INBOX header
    Inbound subheader
    Col:
        MessageBubble
    Outbound subheader
    Col:
        MessageBubble
 */
@Preview
@Composable
private fun PreviewInboxScreen() {
    InboxScreen(rememberNavController())
}

/**
 * A screen where users may compose their response to a smile request
 */
@Composable
fun InboxScreen(navController: NavController) {
    BasicPage{
        Column() {
            Spacer(Modifier.weight(.2f))
            Text(
                text = "Inbox",
                style = SmylestTheme.typography.displayLarge,
                color = SmylestTheme.colors.onBackgroundPrimary,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth(0.75f)
                    .padding(bottom = 15.dp)
                    .align(Alignment.CenterHorizontally)
            )

            Text(
                text = "Concentrated Happiness:",
                style = SmylestTheme.typography.displayMedium,
                color = SmylestTheme.colors.onBackgroundSecondary,
                modifier = Modifier.padding(vertical = 15.dp)
            )

            val outboundMessages: Array<OutboundMessage> = OutboundMessage.loadAll()
            println("Hello??")
            Column {
                outboundMessages.forEach {outboundMessage ->
                    OutboundMessageBubble(
                        messageTimestamp = outboundMessage.timeStamp,
                        filter = outboundMessage.visibility,
                        message = outboundMessage.text
                    )
                }
            }

            InboundMessageBubble(
                messageTimestamp = "7:32pm, 2/10/24",
                message = "Hi! I've been feeling pretty down lately. I recently failed some important" +
                        "finals, and now it's looking like I won't pass my required classes :/") {
            }

            Spacer(Modifier.height(20.dp))

            ComposeMessageBubble(
                prompt = "Make them smile:",
                hint = "Type your message...",
            )

            // TODO consider adding a remember-by value here to toggle button functionality
            // based on whether the above text field has been filled out
            Spacer(Modifier.weight(.2f))

            SmylestWideTextButton(
                text = "Make them smile!",
                onClick = {navController.navigate(Screen.InboxScreen.route)},
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(Modifier.weight(.2f))
        }
    }
}