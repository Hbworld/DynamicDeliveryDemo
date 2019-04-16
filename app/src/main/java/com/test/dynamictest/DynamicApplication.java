package com.test.dynamictest;

import android.content.Context;
import android.support.multidex.MultiDexApplication;

import com.google.android.play.core.splitcompat.SplitCompat;

public class DynamicApplication extends MultiDexApplication {


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        SplitCompat.install(this);
    }

}
