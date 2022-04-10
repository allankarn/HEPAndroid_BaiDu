package com.enetedu.hep.study;


import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.enetedu.hep.R;
import com.enetedu.hep.base.MyBaseFragment;
import com.enetedu.hep.study.adapter.MyViewPagerAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class StudyFragment extends MyBaseFragment {

    private TabLayout mTab;
    private ViewPager mVp;
    private Fragment[] mFragmentArrays = new Fragment[3];
    private String[] mTabTitles = new String[3];

    private ZbStudayFragment zbStudayFragment;
    private XxzFragment xxzFragment;
    private EndStudayFragment endStudayFragment;
    private MyViewPagerAdapter myViewPagerAdapter;

    private static final String TAG = "StudyFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View inflate = inflater.inflate(R.layout.fragment_study, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        mTab = (TabLayout) inflate.findViewById(R.id.tab);
        mVp = (ViewPager) inflate.findViewById(R.id.vp);
        mTabTitles[0] = "准备学";
        mTabTitles[1] = "学习中";
        mTabTitles[2] = "已学完";
        zbStudayFragment = new ZbStudayFragment();
        xxzFragment = new XxzFragment();
        endStudayFragment = new EndStudayFragment();

        mFragmentArrays[0] = zbStudayFragment;
        mFragmentArrays[1] = xxzFragment;
        mFragmentArrays[2] = endStudayFragment;


        myViewPagerAdapter = new MyViewPagerAdapter(getChildFragmentManager(), mTabTitles, mFragmentArrays);
        mVp.setAdapter(myViewPagerAdapter);
        mTab.setupWithViewPager(mVp);
    }
}
