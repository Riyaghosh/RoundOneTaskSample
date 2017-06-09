package com.example.riyaghosh.myrounonetasksample.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.riyaghosh.myrounonetasksample.model.ImageModelObject;

/**
 * Created by Riya Ghosh on 30-11-2016.
 */

public class ImageCustomPagerAdapter extends PagerAdapter {

    private Context mContext;

    public ImageCustomPagerAdapter(Context context) {
        mContext = context;
    }

    @Override
    public Object instantiateItem(ViewGroup collection, int position) {
        ImageModelObject modelObject = ImageModelObject.values()[position];
        LayoutInflater inflater = LayoutInflater.from(mContext);
        ViewGroup layout = (ViewGroup) inflater.inflate(modelObject.getLayoutResId(), collection, false);
        collection.addView(layout);
        return layout;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }

    @Override
    public int getCount() {
        return ImageModelObject.values().length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        ImageModelObject customPagerEnum = ImageModelObject.values()[position];
        return mContext.getString(customPagerEnum.getTitleResId());
    }


}
