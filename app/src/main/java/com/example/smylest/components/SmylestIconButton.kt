package com.example.smylest.components

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChatBubble
import androidx.compose.material.icons.rounded.ThumbUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.smylest.R
import com.example.smylest.ui.theme.SmylestTheme

@Preview
@Composable
fun PreviewSmylestIconButton() {
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
            .size(45.dp)
            .clip(CircleShape)
            .background(SmylestTheme.colors.accent)
    ) {
        Icon(
            imageVector = icon, contentDescription = iconDesc, tint = SmylestTheme.colors.onAccent,
            modifier = Modifier
                .padding(top = 5.dp, bottom = 5.dp)
                .size(25.dp)
                .align(Alignment.Center)
        )
    }
}