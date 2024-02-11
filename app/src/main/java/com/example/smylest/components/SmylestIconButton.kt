package com.example.smylest.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChatBubble
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.smylest.ui.theme.SmylestTheme

@Preview
@Composable
private fun PreviewSmylestIconButton() {
    SmylestIconButton(icon = Icons.Default.ChatBubble, iconDesc = "test") {}
}

/**
 * Circular button icon
 */
@Composable
fun SmylestIconButton(
    icon: ImageVector,
    iconDesc: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Box(
        modifier = modifier
            .size(50.dp)
            .clip(CircleShape)
            .background(SmylestTheme.colors.accent)
            .border(1.5.dp, SmylestTheme.colors.primaryBorder, CircleShape)
            .clickable(){onClick}
    ) {
        Icon(
            imageVector = icon, contentDescription = iconDesc, tint = SmylestTheme.colors.onAccent,
            modifier = Modifier
                .padding(12.dp)
                .fillMaxSize()
                .align(Alignment.Center)
        )
    }
}