package com.mac.testdemo.network

import com.google.gson.JsonElement
import com.mac.testdemo.model.LoginRequestModel
import com.mac.testdemo.model.RegisterCustRequestModel
import com.mac.testdemo.model.RegisterRequestModel
import io.reactivex.Observable


class Repository(private val apiCallInterface: WebService) {

    /*
     * method to call login
     * */
    fun executeLogin(loginModel: LoginRequestModel): Observable<JsonElement> {
        return apiCallInterface.login(loginModel)
    }

    fun executeRegisterR(registerRequestModel: RegisterRequestModel): Observable<JsonElement> {
        return apiCallInterface.register(registerRequestModel)
    }

    fun executeRegisterC(registerRequestModel: RegisterCustRequestModel): Observable<JsonElement> {
        return apiCallInterface.registerCustomer(registerRequestModel)
    }

    fun executeCity(): Observable<JsonElement> {
        return apiCallInterface.getCityList()
    }


}