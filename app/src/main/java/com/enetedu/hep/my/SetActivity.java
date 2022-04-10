package com.enetedu.hep.my;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.enetedu.hep.R;
import com.enetedu.hep.base.BaseActivityPro;
import com.enetedu.hep.config.UserInfoSharePreference;
import com.enetedu.hep.http.entity.UserInfo;
import com.enetedu.hep.login.LoginActivity;
import com.enetedu.hep.utils.BaseDialog;
import com.enetedu.hep.utils.Constant;

public class SetActivity extends BaseActivityPro implements View.OnClickListener {

    private RelativeLayout mRlUser;
    private RelativeLayout mRlPwd;
    private RelativeLayout mRlZhuxiao;
    private BaseDialog baseDialog;
    private UserInfo userInfo;
    /**
     * 返回
     */
    private TextView mTxtLeftTitle;
    /**
     * 退出登录
     */
    private TextView mTvOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);
        initView();
    }

    private void initView() {
        mRlUser = (RelativeLayout) findViewById(R.id.rl_user);
        mRlPwd = (RelativeLayout) findViewById(R.id.rl_pwd);
        mRlZhuxiao = (RelativeLayout) findViewById(R.id.rl_zhuxiao);
        mTvOut = (TextView) findViewById(R.id.tv_out);
        mTvOut.setOnClickListener(this);
        mRlUser.setOnClickListener(this);
        mRlPwd.setOnClickListener(this);
        mRlZhuxiao.setOnClickListener(this);
        mTxtLeftTitle = (TextView) findViewById(R.id.txt_left_title);
        mTxtLeftTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SetActivity.this.finish();
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.rl_user:
                Intent intent = new Intent(SetActivity.this, UserEditActivity.class);
                startActivity(intent);
                break;
            case R.id.rl_pwd:
                Intent intent1 = new Intent(SetActivity.this, ChangePwdActivity.class);
                startActivity(intent1);
                break;
            case R.id.rl_zhuxiao:

                Intent intent2 = new Intent(getApplicationContext(), WebViewActivity.class);
                intent2.putExtra(Constant.INTENT_KEY_VALUE, "https://wxcs.enetedu.com/index.php/Index/logout3");//http://app.tea.chinabett.com/common/notice
                intent2.putExtra("title", "用户注销");
                startActivity(intent2);

                break;
            case R.id.tv_out:
                initCountDialog();

                break;
        }
    }

    private void initCountDialog() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.dialog, null);
        Button btn_no = inflate.findViewById(R.id.btn_no);
        Button btn_yes = inflate.findViewById(R.id.btn_yes);
        TextView tv_tishi = inflate.findViewById(R.id.tv_tishi);
        tv_tishi.setText("是否退出当前账号");
        btn_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                baseDialog.dismiss();
            }
        });

        btn_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserInfoSharePreference.getIns().clear(SetActivity.this);

                Intent logoutIntent = new Intent(SetActivity.this, LoginActivity.class);
                logoutIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(logoutIntent);
                baseDialog.dismiss();

            }
        });
        if (baseDialog == null) {
            baseDialog = new BaseDialog(this, inflate, Gravity.CENTER);
        }
        baseDialog.show();
    }
}
