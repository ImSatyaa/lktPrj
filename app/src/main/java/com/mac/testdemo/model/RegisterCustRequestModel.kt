package com.mac.testdemo.model


data class RegisterCustRequestModel(
    var name: String = "",
    var email: String = "",
    var password: String = "",
    var contact_p: String = "",
    var phone: String = "",
    var address: String = "",
    var c_id: String = "",
    var pin: String = "",
    var gst: String = "",
    var pan: String = "",
    var tin: String = "",
    var business_cat: String = "",
    var company: String = "",
    var company_group: String = "",
    var add_customer: String? = null
)
