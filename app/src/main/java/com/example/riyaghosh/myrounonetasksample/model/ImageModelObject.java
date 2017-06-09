package com.example.riyaghosh.myrounonetasksample.model;

import com.example.riyaghosh.myrounonetasksample.R;

/**
 * Created by Riya Ghosh on 30-11-2016.
 */

public enum ImageModelObject {
    RED(R.string.red, R.layout.viewpager_first_image_layout),
    BLUE(R.string.blue, R.layout.viewpager_second_image_layout),
    GREEN(R.string.green, R.layout.viewpager_thired_image_layout);



    private int mTitleResId;
    private int mLayoutResId;

    ImageModelObject(int titleResId, int layoutResId) {
        mTitleResId = titleResId;
        mLayoutResId = layoutResId;
    }

    public int getTitleResId() {
        return mTitleResId;
    }

    public int getLayoutResId() {
        return mLayoutResId;
    }
}
