package com.custom.inventoryapp.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface InventoryDao {

    @Query("SELECT * FROM Inventory")
    List<Inventory> getAllProducts();

    @Insert
    void  insertInventory(Inventory... inventory);

    @Delete
    void delete(Inventory inventory);
}
