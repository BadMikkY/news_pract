package com.example.news_pract.presentation.fragments.saved_news

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.news_pract.data.NewsRepository
import com.example.news_pract.presentation.fragments.latest_news.NewsViewModel
import com.example.news_pract.presentation.fragments.more_info.ArticleViewModel

class SavedNewsViewModelFactory(private var newsRepository: NewsRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SavedNewsViewModel(newsRepository) as T
    }
}
