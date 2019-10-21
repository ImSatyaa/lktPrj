package com.mac.testdemo.injection

import com.mac.testdemo.view.LoginActivity
import com.mac.testdemo.view.RegisterActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppContext::class,UtilModule::class])
interface AppComponents {

    fun doInject(mainActivity: LoginActivity)
    fun doInject(registerActivity: RegisterActivity)
}