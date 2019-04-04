package com.test.dynamic_feature;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.play.core.splitcompat.SplitCompat;
import com.test.library1.LibraryActivity;

public class DynamicInitActivity extends AppCompatActivity {

    public static final String TAG = "InstallDynamicModule";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_init);

        Log.i(TAG,"inside DynamicInitActivity");


        startActivity(new Intent(this, LibraryActivity.class));
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
        SplitCompat.install(this.getApplicationContext());
    }
}
