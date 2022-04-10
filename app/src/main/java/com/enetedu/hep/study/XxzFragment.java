package com.enetedu.hep.study;


import android.content.Intent;
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
import com.enetedu.hep.http.entity.Course2ViewListEntity;
import com.enetedu.hep.http.entity.UserInfo;
import com.enetedu.hep.study.adapter.XxzAdapter;
import com.enetedu.hep.utils.TwoBallRotationProgressBar;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class XxzFragment extends MyBaseFragment {

    private static final String TAG = "XxzFragment";
    private RecyclerView mRlv;
    private SmartRefreshLayout mSmart;
    private XxzAdapter xxzAdapter;
    private int page = 1;
    private UserInfo userInfo;
    private Course2ViewListEntity course2ViewListEntity;
    private View view;
    private TwoBallRotationProgressBar mLoading;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View inflate = inflater.inflate(R.layout.fragment_xxz, container, false);
        initView(inflate);

        loadUnfinishedList();
        return inflate;
    }

    private void initView(View inflate) {
        mRlv = (RecyclerView) inflate.findViewById(R.id.rlv);
        mSmart = (SmartRefreshLayout) inflate.findViewById(R.id.smart);
        mLoading = (TwoBallRotationProgressBar) inflate.findViewById(R.id.loading);

        userInfo = UserInfoSharePreference.getIns().get(getActivity());
        course2ViewListEntity = new Course2ViewListEntity();
        mRlv.setLayoutManager(new LinearLayoutManager(getActivity()));
        xxzAdapter = new XxzAdapter();
        mRlv.setAdapter(xxzAdapter);

        //下拉刷新
        mSmart.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                page = 1;
                loadUnfinishedList();
            }
        });
        mSmart.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
                page++;
                loadUnfinishedList();
            }
        });

    }

    public void loadUnfinishedList() {
        mLoading.startAnimator();
        course2ViewListEntity.getUnfinishedList(userInfo.getUserToken(), userInfo.getUserId(), page, 7, new BaseEntity.OnBaseResp() {
            @Override
            public void onResp(RespBase resp) {
                if (resp.getResCode() == 0) {

                    final ArrayList<Course2ViewListEntity> data = (ArrayList<Course2ViewListEntity>) resp.getData();

                    if (data != null && data.size() > 0) {
                        if (page == 1) {

                            xxzAdapter.addData(data);
                        } else {
                            xxzAdapter.newaddData(data);
                        }
                        xxzAdapter.setOnItemListener(new XxzAdapter.OnItemListener() {
                            @Override
                            public void onlick(View v, int position) {
                                Intent intent = new Intent(getActivity(), StudyLinkActivity.class);
                                intent.putExtra("id", xxzAdapter.mList.get(position).getId());
                                intent.putExtra("type", xxzAdapter.mList.get(position).getCourseType());
                                intent.putExtra("name", xxzAdapter.mList.get(position).getName());

                                if (xxzAdapter.mList.get(position).getCourseLists().size() > 0) {
                                    intent.putExtra("courseid", xxzAdapter.mList.get(position).getCourseLists().get(0).getID());
                                }
                                intent.putExtra("courselist", xxzAdapter.mList.get(position).getCourseLists());
                                getActivity().startActivity(intent);
                            }
                        });

                        if (mSmart.isRefreshing()) {
                            mSmart.finishRefresh();
                        }
                        if (mSmart.isLoading()) {
                            mSmart.finishLoadMore();
                        }
                    }
                    mLoading.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mLoading.stopAnimator();
                        }
                    }, 3000);
                } else if (resp.getResCode() == -99995) {
                    Toast.makeText(getActivity(), "网络连接超时！", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
