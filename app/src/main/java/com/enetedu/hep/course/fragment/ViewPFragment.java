package com.enetedu.hep.course.fragment;


import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.enetedu.hep.R;
import com.enetedu.hep.course.LiveDetailsActivity;
import com.enetedu.hep.course.OnlineDetailsActivity;
import com.enetedu.hep.course.adapter.CourseListAdapter;
import com.enetedu.hep.http.RespBase;
import com.enetedu.hep.http.entity.BaseEntity;
import com.enetedu.hep.http.entity.CourseListEntity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ViewPFragment extends Fragment {
    private View inflate;
    private RecyclerView mRlv;
    private CourseListAdapter courseListAdapter;
    private CourseListEntity courseListEntity;
    private String type;
    private static final String TAG = "ViewPFragment";
    private View view;
    private SmartRefreshLayout mSmart;
    private int page = 1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        inflate = inflater.inflate(R.layout.fragment_view, container, false);
        Bundle arguments = getArguments();
        if (arguments != null) {
            type = arguments.getString("type");
        }
        Log.d(TAG, "onCreateView: " + type);
        initView(inflate);
        loadCourseList();
        return inflate;
    }


    private void initView(View inflate) {
        mRlv = (RecyclerView) inflate.findViewById(R.id.rlv);
        mSmart = (SmartRefreshLayout) inflate.findViewById(R.id.smart);

        courseListEntity = new CourseListEntity();
        mRlv.setLayoutManager(new LinearLayoutManager(getActivity()));
        courseListAdapter = new CourseListAdapter();
        mRlv.setAdapter(courseListAdapter);

        //下拉刷新
        mSmart.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                page = 1;
                loadCourseList();
            }
        });
        mSmart.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
                page++;
                loadCourseList();
            }
        });

    }

    private void loadCourseList() {
        courseListEntity.getCourseList("ENDPOINT_ANDROID", type, page, 10, new BaseEntity.OnBaseResp() {
            @Override
            public void onResp(RespBase resp) {
                if (resp.getResCode() == 0) {
                    final ArrayList<CourseListEntity> data = (ArrayList<CourseListEntity>) resp.getData();
                    if (data != null && data.size() > 0) {

                        if (page == 1) {
                            courseListAdapter.addData(data);
                        } else {
                            courseListAdapter.newaddData(data);
                        }
                    }

                    courseListAdapter.setOnItemListener(new CourseListAdapter.OnItemListener() {
                        @Override
                        public void onlick(View v, int position) {
                            if (courseListAdapter.mList.get(position).getShowType().equals("直播")) {
                                Intent intent = new Intent(getContext(), LiveDetailsActivity.class);
                                intent.putExtra("id", courseListAdapter.mList.get(position).getId());
                                getActivity().startActivity(intent);
                            } else {
                                Intent intent = new Intent(getContext(), OnlineDetailsActivity.class);
                                intent.putExtra("id", courseListAdapter.mList.get(position).getId());
                                getActivity().startActivity(intent);
                            }
                        }
                    });
                    if (mSmart.isRefreshing()) {
                        mSmart.finishRefresh();
                    }
                    if (mSmart.isLoading()) {
                        mSmart.finishLoadMore();
                    }
                }
            }
        });
    }
}
