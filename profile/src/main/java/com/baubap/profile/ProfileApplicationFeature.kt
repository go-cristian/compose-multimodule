package com.baubap.profile

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import com.baubap.common.ApplicationFeature

object ProfileApplicationFeature : ApplicationFeature {
    override val id = "profile"
    override val mainRoute = ProfileRoute
    override val name: String = "Perfil de usuario"
    override val icon = Icons.Outlined.Person
}
