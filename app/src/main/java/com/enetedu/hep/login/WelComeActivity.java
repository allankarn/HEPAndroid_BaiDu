package com.enetedu.hep.login;

import android.content.Intent;
import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.enetedu.hep.R;
import com.enetedu.hep.base.BaseActivityPro;
import com.enetedu.hep.config.UserInfoSharePreference;
import com.enetedu.hep.http.entity.UserInfo;

public class WelComeActivity extends BaseActivityPro {
    private UserInfo userInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wel_come);
        userInfo = UserInfoSharePreference.getIns().get(this);
        date();
    }

    private void date() {
        SharedPreferences shared = getSharedPreferences("is", MODE_PRIVATE);
        boolean isfer = shared.getBoolean("isfer", true);

        if (isfer) {
            //第一次进入跳转
            Intent in = new Intent(WelComeActivity.this, AgreementActivity.class);
            startActivity(in);
            finish();

        } else {
            //第二次进入跳转
            Intent in = new Intent(WelComeActivity.this, LoginActivity.class);
            startActivity(in);
            finish();
        }
    }
}
