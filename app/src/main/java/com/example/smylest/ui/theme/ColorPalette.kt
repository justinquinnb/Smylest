package com.example.smylest.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

data class ColorPalette(
    var background: Color, // Screen backgrounds
    var onBackgroundPrimary: Color, // Text & components of basic importance
    var onBackgroundDetail: Color, // Background details

    var accent: Color, // Accented components, calls-to-action, actions
    var onAccent: Color // Items on top of accented components
)