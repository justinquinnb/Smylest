package com.example.smylest.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.smylest.R
import com.example.smylest.components.BasicPage
import com.example.smylest.components.InboundMessageBubble
import com.example.smylest.components.OutboundMessageBubble
import com.example.smylest.types.InboundMessage
import com.example.smylest.types.MessageType
import com.example.smylest.types.MessageVisibility
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
            Text(
                text = "Inbox",
                style = SmylestTheme.typography.displayLarge,
                color = SmylestTheme.colors.onBackgroundPrimary,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth(0.75f)
                    .padding(top = 15.dp)
                    .align(Alignment.CenterHorizontally)
            )

            Column(
                modifier = Modifier.verticalScroll(rememberScrollState())
            ) {
                Text(
                    text = "Concentrated Happiness:",
                    style = SmylestTheme.typography.displayMedium,
                    color = SmylestTheme.colors.onBackgroundSecondary,
                    modifier = Modifier.padding(bottom = 15.dp)
                )

                val inboundMessages: List<InboundMessage> = listOf(
                    InboundMessage(
                        "Hi there! I hope you're doing a little bit better now," +
                                " I'd just like to say that...",
                        MessageType.INBOUND_RESPONSE,
                        MessageVisibility.GLOBAL
                    ),
                    InboundMessage(
                        "Hey, sometimes these things happen! It may be unbearable in the" +
                                " moment, but...",
                        "Julian C.",
                        R.drawable.smyleststockpfp1,
                        MessageVisibility.MY_AGE_GROUP
                    ),
                    InboundMessage(
                        "I had a very similar experience as you before. I like to think of" +
                                " it as this: You...",
                        "Natasha L.",
                        R.drawable.smyleststockpfp2,
                        MessageVisibility.MY_LOCATION
                    )
                )

                Column(
                    verticalArrangement = Arrangement.spacedBy(15.dp)
                ){
                    inboundMessages.forEach {inboundMessage ->
                        InboundMessageBubble(inboundMessage)
                    }
                }

                Text(
                    text = "Outbound Messages:",
                    style = SmylestTheme.typography.displayMedium,
                    color = SmylestTheme.colors.onBackgroundSecondary,
                    modifier = Modifier.padding(vertical = 15.dp)
                )

                val outboundMessages: List<OutboundMessage> = listOf(
                    OutboundMessage(
                        "Hey, I'm not feeling so great. I recently failed some important" +
                                " finals, and now...",
                        MessageType.OUTBOUND_REQUEST,
                        MessageVisibility.GLOBAL
                    ),
                    OutboundMessage(
                        "That sounds like a wonderful idea though! Trust me, I went through the" +
                                " same thing...",
                        MessageType.OUTBOUND_RESPONSE,
                        MessageVisibility.GLOBAL
                    ),
                    OutboundMessage(
                        "I wouldn't worry about it! You seem like a strong person, and I'm" +
                                " confident you'll...",
                        MessageType.OUTBOUND_RESPONSE,
                        MessageVisibility.GLOBAL
                    )
                )

                Column(
                    verticalArrangement = Arrangement.spacedBy(15.dp)
                ){
                    outboundMessages.forEach {outboundMessage ->
                        OutboundMessageBubble(outboundMessage)
                    }
                }
            }
        }
    }
}