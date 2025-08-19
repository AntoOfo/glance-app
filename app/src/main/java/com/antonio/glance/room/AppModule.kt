package com.antonio.glance.room

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) : ArticleDatabase =
        Room.databaseBuilder(
            context,
            ArticleDatabase::class.java,
            "glance_db"
        ).build()

    @Provides
    fun provideArticleDao(db: ArticleDatabase): ArticleDao = db.articleDao()
}