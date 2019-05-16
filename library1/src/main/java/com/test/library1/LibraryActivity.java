package com.test.library1;

import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class LibraryActivity extends BaseActivity {

    public static final String TAG = "InstallDynamicModule";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        Log.i(TAG,"inside LibraryActivity");

        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSecondActivity();
            }
        });

        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMovieActivity();
            }
        });

        findViewById(R.id.btn3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPicassoCrashActivity();
            }
        });

        ImageView iv = findViewById(R.id.iv_wifi_vendor);

        Picasso.with(this)
                .load("https://assetscdn1.paytm.com/images/catalog/product/R/RE/RECKUMBH-WIFICCD-1000874C36C5CFF/a_3.png")
                .placeholder(R.drawable.ic_wifi_timing)
                .error(R.drawable.ic_wifi_timing)
                .into(iv);

    }

    private void openPicassoCrashActivity() {
        Intent i = new Intent(LibraryActivity.this,PicassoCrashActivity.class);
        startActivity(i);
    }

    private void openMovieActivity() {
        Intent i = new Intent(LibraryActivity.this,MovieTest.class);
        startActivity(i);
    }

    private void openSecondActivity() {

            Intent i = new Intent(LibraryActivity.this,LibraryActivtySecond.class);
            startActivity(i);
            overridePendingTransition(R.anim.enter_from_right, R.anim.exit_out_left);


    }

    public void transitionTo(Intent i) {
        final Pair<View, String>[] pairs;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            pairs = TransitionHelper.createSafeTransitionParticipants(this, true);
            ActivityOptionsCompat transitionActivityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(this, pairs);
            startActivity(i, transitionActivityOptions.toBundle());
        }

    }
}
