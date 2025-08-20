package com.antonio.glance.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.antonio.glance.R
import com.antonio.glance.ui.theme.GlanceTheme

@Composable
fun NewsCard(
    modifier: Modifier = Modifier,
    image: String,
    source: String,
    publishedAt: String,
    title: String,
    description: String,
    url: String,
    showIndicator: Boolean,
    showImage: Boolean,
    isSaved: Boolean,
    onFavouriteToggle: () -> Unit) {

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

    // just gonna keep the max lines as 4

    // flexible max lines
    //val bodyMaxLines = when {
    //    screenHeightDp > 800 -> 9
    //    screenHeightDp > 600 -> 4
    //    else -> 3
   // }
    val context = LocalContext.current

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface(
            shape = MaterialTheme.shapes.large,
            color = MaterialTheme.colorScheme.surface,
            border = BorderStroke(0.5.dp, color = MaterialTheme.colorScheme.secondary.copy(alpha = 0.2f)),
            modifier = modifier
                .clickable {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                    context.startActivity(intent)
                }
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
                    AsyncImage(
                        model = ImageRequest.Builder(context)
                            .data(image)
                            .crossfade(true)
                            .crossfade(300)
                            .build(),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(if (showImage) 170.dp else 0.dp),
                        placeholder = painterResource(R.drawable.placeholder),
                        error = painterResource(R.drawable.errorimg)
                    )
                }
                Spacer(modifier = Modifier.height(9.dp))
                Text(
                    text = "${source} - ${publishedAt}",   // dummy title
                    style = MaterialTheme.typography.labelLarge.copy(fontSize = labelLargeSize),
                    modifier = Modifier
                        .alpha(0.8f)
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleLarge.copy(fontSize = titleLargeSize, lineHeight = titleLargeLine),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
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
                    text = description,
                    style = MaterialTheme.typography.labelLarge.copy(fontSize = labelLargeSize, lineHeight = labelLargeLine),
                    maxLines = 4,
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
                        onClick = onFavouriteToggle,
                        modifier = Modifier.align(Alignment.CenterEnd)
                    ) {
                        Icon(
                            painter = painterResource(
                                id = if (isSaved) R.drawable.bookmark else R.drawable.bookmark_border),
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
            showImage = true,
            modifier = TODO(),
            source = TODO(),
            publishedAt = TODO(),
            title = TODO(),
            description = TODO(),
            image = TODO(),
            url = TODO(),
            isSaved = TODO(),
            onFavouriteToggle = TODO()
        )
    }
}