package com.enetedu.hep.study;

import android.content.Intent;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.enetedu.hep.R;
import com.enetedu.hep.base.BaseActivityPro;
import com.enetedu.hep.config.UserInfoSharePreference;
import com.enetedu.hep.http.RespBase;
import com.enetedu.hep.http.entity.BaseEntity;
import com.enetedu.hep.http.entity.StudyLinkEntity;
import com.enetedu.hep.http.entity.UserInfo;
import com.enetedu.hep.my.WebViewActivity;
import com.enetedu.hep.study.adapter.StudyLinkAdapter;
import com.enetedu.hep.utils.Constant;
import com.enetedu.hep.utils.SimpleToolbar;
import com.enetedu.hep.utils.TwoBallRotationProgressBar;

import java.util.ArrayList;

public class StudyLinkActivity extends BaseActivityPro {
    private static final String TAG = "StudyLinkActivity";
    /**
     * 返回
     */
    private TextView mTxtLeftTitle;
    /**
     * 我的课单
     */
    private TextView mTxtMainTitle;
    private SimpleToolbar mSimpleToolbar;
    private RecyclerView mRlv;
    private StudyLinkAdapter studyLinkAdapter;
    private StudyLinkEntity studyLinkEntity;
    private UserInfo userInfo;
    private String type;
    private int id;
    private String name;
    private int courseid;
    private TwoBallRotationProgressBar mLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_link);

        Intent intent = getIntent();
        type = intent.getStringExtra("type");
        id = intent.getIntExtra("id", 0);
        name = intent.getStringExtra("name");
        courseid = intent.getIntExtra("courseid", 0);
        Log.d(TAG, "courseid: " + courseid);


        initView();
        loadStudyLink();
        Log.d(TAG, "onCreate:------------ " + type);

    }

    private void initView() {
        mTxtLeftTitle = (TextView) findViewById(R.id.txt_left_title);
        mTxtMainTitle = (TextView) findViewById(R.id.txt_main_title);
        mSimpleToolbar = (SimpleToolbar) findViewById(R.id.simple_toolbar);
        mRlv = (RecyclerView) findViewById(R.id.rlv);
        mLoading = (TwoBallRotationProgressBar) findViewById(R.id.loading);
        mTxtMainTitle.setText(name);
        mTxtLeftTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StudyLinkActivity.this.finish();
            }
        });

        studyLinkEntity = new StudyLinkEntity();
        userInfo = UserInfoSharePreference.getIns().get(this);
        mRlv.setLayoutManager(new LinearLayoutManager(this));
        studyLinkAdapter = new StudyLinkAdapter();
        mRlv.setAdapter(studyLinkAdapter);

    }

    private void loadStudyLink() {
        mLoading.startAnimator();
        studyLinkEntity.getStudyLink(userInfo.getUserToken(), userInfo.getUserId(), type, id, new BaseEntity.OnBaseResp() {
            @Override
            public void onResp(RespBase resp) {
                if (resp.getResCode() == 0) {
                    ArrayList<StudyLinkEntity> data = (ArrayList<StudyLinkEntity>) resp.getData();

                    if (data != null && data.size() > 0) {
                        studyLinkAdapter.addData(data);

                        studyLinkAdapter.setOnItemListener(new StudyLinkAdapter.OnItemListener() {
                            @Override
                            public void onlick(View v, int position) {

                                //作业
                                if (studyLinkAdapter.mList.get(position).getName().equals("提交作业")) {
                                    Intent intent = new Intent(StudyLinkActivity.this, JobActivity.class);
                                    intent.putExtra("coursetype", type);
                                    intent.putExtra("courseid", id);
                                    intent.putExtra("courseid1", courseid);
                                    intent.putExtra("id", studyLinkAdapter.mList.get(position).getId());

                                    startActivity(intent);
                                } else
                                    //证书打印
                                    if (studyLinkAdapter.mList.get(position).getName().equals("电子证书") && type.equals("1")) {

                                        loadPrintZSByChoice();
                                    } else if (studyLinkAdapter.mList.get(position).getName().equals("电子证书") && type.equals("2")) {

                                        loadPrintZSByNetpay();
                                    } else if (studyLinkAdapter.mList.get(position).getName().equals("视频学习")) {
                                        Intent intent = new Intent(StudyLinkActivity.this, StudyMyCourseActivity.class);
                                        intent.putExtra("courseid", courseid);
                                        intent.putExtra("id", id);
                                        intent.putExtra("name", name);
                                        startActivity(intent);
                                    } else if (studyLinkAdapter.mList.get(position).getName().equals("登录视频课堂")) {

                                        loadCourseJH();
                                    } else if (studyLinkAdapter.mList.get(position).getName().equals("直播回放")) {

                                        loadCourseJH();
                                    }
                            }
                        });
                    }
                }
                mLoading.stopAnimator();
            }
        });
    }
    //周刊论文

    //登录视频课堂 直播回放
    private void loadCourseJH() {
        studyLinkEntity.getCourseJH(userInfo.getUserToken(), userInfo.getUserId(), courseid, new BaseEntity.OnBaseResp() {
            @Override
            public void onResp(RespBase resp) {
                if (resp.getResCode() > 0) {
                    Intent intent = new Intent(StudyLinkActivity.this, WebViewActivity.class);
                    intent.putExtra(Constant.INTENT_KEY_VALUE, resp.getDesc());
                    intent.putExtra("title", "直播回放");
                    startActivity(intent);
                } else {
                    Toast.makeText(StudyLinkActivity.this, resp.getDesc(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    //打印证书
    private void loadPrintZSByNetpay() {
        studyLinkEntity.getPrintZSByNetpay(userInfo.getUserToken(), userInfo.getUserId(), courseid, new BaseEntity.OnBaseResp() {
            @Override
            public void onResp(RespBase resp) {

                Toast.makeText(StudyLinkActivity.this, resp.getDesc().toString(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void loadPrintZSByChoice() {
        studyLinkEntity.getPrintZSByChoice(userInfo.getUserToken(), userInfo.getUserId(), id, new BaseEntity.OnBaseResp() {
            @Override
            public void onResp(RespBase resp) {
                Toast.makeText(StudyLinkActivity.this, resp.getDesc().toString(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}
