package com.arad.eomsbd.bddeal.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.arad.eomsbd.bddeal.R;
import com.arad.eomsbd.bddeal.model.Product;
import com.arad.eomsbd.bddeal.model.ProductResponse;
import com.arad.eomsbd.bddeal.rest.ApiClient;
import com.arad.eomsbd.bddeal.rest.ApiInterface;
import com.squareup.picasso.Picasso;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class SingleProductActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private int productId;
    private TextView  productCode, productName, productDescription, productPrice;
    private ImageView productImage;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_product);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        productCode = (TextView) findViewById(R.id.single_product_code);
        productName = (TextView) findViewById(R.id.single_product_name);
        productDescription = (TextView) findViewById(R.id.single_product_description);
        productPrice = (TextView) findViewById(R.id.single_product_price);
        productImage = (ImageView) findViewById(R.id.single_product_image);
        Button btnOrder = (Button) findViewById(R.id.single_product_order);
        Button btnOrderCall = (Button) findViewById(R.id.single_product_order_call);

        productId = getIntent().getIntExtra("product_id", 0);

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<ProductResponse> call = apiService.getProduct(productId);
        call.enqueue(new Callback<ProductResponse>() {
            @Override
            public void onResponse(Call<ProductResponse> call, Response<ProductResponse> response) {
                List<Product> products = response.body().getResults();
                Log.d(TAG, "Number of product received: " + products.size());
                productCode.setText(products.get(0).getProduct_code());
                productName.setText(products.get(0).getProduct_name());
                productPrice.setText(products.get(0).getProduct_selling_price());
                Picasso.with(context).load(products.get(0).getProduct_image()).into(productImage);
                productDescription.setText(products.get(0).getProduct_description());
            }
            @Override
            public void onFailure(Call<ProductResponse> call, Throwable throwable) {
                Log.e(TAG, throwable.toString());
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Send Email to : bddealonline@gmail.com", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), OrderActivity.class);
                intent.putExtra("product_id", productId);
                intent.putExtra("product_name", productName.getText());
                v.getContext().startActivity(intent);
            }
        });
        btnOrderCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phnNum = "+8801975102026";
                Intent intentCall = new Intent(Intent.ACTION_CALL);
                intentCall.setData(Uri.parse(phnNum));
                startActivity(intentCall);
            }
        });
    }
}
