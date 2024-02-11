package com.example.smylest.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChatBubble
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.smylest.R
import com.example.smylest.ui.theme.SmylestTheme

@Preview
@Composable
private fun PreviewInboundMessageBubble() {
    InboundMessageBubble(
        messageTimestamp = "timestamp",
        message = "test message",
        /*action = {
            SmylestIconButton(
                icon = Icons.Default.ChatBubble,
                iconDesc = "Reply to this request") {
                // on-click action
            }
        }*/
    )
}

/**
 * A new message bubble from another user, displayed in a user's inbox or the requests page
 */
@Composable
fun InboundMessageBubble(
    messageAuthorImage: Int = R.drawable.smylestanonymoususer,
    messageAuthorName: String = "Anonymous",
    messageTimestamp: String,
    message: String,
    offsetAction: Boolean = false,
    action: @Composable () -> Unit = {}
) {
    var text by remember {
        mutableStateOf("")
    }

    // Determine if an action button is passed and adjust padding accordingly
    val bottomPaddingForAction: Modifier = if (offsetAction) Modifier.padding(bottom = 15.dp) else Modifier
    val rightPaddingForAction: Modifier = if (offsetAction) Modifier.padding(end = 15.dp) else Modifier

    Box() {
        Row(bottomPaddingForAction) {
            Column(rightPaddingForAction) {
                MessageBubbleContainer(
                    orientation = BubbleOrientation.LEFT,
                ){
                    // Message bubble
                    Column(){
                        // Context
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            modifier = Modifier.padding(bottom = 4.dp)
                        ){
                            Image(
                                painter = painterResource(id = messageAuthorImage),
                                contentDescription = "$messageAuthorName profile picture",
                                contentScale = ContentScale.Fit,
                                modifier = Modifier
                                    .size(30.dp)
                                    .clip(CircleShape)
                            )
                            Text(
                                text = messageAuthorName,
                                style = SmylestTheme.typography.titleMedium,
                                modifier = Modifier.padding(start = 15.dp)
                            )
                            Text(
                                text = "at $messageTimestamp",
                                style = TextStyle(
                                    color = SmylestTheme.colors.onContainerSecondary,
                                    fontSize = SmylestTheme.typography.bodyMedium.fontSize,
                                    fontFamily = SmylestTheme.typography.bodyMedium.fontFamily,
                                    fontStyle = FontStyle.Italic,
                                    baselineShift = BaselineShift(-.1f)
                                ),
                                modifier = Modifier.padding(start = 3.dp)
                            )

                            Spacer(
                                modifier = Modifier
                                    .weight(1f)
                            )

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
        }
        // Optional action
        Box(modifier = Modifier
            .align(Alignment.BottomEnd)
        ){
            action()
        }
    }
}