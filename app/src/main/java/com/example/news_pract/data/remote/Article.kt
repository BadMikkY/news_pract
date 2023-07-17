package com.example.news_pract.data.remote

import androidx.room.Entity
import androidx.room.PrimaryKey


data class Article(
    val author: String,
    val description: String,
    val publishedAt: String,
    val title: String,
    val url: String,
    val urlToImage: String
)