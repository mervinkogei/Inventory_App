package com.custom.inventoryapp;

import java.io.Serializable;

public class ProductResponse implements Serializable {

    private String product_name;
    private String product_type;
    private String price;

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public ProductResponse(String product_name, String product_type, String price) {
        this.product_name = product_name;
        this.product_type = product_type;
        this.price = price;


    }
}
