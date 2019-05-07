package com.arad.eomsbd.bddeal.activity;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.*;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.*;

import com.arad.eomsbd.bddeal.category_model.Category;
import com.arad.eomsbd.bddeal.model.Product;
import com.arad.eomsbd.bddeal.R;
import com.arad.eomsbd.bddeal.model.ProductResponse;
import com.arad.eomsbd.bddeal.rest.ApiClient;
import com.arad.eomsbd.bddeal.rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private static final String TAG = MainActivity.class.getSimpleName();
    private static SharedPreferences sharedpreferences;
    public static final String mypreference = "mypref";
    int data;
    private Context context = MainActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView productGroupName = (TextView) findViewById(R.id.product_group_name);
        productGroupName.setText(R.string.product_group_name);

        sharedpreferences = context.getSharedPreferences( "details", MODE_PRIVATE );
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Send Email to : bddealonline@gmail.com", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<Category> call = apiService.getMainCategory();
        call.enqueue(new Callback<Category>() {
            @Override
            public void onResponse(Call<Category> call, Response<Category> response) {
              Category category=response.body();
              if (response.isSuccessful() && category!=null){
                  String name0=category.getData().get(0).getMcName();
                  String name1=category.getData().get(1).getMcName();
                  String name2=category.getData().get(2).getMcName();
                  String name3=category.getData().get(3).getMcName();
                  String name4=category.getData().get(4).getMcName();
                  String name5=category.getData().get(5).getMcName();
                  String name6=category.getData().get(6).getEnMcName();
                  String name7=category.getData().get(7).getEnMcName();
                  String name8=category.getData().get(8).getEnMcName();
                  String name9=category.getData().get(9).getEnMcName();
                  String name10=category.getData().get(10).getEnMcName();


                  String id0=category.getData().get(0).getMcId();


                  SharedPreferences.Editor editor = sharedpreferences.edit();

                  editor.putString("id0",id0);

                  editor.putString( "name0", name0 );
                  editor.putString( "name1", name1 );
                  editor.putString( "name2", name2 );
                  editor.putString( "name3",name3 );
                  editor.putString( "name4",name4 );
                  editor.putString( "name5",name5 );
                  editor.apply();
                  editor.commit();
              }
//                Log.d(TAG, "Number of product received: " + products.size());
            }
            @Override
            public void onFailure(Call<Category> call, Throwable throwable) {
                Log.e(TAG, throwable.toString());
            }
        });

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (item.getItemId()) {
            case R.id.action_search:
                return true;
            case R.id.action_about_us:
                Intent intentAboutUs = new Intent(this, AboutUsActivity.class);
                this.startActivity(intentAboutUs);
            case R.id.action_customer_service:
                return true;
            case R.id.action_contact:
                Intent intentContact = new Intent(this, ContactActivity.class);
                this.startActivity(intentContact);
            case R.id.action_help:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        String id0=sharedpreferences.getString("id0","details");



        String name0  =sharedpreferences.getString("name0","details");
        String name1=sharedpreferences.getString("name1","details");
        String name2 =sharedpreferences.getString("name2","details");
        String name3=sharedpreferences.getString("name3","details");
        String name4  =sharedpreferences.getString("name4","details");
        String name5=sharedpreferences.getString("name5","details");
        String name6  =sharedpreferences.getString("name6","details");
        String name7=sharedpreferences.getString("name7","details");
        String name8  =sharedpreferences.getString("name8","details");
        String name9=sharedpreferences.getString("name9","details");
        String name10=sharedpreferences.getString("name10","details");
        if (id == R.id.nav_home) {
            Intent intentHome = new Intent(this, MainActivity.class);
            this.startActivity(intentHome);
        } else if (id == R.id.nav_gents) {
            Intent intentGents = new Intent(this, MainCategoryProductActivity.class);
            intentGents.putExtra("category",id0 );
            intentGents.putExtra("category_name", name0);
            this.startActivity(intentGents);
        } else if (id == R.id.nav_girls) {
            Intent intentGirls = new Intent(this, MainCategoryProductActivity.class);
           // intentGirls.putExtra("category", "3");
            intentGirls.putExtra("category_name", name1);
            this.startActivity(intentGirls);
        } else if (id == R.id.nav_kids) {
            Intent intentKids = new Intent(this, MainCategoryProductActivity.class);
           // intentKids.putExtra("category", "8");
            intentKids.putExtra("category_name", name2);
            this.startActivity(intentKids);
        } else if (id == R.id.nav_home_decor) {
            Intent intentHomeDecor = new Intent(this, MainCategoryProductActivity.class);
            //intentHomeDecor.putExtra("category", "4");
            intentHomeDecor.putExtra("category_name",name3);
            this.startActivity(intentHomeDecor);
        } else if (id == R.id.nav_gift) {
            Intent intentGift = new Intent(this, MainCategoryProductActivity.class);
           // intentGift.putExtra("category", "5");
            intentGift.putExtra("category_name", name4);
            this.startActivity(intentGift);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {
        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
//http://androidcss.com/android/fetch-json-data-android/
//https://www.androidhive.info/2016/05/android-working-with-retrofit-http-library/
}