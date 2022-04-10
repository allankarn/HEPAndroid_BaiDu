package com.enetedu.hep.study.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyViewPagerAdapter extends FragmentPagerAdapter {

    private String[] mTabTitles;
    private Fragment[] mFragmentArrays;

    public MyViewPagerAdapter(FragmentManager supportFragmentManager, String[] mTabTitles, Fragment[] mFragmentArrays) {
        super(supportFragmentManager);
        this.mTabTitles = mTabTitles;
        this.mFragmentArrays = mFragmentArrays;

    }

    @Override
    public Fragment getItem(int i) {
        return mFragmentArrays[i];
    }

    @Override
    public int getCount() {
        return mFragmentArrays.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTabTitles[position];
    }
}

