package com.mac.testdemo.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.mac.testdemo.R;
import com.mac.testdemo.databinding.ActivityDistributionListBinding;
import com.mac.testdemo.model.Datum;
import com.mac.testdemo.model.Products;
import com.mac.testdemo.network.ApiClient;
import com.mac.testdemo.network.WebService;

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



        /*WebService apiService =
                ApiClient.getClient().create(WebService.class);

        Call<Products> call = apiService.getDisList();
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
        });*/

    }
}
