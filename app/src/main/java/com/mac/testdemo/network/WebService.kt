package com.mac.testdemo.network

import com.google.gson.JsonElement
import com.mac.testdemo.model.LoginRequestModel
import com.mac.testdemo.model.Products
import com.mac.testdemo.model.RegisterCustRequestModel
import com.mac.testdemo.model.RegisterRequestModel
import com.mac.testdemo.utils.Url
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface WebService {

    @POST(Url.LOGIN)
    fun login(@Body loginRequestModel: LoginRequestModel):Observable<JsonElement>

    @POST(Url.REGISTER_R)
    fun register(@Body registerRequestModel: RegisterRequestModel): Observable<JsonElement>


    @POST(Url.REGISTER_C)
    fun registerCustomer(@Body registerRequestModel: RegisterCustRequestModel): Observable<JsonElement>


    @POST(Url.LIST_CITY)
    fun getCityList():Observable<JsonElement>

    @POST(Url.LIST_PRODUCT)
    fun getProductList(): Call<Products>


    @POST(Url.LIST_DIST)
    fun getDisList(@Body data: HashMap<String, String>): Call<Products>


    @POST(Url.LIST_SALES)
    fun getSaleList(@Body data: HashMap<String, String>): Call<Products>

}