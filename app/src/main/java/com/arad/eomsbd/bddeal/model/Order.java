package com.arad.eomsbd.bddeal.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by eomsbd on 7/21/2017.
 */
public class Order {
    @SerializedName("order_name")
    @Expose
    private String order_name;
    @SerializedName("order_email")
    @Expose
    private String order_email;
    @SerializedName("order_mobile")
    @Expose
    private String order_mobile;
    @SerializedName("order_address")
    @Expose
    private String order_address;
    @SerializedName("order_quantity")
    @Expose
    private int order_quantity;
    @SerializedName("order_comment")
    @Expose
    private String order_comment;
    @SerializedName("product_id")
    @Expose
    private int product_id;

    public String getOrder_name(){
        return order_name;
    }
    public void setOrder_name(String order_name){
        this.order_name = order_name;
    }
    public String getOrder_email() {
        return order_email;
    }
    public void setOrder_email(String order_email) {
        this.order_email = order_email;
    }
    public String getOrder_mobile() {
        return order_mobile;
    }
    public void setOrder_mobile(String order_mobile) {
        this.order_mobile = order_mobile;
    }
    public String getOrder_address() {
        return order_address;
    }
    public void setOrder_address(String order_address) {
        this.order_address = order_address;
    }
    public int getOrder_quantity() {
        return order_quantity;
    }
    public void setOrder_quantity(int order_quantity) {
        this.order_quantity = order_quantity;
    }
    public String getOrder_comment() {
        return order_comment;
    }
    public void setOrder_comment(String order_comment) {
        this.order_comment = order_comment;
    }
    public int getProduct_id() {
        return product_id;
    }
    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_name='" + order_name + '\'' +
                ", order_email='" + order_email + '\'' +
                ", order_mobile='" + order_mobile + '\'' +
                ", order_address='" + order_address + '\'' +
                ", order_quantity=" + order_quantity +
                ", order_comment='" + order_comment + '\'' +
                ", product_id=" + product_id +
                '}';
    }
}
