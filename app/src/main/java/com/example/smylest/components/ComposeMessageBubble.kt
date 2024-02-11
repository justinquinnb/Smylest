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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.smylest.ui.theme.SmylestTheme

@Preview
@Composable
private fun PreviewComposeMessageBubble() {
    ComposeMessageBubble(
        prompt = "Compose a message...",
        hint = "Fashion a smile here...")
}

/**
 * Message bubble to make or fulfill a smile request
 */
@Composable
fun ComposeMessageBubble(
    prompt: String,
    hint: String,
    onValueChanged: (String) -> Unit = {}
) {
    var text by remember {
        mutableStateOf("")
    }
    MessageBubbleContainer(
        orientation = BubbleOrientation.RIGHT,
    ){
        Column(){
            // Context
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.padding(bottom = 4.dp)
            ){
                Text(
                    text = prompt,
                    style = SmylestTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.weight(
                    weight = 1f,
                    fill = true))
                FilterChipDropdown("Visibility")
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
            MultiLineTextField(
                value = text,
                onValueChanged = onValueChanged,
                hintText = hint,
                maxLines = 7,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
    }
}