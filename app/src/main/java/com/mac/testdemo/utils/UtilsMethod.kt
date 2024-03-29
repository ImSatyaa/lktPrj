package com.mac.testdemo.utils

import java.util.regex.Pattern

class UtilsMethod {
    companion object{
        fun isEmailValid(email: String): Boolean {
            val expression = "^[\\w.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"
            val pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
            val matcher = pattern.matcher(email)
            return matcher.matches()
        }    }
}