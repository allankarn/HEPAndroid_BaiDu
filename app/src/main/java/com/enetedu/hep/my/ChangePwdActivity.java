package com.enetedu.hep.my;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.enetedu.hep.R;
import com.enetedu.hep.config.UserInfoSharePreference;
import com.enetedu.hep.http.RespBase;
import com.enetedu.hep.http.entity.BaseEntity;
import com.enetedu.hep.http.entity.UserInfo;
import com.enetedu.hep.utils.BaseDialog;
import com.enetedu.hep.utils.PwdUtil;

public class ChangePwdActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 请输入旧密码
     */
    private EditText mEtJiu;
    /**
     * 8-16位，至少包含数字/字母
     */
    private EditText mEtNew;
    /**
     * 8-16位，至少包含数字/字母
     */
    private EditText mEtNew2;
    private UserInfo userInfo;
    /**
     * 确定
     */
    private TextView mTvQueding;
    private BaseDialog baseDialog;
    /**
     * 返回
     */
    private TextView mTxtLeftTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_pwd);
        initView();
    }

    private void initView() {
        mEtJiu = (EditText) findViewById(R.id.et_jiu);
        mEtNew = (EditText) findViewById(R.id.et_new);
        mEtNew2 = (EditText) findViewById(R.id.et_new2);
        mTvQueding = (TextView) findViewById(R.id.tv_queding);
        mTvQueding.setOnClickListener(this);

        // userInfo = new UserInfo();
        userInfo = UserInfoSharePreference.getIns().get(this);


        mTxtLeftTitle = (TextView) findViewById(R.id.txt_left_title);
        mTxtLeftTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangePwdActivity.this.finish();
            }
        });
    }

    private void loadPassWordEditSave() {
        userInfo.getPassWordEditSave(userInfo.getUserToken(), userInfo.getUserId(), mEtJiu.getText().toString(), mEtNew.getText().toString(), mEtNew2.getText().toString(), new BaseEntity.OnBaseResp() {
            @Override
            public void onResp(RespBase resp) {
                if (resp.getResCode() == 0) {
                    Toast.makeText(ChangePwdActivity.this, "修改成功！", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ChangePwdActivity.this, resp.getDesc(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    //验证密码格式
    private boolean isPassword(String pwd) {
        if (TextUtils.isEmpty(pwd)) {

            Toast.makeText(ChangePwdActivity.this, "密码不能为空", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (pwd.length() < 8 || pwd.length() > 16) {
            Toast.makeText(ChangePwdActivity.this, "请输入8~16位密码", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (PwdUtil.isNotTrue(pwd)) {
            Toast.makeText(ChangePwdActivity.this, "密码只支持数字和字母,不可含有其他符号", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (PwdUtil.isLetterDigit(pwd)) {
            Toast.makeText(ChangePwdActivity.this, "密码不支持纯数字或纯字母", Toast.LENGTH_SHORT).show();

            return false;
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.tv_queding:
                initCountDialog();
                break;
        }
    }

    private void initCountDialog() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.dialog, null);
        Button btn_no = inflate.findViewById(R.id.btn_no);
        Button btn_yes = inflate.findViewById(R.id.btn_yes);
        TextView tv_tishi = inflate.findViewById(R.id.tv_tishi);
        tv_tishi.setText("是否确认修改密码？");
        btn_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                baseDialog.dismiss();
            }
        });

        btn_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isPassword(mEtNew.getText().toString().toString())) {
                    loadPassWordEditSave();
                    baseDialog.dismiss();
                }
            }
        });
        if (baseDialog == null) {
            baseDialog = new BaseDialog(this, inflate, Gravity.CENTER);
        }
        baseDialog.show();
    }
}
