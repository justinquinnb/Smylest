package com.example.smylest.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf

private val lightColorPalette = ColorPalette(
    background = BrightWhite,
    onBackgroundPrimary = MostlyBlack, // Text & components of basic importance
    onBackgroundDetail = MostlyWhite, // Background details

    accent = SmyleyYellow, // Accented components, calls-to-action, actions
    onAccent = BrightWhite // Items on top of accented components
)

private val darkColorPalette = ColorPalette(
    background = DarkBlack,
    onBackgroundPrimary = MostlyWhite, // Text & components of basic importance
    onBackgroundDetail = MostlyBlack, // Background details

    accent = SmyleyYellow, // Accented components, calls-to-action, actions
    onAccent = BrightWhite // Items on top of accented components
)

private val LocalReplacementDarkColors = staticCompositionLocalOf { darkColorPalette }
private val LocalReplacementLightColors = staticCompositionLocalOf { lightColorPalette }

@Composable
fun SmylestTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    localReplacementDarkColors: ProvidableCompositionLocal<ColorPalette> = LocalReplacementDarkColors,
    localReplacementLightColors: ProvidableCompositionLocal<ColorPalette> = LocalReplacementLightColors,
    content: @Composable () -> Unit
) {
    val localReplacementColors = if (darkTheme) localReplacementDarkColors else localReplacementLightColors
    val replacementColors = if (darkTheme) darkColorPalette else lightColorPalette

    CompositionLocalProvider(
        localReplacementColors provides replacementColors
    ) {
        MaterialTheme(
            typography = Typography,
            content = content
        )
    }
}

@Composable
fun CurrentColorPalette(
    darkTheme: Boolean = isSystemInDarkTheme(),
    localReplacementDarkColors: ProvidableCompositionLocal<ColorPalette> = LocalReplacementDarkColors,
    localReplacementLightColors: ProvidableCompositionLocal<ColorPalette> = LocalReplacementLightColors
): ProvidableCompositionLocal<ColorPalette> {
    return if (darkTheme) localReplacementDarkColors else localReplacementLightColors
}

object BusAppTheme {
    val colors: ColorPalette
        @Composable
        get() = CurrentColorPalette().current
    val typography = Typography
}