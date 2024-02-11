package com.example.smylest.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.smylest.ui.theme.SmylestTheme

public enum class BubbleOrientation {LEFT, RIGHT}

@Preview
@Composable
private fun MessageBubbleContainerPreview() {
    MessageBubbleContainer(
        orientation = BubbleOrientation.LEFT,
        ) {
        // Content
        Text("Test text message!")
    }
}

/**
 * A message bubble-shaped container for text
 */
@Composable
fun MessageBubbleContainer(
    orientation: BubbleOrientation,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    content: @Composable (Modifier) -> Unit
) {
    val leftCorner = if (orientation == BubbleOrientation.LEFT) 4.dp else 25.dp
    val rightCorner = if (orientation == BubbleOrientation.RIGHT) 4.dp else 25.dp

    Surface(
        shape = RoundedCornerShape(
            25.dp, 25.dp,
            rightCorner, leftCorner),
        color = SmylestTheme.colors.container,
        contentColor = SmylestTheme.colors.onContainerPrimary,
        border = BorderStroke(1.5.dp, SmylestTheme.colors.primaryBorder),
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .clickable(
                onClick = onClick,
                onClickLabel = "Open Message"
            )
    ) {
        Box(modifier = Modifier
            .padding(start = 20.dp, end = 20.dp, top = 8.dp, bottom = 8.dp)
        ) {
            content(modifier)
        }
    }
}