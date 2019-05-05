package com.arad.eomsbd.bddeal.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by eomsbd on 6/19/2017.
 */
public class Product {
    @SerializedName("product_code")
    public int product_code;
    @SerializedName("product_name")
    public String product_name;
    @SerializedName("product_en_name")
    public String product_en_name;
    @SerializedName("product_selling_price")
    public String product_selling_price;
    @SerializedName("product_image")
    public String product_image;
    @SerializedName("product_description")
    public String product_description;

    public Product(int product_code, String product_name, String product_en_name, String product_selling_price, String product_image, String product_description) {
        this.product_code = product_code;
        this.product_name = product_name;
        this.product_en_name = product_en_name;
        this.product_selling_price = product_selling_price;
        this.product_image = product_image;
        this.product_description = product_description;
    }

    public int getProduct_code() {
        return product_code;
    }
    public void setProduct_code(int product_code) {
        this.product_code = product_code;
    }
    public String getProduct_name() {
        return product_name;
    }
    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }
    public String getProduct_en_name() {
        return product_en_name;
    }
    public void setProduct_en_name(String product_en_name) {
        this.product_en_name = product_en_name;
    }
    public String getProduct_selling_price() {
        return product_selling_price;
    }
    public void setProduct_selling_price(String product_selling_price) {
        this.product_selling_price = product_selling_price;
    }
    public String getProduct_image() {
        return product_image;
    }
    public void setProduct_image(String product_image) {
        this.product_image = product_image;
    }
    public String getProduct_description(){ return product_description; }
    public void setProduct_description(String product_description){ this.product_description = product_description; }
}