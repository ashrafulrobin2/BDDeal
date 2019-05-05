package com.arad.eomsbd.bddeal.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.arad.eomsbd.bddeal.activity.OrderActivity;
import com.arad.eomsbd.bddeal.activity.SingleProductActivity;
import com.arad.eomsbd.bddeal.model.Product;
import com.arad.eomsbd.bddeal.R;
import com.squareup.picasso.Picasso;

import java.util.Collections;
import java.util.List;

/**
 * Created by eomsbd on 6/19/2017.
 */
public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder>{
    private Context context;
    private int rowLayout;
    private List<Product> productList;

    public static class ProductViewHolder extends RecyclerView.ViewHolder{
        public TextView productCode, productName, productPrice;
        public ImageView productImage, productMenu;

        public ProductViewHolder(View v){
            super(v);
            productCode = (TextView) itemView.findViewById(R.id.card_product_code);
            productName = (TextView) itemView.findViewById(R.id.card_product_name);
            productPrice = (TextView) itemView.findViewById(R.id.card_product_price);
            productImage = (ImageView) itemView.findViewById(R.id.card_product_image);
            productMenu = (ImageView) itemView.findViewById(R.id.card_product_menu);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), SingleProductActivity.class);
                    intent.putExtra("product_id", productCode.getText());
                    v.getContext().startActivity(intent);
                }
            });
        }
    }

    public ProductAdapter(List<Product> productList, int rowLayout, Context context){
        this.productList = productList;
        this.context = context;
        this.rowLayout = rowLayout;
    }

    @Override
    public ProductAdapter.ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new ProductViewHolder(view);
    }
    @Override
    public void onBindViewHolder(final ProductViewHolder holder, final int position){
        holder.productCode.setText(productList.get(position).getProduct_code());
        holder.productName.setText(productList.get(position).getProduct_en_name());
        holder.productPrice.setText(productList.get(position).getProduct_selling_price());
        //holder.productImage.setImageResource(Integer.parseInt(productList.get(position).getProduct_image()));
        Picasso.with(context).load(productList.get(position).getProduct_image()).into(holder.productImage);
        holder.productMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(holder.productMenu);
            }
        });
    }
    private void showPopupMenu(View view) {
        PopupMenu popup = new PopupMenu(context, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.card_menu, popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
        popup.show();
    }
    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        public MyMenuItemClickListener(){
        }
        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.card_menu_order:
                    Toast.makeText(context, "Order", Toast.LENGTH_SHORT).show();
                    return true;
                    //Intent intent = new Intent(context, OrderActivity.class);
                    //intent.putExtra("product_id", productCode.getText());
                    //context.startActivity(intent);
                case R.id.card_menu_order_call:
                    //Toast.makeText(context, "Call To Order", Toast.LENGTH_SHORT).show();
                    //return true;
                    String phnNum = "+8801975102026";
                    Intent intentCall = new Intent(Intent.ACTION_CALL);
                    intentCall.setData(Uri.parse(phnNum));
                    context.startActivity(intentCall);
                default:
            }
            return false;
        }
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}