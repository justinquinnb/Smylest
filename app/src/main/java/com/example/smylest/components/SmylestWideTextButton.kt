package com.example.smylest.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.smylest.R
import com.example.smylest.ui.theme.SmylestTheme

@Preview
@Composable
private fun SmylestWideTextButtonPreview() {
    SmylestWideTextButton(text = "Hello, World!", modifier = Modifier, onClick = {})
}

/**
 * Standard, wide, narrow button scaling to container size, not String length
 */
@Composable
fun SmylestWideTextButton(
    text: String, 
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(100, 100, 100, 100),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = colorResource(R.color.BrightWhite),
            disabledContainerColor = Color.Transparent,
            disabledContentColor = Color.Transparent
        ),
        modifier = modifier
            .height(50.dp)
            .fillMaxWidth(0.75f)
            .clip(RoundedCornerShape(100, 100, 100, 100))
            .background(SmylestTheme.colors.accent)
            .border(
                BorderStroke(1.5.dp, SmylestTheme.colors.primaryBorder),
                RoundedCornerShape(100, 100, 100, 100))
    ) {
        Text(
            text = text,
            color = colorResource(R.color.BrightWhite),
            style = SmylestTheme.typography.labelMedium,
            softWrap = false,
        )
    }
}