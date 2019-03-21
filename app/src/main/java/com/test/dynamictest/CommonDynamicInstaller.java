package com.test.dynamictest;

import android.content.Context;

import com.google.android.play.core.splitinstall.SplitInstallManager;
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory;

import java.util.Set;

public class CommonDynamicInstaller {

    private SplitInstallManager mInstallManager;


    public CommonDynamicInstaller(Context context) {
        if (mInstallManager == null) {
            mInstallManager = SplitInstallManagerFactory.create(context);
        }
    }


    public boolean checkForInstallation(String moduleName) {
        Set<String> installedModules = mInstallManager.getInstalledModules();
        return installedModules.contains(moduleName);
    }
}
