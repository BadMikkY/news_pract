package com.example.news_pract

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.news_pract.database.AppDataBase
import com.example.news_pract.database.AppDataBase.Companion.getDatabase
import com.example.news_pract.database.UsersDao

class MainActivity : AppCompatActivity() {
    private lateinit var database: AppDataBase
    private lateinit var dao: UsersDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        database = getDatabase(this)
        dao = database.getUsersDao()
     }
}