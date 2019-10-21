package com.mac.testdemo.base

import android.app.Application
import com.mac.testdemo.injection.AppComponents
import com.mac.testdemo.injection.AppContext
import com.mac.testdemo.injection.DaggerAppComponents
import com.mac.testdemo.injection.UtilModule

class MyApplicationClass :Application() {


    private var appComponents:AppComponents? = null

    override fun onCreate() {
        super.onCreate()

        appComponents = DaggerAppComponents.builder()
            .appContext(AppContext(this))
            .utilModule(UtilModule()).build()



    }

    fun getAppComponents():AppComponents{
        return appComponents!!
    }




}