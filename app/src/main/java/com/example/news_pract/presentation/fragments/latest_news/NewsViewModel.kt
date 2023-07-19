package com.example.news_pract.presentation.fragments.latest_news

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.news_pract.data.NewsRepository
import com.example.news_pract.data.remote.ArticleApiModel
import kotlinx.coroutines.launch
import retrofit2.Response
import com.example.news_pract.util.Result
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class NewsViewModel(val newsRepository: NewsRepository) : ViewModel() {

    private val _latestNews = MutableStateFlow<Result<ArticleApiModel>>(Result.Loading())
    val latestNews = _latestNews.asStateFlow()
    var latestNewsPage = 1

    fun getLatestNews(countryCode: String) = viewModelScope.launch {
        _latestNews.value = Result.Loading()
        when (val result = newsRepository.getLatestNews(countryCode, latestNewsPage)) {
            is Result.Success -> {
                _latestNews.update { result }
            }

            is Result.Error -> {
                _latestNews.update { result }
            }

            else -> {}
        }
    }


}