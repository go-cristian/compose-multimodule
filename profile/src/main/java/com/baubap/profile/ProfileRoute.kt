package com.baubap.profile

import android.os.Bundle
import com.baubap.common.NavigationRoute
import com.baubap.common.TComponent
import com.baubap.common.fadeInTransition
import com.baubap.common.noExitTransition

object ProfileRoute : NavigationRoute {
    override val route = "profile-screen"
    override val enterTransition = fadeInTransition
    override val exitTransition = noExitTransition
    override val popEnterTransition = fadeInTransition
    override val popExitTransition = noExitTransition
    override val component: TComponent<Bundle?> = { ProfileScreen() }
}