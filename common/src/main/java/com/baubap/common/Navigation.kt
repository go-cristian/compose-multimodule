package com.baubap.common

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation

val ApplicationFeature.allRoutes: List<NavigationRoute>
    get() = buildList {
        add(mainRoute)
        if (routes.isNotEmpty()) {
            addAll(routes)
        }
    }

val LocalNavigation = compositionLocalOf<NavHostController> {
    error("No NavHostController provided")
}

fun NavHostController.navigateOver(route: String, popUpToRoute: String = "splash") {
    this.navigate(route) {
        popUpTo(popUpToRoute) {
            inclusive = true
        }
    }
}

@Composable
fun Navigation(
    features: List<ApplicationFeature>,
) {
    val navController = rememberNavController()
    CompositionLocalProvider(LocalNavigation provides navController) {
        NavHost(
            navController,
            startDestination = features.first().id,
        ) {
            features.map { module ->
                navigation(
                    startDestination = module.mainRoute.route,
                    route = module.id,
                ) {
                    module.allRoutes.map { route ->
                        composable(
                            route.route,
                            arguments = route.arguments,
                            deepLinks = route.deepLinks,
                            enterTransition = route.enterTransition,
                            exitTransition = route.exitTransition,
                            popEnterTransition = route.popEnterTransition,
                            popExitTransition = route.popExitTransition,
                        ) { backStackEntry ->
                            route.component(backStackEntry.arguments)
                        }
                    }
                }
            }
        }
    }
}