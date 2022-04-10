package com.enetedu.hep.my;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.enetedu.hep.R;
import com.enetedu.hep.base.BaseActivityPro;
import com.enetedu.hep.config.UserInfoSharePreference;
import com.enetedu.hep.http.RespBase;
import com.enetedu.hep.http.entity.BaseEntity;
import com.enetedu.hep.http.entity.MyCertificateEntity;
import com.enetedu.hep.http.entity.UserInfo;
import com.enetedu.hep.my.adapter.MyCertificateAdapter;
import com.enetedu.hep.utils.SimpleToolbar;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;

public class MyCertificateActivity extends BaseActivityPro {

    /**
     * 返回
     */
    private TextView mTxtLeftTitle;
    /**
     * 我的证书
     */
    private TextView mTxtMainTitle;
    private SimpleToolbar mSimpleToolbar;
    private RecyclerView mRlv;
    private MyCertificateAdapter myCertificateAdapter;
    private UserInfo userInfo;
    private int page = 1;
    private SmartRefreshLayout mSmart;
    private MyCertificateEntity myCertificateEntity;
    private static final String TAG = "MyCertificateActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_certificate);
        initView();
        loadMyCertificate();
    }

    private void initView() {
        mTxtLeftTitle = (TextView) findViewById(R.id.txt_left_title);
        mTxtMainTitle = (TextView) findViewById(R.id.txt_main_title);
        mSimpleToolbar = (SimpleToolbar) findViewById(R.id.simple_toolbar);
        mRlv = (RecyclerView) findViewById(R.id.rlv);
        mSmart = (SmartRefreshLayout) findViewById(R.id.smart);

        userInfo = UserInfoSharePreference.getIns().get(this);
        myCertificateEntity = new MyCertificateEntity();
        mRlv.setLayoutManager(new LinearLayoutManager(this));
        myCertificateAdapter = new MyCertificateAdapter();
        mRlv.setAdapter(myCertificateAdapter);

        mTxtLeftTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyCertificateActivity.this.finish();
            }
        });

        //下拉刷新
        mSmart.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                page = 1;
                loadMyCertificate();
            }
        });
        mSmart.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
                page++;
                loadMyCertificate();
            }
        });
    }

    private void loadMyCertificate() {
        myCertificateEntity.getMyCertificate(userInfo.getUserToken(), userInfo.getUserId(), page, 10, new BaseEntity.OnBaseResp() {
            @Override
            public void onResp(RespBase resp) {

                if (resp.getResCode() == 0) {
                    ArrayList<MyCertificateEntity> data = (ArrayList<MyCertificateEntity>) resp.getData();
                    if (data != null && data.size() > 0) {
                        if (page == 1) {
                            myCertificateAdapter.addData(data);
                        } else {
                            myCertificateAdapter.newaddData(data);
                        }
                        
                        myCertificateAdapter.setOnItemListener(new MyCertificateAdapter.OnItemListener() {
                            @Override
                            public void onlick(View v, int position) {
                                Toast.makeText(MyCertificateActivity.this, "请在个人电脑上下载证书!", Toast.LENGTH_SHORT).show();
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
