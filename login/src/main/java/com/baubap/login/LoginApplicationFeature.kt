package com.baubap.login

import com.baubap.common.ApplicationFeature


object LoginApplicationFeature : ApplicationFeature {
    override val id = "login"
    override val mainRoute = LoginRoute
}
