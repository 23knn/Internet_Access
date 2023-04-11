package com.example.internetaccess.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.internetaccess.model.Result
import com.example.internetaccess.ui.viewModel.UsersUiState

@Composable
fun Home(uiState: UsersUiState, retry : () -> Unit, modifier: Modifier = Modifier){
    when(uiState){
        // this provided a distinction. when you use "is" in a when block, you check for type. without it, you check for equality
        is UsersUiState.Success -> UsersList(users = uiState.users.results)
        is UsersUiState.Loading -> Loading()
        is UsersUiState.Error -> Error(retry)
    }
}

@Composable
fun Loading(modifier: Modifier = Modifier){
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Text("Loading")
    }
}

@Composable
fun Error(retry : ()->Unit, modifier: Modifier = Modifier){
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = retry) {
            Text("Retry fetching")
        }
    }
}

@Composable
fun UsersList(users: List<Result>, modifier: Modifier = Modifier){
    LazyColumn(modifier = modifier.fillMaxWidth(),){
        items(users){it -> Text(it.toString())}
    }
}