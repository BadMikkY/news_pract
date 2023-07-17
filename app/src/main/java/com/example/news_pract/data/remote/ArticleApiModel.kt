package com.example.news_pract.data.remote

data class ArticleApiModel(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)