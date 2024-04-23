package com.baubap.home

import androidx.compose.runtime.Composable
import com.baubap.dashboard.DashboardApplicationFeature
import com.baubap.home.ui.HomeView
import com.baubap.profile.ProfileApplicationFeature

val installedFeatures = listOf(
    DashboardApplicationFeature,
    ProfileApplicationFeature,
)
@Composable
fun HomeScreen() {
    HomeView(installedFeatures)
}