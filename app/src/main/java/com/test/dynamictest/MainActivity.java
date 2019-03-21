package com.test.dynamictest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.test.dynamictest.CommonDynamicLoaderActivity.EXTRA_INIT_ACTIVITY;
import static com.test.dynamictest.CommonDynamicLoaderActivity.EXTRA_INIT_MODULE;

public class MainActivity extends AppCompatActivity {

    private static String DYNAMIC_MODULE_ACTIVITY = "com.test.dynamic_feature.DynamicInitActivity";
    private static String DYNAMIC_MODULE_NAME = "dynamic_feature";

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        Button btnTap = findViewById(R.id.btn_tap);

        btnTap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CommonDynamicInstaller mInstaller = new CommonDynamicInstaller(context);

                if (mInstaller.checkForInstallation(DYNAMIC_MODULE_NAME)) {
                    Intent intent = new Intent();
                    intent.setClassName(context, DYNAMIC_MODULE_ACTIVITY);
                    context.startActivity(intent);
                } else {
                    Intent intent = new Intent(context, CommonDynamicLoaderActivity.class);
                    intent.putExtra(EXTRA_INIT_ACTIVITY, DYNAMIC_MODULE_ACTIVITY);
                    intent.putExtra(EXTRA_INIT_MODULE, DYNAMIC_MODULE_NAME);
                    context.startActivity(intent);
                }
            }
        });
    }
}
