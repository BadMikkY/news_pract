package com.example.news_pract.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.news_pract.database.entities.UserDbEntity


@Dao
interface UsersDao {
    @Insert(entity = UserDbEntity::class)
    fun insertNewUsersInfoData(user:UserDbEntity)

    @Query("SELECT is_logged FROM users ")
    fun getIfUserLoggedInData(): Boolean
}