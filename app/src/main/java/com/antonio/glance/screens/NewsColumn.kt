package com.antonio.glance.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.antonio.glance.Article
import com.antonio.glance.ui.theme.GlanceTheme
import kotlinx.coroutines.delay

@SuppressLint("SuspiciousIndentation")
@Composable
fun NewsColumn(
    modifier: Modifier = Modifier,
    articles: List<Article>,
    savedArticles: List<Article>,
    onFavouriteToggle: (Article) -> Unit,
    showImage: Boolean) {
    // gives list of items for snappping
    val listState = rememberLazyListState()
    // snapping behaviour
    val flingBehavior = rememberSnapFlingBehavior(
        lazyListState = listState,
        snapPosition = SnapPosition.Start)  // snaps to top of column

    var showIndicator by remember { mutableStateOf(true) }
    var lastScrollTime by remember { mutableStateOf(0L) }

    val lastIndex = 4  // dummy

    // detects scrolling
    LaunchedEffect(listState.isScrollInProgress) {
        if (listState.isScrollInProgress) {
            showIndicator = false
            lastScrollTime = System.currentTimeMillis()
        } else {
            val visibleItems = listState.layoutInfo.visibleItemsInfo
            val lastItem = visibleItems.find { it.index == lastIndex }

            // if last item exists and is half the view
            if (lastItem != null) {
                val viewportHeight = listState.layoutInfo.viewportEndOffset
                val itemVisibleHeight = (lastItem.size + lastItem.offset).coerceAtMost(viewportHeight) - lastItem.offset

                val mostOfLastVisible = itemVisibleHeight > (lastItem.size / 2)

                showIndicator = !mostOfLastVisible
            } else {

                showIndicator = true
            }
        }
    }
    val clipShape = RoundedCornerShape(
        topStart = 15.dp,
        topEnd = 15.dp,
        bottomStart = 0.dp,
        bottomEnd = 0.dp
    )
        LazyColumn(
            state = listState,
            flingBehavior = flingBehavior,
            verticalArrangement = Arrangement.spacedBy(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.clip(clipShape)
        ) {
            items(articles.size) { index ->
                val article = articles[index]
                var visible by remember { mutableStateOf(false)}

                LaunchedEffect(Unit) {
                    visible = true
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    val isSaved = savedArticles.any { it.url == article.url}
                    if (showImage) {
                        NewsCard(
                            showIndicator = showIndicator,
                            source = article.source.name,
                            publishedAt = article.publishedAt,
                            title = article.title,
                            description = article.description,
                            showImage = true,
                            image = article.image,
                            url = article.url,
                            isSaved = isSaved,
                            onFavouriteToggle = { onFavouriteToggle(article)}
                        )
                    } else {
                        NewsCard(
                            showIndicator = showIndicator,
                            source = article.source.name,
                            publishedAt = article.publishedAt,
                            title = article.title,
                            description = article.description,
                            showImage = false,
                            image = article.image,
                            url = article.url,
                            isSaved = isSaved,
                            onFavouriteToggle = { onFavouriteToggle(article)})
                    }
            }
}

    }
}

@Preview(showBackground = true, backgroundColor = 0xFF808080)
@Composable
fun NewsColumnPreview() {
    GlanceTheme {
        NewsColumn(
            showImage = true,
            modifier = TODO(),
            articles = TODO(),
            savedArticles = TODO(),
            onFavouriteToggle = TODO()
        )
    }
}