package com.example.internetaccess

import android.app.Application
import com.example.internetaccess.data.AppContainer
import com.example.internetaccess.data.DefaultAppContainer

class UsersApplication : Application() {
    /** AppContainer instance used by the rest of classes to obtain dependencies
     *
     * the factory making the view model will need access to depndencies i.e the repository that
     * the view model is using. thus this provides the dependencies to the Factory
     * */
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}