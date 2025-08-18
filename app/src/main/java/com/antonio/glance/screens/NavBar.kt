package com.antonio.glance.screens

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.NavigationRailItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.antonio.glance.R
import com.antonio.glance.ui.theme.GlanceTheme
import com.antonio.glance.viewmodels.GlanceViewModel

@Composable
fun BottomNav(
    viewModel: GlanceViewModel,
    modifier: Modifier = Modifier
    ) {

    val showOnlyLiked = viewModel.showOnlyLiked

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surface,
        modifier = modifier
    ) {
        NavigationBarItem(
            icon = {
                Crossfade(targetState = !showOnlyLiked) { selected ->
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = "Home",
                        tint = if (selected) MaterialTheme.colorScheme.secondary
                        else MaterialTheme.colorScheme.onSurface
                    )
                }
            },
            label = {
                Text(
                    "Home",
                    style = MaterialTheme.typography.labelLarge)
                    },
            selected = !showOnlyLiked,
            onClick = {
                if (showOnlyLiked) {
                    viewModel.toggleShowOnlyLiked()
                }
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = MaterialTheme.colorScheme.secondary,
                selectedTextColor = MaterialTheme.colorScheme.secondary
            )
        )
        NavigationBarItem(
            icon = {
                Crossfade(targetState = showOnlyLiked) { selected ->
                    Icon(
                        painter = painterResource(id = R.drawable.bookmark_border),
                        contentDescription = "Bookmark",
                        tint = MaterialTheme.colorScheme.secondary
                    )
                }
            },
            label = {
                Text(
                    "Saved",
                    style = MaterialTheme.typography.labelLarge) },
            selected = showOnlyLiked,
            onClick = {
                if (!showOnlyLiked) {
                    viewModel.toggleShowOnlyLiked()
                }
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = MaterialTheme.colorScheme.secondary,
                selectedTextColor = MaterialTheme.colorScheme.secondary
            )
        )
    }
}

@Composable
fun NavRail(modifier: Modifier = Modifier) {
    NavigationRail(
        modifier = modifier.padding(start = 8.dp, end = 8.dp),
        containerColor = MaterialTheme.colorScheme.surface
    ) {
        Column(
            modifier = modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.spacedBy(
                space = 12.dp, alignment = Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NavigationRailItem(
                selected = true,
                icon = {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = "Home",
                        tint = MaterialTheme.colorScheme.secondary
                    )
                },
                label = {
                    Text(
                        "Home",
                        style = MaterialTheme.typography.labelLarge)
                },
                onClick = {},
                colors = NavigationRailItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.secondary,
                    selectedTextColor = MaterialTheme.colorScheme.secondary
                )
            )
            NavigationRailItem(
                selected = false,
                icon = {
                    Icon(
                        painter = painterResource(id = R.drawable.bookmark_border),
                        contentDescription = "Bookmark",
                        tint = MaterialTheme.colorScheme.secondary
                    )
                },
                label = {
                    Text(
                        "Saved",
                        style = MaterialTheme.typography.labelLarge) },
                onClick = {},
                colors = NavigationRailItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.secondary,
                    selectedTextColor = MaterialTheme.colorScheme.secondary
                )
            )
        }

    }
}

@Preview(showBackground = true, backgroundColor = 0xFF808080)
@Composable
fun BottomNavPreview() {
    GlanceTheme {
        BottomNav()
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF808080)
@Composable
fun NavRailPreview() {
    GlanceTheme {
        NavRail()
    }
}