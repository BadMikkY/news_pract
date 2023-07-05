package com.example.news_pract.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.news_pract.database.entities.UserDbEntity

@Database(
    version = 1,
    entities = [
        UserDbEntity::class
    ]
)
abstract class AppDataBase : RoomDatabase() {
    abstract fun getUsersDao(): UsersDao
}