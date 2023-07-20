package com.example.news_pract.presentation.fragments.more_info

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.news_pract.data.NewsRepository

class ArticleViewModelFactory(private var newsRepository: NewsRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ArticleViewModel(newsRepository) as T
    }
}