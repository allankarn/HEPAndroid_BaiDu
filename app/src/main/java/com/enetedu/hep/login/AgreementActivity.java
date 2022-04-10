package com.enetedu.hep.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import com.enetedu.hep.R;

public class AgreementActivity extends AppCompatActivity {
    private String strUrl;
    private WebSettings settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agreement);


        // 通过该接口可以控制隐私权限策略的数据采集，true表示可以采集，false表示不可以采集，请在Application里优先调用
        // 采集这些数据可以帮助App运营人员更好的监控App的使用情况，
        // 建议有用户隐私策略弹窗的App，用户未同意前设置false,同意之后设置true
       // StatService.setAuthorizedState(getApplicationContext(), false);


        WebView webView_showHtml = findViewById(R.id.webview);
        TextView tv_yes = findViewById(R.id.tv_yes);
        TextView tv_no = findViewById(R.id.tv_no);
        //http://mark1.app.enetedu.com/aitea/common/notice
        strUrl = "https://wxcs.enetedu.com/index.php/Index/gonggaoapp";

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
            webView_showHtml.getSettings().setAllowUniversalAccessFromFileURLs(true);
        settings = webView_showHtml.getSettings();
        settings.setDomStorageEnabled(true);
        settings.setAppCacheMaxSize(1024 * 1024 * 8);//设置缓冲大小,8M
        String appCacheDir = this.getDir("cache", Context.MODE_PRIVATE).getPath();
        settings.setJavaScriptEnabled(true);
        settings.setAppCachePath(appCacheDir);
        settings.setAllowFileAccess(true);
        settings.setAppCacheEnabled(true);
        settings.setCacheMode(WebSettings.LOAD_DEFAULT);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        webView_showHtml.loadUrl(strUrl);

        tv_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // StatService.setAuthorizedState(getApplicationContext(), true);
                SharedPreferences shared = getSharedPreferences("is", MODE_PRIVATE);
                SharedPreferences.Editor editor = shared.edit();
                editor.putBoolean("isfer", false);
                editor.commit();
                Intent intent = new Intent(AgreementActivity.this, LoginActivity.class);
                startActivity(intent);

                finish();
            }
        });
        tv_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AgreementActivity.this.finish();
            }
        });
    }
}
