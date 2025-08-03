package com.antonio.glance.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.antonio.glance.R
import com.antonio.glance.ui.theme.GlanceTheme

@Composable
fun NewsCard(
    modifier: Modifier = Modifier,
    showIndicator: Boolean,
    showImage: Boolean) {

    val configuration = LocalConfiguration.current
    val screenHeightDp = configuration.screenHeightDp

    // flexible font sizing
    val labelLargeSize = when {
        screenHeightDp > 800 -> 14.sp
        screenHeightDp > 600 -> 12.sp
        else -> 11.sp
    }
    // flexible line height sizing
    val labelLargeLine = when {
        screenHeightDp > 800 -> 16.sp
        screenHeightDp > 600 -> 14.sp
        else -> 13.sp
    }

    val titleLargeSize = when {
        screenHeightDp > 800 -> 16.sp
        screenHeightDp > 600 -> 13.sp
        else -> 12.sp
    }
    val titleLargeLine = when {
        screenHeightDp > 800 -> 19.sp
        screenHeightDp > 600 -> 16.sp
        else -> 15.sp
    }

    // flexible max lines
    val bodyMaxLines = when {
        screenHeightDp > 800 -> 9
        screenHeightDp > 600 -> 4
        else -> 3
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface(
            shape = MaterialTheme.shapes.large,
            color = MaterialTheme.colorScheme.surface,
            shadowElevation = 2.dp,
            modifier = modifier
        ) {
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                Surface(
                    shape = MaterialTheme.shapes.medium,
                    modifier = modifier
                        .fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.dummy_img),   // dummy img for now
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(if (showImage) 170.dp else 0.dp)
                    )
                }
                Spacer(modifier = Modifier.height(9.dp))
                Text(
                    text = "BBC News - 3h ago",   // dummy title
                    style = MaterialTheme.typography.labelLarge.copy(fontSize = labelLargeSize),
                    modifier = Modifier
                        .alpha(0.8f)
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "Guterres tells UN meeting that impunity, inequality, and other challenges risk engulfing the world",
                    style = MaterialTheme.typography.titleLarge.copy(fontSize = titleLargeSize, lineHeight = titleLargeLine),
                    modifier = Modifier
                )
                Spacer(modifier = Modifier.height(12.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Divider(
                        modifier = Modifier
                            .alpha(0.6f)
                            .fillMaxWidth(0.99f)
                    )
                }
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    // dummy bio
                    text = "The head of the United Nations warned gathered leaders Tuesday that impunity, inequality and uncertainty are driving modern civilisation toward \"a powder keg that risks engulfing the world\" - the latest clarion call from Antonio Guterres that the global situation is becoming intolerable and unsustainable.",
                    style = MaterialTheme.typography.labelLarge.copy(fontSize = labelLargeSize, lineHeight = labelLargeLine),
                    maxLines = bodyMaxLines,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .alpha(0.7f)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Box(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Tap to read more",
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier
                            .align(Alignment.Center)
                            .alpha(0.4f)
                    )
                    IconButton(
                        onClick = {},
                        modifier = Modifier.align(Alignment.CenterEnd)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.bookmark_border),
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.secondary,
                            modifier = Modifier
                                .size(24.dp)
                        )
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(24.dp))
        SwipeDownIndicator(
            show = showIndicator
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF808080)
@Composable
fun NewsCardPreview() {
    GlanceTheme {
        NewsCard(
            showIndicator = true,
            showImage = true
        )
    }
}