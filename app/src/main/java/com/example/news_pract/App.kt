package com.example.news_pract

import android.app.Application
import com.example.news_pract.data.NewsRepository
import com.example.news_pract.data.UsersRepository
import com.example.news_pract.data.database.AppDataBase
import com.example.news_pract.data.database.entities.UserDbEntity
import com.example.news_pract.data.remote.ArticleDao
import com.example.news_pract.data.remote.RetrofitInstance

class App : Application() {

    val dataBase: AppDataBase by lazy { AppDataBase.getDatabase(this) }
    val usersRepository: UsersRepository by lazy { UsersRepository(dataBase.getUsersDao()) }
    val newsRepository: NewsRepository by lazy {
        NewsRepository(
            api = RetrofitInstance.api,
            dao = dataBase.getNewsDao()
        )
    }
}
