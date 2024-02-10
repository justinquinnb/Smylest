package com.example.smylest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChatBubble
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
    Column {
        SmylestIconButton(icon = Icons.Default.ChatBubble, iconDesc = "Compose") {}
        SmylestWideTextButton(text = "Hello, World!") {
        }
    }
}