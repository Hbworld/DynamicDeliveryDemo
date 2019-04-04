package com.test.dynamictest;

import android.content.Context;
import android.util.Log;

import com.google.android.play.core.splitinstall.SplitInstallManager;
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory;

import java.util.Set;

class CommonDynamicInstaller {
    private static final String TAG = "InstallDynamicModule";


    private SplitInstallManager mInstallManager;


    CommonDynamicInstaller(Context context) {
        if (mInstallManager == null) {
            mInstallManager = SplitInstallManagerFactory.create(context);
        }
    }


    boolean checkForInstallation(String moduleName) {
        Set<String> installedModules = mInstallManager.getInstalledModules();
        for(int i = 0; i<installedModules.size(); i++){
            Log.i(TAG,installedModules.toString());

        }
        Log.i(TAG,"inside checkForInstallation size"+installedModules.size());
        return installedModules.contains(moduleName);
    }
}
