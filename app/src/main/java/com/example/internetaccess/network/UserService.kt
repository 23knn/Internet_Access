package com.example.internetaccess.network

import com.example.internetaccess.model.User
import retrofit2.http.GET

interface UserService {
    @GET
    suspend fun getUsers(): List<User>
}