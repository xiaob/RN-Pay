package com.weipay.wxapi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.weipay.PayModule;
import com.weipay.R;

public class WXPayEntryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wxpay_entry);
        PayModule.handleIntent(getIntent());
        finish();
    }
}
