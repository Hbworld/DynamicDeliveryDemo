package com.test.library1;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;

public class PicassoCrashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picasso_crash);

        SlidingViewPager viewPager = findViewById(R.id.image_pager);


        CustomViewPagerAdapter mViewPagerAdapter = new CustomViewPagerAdapter(viewPager);
        setViewPagerLayoutParams(viewPager, mViewPagerAdapter);
        viewPager.setAdapter(mViewPagerAdapter);

    }

    private void setViewPagerLayoutParams(SlidingViewPager viewPager, CustomViewPagerAdapter pagerAdapter) {
        int deviceWidth = getScreenWidth(viewPager.getContext());
        viewPager.setBackground(null);
        int imageWidth = deviceWidth
                - dpToPx(20, viewPager.getContext());
        int imageHeight = (int) (imageWidth / 1.69);
        pagerAdapter.setImageWidthHeight(imageWidth, imageHeight);
    }

    public static int getScreenWidth(Context context) {
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return displayMetrics.widthPixels;
    }

    public static int dpToPx(int paddingInDp,Context context){
        int padding_in_dp = paddingInDp;  // 6 dps
        final float scale = context.getResources().getDisplayMetrics().density;
        int padding_in_px = (int) (padding_in_dp * scale + 0.5f);
        return padding_in_px;
    }
}
