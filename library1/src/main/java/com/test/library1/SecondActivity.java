package com.test.library1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    @Override
    public void onBackPressed() {
        overridePendingTransition(android.R.anim.fade_in, com.test.library1.R.anim.park_slide_out_right);
        super.onBackPressed();
    }
}
