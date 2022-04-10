package com.enetedu.hep.login;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.enetedu.hep.R;
import com.enetedu.hep.base.BaseActivityPro;
import com.enetedu.hep.http.RespBase;
import com.enetedu.hep.http.entity.BaseEntity;
import com.enetedu.hep.http.entity.UserInfo;

//找回密码
public class RetrievePwdActivity extends BaseActivityPro {

    /**
     * 请输入注册时使用的手机号
     */
    private EditText mEdPhone;
    /**
     * 请输入短信验证码
     */
    private EditText mEdYanzheng;
    /**
     * 发送验证码
     */
    private TextView mTvFasong;
    /**
     * 请输入新密码
     */
    private EditText mEdNewpwd;
    /**
     * 确认密码
     */
    private EditText mEdNewpwd2;
    private LinearLayout mLlTijiao;
    private UserInfo userInfo;
    private ImageView mIvFanhui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve_pwd);
        initView();
    }

    private void initView() {
        mEdPhone = (EditText) findViewById(R.id.ed_phone);
        mEdYanzheng = (EditText) findViewById(R.id.ed_yanzheng);
        mTvFasong = (TextView) findViewById(R.id.tv_fasong);
        mEdNewpwd = (EditText) findViewById(R.id.ed_newpwd);
        mEdNewpwd2 = (EditText) findViewById(R.id.ed_newpwd2);
        mLlTijiao = (LinearLayout) findViewById(R.id.ll_tijiao);
        mIvFanhui = (ImageView) findViewById(R.id.iv_fanhui);
        userInfo = new UserInfo();

        mIvFanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RetrievePwdActivity.this.finish();
            }
        });

        mLlTijiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadSMSUpdateLoginPwd();
            }
        });

    }

    private void loadSMSUpdateLoginPwd() {
        userInfo.getSMSUpdateLoginPwd(mEdPhone.getText().toString(), mEdYanzheng.getText().toString(), mEdNewpwd.getText().toString(), mEdNewpwd2.getText().toString(), new BaseEntity.OnBaseResp() {
            @Override
            public void onResp(RespBase resp) {
                if (resp.getResCode() == 0) {
                    Toast.makeText(RetrievePwdActivity.this, resp.getDesc(), Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(RetrievePwdActivity.this, resp.getDesc(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
