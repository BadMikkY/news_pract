package com.example.news_pract.data.remote

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.news_pract.data.database.entities.ArticleDbEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: ArticleDbEntity)

    @Query("SELECT * FROM saved_news")
    fun getAllArticles(): Flow<List<ArticleDbEntity>>
}