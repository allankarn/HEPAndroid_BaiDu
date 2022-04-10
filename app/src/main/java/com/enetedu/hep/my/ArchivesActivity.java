package com.enetedu.hep.my;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.enetedu.hep.R;
import com.enetedu.hep.base.BaseActivityPro;
import com.enetedu.hep.config.UserInfoSharePreference;
import com.enetedu.hep.http.RespBase;
import com.enetedu.hep.http.entity.ArchivesEntity;
import com.enetedu.hep.http.entity.BaseEntity;
import com.enetedu.hep.http.entity.UserInfo;
import com.enetedu.hep.my.adapter.ArchivesAdapter;
import com.enetedu.hep.utils.SimpleToolbar;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;

public class ArchivesActivity extends BaseActivityPro {

    /**
     * 返回
     */
    private TextView mTxtLeftTitle;
    /**
     * 我的学分
     */
    private TextView mTxtMainTitle;
    private SimpleToolbar mSimpleToolbar;
    private RecyclerView mRlv;
    private SmartRefreshLayout mSmart;
    private UserInfo userInfo;
    private ArchivesAdapter archivesAdapter;
    private ArchivesEntity archivesEntity;
    private int page = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_archives);
        initView();
        loadArchives();
    }

    private void initView() {
        mTxtLeftTitle = (TextView) findViewById(R.id.txt_left_title);
        mTxtMainTitle = (TextView) findViewById(R.id.txt_main_title);
        mSimpleToolbar = (SimpleToolbar) findViewById(R.id.simple_toolbar);
        mRlv = (RecyclerView) findViewById(R.id.rlv);
        mSmart = (SmartRefreshLayout) findViewById(R.id.smart);

        userInfo = UserInfoSharePreference.getIns().get(this);
        archivesEntity = new ArchivesEntity();
        mRlv.setLayoutManager(new LinearLayoutManager(this));
        archivesAdapter = new ArchivesAdapter();
        mRlv.setAdapter(archivesAdapter);

        mTxtLeftTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArchivesActivity.this.finish();
            }
        });

        //下拉刷新
        mSmart.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                page = 1;
                loadArchives();
            }
        });
        mSmart.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
                page++;
                loadArchives();
            }
        });
    }

    private void loadArchives() {
        archivesEntity.getArchives(userInfo.getUserToken(), userInfo.getUserId(), page, 10, new BaseEntity.OnBaseResp() {
            @Override
            public void onResp(RespBase resp) {
                if (resp.getResCode() == 0) {
                    ArrayList<ArchivesEntity> data = (ArrayList<ArchivesEntity>) resp.getData();
                    if (data != null && data.size() > 0) {
                        if (page == 1) {
                            archivesAdapter.addData(data);
                        } else {
                            archivesAdapter.newaddData(data);
                        }

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
