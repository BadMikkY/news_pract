package com.example.news_pract.presentation.fragments.latest_news

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.news_pract.data.NewsRepository
import com.example.news_pract.data.UsersRepository

class NewsViewModelFactory(private var newsRepository: NewsRepository ): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NewsViewModel(newsRepository) as T
    }
}