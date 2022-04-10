package com.enetedu.hep.course;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.enetedu.hep.R;
import com.enetedu.hep.base.BaseActivityPro;
import com.enetedu.hep.config.UserInfoSharePreference;
import com.enetedu.hep.course.adapter.FixedFragmentAdapter;
import com.enetedu.hep.course.fragment.ViewPFragment;
import com.enetedu.hep.http.RespBase;
import com.enetedu.hep.http.entity.BaseEntity;
import com.enetedu.hep.http.entity.CourseClassifyListEntity;
import com.enetedu.hep.http.entity.ShoppingCartListEntity;
import com.enetedu.hep.http.entity.UserInfo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

import q.rorbin.verticaltablayout.VerticalTabLayout;
import q.rorbin.verticaltablayout.widget.TabView;

public class OnlineActivity extends BaseActivityPro {

    private static final String TAG = "OnlineActivity";
    private VerticalTabLayout mTab;
    private ArrayList<Fragment> mFragmentsList;
    private CourseClassifyListEntity loadcourse;
    private ViewPager mVp;
    private ArrayList<CourseClassifyListEntity> tittlelist = new ArrayList<>();//初始化Tab栏数据;
    private ViewPFragment viewPFragment;
    private FixedFragmentAdapter adapter;
    private Toolbar simple_toolbar;
    private ImageView iv_shopping;
    private ShoppingCartListEntity shoppingCartListEntity;
    private UserInfo userInfo;
    /**
     * 返回
     */
    private TextView mTxtLeftTitle;
    /**
     * 已选择10课时
     */
    private TextView mTvKeshi;
    /**
     * 查看课程购物车
     */
    private TextView mTvGouwu;
    private float courseCerdit = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online);
        initView();

        loadShoppingCartList();
        loadCourseClassifyList();
    }

    //获取tab栏信息
    private void loadCourseClassifyList() {
        loadcourse.getCourseClassifyList("ENDPOINT_ANDROID", new BaseEntity.OnBaseResp() {
            @Override
            public void onResp(RespBase resp) {
                if (resp.getResCode() == 0) {
                    Log.d(TAG, "onResp: " + resp.getData());
                    ArrayList<CourseClassifyListEntity> data = (ArrayList<CourseClassifyListEntity>) resp.getData();
                    if (data != null && data.size() > 0) {
                        for (int i = 0; i < data.size(); i++) {
                            CourseClassifyListEntity courseClassifyListEntity = data.get(i);
                            // String name = courseClassifyListEntity.getName();
                            tittlelist.add(courseClassifyListEntity);
                            Log.d(TAG, "onResp: " + courseClassifyListEntity.toString());
                        }
                    }
                    mFragmentsList = new ArrayList<>();//添加碎片
                    for (int i = 0; i < tittlelist.size(); i++) {
                        viewPFragment = new ViewPFragment();
                        Bundle bundle = new Bundle();
                        bundle.putString("type", tittlelist.get(i).getId());
                        viewPFragment.setArguments(bundle);
                        mFragmentsList.add(viewPFragment);
                        Log.d(TAG, "onResp: ======================" + tittlelist.get(i).getId());
                    }
                    adapter = new FixedFragmentAdapter(getSupportFragmentManager(), tittlelist, mFragmentsList);
                    mVp.setAdapter(adapter);
                    mTab.setupWithViewPager(mVp);
                    mVp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                        @Override
                        public void onPageScrolled(int i, float v, int i1) {

                        }

                        @Override
                        public void onPageSelected(int i) {
                            mTab.setTabSelected(i);
                        }

                        @Override
                        public void onPageScrollStateChanged(int i) {

                        }
                    });
                    mTab.addOnTabSelectedListener(new VerticalTabLayout.OnTabSelectedListener() {
                        @Override
                        public void onTabSelected(TabView tab, int position) {
                            mVp.setCurrentItem(position);
                        }

                        @Override
                        public void onTabReselected(TabView tab, int position) {

                        }
                    });
                }
            }
        });
    }

    private void loadShoppingCartList() {
        shoppingCartListEntity.getShoppingCartList("ENDPOINT_ANDROID", userInfo.getUserToken(), userInfo.getUserId(), 1, 50, new BaseEntity.OnBaseResp() {
            @Override
            public void onResp(RespBase resp) {
                if (resp.getResCode() == 0) {
                    ArrayList<ShoppingCartListEntity> data = (ArrayList<ShoppingCartListEntity>) resp.getData();

                    if (data != null && data.size() > 0) {

                        for (int i = 0; i < data.size(); i++) {

                            courseCerdit = courseCerdit + Float.parseFloat(data.get(i).getCourseCerdit());
                        }
                        BigDecimal bigDecimal = new BigDecimal(courseCerdit);
                        mTvKeshi.setText("已选择" + bigDecimal.setScale(2, RoundingMode.HALF_UP) + "课时");
                    }
                }
            }
        });
    }

    private void initView() {
        mTab = (VerticalTabLayout) findViewById(R.id.tab);
        mVp = (ViewPager) findViewById(R.id.vp);
        iv_shopping = findViewById(R.id.iv_shopping);
        mTxtLeftTitle = (TextView) findViewById(R.id.txt_left_title);
        mTvKeshi = (TextView) findViewById(R.id.tv_keshi);
        mTvGouwu = (TextView) findViewById(R.id.tv_gouwu);
        userInfo = UserInfoSharePreference.getIns().get(this);
        loadcourse = new CourseClassifyListEntity();
        shoppingCartListEntity = new ShoppingCartListEntity();
        mTvGouwu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OnlineActivity.this, ShopActivity.class);
                startActivity(intent);
            }
        });
        iv_shopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OnlineActivity.this, ShopActivity.class);
                startActivity(intent);
            }
        });

        mTxtLeftTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnlineActivity.this.finish();
            }
        });
    }
}
