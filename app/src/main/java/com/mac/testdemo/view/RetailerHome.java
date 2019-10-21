package com.mac.testdemo.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.mac.testdemo.R;
import com.mac.testdemo.databinding.ActivityRetailerHomeBinding;
import com.mac.testdemo.generated.callback.OnClickListener;

public class RetailerHome extends AppCompatActivity {

    ActivityRetailerHomeBinding homeBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        homeBinding = DataBindingUtil.setContentView(this,(R.layout.activity_retailer_home));


        homeBinding.tvSalesReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RetailerHome.this,SalesReport.class));

            }
        });

        homeBinding.tvViewAddSales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RetailerHome.this,AddSales.class));

            }
        });

        homeBinding.tvViewDis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RetailerHome.this,DistributionList.class));

            }
        });

        homeBinding.tvViewProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RetailerHome.this,ProductList.class));
            }
        });

        homeBinding.tvViewProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RetailerHome.this,ProductList.class));

            }
        });

    }
}
