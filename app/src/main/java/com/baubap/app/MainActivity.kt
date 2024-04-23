package com.baubap.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import com.baubap.common.Navigation
import com.baubap.ds.components.SnackbarComponent
import com.baubap.ds.ui.theme.AppTheme
import com.baubap.home.HomeApplicationFeature
import com.baubap.login.LoginApplicationFeature
import com.baubap.splash.SplashApplicationFeature
import dagger.hilt.android.AndroidEntryPoint

val installedFeatures = listOf(
    SplashApplicationFeature,
    LoginApplicationFeature,
    LoginApplicationFeature,
    HomeApplicationFeature,
)

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val isDarkTheme = isSystemInDarkTheme()
            AppTheme(isDarkTheme) {
                SnackbarComponent {
                    Navigation(installedFeatures)
                }
            }
        }
    }
}
