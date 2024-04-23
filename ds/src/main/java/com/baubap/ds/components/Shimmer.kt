package com.baubap.ds.components

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInRoot
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.baubap.common.px
import com.baubap.ds.ui.theme.Silver

@Composable
fun Shimmer(
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(4.dp),
    baseColor: Color = Silver,
) {
    val gradient = listOf(
        baseColor.copy(alpha = 0.9f),
        baseColor.copy(alpha = 0.3f),
        baseColor.copy(alpha = 0.9f),
        baseColor.copy(alpha = 0.9f),
        baseColor.copy(alpha = 0.9f),
    )

    val transition = rememberInfiniteTransition()
    val translateAnim by transition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(tween(durationMillis = 3200, easing = LinearEasing))
    )

    var positionInRootTopBar by remember { mutableStateOf(Offset.Zero) }
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.px
    val screenWidth = configuration.screenWidthDp.px

    val diff = screenWidth * translateAnim * 4

    val initialX = diff - (positionInRootTopBar.x) - (screenWidth * 2)
    val endX = (screenWidth * 2) + initialX

    val initialY = -positionInRootTopBar.y + diff
    val endY = screenHeight - positionInRootTopBar.y + diff
    val brush = Brush.linearGradient(
        colors = gradient,
        start = Offset(initialX, initialY),
        end = Offset(endX, endY),
    )
    Box(
        modifier = modifier
            .background(brush, shape = shape)
            .onGloballyPositioned {
                positionInRootTopBar = it.positionInRoot()
            }
    )
}