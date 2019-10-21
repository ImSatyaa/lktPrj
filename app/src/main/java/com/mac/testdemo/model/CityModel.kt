package com.mac.testdemo.model

data class CityModel(
    val id: Int,
    val name: String



) {
    override fun toString(): String {
        return name
    }
}