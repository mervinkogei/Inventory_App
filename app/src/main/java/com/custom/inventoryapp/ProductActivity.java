package com.custom.inventoryapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toolbar;

import com.custom.inventoryapp.Adapter.ProductListAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductActivity extends AppCompatActivity {

//    Toolbar toolbar;
    RecyclerView recyclerView;

    ProductListAdapter productListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

       Toolbar toolbar = findViewById(R.id.toolbar);
        recyclerView = findViewById(R.id.recyclerview);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        getProducts();
    }

    public void getProducts(){

        Call<List<ProductResponse>> allProducts = (Call<List<ProductResponse>>) ApiClient.getAllProducts();

        allProducts.enqueue(new Callback<List<ProductResponse>>() {
            @Override
            public void onResponse(Call<List<ProductResponse>> call, Response<List<ProductResponse>> response) {

                if(response.isSuccessful()){
                    List<ProductResponse> productResponses = response.body();
                    productListAdapter.notifyDataSetChanged();
                    recyclerView.setAdapter(productListAdapter);

                }

            }

            @Override
            public void onFailure(Call<List<ProductResponse>> call, Throwable t) {

            }

        });
    }
}