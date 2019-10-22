package com.mac.testdemo.view

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.mac.testdemo.R
import com.mac.testdemo.base.BaseActivity
import com.mac.testdemo.base.MyApplicationClass
import com.mac.testdemo.databinding.ActivityRegisterBinding
import com.mac.testdemo.model.Category
import com.mac.testdemo.model.CityModel
import com.mac.testdemo.viewmodel.RegisterViewModel
import com.mac.testdemo.viewmodel.ViewModelFactory
import mvvm.f4wzy.com.samplelogin.util.CustomeProgressDialog
import javax.inject.Inject

class RegisterActivity : BaseActivity<ActivityRegisterBinding>() {

    @Inject
    lateinit var viewModelFactory :ViewModelFactory

    var prgressDialog : CustomeProgressDialog? = null


    override val layoutName: Int
        get() = R.layout.activity_register

    lateinit var viewModel:RegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (applicationContext as MyApplicationClass).getAppComponents().doInject(this)
        viewModel = ViewModelProviders.of(this,viewModelFactory).get(RegisterViewModel::class.java)
        dataBinding.viewModel = viewModel

        prgressDialog = CustomeProgressDialog(this)

        observerData()
    }

    private fun observerData() {
        viewModel.businessCategoryList.observe(this, Observer {
            lst -> dataBinding.spinnerBusinessCat.adapter = ArrayAdapter<Category>(this,R.layout.custom_spinner,lst)
        })


        viewModel.progressDialog?.observe(this, Observer {
            isShowing -> if(isShowing) prgressDialog?.show() else prgressDialog?.dismiss()
        })


        viewModel.cityModelList.observe(this, Observer{
            listCity-> val adapter : ArrayAdapter<CityModel> = ArrayAdapter(this,R.layout.custom_spinner,listCity)

            dataBinding.autoCompleteCity.setAdapter(adapter)
        })



        viewModel.respo.observe(this, Observer {

                s ->
            if (s.equals("success", true)) {
                Toast.makeText(this, "You have been successfully register", Toast.LENGTH_LONG)
                    .show()
                startActivity(Intent(this, LoginActivity::class.java))
            }
        })

    }


}
