package com.arad.eomsbd.bddeal.rest;

import com.arad.eomsbd.bddeal.category_model.Category;
import com.arad.eomsbd.bddeal.model.Order;
import com.arad.eomsbd.bddeal.model.ProductResponse;
import retrofit2.Call;
import retrofit2.http.*;

/**
 * Created by eomsbd on 7/17/2017.
 */
public interface ApiInterface {
 @GET("product/read.php")
    Call<ProductResponse> getProducts();

    @GET("product/read_one.php?id={id}")
    Call<ProductResponse> getProduct(@Path("id") int product_code);

    @GET("product/read_main_category.php?id={id}")
    Call<ProductResponse> getMainCategoryProducts(@Path("id") int category_id);

    @POST("order/order_product.php")
    @FormUrlEncoded
    Call<Order> orderPost(@Field("order_name") String order_name,
                          @Field("order_email") String order_email,
                          @Field("order_mobile") String order_mobile,
                          @Field("order_address") String order_address,
                          @Field("order_quantity") int order_quantity,
                          @Field("order_comment") String order_comment,
                          @Field("product_id") int product_id);

    @GET("menu/mainMenu")
    Call<Category> getMainCategory();

  @GET("product/search.php?id={id}")
    Call<ProductResponse> getSearchResult(@Path("id") String query);
}
