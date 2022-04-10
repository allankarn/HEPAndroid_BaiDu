package com.enetedu.hep.course;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.enetedu.hep.R;
import com.enetedu.hep.utils.Constant;
import com.enetedu.hep.utils.HepStringUtil;
import com.enetedu.hep.utils.SimpleToolbar;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

public class WeikeActivity extends AppCompatActivity {

    /**
     * 返回
     */
    private TextView mTxtLeftTitle;
    /**  */
    private TextView mTxtMainTitle;
    private SimpleToolbar mSimpleToolbar;
    private WebView webView;
    WebSettings settings;
    private static final String TAG = "WeikeActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weike);
        initView();
    }

    private void initView() {
        mTxtLeftTitle = (TextView) findViewById(R.id.txt_left_title);
        mTxtMainTitle = (TextView) findViewById(R.id.txt_main_title);
        mSimpleToolbar = (SimpleToolbar) findViewById(R.id.simple_toolbar);
        webView = (WebView) findViewById(R.id.webview);

        mTxtMainTitle.setText("微课");
        mTxtLeftTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WeikeActivity.this.finish();
            }
        });

        Intent intent = getIntent();
        final String strUrl = intent.getStringExtra(Constant.INTENT_KEY_VALUE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
            webView.getSettings().setAllowUniversalAccessFromFileURLs(true);
        settings = webView.getSettings();

        settings.setDomStorageEnabled(true);
        settings.setAppCacheMaxSize(1024 * 1024 * 8);//设置缓冲大小,8M
        String appCacheDir = this.getApplicationContext().getDir("cache", Context.MODE_PRIVATE).getPath();
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setAppCachePath(appCacheDir);
        settings.setAllowFileAccess(true);
        settings.setAppCacheEnabled(true);
        settings.setSavePassword(false);
        settings.setCacheMode(WebSettings.LOAD_DEFAULT);


        webView.setWebViewClient(new WebViewClient() {

            public boolean shouldOverrideUrlLoading(WebView view, String url)

            { //  重写此方法表明点击网页里面的链接还是在当前的webview里跳转，不跳到浏览器那边

                view.loadUrl(url);

                return true;

            }

            @Override
            public void onPageFinished(WebView webView, String url) {
                Log.e("onPageFinished", url);

            }
        });

        if (!HepStringUtil.isEmpty(strUrl)) {

            new Thread() {
                @Override
                public void run() {
                    SystemClock.sleep(1000);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            webView.loadUrl(strUrl);
                            webView.reload();
                        }
                    });

                }
            }.start();
        }
    }
    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();// 返回前一个页面
        } else {
            super.onBackPressed();
        }
    }
}
