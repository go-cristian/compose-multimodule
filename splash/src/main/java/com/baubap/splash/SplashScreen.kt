package com.baubap.splash

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.baubap.common.LocalNavigation
import com.baubap.common.navigateOver
import com.baubap.splash.SplashViewModel.State
import com.baubap.splash.ui.SplashView

@Composable
fun SplashScreen(
    splashViewModel: SplashViewModel = hiltViewModel()
) {
    val navHostController = LocalNavigation.current
    val value = splashViewModel.state.collectAsState().value

    SideEffect {
        splashViewModel.checkOnBoarding()
    }
    LaunchedEffect(value) {
        val route = when (value) {
            is State.ContinueWithApp -> "home"
            is State.ContinueToLogin -> "login"
            else -> null
        }
        route?.let { navHostController.navigateOver(it) }
    }

    SplashView()
}
