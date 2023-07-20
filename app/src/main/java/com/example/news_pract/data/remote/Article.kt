package com.example.news_pract.data.remote

import android.os.Parcelable
import com.example.news_pract.data.database.entities.ArticleDbEntity
import kotlinx.parcelize.Parcelize


@Parcelize
data class Article(
    val author: String?,
    val description: String?,
    val publishedAt: String?,
    val title: String?,
    val url: String,
    val urlToImage: String?
) : Parcelable {
    fun toArticleDbEntity():ArticleDbEntity = ArticleDbEntity(
        url = url,
        author= author,
        description = description,
        title = title,
        urlToImage = urlToImage,
        publishedAt = publishedAt
    )
}