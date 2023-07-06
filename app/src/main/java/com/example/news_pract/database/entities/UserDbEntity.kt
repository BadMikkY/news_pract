package com.example.news_pract.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "users")
data class UserDbEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "is_logged") val isLogged: Boolean,
    @ColumnInfo(name = "pin_code") val pinCode: Int
)
