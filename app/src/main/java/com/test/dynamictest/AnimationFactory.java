package com.test.dynamictest;

import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Interpolator;

import com.airbnb.lottie.LottieAnimationView;

public class AnimationFactory {
    private static final int DEFAULT_FLIP_TRANSITION_DURATION = 300;

    private AnimationFactory() {
    }


    public static void startWalletLoader(LottieAnimationView view) {
        if (view != null) {
            view.setVisibility(View.VISIBLE);
            view.setAnimation("Payments-Loader.json");
            view.loop(true);
            view.playAnimation();
        }
    }


    public static void stopWalletLoader(LottieAnimationView view) {
        if (view != null) {
            view.cancelAnimation();
            view.setVisibility(View.GONE);
        }
    }
}