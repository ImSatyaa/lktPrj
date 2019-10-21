package com.mac.testdemo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mac.testdemo.network.Repository
import java.lang.IllegalArgumentException
import javax.inject.Inject

class ViewModelFactory
   @Inject constructor (var repository: Repository) : ViewModelProvider.Factory {


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java))
            return LoginViewModel(repository) as T
        if (modelClass.isAssignableFrom(RegisterViewModel::class.java))
            return RegisterViewModel(repository) as T
        throw IllegalArgumentException("not reachable")
    }
}