package com.example.news_pract.presentation.fragments.more_info

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.news_pract.data.NewsRepository
import com.example.news_pract.data.remote.Article
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class ArticleViewModel(private var newsRepository: NewsRepository) : ViewModel() {

    fun saveNews(article: Article) = viewModelScope.launch {
         newsRepository.upsertNews(article)
    }

}