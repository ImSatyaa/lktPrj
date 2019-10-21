package com.mac.testdemo.network

import io.reactivex.Observable
import com.google.gson.JsonElement
import com.mac.testdemo.model.LoginRequestModel
import com.mac.testdemo.model.Products
import com.mac.testdemo.model.RegisterRequestModel
import com.mac.testdemo.utils.Url
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface WebService {

    @POST(Url.LOGIN)
    fun login(@Body loginRequestModel: LoginRequestModel):Observable<JsonElement>

    @POST(Url.REGISTER_C)
    fun register(@Body registerRequestModel: RegisterRequestModel): Observable<JsonElement>


    @POST(Url.REGISTER_C)
    fun registerCustomer(registerRequestModel: RegisterRequestModel): Observable<JsonElement>


    @POST(Url.LIST_CITY)
    fun getCityList():Observable<JsonElement>

    @POST(Url.LIST_PRODUCT)
    fun getProductList(): Call<Products>


    @POST(Url.LIST_DIST)
    fun getDisList(  data : HashMap<String,String>): Call<Products>


    @POST(Url.LIST_SALES)
    fun getSaleList(  data : HashMap<String,String>): Call<Products>

}