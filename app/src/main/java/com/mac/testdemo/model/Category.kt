package com.mac.testdemo.model

data class Category(
    val bus_cat_id: Int,
    val name: String
){
    override fun toString(): String {
        return name
    }
}