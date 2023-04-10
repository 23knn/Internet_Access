package com.example.internetaccess.data

import com.example.internetaccess.model.Users
import com.example.internetaccess.network.UserService

interface UserRepository {
    // the interface to the UserNetworkRepository.
    suspend fun getUsers(): Users
}

class UserNetworkRepository(private val userService: UserService) : UserRepository {
    // this repository takes in a service as a dependency so it can use it to make calls for fetching data
    override suspend fun getUsers(): Users = userService.getUsers()
    // nice pattern. equate the functions to simulate a direct call. alternative would be to call the one on the right and make the one on the left return its results
}