package com.test.dynamic_feature;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.test.library1.LibraryActivity;

public class DynamicInitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_init);

        startActivity(new Intent(this, LibraryActivity.class));
    }
}
