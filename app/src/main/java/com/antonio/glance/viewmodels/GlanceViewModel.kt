package com.antonio.glance.viewmodels

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.antonio.glance.Article
import com.antonio.glance.network.RetrofitInstance
import kotlinx.coroutines.launch

class GlanceViewModel() : ViewModel() {

    var isLoadingNews by mutableStateOf(false)
    private set

    // holds list of articles
    var articles by mutableStateOf<List<Article>>(emptyList())
        private set

    var showOnlyLiked by mutableStateOf(false)
        private set

    fun toggleShowOnlyLiked() {
        showOnlyLiked = !showOnlyLiked
    }


    // load articles based on category
    @RequiresApi(Build.VERSION_CODES.O)
    fun loadArticles(category: String) {
        viewModelScope.launch {
            try {
                isLoadingNews = true

                val response = RetrofitInstance.newsGetter.getNews(category)

                articles = response.articles.mapNotNull { articles ->
                    val timeAgo = getTimeAgo(articles.publishedAt)
                    articles.copy(publishedAt = timeAgo)   // return changed publishedAt field too
                }
                isLoadingNews = false
            } catch (e: Exception) {
                isLoadingNews = false

        }
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun getTimeAgo(publishedAt: String?): String {
        if (publishedAt.isNullOrBlank()) return ""

        return try {
            val formatter = java.time.format.DateTimeFormatter.ISO_OFFSET_DATE_TIME
            val publishedTime = java.time.OffsetDateTime.parse(publishedAt, formatter)   // turning published time to formatted time
            val now = java.time.OffsetDateTime.now()  // time now
            val duration = java.time.Duration.between(publishedTime, now)     // time between

            when {
                duration.toMinutes() < 60 -> "${duration.toMinutes()}m ago"
                duration.toHours() < 24 -> "${duration.toHours()}h ago"
                else -> "${duration.toDays()}d ago"
            }
        } catch (e: Exception) {
            publishedAt
        }
    }
}