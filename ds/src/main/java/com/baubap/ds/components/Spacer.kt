package com.baubap.ds.components

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun Spacer(size: Dp = 24.dp) {
    androidx.compose.foundation.layout.Spacer(modifier = Modifier.size(size))
}