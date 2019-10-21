package com.mac.testdemo.injection

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal class AppContext(private var context: Context) {

    @Provides
    @Singleton
    fun getContext() : Context{
        return context
    }
}