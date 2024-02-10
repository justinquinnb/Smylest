package com.example.smylest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChatBubble
import androidx.compose.material3.Scaffold
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
import com.example.smylest.components.OutboundMessageBubble
import com.example.smylest.components.SmylestIconButton
import com.example.smylest.components.SmylestWideTextButton
import com.example.smylest.screens.Navigation
import com.example.smylest.ui.theme.SmylestTheme

val DEMO_MODE = true;

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Scaffold(
                //topBar = HamburgerMenu
            ) {contentPadding ->
                Box(Modifier
                    .fillMaxSize()
                    .paint(
                        painterResource(id = (
                                if (isSystemInDarkTheme()) R.drawable.smylestbackground_dark_ else R.drawable.smylestbackground_light_)),
                        contentScale = ContentScale.FillBounds
                    )
                ) {}
                Navigation(contentPadding)
            }



            /*
            SmylestTheme {
                ComponentPalette()
            }
            */
        }
    }
}

@Preview
@Composable
fun ComponentPalette() {
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
            messageTimestamp = "timestamp",
            message = "test message",
            action = {
                SmylestIconButton(
                    icon = Icons.Default.ChatBubble,
                    iconDesc = "Reply to this request") {
                    // on-click action
                }
            }
        )

        OutboundMessageBubble(
            messageTimestamp = "timestamp",
            filter = "Global",
            message = "Hey, I'm looking for xyz\nasdasdfasdf\nasdfasfdasdf\nasdfasdfasfd"
        )
    }
}