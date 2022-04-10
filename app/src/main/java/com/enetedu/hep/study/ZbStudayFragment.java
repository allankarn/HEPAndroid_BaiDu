package com.enetedu.hep.study;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.enetedu.hep.R;
import com.enetedu.hep.base.MyBaseFragment;
import com.enetedu.hep.config.UserInfoSharePreference;
import com.enetedu.hep.http.RespBase;
import com.enetedu.hep.http.entity.BaseEntity;
import com.enetedu.hep.http.entity.CourseViewListEntity;
import com.enetedu.hep.http.entity.UserInfo;
import com.enetedu.hep.study.adapter.ZbStudyAdapter;
import com.enetedu.hep.utils.TwoBallRotationProgressBar;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZbStudayFragment extends MyBaseFragment {

    private RecyclerView mRlv;
    private SmartRefreshLayout mSmart;
    private CourseViewListEntity courseViewListEntity;
    private ZbStudyAdapter zbStudyAdapter;
    private int page = 1;
    private UserInfo userInfo;
    private TwoBallRotationProgressBar mLoading;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View inflate = inflater.inflate(R.layout.fragment_zb_studay, container, false);

        initView(inflate);
        loadPreparationList();
        return inflate;
    }

    private void initView(View inflate) {
        mRlv = (RecyclerView) inflate.findViewById(R.id.rlv);
        mSmart = (SmartRefreshLayout) inflate.findViewById(R.id.smart);
        mLoading = (TwoBallRotationProgressBar) inflate.findViewById(R.id.loading);
        userInfo = UserInfoSharePreference.getIns().get(getActivity());
        courseViewListEntity = new CourseViewListEntity();
        mRlv.setLayoutManager(new LinearLayoutManager(getActivity()));
        zbStudyAdapter = new ZbStudyAdapter();
        mRlv.setAdapter(zbStudyAdapter);

        //下拉刷新
        mSmart.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                page = 1;
                loadPreparationList();
            }
        });
        mSmart.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
                page++;
                loadPreparationList();
            }
        });
    }

    public void loadPreparationList() {
        mLoading.startAnimator();
        courseViewListEntity.getPreparationList(userInfo.getUserToken(), userInfo.getUserId(), page, 7, new BaseEntity.OnBaseResp() {
            @Override
            public void onResp(RespBase resp) {

                if (resp.getResCode() == 0) {

                    final ArrayList<CourseViewListEntity> data = (ArrayList<CourseViewListEntity>) resp.getData();

                    if (data != null && data.size() > 0) {
                        if (page == 1) {
                            zbStudyAdapter.addData(data);
                        } else {
                            zbStudyAdapter.newaddData(data);
                        }
                        zbStudyAdapter.setOnItemListener(new ZbStudyAdapter.OnItemListener() {
                            @Override
                            public void onlick(View v, int position) {
                                Toast.makeText(getActivity(), "请到网站上激活！", Toast.LENGTH_SHORT).show();
                            }
                        });

                        if (mSmart.isRefreshing()) {
                            mSmart.finishRefresh();
                        }
                        if (mSmart.isLoading()) {
                            mSmart.finishLoadMore();
                        }
                    }

                }else if (resp.getResCode() == -99995){
                    Toast.makeText(getActivity(), "网络连接超时！", Toast.LENGTH_SHORT).show();
                }
                mLoading.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mLoading.stopAnimator();
                    }
                }, 3000);
            }
        });

    }
}
