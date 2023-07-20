package com.example.news_pract.presentation.fragments.saved_news

import androidx.lifecycle.ViewModel
import com.example.news_pract.data.NewsRepository
import kotlinx.coroutines.flow.map

class SavedNewsViewModel(private var newsRepository: NewsRepository) : ViewModel() {
    fun getSavedNews() = newsRepository.getSavedArticles().map {
        it.map { articleDbEntity ->
            articleDbEntity.toArticle()
        }
    }
}