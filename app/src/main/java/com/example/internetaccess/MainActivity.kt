package com.example.internetaccess

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.internetaccess.ui.screens.Home
import com.example.internetaccess.ui.theme.InternetAccessTheme
import com.example.internetaccess.ui.viewModel.UsersVM

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InternetAccessTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val usersViewModel: UsersVM = viewModel(factory = UsersVM.Factory)
                    Home(uiState = usersViewModel.usersUiState,
                        retry = usersViewModel::getUsers)
                }
            }
        }
    }
}
