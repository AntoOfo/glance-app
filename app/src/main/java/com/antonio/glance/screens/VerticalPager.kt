package com.antonio.glance.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
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
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.antonio.glance.ui.theme.GlanceTheme

@Composable
fun SwipeDownIndicator(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = Icons.Default.KeyboardArrowDown,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
        )
        Icon(
            imageVector = Icons.Default.KeyboardArrowDown,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
            modifier = Modifier.offset(y = (-16).dp)
        )
    }
}

@Composable
fun NewsVerticalPager(modifier: Modifier = Modifier) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val cardMaxHeight = screenHeight * 0.85f

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
        contentPadding = PaddingValues(bottom = 130.dp)
    ) { pageIndex ->
        Box(
            modifier = Modifier
                .padding(top = 50.dp, start = 14.dp, end = 14.dp, bottom = 10.dp),
            contentAlignment = Alignment.TopCenter
        ) {
            NewsCard(
                modifier = Modifier,
                maxHeight = cardMaxHeight)

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

@Preview(showBackground = true, backgroundColor = 0xFF808080)
@Composable
fun SwipeDownIndicatorPreview() {
    GlanceTheme {
        SwipeDownIndicator()
    }
}