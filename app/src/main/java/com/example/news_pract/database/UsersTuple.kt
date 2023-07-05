package com.example.news_pract.database

import androidx.room.ColumnInfo

data class UsersTuple(
    val is_logged: Boolean,
    @ColumnInfo(name = "pin_code") val PinCode: String
)
