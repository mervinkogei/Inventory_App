package com.custom.inventoryapp.Interface;

import com.custom.inventoryapp.Products;

import java.util.List;

import retrofit2.http.GET;

public interface ApiService {

    @GET("/iprocure-server/products.js")
    List<Products> getAllProducts();

}
