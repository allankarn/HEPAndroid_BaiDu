package com.enetedu.hep.login;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;

import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



import com.enetedu.hep.MainActivity;
import com.enetedu.hep.R;
import com.enetedu.hep.base.BaseActivityPro;
import com.enetedu.hep.config.MyApp;
import com.enetedu.hep.config.UserInfoSharePreference;
import com.enetedu.hep.http.RespBase;
import com.enetedu.hep.http.entity.BaseEntity;
import com.enetedu.hep.http.entity.UserInfo;
import com.enetedu.hep.my.WebViewActivity;
import com.enetedu.hep.utils.Constant;
import com.enetedu.hep.utils.GenseeToast;
import com.enetedu.hep.utils.HepDateUtil;
import com.enetedu.hep.utils.HepStringUtil;
import com.enetedu.hep.utils.MD5Utils;
import com.enetedu.hep.utils.SelfUtils;
import com.enetedu.hep.utils.StringUtils;
import com.tencent.mm.opensdk.modelmsg.SendAuth;

import java.util.Date;

public class LoginActivity extends  BaseActivityPro implements View.OnClickListener {

    /**
     * 请输入用户名
     */
    private EditText mEdName;
    /**
     * 请输入密码
     */
    private EditText mEdPwd;
    /**
     * 登录
     */
    private TextView mLoginBtn;
    /**
     * 注册
     */
    private TextView mRegisterBtn;
    /**
     * 找回密码?
     */
    private TextView mFindPwd;
    private UserInfo userInfo;
    private static final String TAG = "LoginActivity";
    //private boolean dianji = false;
    /**
     * 《隐私协议》
     */
    private TextView mTvXieyi;
    //private ImageView mCb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        initView();
        if (UserInfoSharePreference.getIns().get(this) != null) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        boolean rooted = SelfUtils.isRooted();
        Log.d(TAG, "onCreate: " + rooted);

    }

    private void initView() {

       TextView wx=findViewById(R.id.tv_wx);
        wx.setOnClickListener(this);
        mEdName = (EditText) findViewById(R.id.ed_name);
        mEdName.setOnClickListener(this);
        mEdPwd = (EditText) findViewById(R.id.ed_pwd);
        mEdPwd.setOnClickListener(this);
        mLoginBtn = (TextView) findViewById(R.id.login_btn);
        mLoginBtn.setOnClickListener(this);
        mRegisterBtn = (TextView) findViewById(R.id.register_btn);
        mRegisterBtn.setOnClickListener(this);
        mFindPwd = (TextView) findViewById(R.id.find_pwd);
        mFindPwd.setOnClickListener(this);
        mTvXieyi = (TextView) findViewById(R.id.tv_xieyi);
        mTvXieyi.setOnClickListener(this);
        //  mCb = (ImageView) findViewById(R.id.cb_);
        userInfo = new UserInfo();
        mEdPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());

      /*  mCb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dianji == false) {
                    dianji = true;
                    mCb.setBackgroundResource(R.mipmap.xuanzhong);
                } else {
                    dianji = false;
                    mCb.setBackgroundResource(R.mipmap.weixuanzhong);
                }
            }
        });*/
    }

    private int doLogin() {
        String strName = mEdName.getText().toString();

        if (StringUtils.isEmpty(strName) || !HepStringUtil.isValidEmail(strName)) {

            return R.string.input_email_please;
        }

        if (strName.length() < HepStringUtil.MIN_LEN_LOGINNAME) {
            GenseeToast.showCenter(
                    this,
                    getString(R.string.input_len_err_loginname,
                            HepStringUtil.MIN_LEN_LOGINNAME),
                    GenseeToast.LENGTH_SHORT);
            return 0;
        }

        String strPwd = mEdPwd.getText().toString();
        if (HepStringUtil.isEmpty(strPwd)) {
            return R.string.input_pwd_please;
        }
        if (strPwd.length() < HepStringUtil.MIN_LEN_PWD) {
            GenseeToast.showCenter(
                    this,
                    getString(R.string.input_len_err_pwd,
                            HepStringUtil.MIN_LEN_PWD), GenseeToast.LENGTH_SHORT);

            return 0;
        }
        showWaitingDialog();
        //MD5密码加密
        String md5String = MD5Utils.getMD5String(strPwd);
        String substring = md5String.substring(8, 24);
        userInfo.getUserLogin("ENDPOINT_ANDROID", strName, substring, HepDateUtil.dateToStrLong(new Date()), "1", new BaseEntity.OnBaseResp() {
            @Override
            public void onResp(RespBase resp) {
                if (resp.getResCode() == 0) {
                    UserInfo data = (UserInfo) resp.getData();
                    UserInfoSharePreference.getIns().save(data, LoginActivity.this);
                    dismissProgressDialog();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, resp.getDesc(), Toast.LENGTH_SHORT).show();
                    dismissProgressDialog();
                }
            }
        });
        return 0;
    }

    private void showWaitingDialog() {
        showProgressDialog(getString(R.string.wait_latter));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.ed_name:
                break;
            case R.id.ed_pwd:
                break;
            case R.id.login_btn:
              /*  if (dianji == false) {
                    Toast.makeText(this, "请阅读并同意隐私协议！", Toast.LENGTH_SHORT).show();
                } else {*/
                int ret = doLogin();
                if (ret > 0) {
                    GenseeToast.showCenter(this, ret, GenseeToast.LENGTH_SHORT);
                }
                //  }

                break;
            case R.id.register_btn:
                Intent intent1 = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent1);
                break;
            case R.id.find_pwd:

                Intent intent = new Intent(LoginActivity.this, RetrievePwdActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_xieyi:
                Intent intent3 = new Intent(LoginActivity.this, WebViewActivity.class);
                intent3.putExtra(Constant.INTENT_KEY_VALUE, "https://wxcs.enetedu.com/index.php/Index/gonggaoapp");//http://app.tea.chinabett.com/common/notice
                intent3.putExtra("title", "隐私协议");
                startActivity(intent3);
                break;
            case R.id.tv_wx:

                /**
                 * 5.发送登录请求
                 */
                final SendAuth.Req req = new SendAuth.Req();
                req.scope = "snsapi_userinfo";
                req.state = "enetedu";
                MyApp.wx_api.sendReq(req);
                Log.i( TAG, "onClick: " +"发送登录请求");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mEdPwd.setText("");
    }
}
