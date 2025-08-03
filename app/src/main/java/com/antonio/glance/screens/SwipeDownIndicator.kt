package com.antonio.glance.screens

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.getValue
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
fun SwipeDownIndicator(modifier: Modifier = Modifier, show: Boolean) {
    // compose thing for repeating animations
    val infiniteTransition = rememberInfiniteTransition()

    // top icon animation
    val animatedAlphaTop by infiniteTransition.animateFloat(
        initialValue = 1.0f,
        targetValue = 0.2f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )
    // bottom icon animation
    val animatedAlphaBottom by infiniteTransition.animateFloat(
        initialValue = 1.0f,
        targetValue = 0.2f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 900, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    val alpha by animateFloatAsState(
        targetValue = if (show) 0.3f else 0f,
        animationSpec = tween(200)
    )

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(modifier = Modifier.size(28.dp)) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = "Arrow Done One",
                tint = MaterialTheme.colorScheme.onSurface.copy(alpha = alpha * animatedAlphaTop),
                modifier = Modifier
                    .align(Alignment.Center)
                    .offset(y = (2).dp)
                    .size(28.dp)
            )
            Icon(
                imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = "Arrow Done Two",
                tint = MaterialTheme.colorScheme.onSurface.copy(alpha = alpha * animatedAlphaBottom),
                modifier = Modifier
                    .align(Alignment.Center)
                    .offset(y = (-4).dp)
                    .size(28.dp)
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF808080)
@Composable
fun SwipeDownIndicatorPreview() {
    GlanceTheme {
        SwipeDownIndicator(
            modifier = TODO(),
            show = TODO()
        )
    }
}