package com.example.android.titanic;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by summi on 03-09-2017.
 */

public class SectionsPageAdapter extends FragmentPagerAdapter{

    public SectionsPageAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "RECOMMENDED";
            case 1:
                return "POPULAR";
            case 2:
                return "IN THEATERS";
            default:
                return null;
        }
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                RecommendedFragment recommendedFragment = new RecommendedFragment();
                return recommendedFragment;
            case 1:
                PopularFragment popularFragment = new PopularFragment();
                return popularFragment;
            case 2:
                TheatersFragment theatersFragment = new TheatersFragment();
                return theatersFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
