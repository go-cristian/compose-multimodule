package com.baubap.common

import android.os.Bundle
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDeepLink

typealias NavEnterTransition = AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition?
typealias NavExitTransition = AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition?

interface NavigationRoute {
    val route: String
    val arguments: List<NamedNavArgument>
        get() = emptyList()
    val deepLinks: List<NavDeepLink>
        get() = emptyList()
    val enterTransition: NavEnterTransition
        get() = enterLeftTransition
    val exitTransition: NavExitTransition
        get() = exitLeftTransition
    val popEnterTransition: NavEnterTransition
        get() = enterRightTransition
    val popExitTransition: NavExitTransition
        get() = exitRightTransition
    val component: TComponent<Bundle?>
        get() = {}
}