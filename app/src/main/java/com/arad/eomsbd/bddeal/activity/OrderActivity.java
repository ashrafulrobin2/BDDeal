package com.arad.eomsbd.bddeal.activity;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.arad.eomsbd.bddeal.R;
import com.arad.eomsbd.bddeal.model.Order;
import com.arad.eomsbd.bddeal.model.ProductResponse;
import com.arad.eomsbd.bddeal.rest.ApiClient;
import com.arad.eomsbd.bddeal.rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        TextView orderProductNameTv = (TextView) findViewById(R.id.order_product_name);
        final EditText orderNameEt = (EditText) findViewById(R.id.order_name);
        final EditText orderEmailEt = (EditText) findViewById(R.id.order_email);
        final EditText orderMobileEt = (EditText) findViewById(R.id.order_mobile);
        final EditText orderAddressEt = (EditText) findViewById(R.id.order_address);
        final EditText orderQuantityEt = (EditText) findViewById(R.id.order_quantity);
        final EditText orderCommentEt = (EditText) findViewById(R.id.order_comment);
        Button btnOrder = (Button) findViewById(R.id.order_product_order);

        final int productId = getIntent().getIntExtra("product_id", 0);
        String productName = getIntent().getStringExtra("product_name");

        orderProductNameTv.setText(productName);

        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                String orderName = orderNameEt.getText().toString().trim();
                String orderEmail = orderEmailEt.getText().toString().trim();
                String orderMobile = orderMobileEt.getText().toString().trim();
                String orderAdress = orderAddressEt.getText().toString().trim();
                int orderQuantity = Integer.parseInt(orderQuantityEt.getText().toString().trim());
                String orderComment = orderCommentEt.getText().toString().trim();
                if(!TextUtils.isEmpty(orderName) && !TextUtils.isEmpty(orderEmail) && !TextUtils.isEmpty(orderMobile) && !TextUtils.isEmpty(orderAdress) && !TextUtils.isEmpty(orderComment)){
                    ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
                    apiService.orderPost(orderName, orderEmail, orderMobile, orderAdress, orderQuantity, orderComment, productId)
                            .enqueue(new Callback<Order>() {
                                @Override
                                public void onResponse(Call<Order> call, Response<Order> response) {
                                    String showResponse = response.body().toString();
                                    Snackbar.make(v, showResponse, Snackbar.LENGTH_LONG).show();
                                }
                                @Override
                                public void onFailure(Call<Order> call, Throwable t) {
                                    Snackbar.make(v, "Order Post Failed", Snackbar.LENGTH_LONG).show();
                                }
                            });
                }
            }
        });
    }
}