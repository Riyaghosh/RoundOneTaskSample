package com.example.riyaghosh.myrounonetasksample;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;

import com.example.riyaghosh.myrounonetasksample.adapter.ImageCustomPagerAdapter;
import com.example.riyaghosh.myrounonetasksample.adapter.Pager;
import com.example.riyaghosh.myrounonetasksample.fragment.ImageFragment;
import com.example.riyaghosh.myrounonetasksample.fragment.MileStoneFragment;
import com.example.riyaghosh.myrounonetasksample.fragment.VedioFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    ImageView footer_imageview1,footer_imageview2,footer_imageview3,footer_imageview4,footer_imageview5;
    int selectedIndex;
    float oldTouchValue;
    boolean callHappened = false;
    boolean mPageEnd=false,swipeLeft=false;

    private TabLayout tabLayout;
    private ViewPager slidePager;

    private int[] tabIcons = {
            R.drawable.vr_videos,
            R.drawable.image,
            R.drawable.milestone
    };

//    private int[] tabIcons = {
//            R.mipmap.ic_launcher,
//            R.mipmap.ic_launcher,
//            R.mipmap.ic_launcher
//    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        footer_imageview1=(ImageView) findViewById(R.id.footer_imageview1);
        footer_imageview2=(ImageView) findViewById(R.id.footer_imageview2);
        footer_imageview3=(ImageView) findViewById(R.id.footer_imageview3);
        footer_imageview4=(ImageView) findViewById(R.id.footer_imageview5);
        footer_imageview5=(ImageView) findViewById(R.id.footer_imageview6);

        viewPager.setAdapter(new ImageCustomPagerAdapter(this));
        viewPager.setCurrentItem(0, true);

        setTab();
        onCircleButtonClick();


        slidePager = (ViewPager) findViewById(R.id.slidePager);
        setupViewPager(slidePager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(slidePager);
        setupTabIcons();
//        tabLayout.setOnTabSelectedListener()

        tabLayout.setOnTabSelectedListener(
                new TabLayout.ViewPagerOnTabSelectedListener(viewPager) {

                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        super.onTabSelected(tab);
                        int tabIconColor = ContextCompat.getColor(MainActivity.this, R.color.toolbar_color);
                        tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);


                    }

                    @Override
                    public void onTabUnselected(TabLayout.Tab tab) {
                        super.onTabUnselected(tab);
                        int tabIconColor = ContextCompat.getColor(MainActivity.this, R.color.deselected_color);
                        tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
                    }

                    @Override
                    public void onTabReselected(TabLayout.Tab tab) {
                        super.onTabReselected(tab);
                    }
                }
        );
    }




    private void onCircleButtonClick() {

        footer_imageview1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                footer_imageview1.setImageResource(R.drawable.ic_slider_select);
                viewPager.setCurrentItem(0);
            }
        });

        footer_imageview2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                footer_imageview2.setImageResource(R.drawable.ic_slider_select);
                viewPager.setCurrentItem(1);
            }
        });
        footer_imageview3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                footer_imageview3.setImageResource(R.drawable.ic_slider_select);
                viewPager.setCurrentItem(0);
            }
        });
        footer_imageview4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                footer_imageview4.setImageResource(R.drawable.ic_slider_select);
                viewPager.setCurrentItem(1);
            }
        });
        footer_imageview5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                footer_imageview5.setImageResource(R.drawable.ic_slider_select);
                viewPager.setCurrentItem(2);
            }
        });
    }


    private void setTab() {
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrollStateChanged(int position) {
                if(selectedIndex == viewPager.getAdapter().getCount() - 1)
                {
                    mPageEnd = true;
                }
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
//                if(position==viewPager.getAdapter().getCount()-1){
//                    //start next Activity
//                }

                viewPager.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        switch (event.getAction())

                        {
                            case MotionEvent.ACTION_DOWN:
                                oldTouchValue = event.getX();
                                return true;
//                                break;
                            case MotionEvent.ACTION_UP:
                                float currentX = event.getX();
                                if (oldTouchValue < currentX) {
                                    swipeLeft=false;
                                }
                                if (oldTouchValue > currentX) {
                                    swipeLeft=true;
                                }
                                break;
                        }
                        return false;
                    }
                });

                if( mPageEnd && arg0 == selectedIndex && !callHappened)
                {
                    Log.d(getClass().getName(), "Okay");
                    mPageEnd = false;//To avoid multiple calls.
                    callHappened = true;
                    if(swipeLeft) {
                        Intent reg = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(reg);
                       finish();
                    }
                    callHappened=false;
                }
                else
                {
                    mPageEnd = false;
                }
            }

            @Override
            public void onPageSelected(int position) {
                // TODO Auto-generated method stub
                selectedIndex = position;
                footer_imageview1.setImageResource(R.drawable.ic_slider_deselect);
                footer_imageview2.setImageResource(R.drawable.ic_slider_deselect);
                footer_imageview3.setImageResource(R.drawable.ic_slider_deselect);
                footer_imageview4.setImageResource(R.drawable.ic_slider_deselect);
                footer_imageview5.setImageResource(R.drawable.ic_slider_deselect);

                btnAction(position);



            }

        });


    }


    private void btnAction(int action) {
        switch (action) {
            case 0:
                footer_imageview1.setImageResource(R.drawable.ic_slider_select);

                break;

            case 1:
                footer_imageview2.setImageResource(R.drawable.ic_slider_select);

                break;
            case 2:
                footer_imageview3.setImageResource(R.drawable.ic_slider_select);
                break;
            case 3:
                footer_imageview4.setImageResource(R.drawable.ic_slider_select);
                break;
            case 4:
                footer_imageview5.setImageResource(R.drawable.ic_slider_select);
                break;
        }
    }

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new VedioFragment(), "VEDIO");
        adapter.addFrag(new ImageFragment(), "IMAGE");
        adapter.addFrag(new MileStoneFragment(), "MILESTONE");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }


}
