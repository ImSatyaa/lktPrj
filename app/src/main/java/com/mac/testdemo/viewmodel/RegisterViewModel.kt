package com.mac.testdemo.viewmodel

import android.util.Log
import androidx.annotation.Nullable
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.mac.testdemo.model.Category
import com.mac.testdemo.model.RegisterRequestModel
import com.mac.testdemo.network.Repository
import com.mac.testdemo.utils.UtilsMethod
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import android.widget.RadioGroup
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import com.mac.testdemo.R
import com.mac.testdemo.model.CityModel
import kotlinx.android.synthetic.main.activity_register.view.*
import org.w3c.dom.Node


class RegisterViewModel(private val repository: Repository) : ViewModel() {

    var regClick: ObservableBoolean? = null
    var name: ObservableField<String>? = null
    var password: ObservableField<String>? = null
    var email: ObservableField<String>? = null
    var contactPerson: ObservableField<String>? = null
    var city: ObservableField<String>? = null
    var address: ObservableField<String>? = null
    var mobile: ObservableField<String>? = null
    var pin: ObservableField<String>? = null
    var gst: ObservableField<String>? = null
    var pan: ObservableField<String>? = null
    var tin: ObservableField<String>? = null
    var business: ObservableField<String>? = null
    var company: ObservableField<String>? = null
    var companyGroup: ObservableField<String>? = null
    var radio_checked = MutableLiveData<Int>()


    var progressDialog: MutableLiveData<Boolean>? = null

    var registerRequestModel: RegisterRequestModel = RegisterRequestModel()

    var compositeDisposable = CompositeDisposable()

    var businessCategoryList: MutableLiveData<List<Category>> = MutableLiveData()
    var cityModelList: MutableLiveData<List<CityModel>> = MutableLiveData()

    var position: Int = 0


    init {
        regClick = ObservableBoolean(false)
        email = ObservableField("")
        password = ObservableField("")
        name = ObservableField("")
        contactPerson = ObservableField("")
        city = ObservableField("")
        address = ObservableField("")
        mobile = ObservableField("")
        pin = ObservableField("")
        gst = ObservableField("")
        pan = ObservableField("")
        tin = ObservableField("")
        business = ObservableField("")
        company = ObservableField("")
        companyGroup = ObservableField("")
        progressDialog = MutableLiveData(false)
        radio_checked = MutableLiveData(R.id.rb_retailer)
        onRegisterClick(false)
        getListCity()

    }

    fun onEmailChangeListener(s: CharSequence, i: Int, j: Int, k: Int) {
        registerRequestModel.email = (s.toString())
        regClick?.set(isAllInputValid())
    }


    fun onNameChangeListener(s: CharSequence, i: Int, j: Int, k: Int) {
        registerRequestModel.name = s.toString()
        regClick?.set(isAllInputValid())
    }


    fun onContactPersonChangeListener(s: CharSequence, i: Int, j: Int, k: Int) {
        registerRequestModel.contact_p = s.toString()
        regClick?.set(isAllInputValid())
    }


    fun onPassChangeListener(s: CharSequence, i: Int, j: Int, k: Int) {
        registerRequestModel.password = s.toString()
        regClick?.set(isAllInputValid())
    }


    fun onAddressChangeListener(s: CharSequence, i: Int, j: Int, k: Int) {
        registerRequestModel.address = s.toString()
        regClick?.set(isAllInputValid())
    }


    fun onMobileChangeListener(s: CharSequence, i: Int, j: Int, k: Int) {
        registerRequestModel.phone = s.toString()
        regClick?.set(isAllInputValid())
    }


    fun onCityChangeListener(s: CharSequence, i: Int, j: Int, k: Int) {
        registerRequestModel.c_id = "1"
        regClick?.set(isAllInputValid())
    }


    fun onPinChangeListener(s: CharSequence, i: Int, j: Int, k: Int) {
        registerRequestModel.pin = s.toString()
        regClick?.set(isAllInputValid())
    }


    fun onGstChangeListener(s: CharSequence, i: Int, j: Int, k: Int) {
        registerRequestModel.gst = s.toString()
        regClick?.set(isAllInputValid())
    }


    fun onPanChangeListener(s: CharSequence, i: Int, j: Int, k: Int) {
        registerRequestModel.pan = s.toString()
        regClick?.set(isAllInputValid())
    }


    fun onTinChangeListener(s: CharSequence, i: Int, j: Int, k: Int) {
        registerRequestModel.tin = s.toString()
        regClick?.set(isAllInputValid())
    }


    fun onBusinessChangeListener(s: CharSequence, i: Int, j: Int, k: Int) {
        registerRequestModel.business_cat = s.toString()
        regClick?.set(isAllInputValid())
    }


    fun onCompanyChangeListener(s: CharSequence, i: Int, j: Int, k: Int) {
        registerRequestModel.company = s.toString()
        regClick?.set(isAllInputValid())
    }


    fun onCompanyGrpChangeListener(s: CharSequence, i: Int, j: Int, k: Int) {
        registerRequestModel.company_group = s.toString()
        regClick?.set(isAllInputValid())
    }


    private fun isAllInputValid(): Boolean {
        return UtilsMethod.isEmailValid(email?.get().toString()) &&
                name?.get().toString().length > 3 &&
                password?.get().toString().length > 5 &&
                contactPerson?.get().toString().length > 5 &&
                address?.get().toString().length > 1 &&
                mobile?.get().toString().length > 1 &&
                pin?.get().toString().length > 1 &&
                gst?.get().toString().length > 1 &&
                pan?.get().toString().length > 1 &&
                tin?.get().toString().length > 1 &&
                //business?.get().toString().length > 1 &&
                city?.get().toString().length > 1 &&
                company?.get().toString().length > 1 &&
                companyGroup?.get().toString().length > 1

    }

    fun onRegisterClick(@Nullable isSubmit: Boolean = true) {
        Log.v("========>", businessCategoryList.value.toString() + "")
        registerRequestModel.business_cat =
            businessCategoryList.value?.get(position)?.bus_cat_id.toString()
        if (isSubmit) {
            registerRequestModel.add_retailer = "1"
        } else {
            registerRequestModel.add_retailer = null
        }

        if (radio_checked.value == R.id.rb_customer) {
            if (isAllInputValid())             registerRequestModel.add_retailer = "1"

            compositeDisposable.addAll(repository.executeRegisterC(registerRequestModel)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { s -> progressDialog?.value = true }
                .subscribe(
                    { result -> onResponse(result, false) },
                    { err -> onErr(err) }
                ))
        } else {
            if (isAllInputValid())             registerRequestModel.add_retailer = "1"
            compositeDisposable.addAll(repository.executeRegisterR(registerRequestModel)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { s -> progressDialog?.value = true }
                .subscribe(
                    { result -> onResponse(result, false) },
                    { err -> onErr(err) }
                ))
        }


    }

    private fun getListCity() {
        compositeDisposable.addAll(repository.executeCity()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { s -> }
            .subscribe(
                { result -> onResponse(result, true) },
                { err -> onErr(err) }
            ))
    }

    private fun onResponse(result: JsonElement?, isCity: Boolean) {
        progressDialog?.value = false

        val jsonObject = result as JsonObject


        if (isCity) {
            var list: List<CityModel>? = null

            if (jsonObject.get("status").asInt == 200) {
                list = Gson().fromJson(
                    jsonObject.getAsJsonArray("data"),
                    Array<CityModel>::class.java
                ).toList()


                cityModelList.value = list;
            }




        }else {
            var listCat: List<Category>? = null

            if (jsonObject.get("status").asInt == 304) {
                listCat = Gson().fromJson(
                    jsonObject.getAsJsonArray("category"),
                    Array<Category>::class.java
                ).toList()
            } else {

            }
            //1= admin 2=retailer 3= customer

            businessCategoryList.value = listCat


        }
    }

    private fun onErr(err: Any) {
        progressDialog?.value = false
    }


}