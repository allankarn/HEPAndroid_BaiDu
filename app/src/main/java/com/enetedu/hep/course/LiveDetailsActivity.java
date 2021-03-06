package com.enetedu.hep.course;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.enetedu.hep.R;
import com.enetedu.hep.base.BaseActivityPro;
import com.enetedu.hep.config.UserInfoSharePreference;
import com.enetedu.hep.course.fragment.KdFragment;
import com.enetedu.hep.course.fragment.PxFragment;
import com.enetedu.hep.course.fragment.RcFragment;
import com.enetedu.hep.course.fragment.XxFragment;
import com.enetedu.hep.http.RespBase;
import com.enetedu.hep.http.entity.BaseEntity;
import com.enetedu.hep.http.entity.NewCourseDetailsEntity;
import com.enetedu.hep.http.entity.UserInfo;
import com.enetedu.hep.my.WebViewActivity;
import com.enetedu.hep.utils.BaseDialog;
import com.enetedu.hep.utils.Constant;
import com.enetedu.hep.utils.Date4String;
import com.enetedu.hep.utils.ImgUtils;
import com.enetedu.hep.utils.SimpleToolbar;
import com.enetedu.hep.utils.TwoBallRotationProgressBar;

public class LiveDetailsActivity extends BaseActivityPro {

    /**
     * 以学习者为中心的信息化教学模式创新
     */
    private TextView mTvName;
    private ImageView mIvTu;
    /**
     * 其他-其他类
     */
    private TextView mTvSuoshu;
    /**
     * 高校工作人员专题培训
     */
    private TextView mTvFenlei;
    /**
     * 2018-10-11
     */
    private TextView mTvTime;
    /**
     * 2020-07-29
     */
    private TextView mTvKaishitime;
    private TabLayout mTab;
    private ViewPager mVp;

    private String[] mTabTitles = new String[4];
    private Fragment[] mFragmentArrays = new Fragment[4];
    private PxFragment pxFragment;
    private RcFragment rcFragment;
    private XxFragment xxFragment;
    private KdFragment kdFragment;
    private int id;

    MyViewPagerAdapter myViewPagerAdapter;
    private NewCourseDetailsEntity newCourseDetailsEntity;
    private UserInfo userInfo;
    private static final String TAG = "LiveDetailsActivity";
    /**
     * 加入购物车
     */
    private TextView mTvMing;
    private LinearLayout mTvBaoming;
    /**
     * 旁听观摩
     */
    private TextView mTvPang;
    private LinearLayout mTvPangting;
    private BaseDialog baseDialog;
    private BaseDialog baseDialog2;
    private TwoBallRotationProgressBar mLoading;
    /**
     * 返回
     */
    private TextView mTxtLeftTitle;
    private SimpleToolbar mSimpleToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_details);
        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);
        initView();
        loadNewCourseDetails();
    }

    private void initView() {
        mTxtLeftTitle = (TextView) findViewById(R.id.txt_left_title);
        mSimpleToolbar = (SimpleToolbar) findViewById(R.id.simple_toolbar);
        mLoading = (TwoBallRotationProgressBar) findViewById(R.id.loading);
        mTvName = (TextView) findViewById(R.id.tv_name);
        mIvTu = (ImageView) findViewById(R.id.iv_tu);
        mTvSuoshu = (TextView) findViewById(R.id.tv_suoshu);
        mTvFenlei = (TextView) findViewById(R.id.tv_fenlei);
        mTvTime = (TextView) findViewById(R.id.tv_time);
        mTvKaishitime = (TextView) findViewById(R.id.tv_kaishitime);
        mTab = (TabLayout) findViewById(R.id.tab);
        mVp = (ViewPager) findViewById(R.id.vp);
        mTvMing = (TextView) findViewById(R.id.tv_ming);
        mTvBaoming = (LinearLayout) findViewById(R.id.tv_baoming);
        mTvPang = (TextView) findViewById(R.id.tv_pang);
        mTvPangting = (LinearLayout) findViewById(R.id.tv_pangting);

        newCourseDetailsEntity = new NewCourseDetailsEntity();
        userInfo = UserInfoSharePreference.getIns().get(this);

        mTxtLeftTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LiveDetailsActivity.this.finish();
            }
        });

    }

    private void loadNewCourseDetails() {
        mLoading.startAnimator();
        newCourseDetailsEntity.getNewCourseDetails(id, userInfo.getUserId(), new BaseEntity.OnBaseResp() {
            @Override
            public void onResp(RespBase resp) {
                Log.d(TAG, "onResp: " + resp.getResCode());
                if (resp.getResCode() == -99999) {
                    NewCourseDetailsEntity newCourseDetailsEntity = (NewCourseDetailsEntity) resp.getData();
                    Log.d(TAG, "getTeacherListEntities: " + newCourseDetailsEntity.getTeacherListEntities().toString());
                    mTvName.setText(newCourseDetailsEntity.getCourseModelList().getCoursename());
                    mTvSuoshu.setText(newCourseDetailsEntity.getCourseModelList().getClassname() + "-" + newCourseDetailsEntity.getCourseModelList().getBoardname());
                    mTvFenlei.setText(newCourseDetailsEntity.getCourseModelList().getCourse_category_disp());

                    mTvTime.setText(new Date4String().date4Str(newCourseDetailsEntity.getCourseModelList().getBegin_t()) + "~" + new Date4String().date4Str(newCourseDetailsEntity.getCourseModelList().getEnd_t()));
                    mTvKaishitime.setText(new Date4String().date4Str(newCourseDetailsEntity.getCourseModelList().getCoursetime()));

                    ImgUtils.loadImgToUrl(LiveDetailsActivity.this, newCourseDetailsEntity.getCourseModelList().getImgpath(), 0, mIvTu);

                    String submitbut = newCourseDetailsEntity.getCourseModelList().getSubmitbut();
                    Log.d(TAG, "submitbut:----------- " + submitbut);
                    if (submitbut.contains(",")) {
                        String[] split = submitbut.split(",");
                        String s1 = split[0];
                        String s2 = split[1];

                        String type = getType(s1);
                        String type1 = getType(s2);

                        mTvMing.setText(type);
                        mTvPang.setText(type1);
                    } else {
                        mTvMing.setText("已结束");
                        mTvPang.setVisibility(View.GONE);
                    }
                    mTabTitles[0] = "培训内容";
                    mTabTitles[1] = "主讲专家";
                    mTabTitles[2] = "培训环节须知";
                    mTabTitles[3] = "培训通知查看";
                    pxFragment = new PxFragment();
                    rcFragment = new RcFragment();
                    xxFragment = new XxFragment();
                    kdFragment = new KdFragment();
                    mFragmentArrays[0] = pxFragment;
                    mFragmentArrays[1] = rcFragment;
                    mFragmentArrays[2] = xxFragment;
                    mFragmentArrays[3] = kdFragment;
                    Bundle bundle = new Bundle();
                    bundle.putString("Name", newCourseDetailsEntity.getMainCenterList().getName());
                    bundle.putSerializable("tjlist", newCourseDetailsEntity.getMainCenterList().getTjLists());
                    bundle.putSerializable("subcList", newCourseDetailsEntity.getSubcLists());
                    bundle.putSerializable("teacherlist", newCourseDetailsEntity.getTeacherListEntities());
                    bundle.putString("traing_notice", newCourseDetailsEntity.getCourseModelList().getTraing_notice());
                    bundle.putString("courseinfo", newCourseDetailsEntity.getCourseModelList().getCourseinfo());
                    bundle.putString("wordpath", newCourseDetailsEntity.getCourseModelList().getWordpath());
                    pxFragment.setArguments(bundle);
                    rcFragment.setArguments(bundle);
                    xxFragment.setArguments(bundle);
                    kdFragment.setArguments(bundle);
                    myViewPagerAdapter = new MyViewPagerAdapter(getSupportFragmentManager());
                    mVp.setAdapter(myViewPagerAdapter);
                    mTab.setupWithViewPager(mVp);
                }
                mLoading.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mLoading.stopAnimator();
                    }
                }, 3000);
            }
        });
    }

    private void loadCouseDetailsPlayForCourseLive() {
        newCourseDetailsEntity.getCouseDetailsPlayForCourseLive(id, userInfo.getUserId(), userInfo.getUserToken(), new BaseEntity.OnBaseResp() {
            @Override
            public void onResp(RespBase resp) {
                if (resp.getResCode() == 1 || resp.getResCode() == 2) {
                    Intent intent = new Intent(LiveDetailsActivity.this, WebViewActivity.class);
                    intent.putExtra(Constant.INTENT_KEY_VALUE, resp.getDesc());
                    intent.putExtra("title", "直播详情");
                    startActivity(intent);
                } else {
                    Toast.makeText(LiveDetailsActivity.this, resp.getDesc(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void loadCourseWhetherStudy() {
        newCourseDetailsEntity.getCourseWhetherStudy(id, userInfo.getUserId(), userInfo.getUserToken(), "3", new BaseEntity.OnBaseResp() {
            @Override
            public void onResp(RespBase resp) {
                if (resp.getResCode() > 0) {
                    //  Toast.makeText(LiveDetailsActivity.this, resp.getDesc(), Toast.LENGTH_SHORT).show();
                    initCountDialog2();

                } else {
                    Toast.makeText(LiveDetailsActivity.this, resp.getDesc(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void loadCourseSign() {
        newCourseDetailsEntity.getCourseSign(id, userInfo.getUserId(), userInfo.getUserToken(), "3", new BaseEntity.OnBaseResp() {
            @Override
            public void onResp(RespBase resp) {
                if (resp.getResCode() == 0) {
                    Toast.makeText(LiveDetailsActivity.this, resp.getDesc(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LiveDetailsActivity.this, resp.getDesc(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private String getType(String s) {
        switch (s) {
            case "0":
                //不需要任何操作
                return "已结束";
            case "1":
                //不需要任何操作
                return "现在报名";
            case "2":
                mTvBaoming.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        loadCourseWhetherStudy();
                    }
                });
                return "加入购物车";
            case "3":
                mTvPangting.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        initCountDialog();
                    }
                });

                return "旁听观摩";
            case "4":
                //不需要任何操作
                return "已经报名";
            case "5":

                //不需要任何操作
                return "旁听观摩";
            case "6":

                //不需要任何操作
                return "现在报名";
            case "7":
                mTvBaoming.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(LiveDetailsActivity.this, "请登录您的账号！", Toast.LENGTH_SHORT).show();
                    }
                });
                return "现在报名";
            case "8":
                mTvPangting.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(LiveDetailsActivity.this, "请登录您的账号！", Toast.LENGTH_SHORT).show();
                    }
                });
                return "旁听观摩";
        }
        return "";
    }


    private void initCountDialog() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.dialog, null);
        Button btn_no = inflate.findViewById(R.id.btn_no);
        Button btn_yes = inflate.findViewById(R.id.btn_yes);
        TextView tv_tishi = inflate.findViewById(R.id.tv_tishi);
        tv_tishi.setText("旁听观摩：根据实际需要自主学习直播课程视频内容，不包含其他学习环节，无需报名付费。学习结束后，无学习记录和培训证书。");

        btn_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                baseDialog.dismiss();
            }
        });

        btn_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadCouseDetailsPlayForCourseLive();
                baseDialog.dismiss();
            }
        });

        if (baseDialog == null) {
            baseDialog = new BaseDialog(this, inflate, Gravity.CENTER);
        }
        baseDialog.show();
    }

    private void initCountDialog2() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.dialog, null);
        Button btn_no = inflate.findViewById(R.id.btn_no);
        Button btn_yes = inflate.findViewById(R.id.btn_yes);
        TextView tv_tishi = inflate.findViewById(R.id.tv_tishi);
        tv_tishi.setText("加入课程购物车：包括参加课程视频内容学习、在线活动、拓展学习和作业考核等学习环节。需要用学习卡进行激活，90天内完成学习。当完成全部学习任务后，可获得培训证书。");

        btn_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                baseDialog2.dismiss();
            }
        });

        btn_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadCourseSign();
                baseDialog2.dismiss();
            }
        });

        if (baseDialog2 == null) {
            baseDialog2 = new BaseDialog(this, inflate, Gravity.CENTER);
        }
        baseDialog2.show();
    }

    class MyViewPagerAdapter extends FragmentPagerAdapter {
        public MyViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentArrays[position];
        }

        @Override
        public int getCount() {
            return mFragmentArrays.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTabTitles[position];
        }
    }
}
