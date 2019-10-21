package com.mac.testdemo.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.mac.testdemo.R
import com.mac.testdemo.base.BaseActivity
import com.mac.testdemo.base.MyApplicationClass
import com.mac.testdemo.databinding.ActivityLoginBinding
import com.mac.testdemo.viewmodel.LoginViewModel
import com.mac.testdemo.viewmodel.ViewModelFactory
import mvvm.f4wzy.com.samplelogin.util.CustomeProgressDialog
import javax.inject.Inject

class LoginActivity : BaseActivity<ActivityLoginBinding>() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    var customeProgressDialog: CustomeProgressDialog? = null


    override val layoutName: Int
        get() = R.layout.activity_login


    lateinit var activityViewModel: LoginViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (applicationContext as MyApplicationClass).getAppComponents().doInject(this)
        activityViewModel =
            ViewModelProviders.of(this, viewModelFactory).get(LoginViewModel::class.java)
        dataBinding.viewModel = activityViewModel

        customeProgressDialog = CustomeProgressDialog(this)

        observer()

    }

    /*{"return_data":{"status":200,"msg":"Ok","Userdata":{"uid":532117,"role_id":1}}}*/
    private fun observer() {
        activityViewModel.onRegisterClick.observe(this, Observer { isClick ->
            if (isClick) startActivity(Intent(this, RegisterActivity::class.java))
        })

        activityViewModel.progressDialog?.observe(this, Observer { isLoading ->
            if (isLoading) customeProgressDialog?.show() else customeProgressDialog?.dismiss()
        })

        activityViewModel.role.observe(this, Observer { role ->
            if (role == 1) {
                Toast.makeText(this, "User name or password do not match ", Toast.LENGTH_LONG)
                    .show()
            }else {
                startActivity(Intent(this,RetailerDashboard::class.java))
            }


        })


    }
}
