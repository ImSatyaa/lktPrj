package com.mac.testdemo.utils

import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingListener
import com.mac.testdemo.model.Category
import androidx.appcompat.widget.AppCompatSpinner
import androidx.databinding.InverseBindingAdapter


@InverseBindingAdapter(attribute = "selectedItemPosition")
fun getSelectedItemPosition(spinner: AppCompatSpinner): Int? {
    return spinner.selectedItemPosition
}



