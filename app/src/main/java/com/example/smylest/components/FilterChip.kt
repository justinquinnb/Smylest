package com.example.smylest.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.smylest.ui.theme.SmylestTheme

@Preview
@Composable
fun PreviewFilterChip() {
    FilterChip("TestTopic! Woot woot!")
}

/**
 * A chip displaying the applied filter
 */
@Composable
fun FilterChip(
    filter: String
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .height(30.dp)
            .wrapContentWidth()
            .clip(RoundedCornerShape(100, 100, 100, 100))
            .background(SmylestTheme.colors.onBackgroundDetail)
    ) {
        Text(
            text = filter,
            color = SmylestTheme.colors.onContainerSecondary,
            softWrap = false,
            style = TextStyle(
                fontSize = SmylestTheme.typography.labelMedium.fontSize,
                fontFamily = SmylestTheme.typography.labelMedium.fontFamily,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.SemiBold,
            ),
            modifier = Modifier.padding(start = 15.dp, end = 15.dp)
        )
    }
}