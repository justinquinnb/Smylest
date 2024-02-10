package com.example.smylest.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.smylest.R


@Composable
fun BasicPage(content: @Composable (PaddingValues) -> Unit) {
    Scaffold(
        //topBar = HamburgerMenu
    ) {contentPadding ->
        Box(Modifier
            .fillMaxSize()
            .paint(
                painterResource(id = (
                        if (isSystemInDarkTheme()) R.drawable.smylestbackground_dark_ else R.drawable.smylestbackground_light_)),
                contentScale = ContentScale.FillBounds
            )
        ) {}
        content(contentPadding)
    }
}