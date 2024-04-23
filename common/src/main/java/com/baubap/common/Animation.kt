package com.baubap.common

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.ui.unit.IntOffset

private val animationSpec = tween<IntOffset>(300)

val enterLeftTransition: NavEnterTransition = {
    slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Left, animationSpec)
}

val enterRightTransition: NavEnterTransition = {
    slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Right, animationSpec)
}

val exitLeftTransition: NavExitTransition = {
    slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Left, animationSpec)
}

val exitRightTransition: NavExitTransition = {
    slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Right, animationSpec)
}

val enterBottomTransition: NavEnterTransition =
    {
        slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Up, animationSpec)
    }

val exitBottomTransition: NavExitTransition = {
    slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Down, animationSpec)
}

val fadeInTransition: NavEnterTransition = { fadeIn() }

val fadeOutTransition: NavExitTransition = { fadeOut() }

val noEnterTransition: NavEnterTransition = { EnterTransition.None }

val noExitTransition: NavExitTransition = { ExitTransition.None }