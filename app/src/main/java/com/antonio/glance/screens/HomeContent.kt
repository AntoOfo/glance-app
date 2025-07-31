package com.antonio.glance.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.antonio.glance.ui.theme.GlanceTheme

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {

    Column(modifier = modifier) {
        Spacer(Modifier.height(20.dp))

        SearchBar(Modifier.padding(horizontal = 16.dp))

        NewsColumn(Modifier
            .padding(horizontal = 18.dp)
            .padding(top = 20.dp))
    }
}

@Composable
fun MyAppPortrait() {
    GlanceTheme {
        Scaffold(bottomBar = { BottomNav() })
        { paddingValues ->
            HomeScreen(modifier = Modifier.padding(paddingValues))
        }
    }
}

@Preview(name = "Bigger phone",
    device = "id:pixel_3",
    showBackground = true,
    backgroundColor = 0xFFEEEEEE, showSystemUi = true
)
@Composable
fun MyAppPortraitPreview() {
    GlanceTheme {
        MyAppPortrait()
    }
}



