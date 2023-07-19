package com.example.news_pract.presentation.fragments.type_pin


import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.news_pract.data.UsersRepository
import com.example.news_pract.data.database.entities.User
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class TypePinViewModel(private var usersRepository: UsersRepository) : ViewModel() {

    private val _uiState = MutableStateFlow(TypePinUiState())
    val uiState: StateFlow<TypePinUiState> = _uiState
    private val _singleToastEvent = Channel<String>()
    val singleToastEvent = _singleToastEvent.receiveAsFlow()

    fun isLoggedIn() {
        viewModelScope.launch {
            val isLoggedIn = usersRepository.isUserLoggedIn()
            _uiState.update {
                it.copy(
                    isLoggedIn = isLoggedIn,
                    showSkipButton = isLoggedIn?.not() ?: true
                )
            }
        }
    }

    fun skipPin() {
        viewModelScope.launch {
            usersRepository.saveUser(User(1, false, ""))
        }
    }

    fun onCodeChanged(code: String) {
        _uiState.update { it.copy(code = code) }
    }

    fun onConfirmClick() {
        viewModelScope.launch {
            val code = _uiState.value.code

            if (uiState.value.isLoggedIn == true) {
                val pin = usersRepository.getUsersInfo().pinCode
                if (code == pin) {
                    _uiState.update { it.copy(navigateToNews = true) }
                }else{
                    _singleToastEvent.send("Wrong PIN")
                }

            } else {
                usersRepository.saveUser(User(1, true, code))
                _uiState.update { it.copy(navigateToNews = true) }
            }

        }
    }


}