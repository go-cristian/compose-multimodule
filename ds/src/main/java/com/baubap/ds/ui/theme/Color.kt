package com.baubap.ds.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Green = Color(0xFF80FD93)
val Violet = Color(0xFF5F24DE)
val LightPurple = Color(0xFF875DF4)
val White = Color(0xFFFEFFFE)
val Black = Color(0xFF000000)
val Silver = Color(0xFFAFB0CB)

val bodyColor
    @Composable
    get() = Black orInDarkTheme White

val backgroundColor
    @Composable
    get() = White orInDarkTheme Black

val primaryButtonBackgroundColor
    @Composable
    get() = Green

val primaryButtonBorderColor
    @Composable
    get() = Silver

val primaryButtonTextColor
    @Composable
    get() = Black

val primaryButtonDisabledTextColor
    @Composable
    get() = Black orInDarkTheme Silver

val secondaryButtonTextColor
    @Composable
    get() = White

val AppLightColors = lightColorScheme(
    primary = Green,
    secondary = LightPurple,
    background = White,
    surface = White,
    onPrimary = White,
    onBackground = LightPurple,
    onSecondary = Violet,
)

val AppDarkColors = darkColorScheme(
    primary = Green,
    secondary = LightPurple,
    background = Black,
    surface = Black,
    onPrimary = Black,
    onBackground = White,
    onSecondary = White,
)