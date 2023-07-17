package com.example.news_pract.presentation.fragments.type_pin

import com.example.news_pract.data.database.entities.User

data class TypePinUiState(
    val code: String = "",
    val user: User? = null,
    val isLoggedIn: Boolean? = null,
    val navigateToNews: Boolean = false,
    val showSkipButton: Boolean = true
)
