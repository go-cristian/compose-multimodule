package com.baubap.home

import com.baubap.common.ApplicationFeature

object HomeApplicationFeature: ApplicationFeature {
    override val id = "home"
    override val mainRoute = HomeRoute
}