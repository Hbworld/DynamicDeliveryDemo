package com.test.library1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class LibraryActivity extends AppCompatActivity {

    public static final String TAG = "InstallDynamicModule";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        Log.i(TAG,"inside LibraryActivity");

    }
}
