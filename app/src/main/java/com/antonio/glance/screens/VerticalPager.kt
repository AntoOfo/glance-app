package com.antonio.glance.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.antonio.glance.ui.theme.GlanceTheme

@Composable
fun NewsVerticalPager(modifier: Modifier = Modifier) {
    val newsCount = 5   // dummy amount for now

    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f  // null
    ) {
        newsCount
    }
    VerticalPager(
        state = pagerState,
        modifier = modifier.fillMaxSize(),
        beyondViewportPageCount = 1,
        contentPadding = PaddingValues(
            bottom = 120.dp
        )
    ) { pageIndex ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 50.dp, start = 10.dp, end = 10.dp, bottom = 10.dp),
            contentAlignment = Alignment.TopCenter
        ) {
            NewsCard(modifier = Modifier)

        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF808080)
@Composable
fun NewsVerticalPagerPreview() {
    GlanceTheme {
        NewsVerticalPager()
    }
}