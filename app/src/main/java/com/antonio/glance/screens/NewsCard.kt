package com.antonio.glance.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.antonio.glance.R
import com.antonio.glance.ui.theme.GlanceTheme

@Composable
fun NewsCard(modifier: Modifier = Modifier) {

    Surface(
        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colorScheme.surface,
        modifier = modifier
            .aspectRatio(513f / 576f)
            .padding(4.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Surface(
                shape = MaterialTheme.shapes.extraSmall,
                modifier = modifier
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.dummy_img),   // dummy img for now
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(190.dp)
                )
            }
            Text(
                text = "BBC News - 3h ago",   // dummy title
                style = MaterialTheme.typography.labelLarge,
                modifier = Modifier
                    .padding(top = 10.dp)
            )
            Text(
                text = "Guterres tells UN meeting that impunity, inequality, and other challenges risk engulfing the world",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier
                    .padding(top = 3.dp)
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF808080)
@Composable
fun NewsCardPreview() {
    GlanceTheme {
        NewsCard()
    }
}