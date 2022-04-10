package com.enetedu.hep;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;

import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/*import com.baidu.autoupdatesdk.BDAutoUpdateSDK;
import com.baidu.autoupdatesdk.UICheckUpdateCallback;*/
import com.enetedu.hep.base.BaseActivityPro;
import com.enetedu.hep.course.CourseFragment;
import com.enetedu.hep.my.MyFragment;
import com.enetedu.hep.news.NewsFragment;
import com.enetedu.hep.study.StudyFragment;

public class MainActivity extends BaseActivityPro {


    private TextView mToolbarTv;
    private Toolbar mToolbar;
    private FrameLayout mFramelayout;
    /**
     * 课程
     */
    private RadioButton mRbCourse;
    /**
     * 资讯
     */
    private RadioButton mRbNews;
    /**
     * 学习
     */
    private RadioButton mRbStudy;
    /**
     * 我的
     */
    private RadioButton mRbMy;
    private RadioGroup mGP;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addFragment(getSupportFragmentManager(), CourseFragment.class, R.id.framelayout, null);
        initView();
        initRadio();

        //检查自动更新，默认UI
      //  BDAutoUpdateSDK.uiUpdateAction(this, new MyUICheckUpdateCallback(),true);
    }

    private void initView() {
        mToolbarTv = (TextView) findViewById(R.id.toolbar_tv);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mFramelayout = (FrameLayout) findViewById(R.id.framelayout);
        mRbCourse = (RadioButton) findViewById(R.id.rb_course);
        mRbNews = (RadioButton) findViewById(R.id.rb_news);
        mRbStudy = (RadioButton) findViewById(R.id.rb_study);

        mRbMy = (RadioButton) findViewById(R.id.rb_my);
        mGP = (RadioGroup) findViewById(R.id.GP);

        mToolbarTv.setText("课程");
    }

    /**
     * 自动更新接口
     */
    /*private class MyUICheckUpdateCallback implements UICheckUpdateCallback {
        @Override
        public void onNoUpdateFound() {

        }

        @Override
        public void onCheckComplete() {

        }
    }*/

    private void initRadio() {

        mGP.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_course:

                        addFragment(getSupportFragmentManager(), CourseFragment.class, R.id.framelayout, null);
                        mToolbarTv.setText("课程");
                        break;
                    case R.id.rb_news:

                        addFragment(getSupportFragmentManager(), NewsFragment.class, R.id.framelayout, null);
                        mToolbarTv.setText("资讯");
                        break;
                    case R.id.rb_study:

                        addFragment(getSupportFragmentManager(), StudyFragment.class, R.id.framelayout, null);
                        mToolbarTv.setText("学习");
                        break;

                    case R.id.rb_my:

                        addFragment(getSupportFragmentManager(), MyFragment.class, R.id.framelayout, null);
                        mToolbarTv.setText("我的");
                        break;
                }
            }
        });
    }
}
