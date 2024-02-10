package com.example.smylest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChatBubble
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.smylest.components.BubbleOrientation
import com.example.smylest.components.ComposeMessageBubble
import com.example.smylest.components.InboundMessageBubble
import com.example.smylest.components.MessageBubbleContainer
import com.example.smylest.components.SmylestIconButton
import com.example.smylest.components.SmylestWideTextButton
import com.example.smylest.ui.theme.SmylestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SmylestTheme {
                PreviewActivity()
            }
        }
    }
}

@Preview
@Composable
fun PreviewActivity() {
    Column (
        modifier = with(Modifier) {
            fillMaxSize()
                .paint(
                    painterResource(id = (
                            if (isSystemInDarkTheme()) R.drawable.smylestbackground_dark_ else R.drawable.smylestbackground_light_)),
                    contentScale = ContentScale.FillBounds
                )

        }
    ) {
        SmylestIconButton(icon = Icons.Default.ChatBubble, iconDesc = "Compose") {}
        SmylestWideTextButton(text = "Hello, World!") {}
        MessageBubbleContainer(
            orientation = BubbleOrientation.LEFT,
        ) {
            Text("Left Bubble")
        }
        MessageBubbleContainer(
            orientation = BubbleOrientation.RIGHT,
        ) {
            Text("Right Bubble")
        }
        ComposeMessageBubble(
            prompt = "Compose a message...",
            hint = "What do you need?"
        )
        InboundMessageBubble(
            messageTimestamp = "00:00am, #/#/##",
            message = "Test message")
    }
}