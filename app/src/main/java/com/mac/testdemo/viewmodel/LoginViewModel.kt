package com.mac.testdemo.viewmodel

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.mac.testdemo.model.LoginRequestModel
import com.mac.testdemo.network.Repository
import com.mac.testdemo.utils.SingleLiveData
import com.mac.testdemo.utils.UtilsMethod
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class LoginViewModel(private val repository: Repository) : ViewModel() {


    var btnSelected: ObservableBoolean? = null
    var email: ObservableField<String>? = null
    var password: ObservableField<String>? = null
    var progressDialog: MutableLiveData<Boolean>? = null
    var userLogin: LoginRequestModel

    var compositeDisposable = CompositeDisposable()
    var onRegisterClick = SingleLiveData<Boolean>()
    var role = MutableLiveData<Int>()
    var id = MutableLiveData<Int>()

    init {
        btnSelected = ObservableBoolean(false)
        progressDialog = MutableLiveData(false)
        email = ObservableField("")
        password = ObservableField("")
        userLogin = LoginRequestModel("","")
        onRegisterClick.value = false
        role = MutableLiveData(0)
    }

    fun onEmailChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        btnSelected?.set(UtilsMethod.isEmailValid(s.toString()) && password?.get()!!.length >= 5)
        userLogin.username = s.toString()


    }

    fun onRegsterClick(){
        onRegisterClick.value = true
    }

    fun onPasswordChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        btnSelected?.set(UtilsMethod.isEmailValid(email?.get()!!) && s.toString().length >= 5)
        userLogin.password = s.toString()
    }

    fun login() {


        compositeDisposable.add(repository.executeLogin(userLogin)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { progressDialog?.value = true }
            .subscribe(
                { result -> onResponse(result) },
                { throwable -> onFailure(throwable) }
            ))


    }

    private fun onResponse(call: JsonElement) {
        progressDialog?.value = false

        //{"return_data":{"status":200,"msg":"Ok","Userdata":{"uid":235320,"role_id":2}}}

        val json = call as JsonObject
        if (json.has("return_data") && json.get("return_data").asJsonObject.get("status").asInt == 200) {
            role.value = json.get("return_data").asJsonObject.get("Userdata").asJsonObject.get("role_id").asInt
            id.value =
                json.get("return_data").asJsonObject.get("Userdata").asJsonObject.get("uid").asInt
        }


    }

    private fun onFailure(t: Throwable?) {
        progressDialog?.value = false

    }


}