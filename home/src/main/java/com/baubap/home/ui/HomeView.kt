@file:OptIn(ExperimentalFoundationApi::class)

package com.baubap.home.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.baubap.common.ApplicationFeature
import kotlinx.coroutines.launch

@Composable
fun HomeView(features: List<ApplicationFeature>) {
    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f,
        pageCount = { features.size },
    )
    val scope = rememberCoroutineScope()
    Scaffold(
        bottomBar = {
            BottomBar(
                current = pagerState.currentPage,
                features = features,
                onBottomItemClicked = { index: Int ->
                    scope.launch {
                        pagerState.scrollToPage(index)
                    }
                }
            )
        }
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .padding(it)
                .fillMaxWidth(),
        ) { page ->
            features[page].mainRoute.component(null)
        }
    }
}
