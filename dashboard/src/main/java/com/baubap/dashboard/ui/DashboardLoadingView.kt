package com.baubap.dashboard.ui

import android.content.res.Configuration.UI_MODE_TYPE_NORMAL
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.baubap.common.toDp
import com.baubap.ds.components.Shimmer
import com.baubap.ds.components.Spacer
import com.baubap.ds.ui.theme.AppTheme
import com.baubap.ds.ui.theme.Green
import com.baubap.ds.ui.theme.Violet

@Composable
fun LoadingDashboardView(
    modifier: Modifier = Modifier,
) {
    Surface {
        Column(
            modifier = modifier
                .fillMaxSize()
                .testTag("LoadingDashboardView"),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(84.dp)
                    .padding(end = 50.dp, top = 24.dp)
                    .clip(
                        RoundedCornerShape(
                            bottomEnd = 30.dp,
                            topEnd = 30.dp,
                        )
                    ),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Shimmer(
                    modifier = Modifier
                        .background(Violet)
                        .fillMaxSize()
                )
            }
            com.baubap.ds.components.Spacer()
            Shimmer(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp)
                    .weight(1f),
            )
            Spacer()
            Shimmer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(16.sp.toDp()),
            )
            Spacer()
            Divider()
            Spacer()
            Shimmer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(24.dp)
            )
            Spacer()
            Divider()
            Spacer()
            Shimmer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(24.dp)
            )
            Spacer()
            Divider()
            Spacer()
            Shimmer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(58.dp), baseColor = Green
            )
        }
    }
}

@Composable
@Preview(uiMode = UI_MODE_TYPE_NORMAL)
fun LoadingDashboardViewPreview() {
    val context = LocalContext.current
    CompositionLocalProvider(LocalContext provides context) {
        AppTheme(useDarkTheme = false) {
            LoadingDashboardView()
        }
    }
}