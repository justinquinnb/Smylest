package com.example.smylest.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.smylest.ui.theme.SmylestTheme

@Preview
@Composable
private fun PreviewOutboundRequestBubble() {
    OutboundRequestBubble(
        messageHeader = "Timestamp",
        filter = "Everyone",
        message = "test message",
    )
}

/**
 * A new message bubble from another user, displayed in a user's inbox or the requests page
 */
@Composable
fun OutboundRequestBubble(
    messageHeader: String,
    filter: String,
    message: String,
) {
    var text by remember {
        mutableStateOf("")
    }
    MessageBubbleContainer(
        orientation = BubbleOrientation.RIGHT,
    ){
        // Message bubble
        Column(){
            // Context
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.padding(bottom = 4.dp)
            ){
                Text(
                    text = messageHeader,
                    style = SmylestTheme.typography.titleMedium,
                )

                Spacer(
                    modifier = Modifier
                        .weight(1f)
                )

                FilterChip(filter)

                Icon(
                    imageVector = Icons.Default.MoreHoriz,
                    contentDescription = "View Options",
                    tint = SmylestTheme.colors.onContainerSecondary,
                    modifier = Modifier
                        .graphicsLayer(translationX = 15f)
                )
            }

            // Yellow spacer
            Spacer(
                modifier = Modifier
                    .height(6.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(100))
                    .background(color = SmylestTheme.colors.accent)
            )

            // Text field
            MultiLineTextBox(
                text = message,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
    }
}