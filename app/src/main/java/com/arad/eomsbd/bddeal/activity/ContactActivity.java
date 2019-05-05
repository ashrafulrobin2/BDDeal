package com.arad.eomsbd.bddeal.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.arad.eomsbd.bddeal.R;

public class ContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        TextView contact = (TextView) findViewById(R.id.contact);
        TextView contactMobile = (TextView) findViewById(R.id.contact_mobile);
        TextView contactEmail = (TextView) findViewById(R.id.contact_email);

        contactMobile.setText(R.string.contact_mobile);
    }
}
