package com.example.news_pract.presentation.fragments.type_pin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.news_pract.data.UsersRepository

class TypePinViewModelFactory(private var usersRepository: UsersRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TypePinViewModel(usersRepository) as T
    }
}