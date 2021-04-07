package com.custom.inventoryapp.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Inventory.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract InventoryDao inventoryDao();

    private  static AppDatabase INSTANCE;

    public static AppDatabase getINSTANCE(Context context) {
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class,"INVENTORY_DB")
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }
}
