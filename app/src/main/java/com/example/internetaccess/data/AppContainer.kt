package com.example.internetaccess.data

import com.example.internetaccess.network.UserService
import retrofit2.Retrofit

interface AppContainer {
    /** this is used to bring everything together instead of doing it in other places e.g the view model.
     * its implementation will build retrofit and provide the retrofit service to the repository.
     * then the implementation will expose the instantiated repository as a public variable that the View model can use for calls
     */
    val randomUserRepository: UserRepository
}

class DefaultAppContainer: AppContainer{
    // make retrofit
    private val baseUrl = "https://randomuser.me/api"
    private val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .build()

    // create a retrofit service that implements the of the type of UserService.
    private val retrofitService : UserService by lazy { retrofit.create(UserService::class.java) }
    // the :: is a lambda. when a class::java lambda is provided to retrofit.create(), retrofit can call it when it needs it to instantiate an object of the Service class
    // lazy means that it will not be made until it is needed. for that to be possible, the lambda must be provided

    //inject the service into an instance of the repository and assign it to the variable for it
    override val randomUserRepository: UserRepository = UserNetworkRepository(retrofitService)
}