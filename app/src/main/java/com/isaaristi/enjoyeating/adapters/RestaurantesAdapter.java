package com.isaaristi.enjoyeating.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

public class RestaurantesAdapter extends FragmentStatePagerAdapter{


    List<Fragment> data;

    public RestaurantesAdapter(FragmentManager fm, List<Fragment> data) {
        super(fm);
        this.data = data;
    }


    @Override
    public Fragment getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getCount() {
        return data.size();
    }
}
