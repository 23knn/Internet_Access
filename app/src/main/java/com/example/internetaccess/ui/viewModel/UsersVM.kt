package com.example.internetaccess.ui.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.internetaccess.data.UserRepository
import com.example.internetaccess.model.Users
import kotlinx.coroutines.launch

/**
 * great design pattern for this interface. the members of the interface are of the same type as
 * the interface.This makes the interface behave like an enum
 * **/
sealed interface UsersUiState{
    data class Success(val users : Users) : UsersUiState
    object Error : UsersUiState
    object Loading : UsersUiState
}

class UsersVM(private val randomUserRepository: UserRepository) : ViewModel() {
    var usersUiState : UsersUiState by mutableStateOf(UsersUiState.Loading)
        private set
    init {
        getUsers()
    }

    fun getUsers(){
        viewModelScope.launch {
            usersUiState = UsersUiState.Loading
            usersUiState = try{
                UsersUiState.Success(randomUserRepository.getUsers())
            }catch(e: java.lang.Exception){
                UsersUiState.Error
            }

        }
    }
}