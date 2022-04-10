package com.enetedu.hep.news;


import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.enetedu.hep.R;
import com.enetedu.hep.base.MyBaseFragment;
import com.enetedu.hep.http.RespBase;
import com.enetedu.hep.http.entity.BaseEntity;
import com.enetedu.hep.http.entity.InfoListEntity;
import com.enetedu.hep.news.adapter.NewsVpAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsVpFragment extends MyBaseFragment {


    private RecyclerView mRlv;
    private View view;
    private SmartRefreshLayout mSmart;
    private NewsVpAdapter newsVpAdapter;
    private InfoListEntity infoListEntity;
    private String id;
    private int i;
    private int page = 1;
    private TextView tv_jiazai;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View inflate = inflater.inflate(R.layout.fragment_news_vp, container, false);

        Bundle arguments = getArguments();
        if (arguments != null) {
            id = arguments.getString("id");
        }
        i = Integer.valueOf(id).intValue();

        initView(inflate);
        loadInfoList();
        return inflate;

    }

    private void initView(View inflate) {
        mRlv = (RecyclerView) inflate.findViewById(R.id.rlv);
        mSmart = (SmartRefreshLayout) inflate.findViewById(R.id.smart);
        tv_jiazai = (TextView) inflate.findViewById(R.id.tv_jiazai);
        infoListEntity = new InfoListEntity();
        mRlv.setLayoutManager(new LinearLayoutManager(getActivity()));
        newsVpAdapter = new NewsVpAdapter();
        mRlv.setAdapter(newsVpAdapter);

        if (i != 1) {

            //下拉刷新
            mSmart.setOnRefreshListener(new OnRefreshListener() {
                @Override
                public void onRefresh(RefreshLayout refreshLayout) {
                    page = 1;
                    loadInfoList();
                }
            });
            mSmart.setOnLoadMoreListener(new OnLoadMoreListener() {
                @Override
                public void onLoadMore(RefreshLayout refreshLayout) {
                    page++;
                    loadInfoList();
                }
            });
        } else {
            tv_jiazai.setVisibility(View.GONE);
        }


    }

    private void loadInfoList() {

        infoListEntity.getInfoList(i, "0", page, 10, new BaseEntity.OnBaseResp() {
            @Override
            public void onResp(RespBase resp) {
                if (resp.getResCode() == 0) {
                    final ArrayList<InfoListEntity> data = (ArrayList<InfoListEntity>) resp.getData();
                    if (data != null && data.size() > 0) {
                        if (page == 1) {
                            newsVpAdapter.addData(data);
                        } else {
                            newsVpAdapter.newaddData(data);
                        }
                        newsVpAdapter.setOnItemListener(new NewsVpAdapter.OnItemListener() {
                            @Override
                            public void onlick(View v, int position) {
                                Intent intent = new Intent(getActivity(), NewsDetailsActivity.class);
                                intent.putExtra("content", data.get(position).getCONTENT());
                                intent.putExtra("time", data.get(position).getINPUT_TIME());
                                intent.putExtra("title", data.get(position).getTITLE());
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
                }

            }
        });
    }
}
