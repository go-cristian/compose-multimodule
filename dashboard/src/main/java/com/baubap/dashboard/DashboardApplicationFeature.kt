package com.baubap.dashboard

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import com.baubap.common.ApplicationFeature

object DashboardApplicationFeature : ApplicationFeature {
    override val id = "dashboard"
    override val mainRoute = DashboardRoute
    override val name: String = "Inicio"
    override val icon = Icons.Outlined.Home
}
