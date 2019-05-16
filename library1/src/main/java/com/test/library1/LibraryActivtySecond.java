package com.test.library1;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.Visibility;
import android.view.Gravity;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class LibraryActivtySecond extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library_activty_second);

        ImageView iv = findViewById(R.id.iv_wifi_vendor2);

        Picasso.with(this)
                .load("https://assetscdn1.paytm.com/images/catalog/product/R/RE/RECKUMBH-WIFICCD-1000874C36C5CFF/a_3.png")
                .placeholder(R.drawable.ic_wifi_timing)
                .error(R.drawable.ic_wifi_timing)
                .into(iv);
    }

//    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
//    private void setupWindowAnimations() {
//        Transition transition = buildEnterTransition();
//
//        getWindow().setEnterTransition(transition);
//    }
//
//    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
//    private Visibility buildEnterTransition() {
//        Slide enterTransition = new Slide();
//        enterTransition.setDuration(500);
//
//        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
//            enterTransition.setSlideEdge(Gravity.END);
//        } else {
//            enterTransition.setSlideEdge(Gravity.RIGHT);
//        }
//
//        return enterTransition;
//    }
}
