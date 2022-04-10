package com.enetedu.hep.news;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.core.widget.NestedScrollView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.enetedu.hep.R;
import com.enetedu.hep.base.MyBaseFragment;
import com.enetedu.hep.course.adapter.FixedFragmentAdapter;
import com.enetedu.hep.http.RespBase;
import com.enetedu.hep.http.entity.BaseEntity;
import com.enetedu.hep.http.entity.CourseClassifyListEntity;
import com.enetedu.hep.http.entity.LunBoTuEntity;
import com.enetedu.hep.my.WebViewActivity;
import com.enetedu.hep.utils.Constant;
import com.xw.banner.Banner;
import com.xw.banner.BannerConfig;
import com.xw.banner.listener.OnBannerListener;
import com.xw.banner.loader.ImageLoader;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends MyBaseFragment {

    private TabLayout mTab;
    private ViewPager mVp;
    private ArrayList<CourseClassifyListEntity> tittlelist = new ArrayList<>();//初始化Tab栏数据;
    private ArrayList<Fragment> mFragmentsList;
    private NewsVpFragment newsVpFragment;
    private FixedFragmentAdapter fixedFragmentAdapter;
    private CourseClassifyListEntity courseClassifyListEntity;
    private View view;
    private Banner mBanner;
    private LunBoTuEntity lunBoTuEntity;
    private ArrayList<String> bannertitle;
    private NestedScrollView mNestedScrollView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View inflate = inflater.inflate(R.layout.fragment_news, container, false);

        initView(inflate);
        loadRotationChart();
        loadInfoClassifyList();
        return inflate;
    }

    private void initView(View inflate) {
        mTab = (TabLayout) inflate.findViewById(R.id.tab);
        mVp = (ViewPager) inflate.findViewById(R.id.vp);
        mBanner = (Banner) inflate.findViewById(R.id.banner);
        mNestedScrollView = (NestedScrollView) inflate.findViewById(R.id.nestedScrollView);
        // infoClassifyListEntity = new InfoClassifyListEntity();
        courseClassifyListEntity = new CourseClassifyListEntity();
        lunBoTuEntity = new LunBoTuEntity();

        bannertitle = new ArrayList<>();

        mNestedScrollView.setFillViewport(true);
    }

    private void loadRotationChart() {
        lunBoTuEntity.getRotationChartCommunity(new BaseEntity.OnBaseResp() {
            @Override
            public void onResp(RespBase resp) {
                if (resp.getResCode() == 0) {
                    final ArrayList<LunBoTuEntity> data = (ArrayList<LunBoTuEntity>) resp.getData();
                    if (data != null && data.size() > 0) {

                        ArrayList<String> objects = new ArrayList<>();

                        for (int i = 0; i < data.size(); i++) {
                            objects.add(data.get(i).getPICTURE_URL());
                            bannertitle.add(data.get(i).getTITLE());
                        }
                        mBanner.setBannerTitles(bannertitle)
                                .setImages(objects).setImageLoader(new ImageLoader() {
                            @Override
                            public void displayImage(Context context, Object path, ImageView imageView) {
                                String path1 = (String) path;
                                Glide.with(context).load(path1).into(imageView);
                            }
                        }).setDelayTime(4000)
                                .isAutoPlay(true)
                                .setIndicatorGravity(Gravity.CENTER_VERTICAL)
                                .setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE)
                                .setOnBannerListener(new OnBannerListener() {
                                    @Override
                                    public void OnBannerClick(int position) {
                                        Intent intent = new Intent(getActivity(), WebViewActivity.class);
                                        intent.putExtra(Constant.INTENT_KEY_VALUE, data.get(position).getHYPERLINK());
                                        intent.putExtra("title", data.get(position).getTITLE());
                                        getActivity().startActivity(intent);
                                    }
                                }).start();
                    }
                }
            }
        });
    }

    private void loadInfoClassifyList() {
        courseClassifyListEntity.getInfoClassifyList(new BaseEntity.OnBaseResp() {
            @Override
            public void onResp(RespBase resp) {
                if (resp.getResCode() == 0) {
                    ArrayList<CourseClassifyListEntity> data = (ArrayList<CourseClassifyListEntity>) resp.getData();
                    if (data != null && data.size() > 0) {
                        for (int i = 0; i < data.size(); i++) {
                            CourseClassifyListEntity courseClassifyListEntity = data.get(i);
                            tittlelist.add(courseClassifyListEntity);
                        }
                    }

                    mFragmentsList = new ArrayList<>();//添加碎片
                    for (int i = 0; i < tittlelist.size(); i++) {
                        newsVpFragment = new NewsVpFragment();
                        Bundle bundle = new Bundle();
                        bundle.putString("id", tittlelist.get(i).getId());
                        newsVpFragment.setArguments(bundle);
                        mFragmentsList.add(newsVpFragment);
                    }
                    fixedFragmentAdapter = new FixedFragmentAdapter(getChildFragmentManager(), tittlelist, mFragmentsList);
                    mVp.setAdapter(fixedFragmentAdapter);
                    mTab.setupWithViewPager(mVp);

                }
            }
        });
    }
}
