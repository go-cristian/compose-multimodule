package com.baubap.dashboard

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.hilt.navigation.compose.hiltViewModel
import com.baubap.dashboard.ui.DashboardView
import com.baubap.dashboard.ui.LoadingDashboardView
import com.baubap.ds.components.ErrorView

@Composable
fun DashboardScreen(
    dashboardViewModel: DashboardViewModel = hiltViewModel()
) {
    val loaded = rememberSaveable { mutableStateOf(false) }
    val value = dashboardViewModel.state.collectAsState().value

    LaunchedEffect(loaded) {
        if (!loaded.value) {
            dashboardViewModel.getAccountState()
            loaded.value = true
        }
    }

    when (value) {
        is DashboardViewModel.State.Loaded -> {
            DashboardView(value.data, onPaymentClick = { dashboardViewModel.getAccountState() })
        }

        is DashboardViewModel.State.Error -> {
            ErrorView {
                dashboardViewModel.getAccountState()
            }
        }

        DashboardViewModel.State.IsLoading -> {
            LoadingDashboardView()
        }
    }
}

