package com.baubap.home.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.baubap.common.ApplicationFeature
import com.baubap.common.onClick
import com.baubap.ds.components.Typographies
import com.baubap.ds.ui.theme.Black
import com.baubap.ds.ui.theme.LightPurple
import com.baubap.ds.ui.theme.Violet
import com.baubap.ds.ui.theme.White
import com.baubap.ds.ui.theme.backgroundColor
import com.baubap.ds.ui.theme.orInDarkTheme

@Composable
fun BottomBar(
    current: Int,
    features: List<ApplicationFeature>,
    onBottomItemClicked: (Int) -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(backgroundColor),
    ) {
        features.forEachIndexed { index, route ->
            val currentlySelected = index == current
            val color by animateColorAsState(
                targetValue = if (currentlySelected) {
                    Violet orInDarkTheme LightPurple
                } else {
                    Black orInDarkTheme White
                }
            )

            Column(
                modifier = Modifier
                    .onClick {
                        onBottomItemClicked(index)
                    }
                    .weight(1f)
                    .padding(vertical = 12.dp),
                horizontalAlignment = CenterHorizontally,
            ) {
                Box {
                    Icon(
                        route.icon!!,
                        contentDescription = null,
                        tint = color,
                        modifier = Modifier
                            .size(24.dp),
                    )
                }
                Typographies.Body4(
                    route.name!!,
                    modifier = Modifier.padding(top = 10.dp),
                    color = color,
                    overflow = TextOverflow.Ellipsis
                )
                AnimatedVisibility(visible = currentlySelected) {
                    Box(
                        modifier = Modifier
                            .height(2.dp)
                            .padding(horizontal = 24.dp)
                            .fillMaxWidth()
                            .background(color)
                    )
                }
            }
        }
    }
}