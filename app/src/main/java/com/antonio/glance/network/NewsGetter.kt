package com.antonio.glance.network

import com.antonio.glance.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsGetter {

    @GET("news/top-headlines")
    suspend fun getNews(
        @Query("category") category: String
    ): NewsResponse
}