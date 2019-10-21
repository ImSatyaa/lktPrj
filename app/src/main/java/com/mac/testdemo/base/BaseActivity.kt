package com.mac.testdemo.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<BindData : ViewDataBinding> : AppCompatActivity() {

    lateinit var dataBinding: BindData

    @get:LayoutRes
    abstract val layoutName: Int


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, layoutName)

    }
}