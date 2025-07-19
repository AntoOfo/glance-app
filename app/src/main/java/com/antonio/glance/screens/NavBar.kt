package com.antonio.glance.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.antonio.glance.R
import com.antonio.glance.ui.theme.GlanceTheme

@Composable
fun BottomNav(modifier: Modifier = Modifier) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surface,
        modifier = modifier
    ) {
        NavigationBarItem(
            selected = true,
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Home",
                    tint = MaterialTheme.colorScheme.secondary
                )
            },
            label = { Text("Home") },
            onClick = {},
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = MaterialTheme.colorScheme.secondary,
                selectedTextColor = MaterialTheme.colorScheme.secondary
            )
        )
        NavigationBarItem(
            selected = false,
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.bookmark_border),
                    contentDescription = "Bookmark",
                    tint = MaterialTheme.colorScheme.secondary
                )
            },
            label = { Text("Saved") },
            onClick = {},
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = MaterialTheme.colorScheme.secondary,
                selectedTextColor = MaterialTheme.colorScheme.secondary
            )
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF808080)
@Composable
fun BottomNavPreview() {
    GlanceTheme {
        BottomNav()
    }
}