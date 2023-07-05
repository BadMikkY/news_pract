package com.example.news_pract.database.entities

data class User(
    val isLogged: Boolean,
    val pinCode: Int
) {
    fun toUserDbEntity(): UserDbEntity = UserDbEntity(
        is_logged =isLogged,
        PinCode =pinCode
    )
}
