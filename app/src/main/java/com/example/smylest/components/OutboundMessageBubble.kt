package com.example.smylest.components

import androidx.compose.runtime.Composable
import com.example.smylest.types.MessageType
import com.example.smylest.types.OutboundMessage

@Composable
fun OutboundMessageBubble(message: OutboundMessage) {
    if (message.messageType == MessageType.OUTBOUND_REQUEST) {
        OutboundRequestBubble(
            messageHeader = "Request from you",
            filter = message.messageVisibility,
            message = message.text
        )
    } else {
        OutboundResponseBubble(
            messageHeader = "Response from you",
            filter = message.messageVisibility,
            message = message.text
        )
    }
}