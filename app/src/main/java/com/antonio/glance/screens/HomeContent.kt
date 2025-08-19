package com.antonio.glance.screens

import android.content.res.Configuration
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.LoadingIndicator
import androidx.compose.material3.LoadingIndicatorDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.antonio.glance.Article
import com.antonio.glance.Source
import com.antonio.glance.ui.theme.GlanceTheme
import com.antonio.glance.viewmodels.GlanceViewModel

// homescreen ui w/o navbar
@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    showImage: Boolean,
    viewModel: GlanceViewModel) {

    // from api
    val articles = viewModel.articles


    val displayArticles = if (viewModel.showOnlyLiked) {
        articles.filter { article ->
            viewModel.savedArticles.any {it.url == article.url}
        }
    } else {
        articles
    }

    val savedArticlesList = viewModel.savedArticles.map { entity ->
        Article(
            source = Source(entity.source),
            title = entity.title,
            description = entity.description,
            url = entity.url,
            image = entity.image,
            publishedAt = entity.publishedAt
        )
    }

    val isLoadingNews = viewModel.isLoadingNews

    LaunchedEffect(Unit) {
        viewModel.loadArticles("general")
    }

    Column(modifier = modifier) {
        Spacer(Modifier.height(20.dp))

        CategoryRow(
            Modifier.padding(horizontal = 20.dp),
            onCategorySelected = { category ->
                viewModel.loadArticles(category)
            })

        when {
            // loading news is true
            isLoadingNews -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    LoadingIndicator(
                        modifier = Modifier.padding(16.dp),
                        polygons = LoadingIndicatorDefaults.IndeterminateIndicatorPolygons.take(4),
                        color = MaterialTheme.colorScheme.secondary
                    )
                }
            }

            // if article list is empty
            articles.isEmpty() -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "No articles available.",
                        style = MaterialTheme.typography.labelLarge,
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }

            else -> {

                if (showImage) {
                    NewsColumn(
                        Modifier
                            .padding(horizontal = 18.dp)
                            .padding(top = 20.dp),
                        articles = displayArticles,
                        savedArticles = savedArticlesList,
                        onFavouriteToggle = { article ->
                            viewModel.toggleSaveArticle(article)
                        },
                        showImage = true
                    )
                } else {
                    NewsColumn(
                        Modifier
                            .padding(horizontal = 18.dp)
                            .padding(top = 20.dp),
                        articles = displayArticles,
                        savedArticles = savedArticlesList,
                        onFavouriteToggle = { article ->
                            viewModel.toggleSaveArticle(article)
                        },
                        showImage = false
                    )
                }
            }
        }
    }
}

// portrait ui w navbar / dk if ill do landscape
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MyAppPortrait() {
    val viewModel: GlanceViewModel = hiltViewModel()
    GlanceTheme {
        Scaffold(bottomBar = { BottomNav(viewModel) })
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
    val viewModel: GlanceViewModel = hiltViewModel()
    GlanceTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Row {
                NavRail(viewModel)
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




