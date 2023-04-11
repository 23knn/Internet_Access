package com.example.internetaccess.network

import com.example.internetaccess.model.Users
import retrofit2.http.GET

interface UserService {
    @GET(".")
    suspend fun getUsers(): Users
}
