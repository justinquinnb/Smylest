package com.example.smylest.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
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
private fun PreviewMultilineTextField(){
    MultilineTextField(
        value = "",
        hintText = "Hint",
        onValueChanged = {},
        maxLines = 4)
}

/**
 * A multi-line, expanding text field with a prompt
 */
@Composable
fun MultilineTextField(
    value: String,
    onValueChanged: (String) -> Unit,
    maxLines: Int,
    modifier: Modifier = Modifier,
    hintText: String = "",
    textStyle: TextStyle = SmylestTheme.typography.bodyLarge
) {
    BasicTextField(
        value = value,
        onValueChange = onValueChanged,
        textStyle = TextStyle(
            color = SmylestTheme.colors.onContainerPrimary,
            fontSize = textStyle.fontSize,
            fontFamily = textStyle.fontFamily,
            fontStyle = textStyle.fontStyle
        ),
        modifier = modifier
            .fillMaxWidth()
            .border(
                BorderStroke(1.5.dp, SmylestTheme.colors.onBackgroundDetail),
                RoundedCornerShape(8.dp)
            ),
        maxLines = maxLines,
        decorationBox = {innerTextField ->
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(SmylestTheme.colors.onContainerDetail)
                    .padding(start=8.dp, end=8.dp, top=4.dp, bottom=4.dp)
            ) {
                if(value.isEmpty()) {
                    Text(
                        text = hintText,
                        color = SmylestTheme.colors.onContainerSecondary,
                        style = TextStyle(
                            fontSize = textStyle.fontSize,
                            fontFamily = textStyle.fontFamily,
                            fontStyle = FontStyle.Italic
                        ),
                    )
                }
                innerTextField()
            }
        }
    )
}