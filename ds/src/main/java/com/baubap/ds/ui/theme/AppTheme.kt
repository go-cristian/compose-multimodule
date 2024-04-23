package com.baubap.ds.ui.theme

import android.annotation.SuppressLint
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.mutableStateOf
import com.baubap.common.Component

@Composable
fun AppTheme(
    useDarkTheme: Boolean,
    content: Component,
) {
    DarkThemeValue.current.value = useDarkTheme
    MaterialTheme(
        colorScheme = if (useDarkTheme) AppDarkColors else AppLightColors,
        typography = AppTypography,
        shapes = AppShapes,
        content = content
    )
}

@Composable
@ReadOnlyComposable
fun isDarkTheme() = DarkThemeValue.current.value

@SuppressLint("CompositionLocalNaming")
private val DarkThemeValue = compositionLocalOf { mutableStateOf(false) }

@Composable
@ReadOnlyComposable
infix fun <T> T.orInDarkTheme(other: T): T = if (isDarkTheme()) other else this