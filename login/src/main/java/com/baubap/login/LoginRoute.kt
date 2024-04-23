package com.baubap.login

import android.os.Bundle
import com.baubap.common.NavigationRoute
import com.baubap.common.TComponent
import com.baubap.common.fadeInTransition
import com.baubap.common.noExitTransition

object LoginRoute : NavigationRoute {
    override val route = "login-screen"
    override val enterTransition = fadeInTransition
    override val exitTransition = noExitTransition
    override val popEnterTransition = fadeInTransition
    override val popExitTransition = noExitTransition
    override val component: TComponent<Bundle?> = { LoginScreen() }
}