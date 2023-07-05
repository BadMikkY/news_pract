package com.example.news_pract.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "users")
data class UserDbEntity(
    @PrimaryKey val is_logged: Boolean,
    @ColumnInfo(name = "pin_code") val PinCode: Int
)
