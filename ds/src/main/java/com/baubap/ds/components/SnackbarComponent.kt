package com.baubap.ds.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.SnackbarData
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.baubap.common.Component
import com.baubap.common.stateOf

val LocalSnackbar = compositionLocalOf<SnackbarHostState> {
    error("No SnackbarHostState provided")
}

@Composable
fun SnackbarComponent(
    content: Component,
) {
    val snackbarHostState = stateOf(initial = SnackbarHostState())
    CompositionLocalProvider(LocalSnackbar provides snackbarHostState.value) {
        Box(modifier = Modifier.fillMaxSize()) {
            content()
            SnackbarHost(
                modifier = Modifier.align(Alignment.BottomCenter),
                hostState = snackbarHostState.value,
                snackbar = { data: SnackbarData -> SnackbarMessage(message = data.visuals.message) }
            )
        }
    }
}