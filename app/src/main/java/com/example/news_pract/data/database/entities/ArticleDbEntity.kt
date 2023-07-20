package com.example.news_pract.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.news_pract.data.remote.Article

@Entity(tableName = "saved_news")
data class ArticleDbEntity(
    @PrimaryKey val url: String,
    @ColumnInfo(name = "description") val description: String?,
    @ColumnInfo(name = "author") val author: String?,
    @ColumnInfo(name = "published_at") val publishedAt: String?,
    @ColumnInfo(name = "title") val title: String?,
    @ColumnInfo(name = "url_to_image") val urlToImage: String?
){
    fun toArticle(): Article = Article(
        url = url,
        author= author,
        description = description,
        title = title,
        urlToImage = urlToImage,
        publishedAt = publishedAt
    )
}
