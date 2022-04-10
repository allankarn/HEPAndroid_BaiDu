package com.enetedu.hep.course.adapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.enetedu.hep.http.entity.CourseClassifyListEntity;

import java.util.ArrayList;
import java.util.List;

public class FixedFragmentAdapter extends FragmentPagerAdapter {

    private List<Fragment> mFragments;
    private List<CourseClassifyListEntity> mTitles;

    public FixedFragmentAdapter(FragmentManager supportFragmentManager, ArrayList<CourseClassifyListEntity> tittlelist, ArrayList<Fragment> mFragmentsList) {
        super(supportFragmentManager);
        mFragments=mFragmentsList;
        mTitles=tittlelist;

    }


    @Override
    public Fragment getItem(int i) {
        return mFragments.get(i);
    }

    @Override
    public int getCount() {
        return mFragments == null ? 0 : mFragments.size();

    }



    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        return mTitles.get(position).getName();
    }





}
