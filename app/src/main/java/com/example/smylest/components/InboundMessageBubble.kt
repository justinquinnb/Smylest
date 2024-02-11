package com.example.smylest.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChatBubble
import androidx.compose.material.icons.filled.Mood
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.smylest.screens.Screen
import com.example.smylest.types.InboundMessage
import com.example.smylest.types.MessageType

@Composable
fun InboundMessageBubble(message: InboundMessage, onClickAction: () -> Unit) {
    if (message.messageType == MessageType.INBOUND_REQUEST) {
        InboundRequestBubble(
            filter = message.messageVisibility,
            message = message.text,
            timeStamp = message.timeStamp,
            offsetAction = true,
        ) {
            SmylestIconButton(
                icon = Icons.Default.ChatBubble,
                iconDesc = "Reply to this request",
                onClick = onClickAction
            )
        }
    } else {
        InboundResponseBubble(
            messageAuthorName = message.authorName,
            messageAuthorImage = message.authorImage,
            messageTimestamp = message.timeStamp,
            message = message.text,
            offsetAction = true
        ) {
            SmylestIconButton(
                icon = Icons.Default.Mood,
                iconDesc = "Like this response",
                onClick = onClickAction
            )
        }
    }
}

@Composable
fun InboundMessageBubble(message: InboundMessage) {
    if (message.messageType == MessageType.INBOUND_REQUEST) {
        InboundRequestBubble(
            message = message.text,
            filter = message.messageVisibility,
            timeStamp = message.timeStamp,
            offsetAction = true,
        ) {
            SmylestIconButton(
                icon = Icons.Default.ChatBubble,
                iconDesc = "Reply to this request",
                onClick = {}
            )
        }
    } else {
        InboundResponseBubble(
            messageAuthorName = message.authorName,
            messageAuthorImage = message.authorImage,
            messageTimestamp = message.timeStamp,
            message = message.text,
            offsetAction = true
        ) {
            SmylestIconButton(
                icon = Icons.Default.Mood,
                iconDesc = "Like this response",
                onClick = {}
            )
        }
    }
}