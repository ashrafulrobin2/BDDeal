package com.arad.eomsbd.bddeal.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by eomsbd on 7/25/2017.
 */
public class Category {
    @SerializedName("category_code")
    public int category_code;
    @SerializedName("category_name")
    public String category_name;
    @SerializedName("category_en_name")
    public String category_en_name;

    public Category(int category_code, String category_name, String category_en_name) {
        this.category_code = category_code;
        this.category_name = category_name;
        this.category_en_name = category_en_name;
    }

    public int getCategory_code() {
        return category_code;
    }
    public void setCategory_code(int category_code) {
        this.category_code = category_code;
    }
    public String getCategory_name() {
        return category_name;
    }
    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }
    public String getCategory_en_name() {
        return category_en_name;
    }
    public void setCategory_en_name(String category_en_name) {
        this.category_en_name = category_en_name;
    }
}
