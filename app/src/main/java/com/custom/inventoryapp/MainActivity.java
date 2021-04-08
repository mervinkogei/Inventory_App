package com.custom.inventoryapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

import com.custom.inventoryapp.Adapter.InventoryListAdapter;
import com.custom.inventoryapp.database.AppDatabase;
import com.custom.inventoryapp.database.Inventory;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private InventoryListAdapter inventoryListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_inventory = findViewById(R.id.btn_inventory);
        Button btn_products = findViewById(R.id.btn_product);

        btn_products.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this,ProductActivity.class);
//                startActivity(intent);
            }
        });

        btn_inventory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MainActivity.this, Inventory_Screen.class), 100);
            }
        });

        initRecyclerView();

        loadProductList();
    }

    private void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);

        inventoryListAdapter = new InventoryListAdapter(this);
        recyclerView.setAdapter(inventoryListAdapter);

    }

    private void loadProductList(){
        AppDatabase db = AppDatabase.getDbINSTANCE(this.getApplicationContext());
        List<Inventory> inventoryList = db.inventoryDao().getAllProducts();
        inventoryListAdapter.setInventoryList(inventoryList);
    }

    @Override
    protected void onActivityResult(
            int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode ==100){
            loadProductList();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}