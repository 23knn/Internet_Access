package com.example.internetaccess.data

import com.example.internetaccess.network.UserService

interface UserRepository {
    // the interface to the UserNetworkRepository.
}

class UserNetworkRepository(userService: UserService):UserRepository{
    // this repository takes in a service as a dependency so it can use it to make calls for fetching data
}