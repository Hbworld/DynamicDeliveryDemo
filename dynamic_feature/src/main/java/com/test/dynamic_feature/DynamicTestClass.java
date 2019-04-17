package com.test.dynamic_feature;

import android.app.Application;
import android.util.Log;

public class DynamicTestClass {


    static String TAG = "InstallDynamicModule";

    public static void init(Application application){
        Log.i(TAG,"inside DynamicTestClass");

    }

}
