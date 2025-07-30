package com.antonio.glance.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.antonio.glance.ui.theme.GlanceTheme

@Composable
fun NewsColumn(modifier: Modifier = Modifier) {

    Surface(
        shape = MaterialTheme.shapes.large,
        color = MaterialTheme.colorScheme.surface
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
        ) {
            items(5) { index ->
                NewsCard()
                SwipeDownIndicator()
            }

        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF808080)
@Composable
fun NewsColumnPreview() {
    GlanceTheme {
        NewsColumn()
    }
}