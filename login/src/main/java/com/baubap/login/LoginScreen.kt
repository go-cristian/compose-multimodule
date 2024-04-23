package com.baubap.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.baubap.common.LocalNavigation
import com.baubap.ds.components.LoadingView
import com.baubap.ds.components.LocalSnackbar
import com.baubap.login.ui.LoginView

@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel = hiltViewModel()
) {
    val navHostController = LocalNavigation.current
    val snackbarHostState = LocalSnackbar.current
    val value = loginViewModel.state.collectAsState().value

    LaunchedEffect(value) {
        if (value is LoginViewModel.State.LoggedIn) {
            navHostController.navigate("home")
        } else if (value is LoginViewModel.State.LoginFailed) {
            snackbarHostState.showSnackbar("Error logging in")
        }
    }

    LoginView(
        onLogin = { email, password ->
            loginViewModel.login(email, password)
        }
    )
    if (value is LoginViewModel.State.IsLoading) {
        LoadingView()
    }
}

