package com.example.news_pract.data.database.entities

data class User(
    val id: Int,
    val isLogged: Boolean,
    val pinCode: String
) {
    fun toUserDbEntity(): UserDbEntity = UserDbEntity(
        id = 1,
        isLogged = isLogged,
        pinCode = pinCode
    )
}
