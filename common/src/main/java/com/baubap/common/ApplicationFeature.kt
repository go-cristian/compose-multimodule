package com.baubap.common

import androidx.compose.ui.graphics.vector.ImageVector

interface ApplicationFeature {
    val id: String
    val mainRoute: NavigationRoute
    val routes: List<NavigationRoute>
        get() = emptyList()
    val name: String?
        get() = null
    val icon: ImageVector?
        get() = null
}