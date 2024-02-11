package com.example.smylest.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.smylest.ui.theme.SmylestTheme

@Preview
@Composable
private fun PreviewMultiLineTextBox() {
    MultiLineTextBox(text = "Multi\nLine\nTextbox\nTest!!!")
}

@Composable
fun MultiLineTextBox(
    text: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(SmylestTheme.colors.onContainerDetail)
            .border(
                BorderStroke(1.5.dp, SmylestTheme.colors.onBackgroundDetail),
                RoundedCornerShape(8.dp)
            )
            .padding(start = 8.dp, end = 8.dp, top = 4.dp, bottom = 4.dp)
    ) {
        Text(
            text = text,
            color = SmylestTheme.colors.onContainerSecondary,
            style = TextStyle(
                color = SmylestTheme.colors.onContainerPrimary,
                fontSize = SmylestTheme.typography.bodyMedium.fontSize,
                fontFamily = SmylestTheme.typography.bodyMedium.fontFamily,
                fontStyle = SmylestTheme.typography.bodyMedium.fontStyle
            ),
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}