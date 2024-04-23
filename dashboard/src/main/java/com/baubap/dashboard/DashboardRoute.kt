package com.baubap.dashboard

import android.os.Bundle
import com.baubap.common.NavigationRoute
import com.baubap.common.TComponent
import com.baubap.common.fadeInTransition
import com.baubap.common.noExitTransition

object DashboardRoute : NavigationRoute {
    override val route = "dashboard-screen"
    override val enterTransition = fadeInTransition
    override val exitTransition = noExitTransition
    override val popEnterTransition = fadeInTransition
    override val popExitTransition = noExitTransition
    override val component: TComponent<Bundle?> = { DashboardScreen() }
}