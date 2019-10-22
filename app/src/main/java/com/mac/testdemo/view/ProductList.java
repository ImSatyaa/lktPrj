package com.mac.testdemo.view;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.mac.testdemo.R;
import com.mac.testdemo.databinding.ActivityProductListBinding;
import com.mac.testdemo.model.Datum;
import com.mac.testdemo.model.Products;
import com.mac.testdemo.network.ApiClient;
import com.mac.testdemo.network.WebService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductList extends AppCompatActivity {

    ActivityProductListBinding productListBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        productListBinding = DataBindingUtil.setContentView(this,R.layout.activity_product_list);



        WebService apiService =
                ApiClient.getClient().create(WebService.class);

        Call<Products> call = apiService.getProductList();
        call.enqueue(new Callback<Products>() {
            @Override
            public void onResponse(Call<Products>call, Response<Products> response) {
                if (response.isSuccessful()) {

                    List<Datum> pro = response.body().getData();
                    ProductListAdpt listAdpt = new ProductListAdpt(pro);
                    productListBinding.tvRecyclerView.setLayoutManager(new LinearLayoutManager(ProductList.this));
                    productListBinding.tvRecyclerView.setAdapter(listAdpt);
                }
            }

            @Override
            public void onFailure(Call<Products>call, Throwable t) {
                // Log error here since request failed
                Log.d("======", "onFailure: " + t.getMessage());
            }
        });
    }
}
