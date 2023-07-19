package com.example.news_pract.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.news_pract.R
import com.example.news_pract.data.database.AppDataBase
import com.example.news_pract.data.database.AppDataBase.Companion.getDatabase
import com.example.news_pract.data.database.Dao

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

     }
}