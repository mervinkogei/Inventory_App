package com.custom.inventoryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.custom.inventoryapp.database.AppDatabase;
import com.custom.inventoryapp.database.Inventory;

public class Inventory_Screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory__screen);

        final EditText prod_name = findViewById(R.id.prod_name);
        final EditText prod_type = findViewById(R.id.prod_type);
        final EditText prod_price = findViewById(R.id.prod_price);
        Button save_inventory = findViewById(R.id.btn_save);

        save_inventory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveInventory(prod_name.getText().toString(),prod_type.getText().toString(),prod_price.getText().toString());

            }
        });

    }

    private void saveInventory(String product_name, String product_type, String price){
        AppDatabase db = AppDatabase.getDbINSTANCE(this.getApplicationContext());

        Inventory inventory = new Inventory();
        inventory.product_name = product_name;
        inventory.product_type = product_type;
        inventory.price = price;

        db.inventoryDao().insertInventory(inventory);

        finish();
    }
}