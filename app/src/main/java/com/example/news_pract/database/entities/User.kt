package com.example.news_pract.database.entities

data class User(
    val id: Int,
    val isLogged: Boolean,
    val pinCode: Int
) {
    fun toUserDbEntity(): UserDbEntity = UserDbEntity(
        id = 1,
        isLogged = isLogged,
        pinCode = pinCode
    )
}
