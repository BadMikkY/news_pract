package com.example.news_pract.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.news_pract.data.database.entities.UserDbEntity


@Dao
interface Dao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNewUsersInfoData(user: UserDbEntity)

    @Query("SELECT is_logged FROM users ")
    fun getIfUserLoggedInData(): Boolean

    @Query("SELECT * FROM users")
    fun getUsersInfoData(): UserDbEntity

    @Delete
    fun deleteUsers(user: UserDbEntity)
}