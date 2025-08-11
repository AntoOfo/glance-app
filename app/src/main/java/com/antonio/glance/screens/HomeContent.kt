package com.antonio.glance.screens

import android.content.res.Configuration
import android.os.Build
import androidx.annotation.RequiresApi
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
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.antonio.glance.ui.theme.GlanceTheme
import com.antonio.glance.viewmodels.GlanceViewModel

// homescreen ui w/o navbar
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    showImage: Boolean,
    viewModel: GlanceViewModel) {

    val articles = viewModel.articles

    Column(modifier = modifier) {
        Spacer(Modifier.height(20.dp))

        CategoryRow(
            Modifier.padding(horizontal = 20.dp),
            onCategorySelected = { category ->
                viewModel.loadArticles(category)
            })

        if (showImage) {
            NewsColumn(
                Modifier
                    .padding(horizontal = 18.dp)
                    .padding(top = 20.dp),
                articles = articles,
                showImage = true
            )
        } else {
            NewsColumn(
                Modifier
                    .padding(horizontal = 18.dp)
                    .padding(top = 20.dp),
                articles = articles,
                showImage = false
            )
        }
    }
}

// portrait ui w navbar / dk if ill do landscape
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MyAppPortrait() {
    val viewModel: GlanceViewModel = viewModel()
    GlanceTheme {
        Scaffold(bottomBar = { BottomNav() })
        { paddingValues ->
            HomeScreen(
                modifier = Modifier.padding(paddingValues),
                showImage = true,
                viewModel = viewModel)
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MyAppLandscape() {
    val viewModel: GlanceViewModel = viewModel()
    GlanceTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Row {
                NavRail()
                HomeScreen(
                    showImage = false,
                    viewModel = viewModel)
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MyApp() {
    val configuration = LocalConfiguration.current
    val isLandscape = configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

    if (isLandscape) {
        MyAppLandscape()
    } else {
        MyAppPortrait()
    }
}

@RequiresApi(Build.VERSION_CODES.O)
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
@RequiresApi(Build.VERSION_CODES.O)
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




