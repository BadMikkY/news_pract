package com.example.news_pract.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.news_pract.data.database.entities.ArticleDbEntity
import com.example.news_pract.data.remote.Article
import com.example.news_pract.data.database.entities.UserDbEntity
import com.example.news_pract.data.remote.ArticleDao

@Database(
    version = 1,
    entities = [
        UserDbEntity::class,
        ArticleDbEntity::class
    ]
)


abstract class AppDataBase : RoomDatabase() {
    abstract fun getUsersDao(): Dao
    abstract fun getNewsDao(): ArticleDao

    companion object {
        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun getDatabase(context: Context): AppDataBase {
            return INSTANCE ?: synchronized((this)) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java, "news_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }

}