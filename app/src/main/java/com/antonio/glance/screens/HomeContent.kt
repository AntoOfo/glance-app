package com.antonio.glance.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.antonio.glance.ui.theme.GlanceTheme

// homescreen ui w/o navbar
@Composable
fun HomeScreen(modifier: Modifier = Modifier, showImage: Boolean) {

    Column(modifier = modifier) {
        Spacer(Modifier.height(20.dp))

        CategoryRow(Modifier.padding(horizontal = 20.dp))

        if (showImage) {
            NewsColumn(
                Modifier
                    .padding(horizontal = 18.dp)
                    .padding(top = 20.dp),
                showImage = true
            )
        } else {
            NewsColumn(
                Modifier
                    .padding(horizontal = 18.dp)
                    .padding(top = 20.dp),
                showImage = false
            )
        }
    }
}

// portrait ui w navbar / dk if ill do landscape
@Composable
fun MyAppPortrait() {
    GlanceTheme {
        Scaffold(bottomBar = { BottomNav() })
        { paddingValues ->
            HomeScreen(modifier = Modifier.padding(paddingValues),
                showImage = true)
        }
    }
}

@Composable
fun MyAppLandscape() {
    GlanceTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Row {
                NavRail()
                HomeScreen(showImage = false)
            }
        }
    }
}

@Preview(name = "Bigger phone",
    device = "id:pixel",
    showBackground = true,
    backgroundColor = 0xFFEEEEEE, showSystemUi = true
)
@Composable
fun MyAppPortraitPreview() {
    GlanceTheme {
        MyAppPortrait()
    }
}
@Preview(name = "Bigger phone",
    device = "spec:parent=pixel,orientation=landscape",
    showBackground = true,
    backgroundColor = 0xFFEEEEEE, showSystemUi = true
)
@Composable
fun MyAppLandscapePreview() {
    GlanceTheme {
        MyAppLandscape()
    }
}




