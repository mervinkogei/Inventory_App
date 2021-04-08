package com.custom.inventoryapp;

public class Products {
    private String product_name;
    private String product_type;
    private String price;

    public Products(String product_name, String product_type, String price) {
        this.product_name = product_name;
        this.product_type = product_type;
        this.price = price;
    }

    public String getProduct_name() {
        return product_name;
    }

    public String getProduct_type() {
        return product_type;
    }

    public String getPrice() {
        return price;
    }
}
