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
import com.enetedu.hep.http.entity.Course3ViewListEntity;
import com.enetedu.hep.http.entity.UserInfo;
import com.enetedu.hep.study.adapter.EndStudyAdapter;
import com.enetedu.hep.utils.TwoBallRotationProgressBar;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class EndStudayFragment extends MyBaseFragment {
    private int page = 1;
    private UserInfo userInfo;
    private RecyclerView mRlv;
    private SmartRefreshLayout mSmart;
    private Course3ViewListEntity course3ViewListEntity;
    private EndStudyAdapter endStudyAdapter;
    private static final String TAG = "EndStudayFragment";
    private TwoBallRotationProgressBar mLoading;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View inflate = inflater.inflate(R.layout.fragment_end_studay, container, false);
        initView(inflate);
        loadFinishedList();
        return inflate;
    }

    private void initView(View inflate) {
        mRlv = (RecyclerView) inflate.findViewById(R.id.rlv);
        mSmart = (SmartRefreshLayout) inflate.findViewById(R.id.smart);
        mLoading = (TwoBallRotationProgressBar) inflate.findViewById(R.id.loading);
        userInfo = UserInfoSharePreference.getIns().get(getActivity());
        course3ViewListEntity = new Course3ViewListEntity();
        mRlv.setLayoutManager(new LinearLayoutManager(getActivity()));
        endStudyAdapter = new EndStudyAdapter();
        mRlv.setAdapter(endStudyAdapter);


        //下拉刷新
        mSmart.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                page = 1;
                loadFinishedList();
            }
        });
        mSmart.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
                page++;
                loadFinishedList();
            }
        });

    }

    public void loadFinishedList() {
        mLoading.startAnimator();
        course3ViewListEntity.getFinishedList(userInfo.getUserToken(), userInfo.getUserId(), page, 7, new BaseEntity.OnBaseResp() {
            @Override
            public void onResp(RespBase resp) {

                if (resp.getResCode() == 0) {
                    final ArrayList<Course3ViewListEntity> data = (ArrayList<Course3ViewListEntity>) resp.getData();
                    if (data != null && data.size() > 0) {
                        if (page == 1) {
                            endStudyAdapter.addData(data);
                        } else {
                            endStudyAdapter.newaddData(data);
                        }

                        endStudyAdapter.setOnItemListener(new EndStudyAdapter.OnItemListener() {
                            @Override
                            public void onlick(View v, int position) {
                                Intent intent = new Intent(getActivity(), StudyLinkActivity.class);
                                intent.putExtra("id", endStudyAdapter.mList.get(position).getId());
                                intent.putExtra("type", endStudyAdapter.mList.get(position).getCourseType());
                                intent.putExtra("name", endStudyAdapter.mList.get(position).getName());

                                if (endStudyAdapter.mList.get(position).getCourseLists().size() > 0) {
                                    intent.putExtra("courseid", endStudyAdapter.mList.get(position).getCourseLists().get(0).getID());
                                }


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
                } else if (resp.getResCode() == -99995) {
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
