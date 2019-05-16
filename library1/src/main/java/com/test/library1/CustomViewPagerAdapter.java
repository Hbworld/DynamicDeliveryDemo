package com.test.library1;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.squareup.picasso.Picasso;

public class CustomViewPagerAdapter extends PagerAdapter {

    private final Context mContext;
    private LayoutInflater mLayoutInflater;
    private ViewPager mViewPager;

    private int imageHeight = 0;
    private int imageWidth = 0;

    public CustomViewPagerAdapter(ViewPager mViewPager) {
        this.mViewPager = mViewPager;
        mContext = mViewPager.getContext();
        mLayoutInflater= LayoutInflater.from(mContext);
    }

    public void setImageWidthHeight(int width, int height) {
        this.imageWidth = width;
        this.imageHeight = height;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        final View view = mLayoutInflater.inflate(R.layout.movie_view_pager_item, container, false);

        final ImageView imageView = view.findViewById(com.test.library1.R.id.viewpager_image);
        Picasso.with(mContext)
                .load("https://assetscdn1.paytm.com/images/catalog/product/R/RE/RECKUMBH-WIFICCD-1000874C36C5CFF/a_3.png")
                .fit()
                .placeholder(com.test.library1.R.drawable.ic_wifi_timing)
                .error(com.test.library1.R.drawable.ic_wifi_timing)
                .into(imageView);

        container.addView(view);
        return view;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View)object;
        if(view instanceof RelativeLayout) {
            ((RelativeLayout) view).removeAllViews();
        }
        view.setOnClickListener(null);
        view.removeCallbacks(null);
        container.removeView((View) object);

    }

}