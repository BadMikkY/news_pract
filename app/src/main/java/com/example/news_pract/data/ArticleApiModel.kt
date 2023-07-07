package com.example.news_pract.data

data class ArticleApiModel(
    val articles: List<ArticleX>,
    val status: String,
    val totalResults: Int
)