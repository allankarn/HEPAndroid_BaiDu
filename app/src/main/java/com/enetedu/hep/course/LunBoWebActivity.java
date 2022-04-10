package com.enetedu.hep.course;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.enetedu.hep.R;
import com.enetedu.hep.base.BaseActivityPro;

public class LunBoWebActivity extends BaseActivityPro {

    private WebView mWebview;
    // private String strUrl;
    private WebSettings settings;
    private String url;
    private static final String TAG = "LunBoWebActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lun_bo_web);
        Intent intent = getIntent();
        url = intent.getStringExtra("url");
        initView();

        Log.d(TAG, "onCreate: " + url);
    }

    private void initView() {
        mWebview = (WebView) findViewById(R.id.webview);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
            mWebview.getSettings().setAllowUniversalAccessFromFileURLs(true);
        settings = mWebview.getSettings();
        settings.setDomStorageEnabled(true);
        settings.setAppCacheMaxSize(1024 * 1024 * 8);//设置缓冲大小,8M
        String appCacheDir = this.getDir("cache", Context.MODE_PRIVATE).getPath();
        settings.setJavaScriptEnabled(true);
        settings.setAppCachePath(appCacheDir);
        settings.setAllowFileAccess(true);
        settings.setAppCacheEnabled(true);
        settings.setCacheMode(WebSettings.LOAD_DEFAULT);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        mWebview.loadUrl(url);
    }
}
