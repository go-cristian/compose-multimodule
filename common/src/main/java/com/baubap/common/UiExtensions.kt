package com.baubap.common

import android.content.Context
import android.content.res.Resources
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.delay

@Composable
fun Dp.toPx(): Float {
    val dps = this
    return with(LocalDensity.current) { dps.toPx() }
}

@Composable
fun TextUnit.toDp(): Dp {
    val lineHeightSp = this
    return with(LocalDensity.current) {
        lineHeightSp.toDp()
    }
}

@Composable
inline fun Modifier.onClick(
    crossinline onClick: UnitFunction = {},
): Modifier {
    var blocked by stateOf(false)
    val realOnClick: UnitFunction = {
        if (blocked.not()) {
            onClick()
            blocked = true
        }
    }
    LaunchedEffect(blocked) {
        if (blocked) {
            delay(500)
            blocked = false
        }
    }
    return clickable(
        interactionSource = remember { MutableInteractionSource() },
        indication = null,
    ) { realOnClick() }
}

val Int.px: Int get() = (this * Resources.getSystem().displayMetrics.density).toInt()

@Composable
fun <T> stateOf(initial: T) = remember { mutableStateOf(initial) }

val Context.dataStore by preferencesDataStore("settings")