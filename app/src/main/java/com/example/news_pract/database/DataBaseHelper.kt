package com.example.news_pract.database

import android.content.Context
import androidx.room.Room


object DataBaseHelper {

    private lateinit var applicationContext: Context

    fun init(context: Context) {
        applicationContext = context
    }

    private val appDataBase: AppDataBase by lazy {
        Room.databaseBuilder(applicationContext, AppDataBase::class.java, "database.db").build()
    }

}