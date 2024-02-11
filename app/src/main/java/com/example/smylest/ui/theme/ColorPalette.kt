package com.example.smylest.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

data class ColorPalette(
    var background: Color, // Screen backgrounds
    var onBackgroundPrimary: Color, // Text & components of basic importance
    var onBackgroundSecondary: Color,
    var onBackgroundDetail: Color, // Background details

    var container: Color, // Containers
    var onContainerPrimary: Color,
    var onContainerSecondary: Color,
    var onContainerDetail: Color,

    var primaryBorder: Color,
    var secondaryBorder: Color,

    var accent: Color, // Accented components, calls-to-action, actions
    var onAccent: Color // Items on top of accented components
)