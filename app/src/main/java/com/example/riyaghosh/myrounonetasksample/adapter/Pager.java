package com.example.riyaghosh.myrounonetasksample.adapter;

/**
 * Created by Riya Ghosh on 09-06-2017.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.riyaghosh.myrounonetasksample.ImageTab;
import com.example.riyaghosh.myrounonetasksample.MilestoneTab;
import com.example.riyaghosh.myrounonetasksample.VedioTab;

/**
 * Created by Belal on 2/3/2016.
 */
//Extending FragmentStatePagerAdapter
public class Pager extends FragmentStatePagerAdapter {

    //integer to count number of tabs
    int tabCount;

    //Constructor to the class
    public Pager(FragmentManager fm, int tabCount) {
        super(fm);
        //Initializing tab count
        this.tabCount= tabCount;
    }

    //Overriding method getItem
    @Override
    public Fragment getItem(int position) {
        //Returning the current tabs
        switch (position) {
            case 0:
                VedioTab vedioTab = new VedioTab();
                return vedioTab;
            case 1:
                ImageTab imageTab = new ImageTab();
                return imageTab;
            case 2:
                MilestoneTab milestoneTab = new MilestoneTab();
                return milestoneTab;
            default:
                return null;
        }
    }

    //Overriden method getCount to get the number of tabs
    @Override
    public int getCount() {
        return tabCount;
    }
}
