package com.antonio.glance.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.antonio.glance.Article
import kotlinx.coroutines.launch

class GlanceViewModel() : ViewModel() {

    // holds list of articles
    var articles by mutableStateOf<List<Article>>(emptyList())
    private set

    // load articles based on category
    fun loadArticles(category: String) {
        viewModelScope.launch {

        }
    }
}