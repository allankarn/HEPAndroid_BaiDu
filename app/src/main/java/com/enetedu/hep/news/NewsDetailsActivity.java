package com.enetedu.hep.news;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.enetedu.hep.R;
import com.enetedu.hep.base.BaseActivityPro;
import com.enetedu.hep.utils.Date4String;
import com.enetedu.hep.utils.HtmlFormat;
import com.enetedu.hep.utils.SimpleToolbar;

public class NewsDetailsActivity extends BaseActivityPro {

    /**
     * 返回
     */
    private TextView mTxtLeftTitle;
    /**
     * 公告详情
     */
    private TextView mTxtMainTitle;
    private SimpleToolbar mSimpleToolbar;
    /**
     * 名字
     */
    private TextView mTvTitle;
    /**
     * 发布时间：2020-06-03
     */
    private TextView mTvTime;
    private WebView mTvNeirong;
    private String title;
    private String time;
    private String content;
    private static final String TAG = "NewsDetailsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);

        Intent intent = getIntent();
        content = intent.getStringExtra("content");
        time = intent.getStringExtra("time");
        title = intent.getStringExtra("title");

        initView();
    }

    private void initView() {
        mTxtLeftTitle = (TextView) findViewById(R.id.txt_left_title);
        mTxtMainTitle = (TextView) findViewById(R.id.txt_main_title);
        mSimpleToolbar = (SimpleToolbar) findViewById(R.id.simple_toolbar);
        mTvTitle = (TextView) findViewById(R.id.tv_title);
        mTvTime = (TextView) findViewById(R.id.tv_time);
        mTvNeirong = (WebView) findViewById(R.id.tv_neirong);

        mTxtLeftTitle.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                NewsDetailsActivity.this.finish();
            }
        });
        mTvTitle.setText(title);
        mTvTime.setText("发布时间" + new Date4String().date4Str(time, "yyyy-MM-dd"));
        mTvNeirong.getSettings().setJavaScriptEnabled(true);//支持javascript
        mTvNeirong.setWebViewClient(new ArticleWebViewClient());
        mTvNeirong.loadDataWithBaseURL("", content, "text/html", "UTF-8", "");
    }

    private class ArticleWebViewClient extends WebViewClient {

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            //重置webview中img标签的图片大小
            imgReset();
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    /**
     * 对图片进行重置大小，宽度就是手机屏幕宽度，高度根据宽度比便自动缩放
     **/
    private void imgReset() {
        mTvNeirong.loadUrl("javascript:(function(){" +
                "var objs = document.getElementsByTagName('img'); " +
                "for(var i=0;i<objs.length;i++)  " +
                "{"
                + "var img = objs[i];   " +
                "    img.style.maxWidth = '100%'; img.style.height = 'auto';  " +
                "}" +
                "})()");
    }

}
