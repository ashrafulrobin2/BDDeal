package com.arad.eomsbd.bddeal.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.arad.eomsbd.bddeal.R;

public class AboutUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        TextView aboutUs = (TextView) findViewById(R.id.about_us);
        TextView aboutUsContent = (TextView) findViewById(R.id.about_us_content);
    }
}
