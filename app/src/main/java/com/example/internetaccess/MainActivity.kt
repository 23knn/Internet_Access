package com.example.internetaccess

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.internetaccess.ui.theme.InternetAccessTheme
import com.example.internetaccess.ui.viewModel.UsersVM
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.internetaccess.ui.screens.Home

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
                    val usersViewModel: UsersVM = viewModel()
                    Home(uiState = usersViewModel.usersUiState,
                        retry = usersViewModel::getUsers)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    InternetAccessTheme {
        Greeting("Android")
    }
}