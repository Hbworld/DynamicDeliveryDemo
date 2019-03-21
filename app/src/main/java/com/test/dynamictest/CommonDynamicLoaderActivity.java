package com.test.dynamictest;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.play.core.splitinstall.SplitInstallHelper;
import com.google.android.play.core.splitinstall.SplitInstallManager;
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory;
import com.google.android.play.core.splitinstall.SplitInstallRequest;
import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import com.google.android.play.core.splitinstall.SplitInstallStateUpdatedListener;
import com.google.android.play.core.splitinstall.model.SplitInstallSessionStatus;
import com.google.android.play.core.tasks.OnCompleteListener;
import com.google.android.play.core.tasks.OnFailureListener;
import com.google.android.play.core.tasks.OnSuccessListener;
import com.google.android.play.core.tasks.Task;

//import android.util.Log;

public class CommonDynamicLoaderActivity extends AppCompatActivity implements SplitInstallStateUpdatedListener, OnCompleteListener, OnFailureListener, OnSuccessListener {

    private static String TAG = "CommonDynamicLoaderActivity";
    public static String EXTRA_INIT_ACTIVITY = "EXTRA_INIT_ACTIVITY";
    public static String EXTRA_INIT_MODULE = "EXTRA_INIT_MODULE";


    private LottieAnimationView mainLoaderView;
    private TextView txtProgress;
    private Context mContext;
    private Intent resultIntent;
    private SplitInstallManager mInstallManager;
    private String initActivity;
    private String initModule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_loader);

        mainLoaderView = findViewById(R.id.mainLoaderView);
        txtProgress = findViewById(R.id.progress);
        mContext = CommonDynamicLoaderActivity.this;
        mInstallManager = SplitInstallManagerFactory.create(this);
        resultIntent = getIntent();
        initActivity = resultIntent.getStringExtra(EXTRA_INIT_ACTIVITY);
        initModule = resultIntent.getStringExtra(EXTRA_INIT_MODULE);

        installModule();

    }

    private void installModule() {
        SplitInstallRequest request = SplitInstallRequest.newBuilder()
                .addModule(initModule)
                .build();
        mInstallManager.registerListener(this);
        mInstallManager.startInstall(request).addOnFailureListener(this).addOnSuccessListener(this).addOnCompleteListener(this);
    }

    @Override
    public void onStateUpdate(SplitInstallSessionState splitInstallSessionState) {
        Log.i(TAG, "onStateUpdate " + splitInstallSessionState.status());
        if (splitInstallSessionState.moduleNames().contains(initModule)) {
            switch (splitInstallSessionState.status()) {
                case SplitInstallSessionStatus.DOWNLOADING:
                    displayLoadingState(splitInstallSessionState, "Downloading ");
                    break;
                case SplitInstallSessionStatus.REQUIRES_USER_CONFIRMATION:
                    try {
                        mContext.startIntentSender(splitInstallSessionState.resolutionIntent().getIntentSender(), null, 0, 0, 0);
                    } catch (IntentSender.SendIntentException e) {
                        e.printStackTrace();
                    }
                    break;
                case SplitInstallSessionStatus.INSTALLED:
                    if (26 <= Build.VERSION.SDK_INT) {
                        SplitInstallHelper.updateAppInfo(mContext.getApplicationContext());
                    }
                    startModuleActivity();
                    hideProgress();
                    break;
                case SplitInstallSessionStatus.INSTALLING:
                    displayLoadingState(splitInstallSessionState, "Downloading ");
                    break;
                case SplitInstallSessionStatus.FAILED:
                    Log.e(TAG, "Error " + splitInstallSessionState.errorCode() + " for module ");
                    break;
            }
        }

    }

    private void startModuleActivity() {
        resultIntent.setClassName(this, initActivity);
        startActivity(resultIntent);
        finish();
    }

    private void hideProgress() {
        AnimationFactory.stopWalletLoader(mainLoaderView);

    }

    private void displayLoadingState(SplitInstallSessionState state, String message) {
        AnimationFactory.startWalletLoader(mainLoaderView);
        long progress = (state.bytesDownloaded() / state.totalBytesToDownload()) * 100;

//        txtProgress.setText(getString(R.string.dynamic_hoho_progress, (int) progress));

        Log.d(TAG, "Total: " + state.totalBytesToDownload());
        Log.d(TAG, state.bytesDownloaded() + "");
    }

    @Override
    public void onComplete(Task task) {
        txtProgress.setText(getString(R.string.dynamic_hoho_progress_complete));
    }

    @Override
    public void onFailure(Exception e) {
        txtProgress.setText(getString(R.string.dynamic_hoho_progress_failed));

    }

    @Override
    public void onSuccess(Object o) {
        txtProgress.setText(getString(R.string.dynamic_hoho_progress_complete));
    }
}
