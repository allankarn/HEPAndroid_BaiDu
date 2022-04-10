package com.enetedu.hep.study;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.enetedu.hep.R;
import com.enetedu.hep.config.UserInfoSharePreference;
import com.enetedu.hep.http.RespBase;
import com.enetedu.hep.http.entity.BaseEntity;
import com.enetedu.hep.http.entity.HomeWorkEdit3Entity;
import com.enetedu.hep.http.entity.HomeWorkEditEntity;
import com.enetedu.hep.http.entity.UserInfo;
import com.enetedu.hep.utils.SimpleToolbar;

public class JobActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 返回
     */
    private TextView mTxtLeftTitle;
    /**
     * 作业
     */
    private TextView mTxtMainTitle;
    private SimpleToolbar mSimpleToolbar;
    private TextView mExTvJob;
    /**
     * 查看全部
     */
    private Button mBtnExpand;
    /**
     * 请输入作业标题
     */
    private EditText mEdTitle;
    /**
     * 请输入正文
     */
    private EditText mEdJob;
    private HomeWorkEditEntity homeWorkEditEntity;
    private UserInfo userInfo;
    private int courseid;
    private static final String TAG = "JobActivity";
    private int id;

    private HomeWorkEdit3Entity homeWorkEdit3Entity;
    private String coursetype;
    /**
     * 提交
     */
    private TextView mTvTijiao;
    private int courseid1;
    private HomeWorkEditEntity homeWorkEditEntity1;
    private HomeWorkEdit3Entity homeWorkEdit3Entity1;
    // private ExpandableTextView mExpandTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job);

        Intent intent = getIntent();
        courseid = intent.getIntExtra("courseid", 0);

        coursetype = intent.getStringExtra("coursetype");
        courseid1 = intent.getIntExtra("courseid1", 0);
        id = intent.getIntExtra("id", 0);
        initView();
        Log.d(TAG, "coursetype: " + coursetype);

        Log.d(TAG, "courseid: ---------" + courseid);
        if (coursetype.equals("1")) {
            loadHomeWorkEdit4();
        } else if (coursetype.equals("2")) {
            loadHomeWorkEdit3();
        }
    }

    private void initView() {
        mTxtLeftTitle = (TextView) findViewById(R.id.txt_left_title);
        mTxtMainTitle = (TextView) findViewById(R.id.txt_main_title);
        mSimpleToolbar = (SimpleToolbar) findViewById(R.id.simple_toolbar);
        mExTvJob = (TextView) findViewById(R.id.ex_tv_job);
        mBtnExpand = (Button) findViewById(R.id.btn_expand);

        mEdTitle = (EditText) findViewById(R.id.ed_title);
        mEdJob = (EditText) findViewById(R.id.ed_job);
        mTvTijiao = (TextView) findViewById(R.id.tv_tijiao);
        mTvTijiao.setOnClickListener(this);

        homeWorkEditEntity = new HomeWorkEditEntity();
        homeWorkEdit3Entity = new HomeWorkEdit3Entity();
        userInfo = UserInfoSharePreference.getIns().get(this);

        mTxtLeftTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JobActivity.this.finish();
            }
        });
        //  mExpandTextView = (ExpandableTextView) findViewById(R.id.expand_text_view);
    }

    private void loadHomeWorkEdit3() {
        homeWorkEdit3Entity.getHomeWorkEdit3(userInfo.getUserToken(), userInfo.getUserId(), courseid1, new BaseEntity.OnBaseResp() {
            @Override
            public void onResp(RespBase resp) {
                Log.d(TAG, "onResp: " + resp.getResCode());
                if (resp.getResCode() == -99999) {
                    homeWorkEdit3Entity1 = (HomeWorkEdit3Entity) resp.getData();
                    if (homeWorkEdit3Entity1 != null) {
                        mExTvJob.setText(homeWorkEdit3Entity1.getTraing_notice());
                        //mExpandTextView.setText(homeWorkEdit3Entity1.getTraing_notice());
                        mEdTitle.setText(homeWorkEdit3Entity1.getPapermodelEntity().getTitle());
                        mEdJob.setText(homeWorkEdit3Entity1.getPapermodelEntity().getContent());
                    } else {
                        Toast.makeText(JobActivity.this, "请到主网站学习！", Toast.LENGTH_SHORT).show();
                        JobActivity.this.finish();
                    }
                }
            }
        });
    }

    private void loadHomeWorkEditSave3() {
        homeWorkEdit3Entity.getHomeWorkEditSave3(userInfo.getUserToken(), userInfo.getUserId(), courseid1, mEdTitle.getText().toString(), mEdJob.getText().toString(), homeWorkEdit3Entity1.getPapermodelEntity().getId(), new BaseEntity.OnBaseResp() {
            @Override
            public void onResp(RespBase resp) {
                if (resp.getResCode() == 0) {
                    Toast.makeText(JobActivity.this, "提交成功！", Toast.LENGTH_SHORT).show();
                    JobActivity.this.finish();
                }
            }
        });
    }

    private void loadHomeWorkEdit4() {
        homeWorkEditEntity.getHomeWorkEdit4(userInfo.getUserToken(), userInfo.getUserId(), courseid, new BaseEntity.OnBaseResp() {
            @Override
            public void onResp(RespBase resp) {
                Log.d(TAG, "onResp: " + resp.getResCode());
                if (resp.getResCode() == -99999) {
                    homeWorkEditEntity1 = (HomeWorkEditEntity) resp.getData();
                    if (homeWorkEditEntity1 != null) {
                        //mExpandTextView.setText(homeWorkEditEntity1.getTitle());
                        mExTvJob.setText(homeWorkEditEntity1.getTitle());
                        mEdTitle.setText(homeWorkEditEntity1.getHOMEWORK_TITLE());
                        mEdJob.setText(homeWorkEditEntity1.getHOMEWORK_CONTENT());
                    } else {
                        Toast.makeText(JobActivity.this, "请到主网站学习！", Toast.LENGTH_SHORT).show();
                        JobActivity.this.finish();
                    }
                }
            }
        });
    }

    private void loadHomeWorkEditSave4() {
        homeWorkEditEntity.getHomeWorkEditSave4(userInfo.getUserToken(), userInfo.getUserId(), courseid, mEdTitle.getText().toString(), mEdJob.getText().toString(), homeWorkEditEntity1.getId(), new BaseEntity.OnBaseResp() {
            @Override
            public void onResp(RespBase resp) {
                if (resp.getResCode() == 0) {
                    Toast.makeText(JobActivity.this, "提交成功！", Toast.LENGTH_SHORT).show();
                    JobActivity.this.finish();
                }
            }
        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.tv_tijiao:
                if (coursetype.equals("1")) {
                    loadHomeWorkEditSave4();
                } else if (coursetype.equals("2")) {
                    loadHomeWorkEditSave3();
                }

                break;
        }
    }
}