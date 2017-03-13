package com.example.administrator.eyepetizer.moduls.find.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2017/3/6.
 */

public class FindAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments;
    private List<String> titles;

    public FindAdapter(FragmentManager fm, List<Fragment> fragments, List<String> titles) {
        super(fm);
        this.fragments = fragments;
        this.titles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments!=null?fragments.size():0;
    }

    /**
     * 将tabLayout与viewPager关联需要重写的方法
     * @param position
     * @return
     */
    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
