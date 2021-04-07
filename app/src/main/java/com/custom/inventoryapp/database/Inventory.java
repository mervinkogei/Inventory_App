package com.custom.inventoryapp.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Inventory {

    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "product_name")
    public String product_name;

    @ColumnInfo(name = "product_type")
    public String product_type;

    @ColumnInfo(name = "price")
    public String price;
}
