package com.example.news_pract.data

import com.example.news_pract.data.database.entities.ArticleDbEntity
import com.example.news_pract.data.remote.Article
import com.example.news_pract.data.remote.ArticleApiModel
import com.example.news_pract.data.remote.ArticleDao
import com.example.news_pract.data.remote.NewsAPI
import com.example.news_pract.data.remote.RetrofitInstance
import com.example.news_pract.util.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext
import retrofit2.Response

class NewsRepository(private val api: NewsAPI, private val dao: ArticleDao) {
    suspend fun getLatestNews(countryCode: String, pageNumber: Int): Result<ArticleApiModel> =
        withContext(Dispatchers.IO) {
            try {
                val response = RetrofitInstance.api.getLatestNews(countryCode, pageNumber)
                if (response.isSuccessful) {
                    response.body()?.let { resultResponse ->
                        Result.Success(resultResponse)
                    } ?: Result.Success(
                        ArticleApiModel(
                            articles = emptyList(),
                            status = "Success",
                            totalResults = 0
                        )
                    )
                } else {
                    Result.Error(response.message())
                }
            } catch (e: Exception) {
                Result.Error(e.message ?: e.toString())
            }
        }

    suspend fun upsertNews(article: Article) = withContext(Dispatchers.IO) {
        dao.upsert(article.toArticleDbEntity())
    }

    fun getSavedArticles(): Flow<List<ArticleDbEntity>> = dao.getAllArticles()


}

