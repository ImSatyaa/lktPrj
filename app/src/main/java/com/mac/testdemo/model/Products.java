
package com.mac.testdemo.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Products {

    @SerializedName("status")
    @Expose
    public Integer status;
    @SerializedName("msg")
    @Expose
    public String msg;
    @SerializedName("data")
    @Expose
    public List<Datum> data = null;


    public Integer getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public List<Datum> getData() {
        return data;
    }
}
