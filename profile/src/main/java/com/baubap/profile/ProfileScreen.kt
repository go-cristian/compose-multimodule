package com.baubap.profile

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.baubap.common.LocalNavigation
import com.baubap.common.navigateOver
import com.baubap.ds.components.LoadingView
import com.baubap.profile.ui.ProfileView

@Composable
fun ProfileScreen(
    profileViewModel: ProfileViewModel = hiltViewModel()
) {
    val navigation = LocalNavigation.current
    val value = profileViewModel.state.collectAsState().value

    LaunchedEffect(true) {
        profileViewModel.getUser()
    }
    LaunchedEffect(value) {
        if (value is ProfileViewModel.State.LoggedOut) {
            navigation.navigateOver("login")
        }
    }

    when (value) {

        is ProfileViewModel.State.Idle -> {
            ProfileView(value.user, onLogout = { profileViewModel.logout() })
        }

        else -> {
            LoadingView()
        }
    }
}
