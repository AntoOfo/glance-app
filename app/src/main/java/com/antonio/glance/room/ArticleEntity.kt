package com.antonio.glance.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "articles")
data class ArticleEntity(
    @PrimaryKey val url: String,
    val source: String,
    val publishedAt: String,
    val title: String,
    val description: String,
    val image: String
)