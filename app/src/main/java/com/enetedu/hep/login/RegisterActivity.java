package com.enetedu.hep.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.CheckBox;
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
import com.enetedu.hep.my.WebViewActivity;
import com.enetedu.hep.utils.Constant;


public class RegisterActivity extends BaseActivityPro implements View.OnClickListener {

    /**
     * 请输入真实姓名
     */
    private EditText mManageEditStudentUser;
    /**
     * 请输入邮箱
     */
    private EditText mEdMail;
    /**
     * 请输入密码
     */
    private EditText mEdPwd;
    /**
     * 请输入密码
     */
    private EditText mEdConfirmPwd;
    /**
     * 请输入手机
     */
    private EditText mEdPhone;
    /**
     * 请输入学校名称
     */
    private EditText mEdSchool;
    private CheckBox mCbXieyi;
    private CheckBox mCbGonggao;
    private CheckBox mCbChengnuo;
    private LinearLayout mLlZhuce;
    private UserInfo userInfo;
    private ImageView mIvFanhui;
    /**
     * 用户协议
     */
    private TextView mTvXieyi;
    private TextView tv_yinsi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
    }

    private void initView() {
        mManageEditStudentUser = (EditText) findViewById(R.id.manage_editStudent_user);
        mEdMail = (EditText) findViewById(R.id.ed_mail);
        mEdPwd = (EditText) findViewById(R.id.ed_pwd);
        mEdConfirmPwd = (EditText) findViewById(R.id.ed_confirm_pwd);
        mEdPhone = (EditText) findViewById(R.id.ed_phone);
        mEdSchool = (EditText) findViewById(R.id.ed_school);
        mCbXieyi = (CheckBox) findViewById(R.id.cb_xieyi);
        mCbGonggao = (CheckBox) findViewById(R.id.cb_gonggao);
        mCbChengnuo = (CheckBox) findViewById(R.id.cb_chengnuo);
        mLlZhuce = (LinearLayout) findViewById(R.id.ll_zhuce);
        mLlZhuce.setOnClickListener(this);
        mIvFanhui = (ImageView) findViewById(R.id.iv_fanhui);
        mIvFanhui.setOnClickListener(this);
        mTvXieyi = (TextView) findViewById(R.id.tv_xieyi);
        mTvXieyi.setOnClickListener(this);
        tv_yinsi = (TextView) findViewById(R.id.tv_yinsi);

        userInfo = new UserInfo();
        mEdPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
        mEdConfirmPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());

    }

    private void loadUserRegister() {

        userInfo.getUserRegister("ENDPOINT_ANDROID", mManageEditStudentUser.getText().toString(), mEdPwd.getText().toString(), mEdPhone.getText().toString(),
                mEdSchool.getText().toString(), "UserRealName", new BaseEntity.OnBaseResp() {
                    @Override
                    public void onResp(RespBase resp) {
                        if (resp.getResCode() == 0) {
                            Toast.makeText(RegisterActivity.this, "注册成功！", Toast.LENGTH_SHORT).show();
                            RegisterActivity.this.finish();
                        } else {
                            Toast.makeText(RegisterActivity.this, resp.getDesc(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.ll_zhuce:
                if (!mCbXieyi.isChecked()) {
                    Toast.makeText(this, "请阅读并同意 《用户协议》", Toast.LENGTH_SHORT).show();
                } else if (!mCbGonggao.isChecked()) {
                    Toast.makeText(this, "请阅读并同意 《用户信息使用公告》", Toast.LENGTH_SHORT).show();
                } else if (!mCbChengnuo.isChecked()) {
                    Toast.makeText(this, "请同意承诺！", Toast.LENGTH_SHORT).show();
                } else {
                    loadUserRegister();
                }

                break;
            case R.id.iv_fanhui:

                RegisterActivity.this.finish();
                break;
            case R.id.tv_xieyi:

                Intent intent = new Intent(RegisterActivity.this, WebViewActivity.class);
                intent.putExtra(Constant.INTENT_KEY_VALUE, "https://wxcs.enetedu.com/index.php/Index/gonggaoapp");//http://app.tea.chinabett.com/common/notice
                intent.putExtra("title", "隐私协议");
                startActivity(intent);
                break;
            case R.id.tv_yinsi:
                Intent intent2 = new Intent(RegisterActivity.this, WebViewActivity.class);
                intent2.putExtra(Constant.INTENT_KEY_VALUE, "https://wxcs.enetedu.com/index.php/Index/gonggaoapp");//http://app.tea.chinabett.com/common/notice
                intent2.putExtra("title", "隐私协议");
                startActivity(intent2);
                break;
        }
    }
}
