package com.example.internetaccess.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.internetaccess.model.User
import com.example.internetaccess.ui.viewModel.UsersUiState

@Composable
fun Home(uiState: UsersUiState, retry : () -> Unit, modifier: Modifier = Modifier){
    when(uiState){
        // this provided a distinction. when you use "is" in a when block, you check for type. without it, you check for equality
        is UsersUiState.Success -> UsersList(users = uiState.users.results)
        is UsersUiState.Loading -> Loading()
        else -> Error(retry)
    }
}

@Composable
fun Loading(){
    Text("Loading")
}

@Composable
fun Error(retry : ()->Unit){
    Button(onClick = retry){
        Text(text = "Retry fetching")
    }
}

@Composable
fun UsersList(users: List<User>){
    LazyColumn{
        items(users){it -> it.toString()}
    }
}