package com.mac.testdemo.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.mac.testdemo.R;
import com.mac.testdemo.databinding.ActivityDistributionListBinding;
import com.mac.testdemo.model.Datum;
import com.mac.testdemo.model.Products;
import com.mac.testdemo.network.ApiClient;
import com.mac.testdemo.network.WebService;
import com.mac.testdemo.storage.UserSessionManager;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DistributionList extends AppCompatActivity {
    ActivityDistributionListBinding listBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listBinding = DataBindingUtil.setContentView(this,R.layout.activity_distribution_list);


        WebService apiService =
                ApiClient.getClient().create(WebService.class);

        HashMap<String, String> stringMap = new HashMap<String, String>();
        stringMap.put("retailer_id", UserSessionManager.getsharedprefInstance(this).getTokenID());


        Call<Products> call = apiService.getDisList(stringMap);
        call.enqueue(new Callback<Products>() {
            @Override
            public void onResponse(Call<Products>call, Response<Products> response) {
                if (response.isSuccessful()) {

                    List<Datum> pro = response.body().getData();
                    ProductListAdpt listAdpt = new ProductListAdpt(pro);
                    listBinding.recyclerview.setLayoutManager(new LinearLayoutManager(DistributionList.this));
                    listBinding.recyclerview.setAdapter(listAdpt);
                }
            }

            @Override
            public void onFailure(Call<Products>call, Throwable t) {
                // Log error here since request failed
            }
        });

    }
}
