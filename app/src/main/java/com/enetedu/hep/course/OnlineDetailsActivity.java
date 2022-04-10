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
import com.enetedu.hep.course.fragment.PxFragment;
import com.enetedu.hep.course.fragment.ZjFragment;
import com.enetedu.hep.http.RespBase;
import com.enetedu.hep.http.entity.BaseEntity;
import com.enetedu.hep.http.entity.Course2DetailEntity;
import com.enetedu.hep.http.entity.TeacherListEntity;
import com.enetedu.hep.http.entity.UserInfo;
import com.enetedu.hep.utils.BaseDialog;
import com.enetedu.hep.utils.ImgUtils;
import com.enetedu.hep.utils.SimpleToolbar;
import com.enetedu.hep.utils.TwoBallRotationProgressBar;

import java.util.ArrayList;

public class OnlineDetailsActivity extends BaseActivityPro implements View.OnClickListener {

    /**
     * 返回
     */
    private TextView mTxtLeftTitle;
    /**
     * 在线
     */
    private TextView mTxtMainTitle;
    private SimpleToolbar mSimpleToolbar;
    /**
     * 以学习者为中心的信息化教学模式创新
     */
    private TextView mTvTittle;
    private ImageView mIvTu;
    /**
     * 其他-其他类
     */
    private TextView mTvXueke;
    private LinearLayout mLl;
    /**
     * 高校工作人员专题培训
     */
    private TextView mTvFenlei;
    private LinearLayout mLl2;
    /**
     * 2天
     */
    private TextView mTvTianshu;
    private LinearLayout mLl3;
    /**
     * 费用说明：需在直播、在线类课程中选择搭配15-20学时内容组成课单进行学习，共计600元。
     */
    private TextView mTvFeiyong;
    private TabLayout mTab;
    private ViewPager mVp;
    private Fragment[] mFragmentArrays = new Fragment[2];
    private String[] mTabTitles = new String[2];
    private PxFragment pxFragment;
    private ZjFragment zjFragment;
    private MyViewPagerAdapter myViewPagerAdapter;
    private int id;
    private Course2DetailEntity course2DetailEntity;
    private static final String TAG = "OnlineDetailsActivity";
    private ArrayList<TeacherListEntity> teacherListEntities;
    private LinearLayout tv_shopping;
    private LinearLayout tv_ljstudy;
    private LinearLayout tv_zzstudy;
    private UserInfo userInfo;
    private BaseDialog baseDialog;
    private BaseDialog baseDialog2;
    private BaseDialog baseDialog3;
    private Course2DetailEntity course2DetailEntity1;
    private Course2DetailEntity course2DetailEntity2;
    private TwoBallRotationProgressBar mLoading;
    /**
     * 试听
     */
    private TextView mTvShiting;
    private int intExtra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_details);

        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);
        intExtra = intent.getIntExtra("1", 0);
        Log.d(TAG, "onCreate: " + id);
        initView();

        if (id < 10001) {
            loadCourse2Detail();
        } else {
            loadCourse22Detail();
        }

        initdata();

    }

    private void initdata() {

        mTabTitles[0] = "培训内容";
        mTabTitles[1] = "主讲专家";
        pxFragment = new PxFragment();
        zjFragment = new ZjFragment();
        mFragmentArrays[0] = pxFragment;
        mFragmentArrays[1] = zjFragment;

        myViewPagerAdapter = new MyViewPagerAdapter(getSupportFragmentManager());
        mVp.setAdapter(myViewPagerAdapter);
        mTab.setupWithViewPager(mVp);

    }

    private void initView() {
        mLoading = (TwoBallRotationProgressBar) findViewById(R.id.loading);
        mTxtLeftTitle = (TextView) findViewById(R.id.txt_left_title);
        mTxtMainTitle = (TextView) findViewById(R.id.txt_main_title);
        mSimpleToolbar = (SimpleToolbar) findViewById(R.id.simple_toolbar);
        mTvTittle = (TextView) findViewById(R.id.tv_tittle);
        mIvTu = (ImageView) findViewById(R.id.iv_tu);
        mTvXueke = (TextView) findViewById(R.id.tv_xueke);
        mLl = (LinearLayout) findViewById(R.id.ll);
        mTvFenlei = (TextView) findViewById(R.id.tv_fenlei);
        mLl2 = (LinearLayout) findViewById(R.id.ll2);
        mTvTianshu = (TextView) findViewById(R.id.tv_tianshu);
        mLl3 = (LinearLayout) findViewById(R.id.ll3);
        mTvFeiyong = (TextView) findViewById(R.id.tv_feiyong);
        mTab = (TabLayout) findViewById(R.id.tab);
        mVp = (ViewPager) findViewById(R.id.vp);
        tv_shopping = findViewById(R.id.tv_shopping);
        tv_ljstudy = findViewById(R.id.tv_ljstudy);
        tv_zzstudy = findViewById(R.id.tv_zzstudy);
        tv_ljstudy.setOnClickListener(this);
        tv_zzstudy.setOnClickListener(this);
        mTvShiting = (TextView) findViewById(R.id.tv_shiting);
        mTvShiting.setOnClickListener(this);

        if (intExtra == 1) {
            mTvShiting.setVisibility(View.VISIBLE);
        } else {
            mTvShiting.setVisibility(View.GONE);
        }
        course2DetailEntity = new Course2DetailEntity();
        userInfo = UserInfoSharePreference.getIns().get(this);
        mTxtLeftTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnlineDetailsActivity.this.finish();
            }
        });


    }

    private void loadCourse2Detail() {
        mLoading.startAnimator();
        course2DetailEntity.getCourse2Detail("ENDPOINT_ANDROID", id, userInfo.getUserId(), new BaseEntity.OnBaseResp() {
            @Override
            public void onResp(RespBase resp) {

                if (resp.getResCode() == -99999) {

                    course2DetailEntity1 = (Course2DetailEntity) resp.getData();

                    mTvTittle.setText(course2DetailEntity1.getCourse2ModelEntity().getName());
                    ImgUtils.loadImgToUrl(OnlineDetailsActivity.this, course2DetailEntity1.getCourse2ModelEntity().getHead_img_url(), 0, mIvTu);
                    mTvXueke.setText(course2DetailEntity1.getCourse2ModelEntity().getPrimal_subject_name());
                    mTvFenlei.setText(course2DetailEntity1.getCourse2ModelEntity().getCourse_category_disp());
                    mTvTianshu.setText(course2DetailEntity1.getCourse2ModelEntity().getDays() + "天");
                    mTvFeiyong.setText("费用说明：" + course2DetailEntity1.getCourse2ModelEntity().getMoney());

                    int studyState = course2DetailEntity1.getCourse2ModelEntity().getStudyState();
                    if (studyState == 1) {
                        tv_ljstudy.setVisibility(View.GONE);
                        tv_zzstudy.setVisibility(View.GONE);
                    } else if (studyState == 2) {
                        tv_zzstudy.setVisibility(View.GONE);
                        tv_shopping.setVisibility(View.GONE);
                    } else if (studyState == 3) {
                        tv_shopping.setVisibility(View.GONE);
                    }
                    tv_shopping.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            course2DetailEntity.getAddShoppingCart("ENDPOINT_ANDROID", userInfo.getUserToken(), userInfo.getUserId(), id, "1", new BaseEntity.OnBaseResp() {
                                @Override
                                public void onResp(RespBase resp) {

                                    if (resp.getResCode() == 0) {
                                        Toast.makeText(OnlineDetailsActivity.this, resp.getDesc(), Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(OnlineDetailsActivity.this, resp.getDesc(), Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                        }
                    });
                    teacherListEntities = course2DetailEntity1.getTeacherListEntities();
                    zjFragment.getList(teacherListEntities);
                    pxFragment.getList(course2DetailEntity1.getCourse2ModelEntity());
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

    private void loadCourse22Detail() {
        mLoading.startAnimator();
        course2DetailEntity.getCourse22Detail("ENDPOINT_ANDROID", id, userInfo.getUserId(), new BaseEntity.OnBaseResp() {
            @Override
            public void onResp(RespBase resp) {

                if (resp.getResCode() == -99999) {

                    course2DetailEntity2 = (Course2DetailEntity) resp.getData();

                    mTvTittle.setText(course2DetailEntity2.getCourse2ModelEntity().getName());
                    ImgUtils.loadImgToUrl(OnlineDetailsActivity.this, course2DetailEntity2.getCourse2ModelEntity().getHead_img_url(), 0, mIvTu);
                    mTvXueke.setText(course2DetailEntity2.getCourse2ModelEntity().getPrimal_subject_name());
                    mTvFenlei.setText(course2DetailEntity2.getCourse2ModelEntity().getCourse_category_disp());
                    mTvTianshu.setText(course2DetailEntity2.getCourse2ModelEntity().getDays() + "天");
                    mTvFeiyong.setText("费用说明：" + course2DetailEntity2.getCourse2ModelEntity().getMoney());

                    int studyState = course2DetailEntity2.getCourse2ModelEntity().getStudyState();
                    if (studyState == 1) {
                        tv_ljstudy.setVisibility(View.GONE);
                        tv_zzstudy.setVisibility(View.GONE);
                    } else if (studyState == 2) {
                        tv_zzstudy.setVisibility(View.GONE);
                        tv_shopping.setVisibility(View.GONE);
                    } else if (studyState == 3) {
                        tv_shopping.setVisibility(View.GONE);
                    }
                    tv_shopping.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            course2DetailEntity.getAddShoppingCart("ENDPOINT_ANDROID", userInfo.getUserToken(), userInfo.getUserId(), id, "2", new BaseEntity.OnBaseResp() {
                                @Override
                                public void onResp(RespBase resp) {
                                    Log.d(TAG, "onResp: " + resp.getResCode());
                                    if (resp.getResCode() == 0) {
                                        Toast.makeText(OnlineDetailsActivity.this, resp.getDesc(), Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(OnlineDetailsActivity.this, resp.getDesc(), Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                        }
                    });
                    teacherListEntities = course2DetailEntity2.getTeacherListEntities();
                    zjFragment.getList(teacherListEntities);
                    pxFragment.getList(course2DetailEntity2.getCourse2ModelEntity());

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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.tv_ljstudy:
                course2DetailEntity.getCourseConfirm("ENDPOINT_ANDROID", userInfo.getUserToken(), userInfo.getUserId(), id, new BaseEntity.OnBaseResp() {
                    @Override
                    public void onResp(RespBase resp) {
                        if (resp.getResCode() == 0) {
                            initCountDialog2();
                        } else {
                            Toast.makeText(OnlineDetailsActivity.this, resp.getDesc(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                break;
            case R.id.tv_zzstudy:
                initCountDialog();

                break;
            case R.id.tv_shiting:
                initCountDialog3();
                break;
        }
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

    private void initCountDialog() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.dialog, null);
        Button btn_no = inflate.findViewById(R.id.btn_no);
        Button btn_yes = inflate.findViewById(R.id.btn_yes);
        TextView tv_tishi = inflate.findViewById(R.id.tv_tishi);
        tv_tishi.setText("自主选学：根据实际需要自主学习培训课程视频内容，不包含其他学习环节，无需用学习卡激活。学习结束后，无学习记录和培训证书。");

        btn_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                baseDialog.dismiss();
            }
        });

        btn_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OnlineDetailsActivity.this, VideoPlayForMgcActivity.class);
                intent.putExtra("id", id);
                startActivity(intent);
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
        tv_tishi.setText("立即学习：包括参加课程视频内容学习、在线活动、拓展学习和作业考核等学习环节。需要用学习卡进行激活，90天内完成学习。当完成全部学习任务后，可获得培训证书。");
        btn_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                baseDialog2.dismiss();
            }
        });

        btn_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OnlineDetailsActivity.this, LijiStudyActivity.class);
                intent.putExtra("id", id);
                if (id < 10001) {
                    intent.putExtra("name", course2DetailEntity1.getCourse2ModelEntity().getName());
                } else {
                    intent.putExtra("name", course2DetailEntity2.getCourse2ModelEntity().getName());
                }
                startActivity(intent);
                baseDialog2.dismiss();

            }
        });
        if (baseDialog2 == null) {
            baseDialog2 = new BaseDialog(this, inflate, Gravity.CENTER);
        }
        baseDialog2.show();
    }

    private void initCountDialog3() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.dialog, null);
        Button btn_no = inflate.findViewById(R.id.btn_no);
        Button btn_yes = inflate.findViewById(R.id.btn_yes);
        TextView tv_tishi = inflate.findViewById(R.id.tv_tishi);
        tv_tishi.setText("试听课：根据实际需要自主学习培训课程视频内容，不包含其他学习环节，无需用学习卡激活。学习结束后，无学习记录和培训证书。");

        btn_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                baseDialog3.dismiss();
            }
        });

        btn_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OnlineDetailsActivity.this, VideoPlayForMgcActivity.class);
                intent.putExtra("id", id);
                startActivity(intent);
                baseDialog3.dismiss();
            }
        });

        if (baseDialog3 == null) {
            baseDialog3 = new BaseDialog(this, inflate, Gravity.CENTER);
        }
        baseDialog3.show();
    }
}
