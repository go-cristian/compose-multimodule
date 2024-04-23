package com.baubap.splash.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.baubap.ds.ui.theme.AppTheme
import com.baubap.ds.ui.theme.Black
import com.baubap.ds.ui.theme.LightPurple
import com.baubap.ds.ui.theme.Violet
import com.baubap.ds.ui.theme.White
import com.baubap.ds.ui.theme.orInDarkTheme
import com.baubap.splash.R

private object Colors {
    val background
        @Composable
        get() = White orInDarkTheme Black

    val stars
        @Composable
        get() = Violet orInDarkTheme LightPurple
}

@Composable
fun SplashView(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .background(Colors.background)
            .fillMaxWidth()
            .fillMaxHeight(),
    ) {
        AnimatedBackground(
            starsColor = Colors.stars
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                modifier = Modifier
                    .fillMaxWidth(),
                contentDescription = "Baubap Logo",
            )
        }
    }
}

@Composable
@Preview
fun SplashViewPreview() {
    AppTheme(false) {
        SplashView()
    }
}