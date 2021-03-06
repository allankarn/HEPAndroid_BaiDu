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
import com.enetedu.hep.course.fragment.JzXueXiFragment;
import com.enetedu.hep.course.fragment.KdFragment;
import com.enetedu.hep.course.fragment.PxFragment;
import com.enetedu.hep.course.fragment.RcFragment;
import com.enetedu.hep.course.fragment.XxFragment;
import com.enetedu.hep.http.RespBase;
import com.enetedu.hep.http.entity.BaseEntity;
import com.enetedu.hep.http.entity.CaddressListEntity;
import com.enetedu.hep.http.entity.NewCourseDetailsEntity;
import com.enetedu.hep.http.entity.UserInfo;
import com.enetedu.hep.my.WebViewActivity;
import com.enetedu.hep.utils.BaseDialog;
import com.enetedu.hep.utils.Constant;
import com.enetedu.hep.utils.Date4String;
import com.enetedu.hep.utils.ImgUtils;
import com.enetedu.hep.utils.TwoBallRotationProgressBar;

import java.util.ArrayList;

public class FocusDetailsActivity extends BaseActivityPro implements View.OnClickListener {
    private static final String TAG = "FocusDetailsActivity";
    private TabLayout mTab;
    private ViewPager mVp;
    MyViewPagerAdapter myViewPagerAdapter;
    private int id;
    private Fragment[] mFragmentArrays = new Fragment[5];

    private String[] mTabTitles = new String[5];
    private PxFragment pxFragment;
    private RcFragment rcFragment;
    private XxFragment xxFragment;
    private KdFragment kdFragment;
    private JzXueXiFragment jzXueXiFragment;
    private NewCourseDetailsEntity newCourseDetailsEntity;
    private UserInfo userInfo;
    /**
     * ???????????????????????????????????????????????????
     */
    private TextView mTvName;
    private ImageView mIvTu;
    /**
     * ??????-?????????
     */
    private TextView mTvSuoshu;
    /**
     * ??????????????????????????????
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
    /**
     * ??????
     */
    private TextView mTxtLeftTitle;
    private LinearLayout mTvBaoming;
    private LinearLayout mTvPangting;
    /**
     * ????????????
     */
    private TextView mTvMing;
    /**
     * ????????????
     */
    private TextView mTvPang;
    private BaseDialog baseDialog;
    private TwoBallRotationProgressBar mLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_focus_details);
        initView();
        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);
        Log.d(TAG, "onCreate: " + id);
        loadNewCourseDetails();
    }

    private void initView() {
        mLoading = (TwoBallRotationProgressBar) findViewById(R.id.loading);
        mTab = (TabLayout) findViewById(R.id.tab);
        mVp = (ViewPager) findViewById(R.id.vp);
        mTvName = (TextView) findViewById(R.id.tv_name);
        mIvTu = (ImageView) findViewById(R.id.iv_tu);
        mTvSuoshu = (TextView) findViewById(R.id.tv_suoshu);
        mTvFenlei = (TextView) findViewById(R.id.tv_fenlei);
        mTvTime = (TextView) findViewById(R.id.tv_time);
        mTvKaishitime = (TextView) findViewById(R.id.tv_kaishitime);
        mTxtLeftTitle = (TextView) findViewById(R.id.txt_left_title);
        mTvBaoming = (LinearLayout) findViewById(R.id.tv_baoming);
        mTvBaoming.setOnClickListener(this);
        mTvPangting = (LinearLayout) findViewById(R.id.tv_pangting);
        mTvPangting.setOnClickListener(this);
        mTvMing = (TextView) findViewById(R.id.tv_ming);
        mTvPang = (TextView) findViewById(R.id.tv_pang);

        newCourseDetailsEntity = new NewCourseDetailsEntity();
        userInfo = UserInfoSharePreference.getIns().get(this);

        mTxtLeftTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FocusDetailsActivity.this.finish();
            }
        });
    }

    private void loadNewCourseDetails() {
        mLoading.startAnimator();
        newCourseDetailsEntity.getNewCourseDetails(id, userInfo.getUserId(), new BaseEntity.OnBaseResp() {
            @Override
            public void onResp(RespBase resp) {
                if (resp.getResCode() == -99999) {
                    NewCourseDetailsEntity newCourseDetailsEntity = (NewCourseDetailsEntity) resp.getData();
                    mTvName.setText(newCourseDetailsEntity.getCourseModelList().getCoursename());
                    mTvSuoshu.setText(newCourseDetailsEntity.getCourseModelList().getClassname() + "-" + newCourseDetailsEntity.getCourseModelList().getBoardname());
                    mTvFenlei.setText(newCourseDetailsEntity.getCourseModelList().getCourse_category_disp());

                    mTvTime.setText(new Date4String().date4Str(newCourseDetailsEntity.getCourseModelList().getBegin_t()) + "~" + new Date4String().date4Str(newCourseDetailsEntity.getCourseModelList().getEnd_t()));
                    mTvKaishitime.setText(new Date4String().date4Str(newCourseDetailsEntity.getCourseModelList().getCoursetime()));

                    ImgUtils.loadImgToUrl(FocusDetailsActivity.this, newCourseDetailsEntity.getCourseModelList().getImgpath(), 0, mIvTu);

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
                    } else if ("12345678".contains(submitbut)) {
                        String type = getType(submitbut);
                        mTvMing.setText(type);
                        mTvPangting.setVisibility(View.GONE);
                    } else {
                        mTvMing.setText("?????????");
                        mTvPangting.setVisibility(View.GONE);
                    }

                    mTabTitles[0] = "????????????";
                    mTabTitles[1] = "????????????";
                    mTabTitles[2] = "??????????????????";
                    mTabTitles[3] = "??????????????????";
                    mTabTitles[4] = "????????????????????????";

                    pxFragment = new PxFragment();
                    rcFragment = new RcFragment();
                    xxFragment = new XxFragment();
                    kdFragment = new KdFragment();
                    jzXueXiFragment = new JzXueXiFragment();

                    mFragmentArrays[0] = pxFragment;
                    mFragmentArrays[1] = rcFragment;
                    mFragmentArrays[2] = xxFragment;
                    mFragmentArrays[3] = kdFragment;
                    mFragmentArrays[4] = jzXueXiFragment;
                    Bundle bundle = new Bundle();
                    bundle.putString("Name", newCourseDetailsEntity.getMainCenterList().getName());
                    bundle.putSerializable("tjlist", newCourseDetailsEntity.getMainCenterList().getTjLists());
                    bundle.putSerializable("subcList", newCourseDetailsEntity.getSubcLists());
                    bundle.putSerializable("teacherlist", newCourseDetailsEntity.getTeacherListEntities());
                    bundle.putString("traing_notice", newCourseDetailsEntity.getCourseModelList().getTraing_notice());
                    bundle.putString("courseinfo", newCourseDetailsEntity.getCourseModelList().getCourseinfo());
                    bundle.putString("wordpath", newCourseDetailsEntity.getCourseModelList().getWordpath());
                    pxFragment.setArguments(bundle);
                    jzXueXiFragment.setArguments(bundle);
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

    //????????????????????????
    private void loadCouseDetailsPlayForCourse() {
        newCourseDetailsEntity.getCouseDetailsPlayForCourse(id, userInfo.getUserId(), userInfo.getUserToken(), new BaseEntity.OnBaseResp() {
            @Override
            public void onResp(RespBase resp) {
                if (resp.getResCode() == 1 || resp.getResCode() == 2) {
                    Intent intent = new Intent(FocusDetailsActivity.this, WebViewActivity.class);
                    intent.putExtra(Constant.INTENT_KEY_VALUE, resp.getDesc());
                    intent.putExtra("title", "????????????");
                    startActivity(intent);
                } else {
                    Toast.makeText(FocusDetailsActivity.this, resp.getDesc(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void loadSignUp() {
        newCourseDetailsEntity.getSignUp(id, userInfo.getUserId(), userInfo.getUserToken(), new BaseEntity.OnBaseResp() {
            @Override
            public void onResp(RespBase resp) {
                if (resp.getResCode() == 0) {
                    ArrayList<CaddressListEntity> data = (ArrayList<CaddressListEntity>) resp.getData();
                    if (data != null && data.size() > 0) {
                        ArrayList<CaddressListEntity> caddressListEntities = new ArrayList<>();
                        caddressListEntities.addAll(data);
                        Intent intent = new Intent(FocusDetailsActivity.this, SignUpActivity.class);
                        intent.putExtra("id", id);
                        intent.putExtra("cadd", caddressListEntities);
                        startActivity(intent);
                    }


                } else {
                    Toast.makeText(FocusDetailsActivity.this, resp.getDesc(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    private String getType(String s) {
        switch (s) {
            case "0":
                //?????????????????????
                return "?????????";
            case "1":
                //?????????????????????
                return "????????????";
            case "2":
                //?????????????????????
                return "???????????????";
            case "3":

                return "????????????";
            case "4":
                //?????????????????????
                return "????????????";
            case "5":
                mTvPangting.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        initCountDialog();
                    }
                });

                return "????????????";
            case "6":

                mTvBaoming.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        loadSignUp();
                    }
                });
                return "????????????";
            case "7":
                mTvBaoming.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(FocusDetailsActivity.this, "????????????????????????", Toast.LENGTH_SHORT).show();
                    }
                });
                return "????????????";
            case "8":
                mTvPangting.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(FocusDetailsActivity.this, "????????????????????????", Toast.LENGTH_SHORT).show();
                    }
                });
                return "????????????";
        }
        return "";
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.tv_baoming:

                break;
            case R.id.tv_pangting:
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
        tv_tishi.setText("??????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????");

        btn_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                baseDialog.dismiss();
            }
        });

        btn_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadCouseDetailsPlayForCourse();
                baseDialog.dismiss();
            }
        });

        if (baseDialog == null) {
            baseDialog = new BaseDialog(this, inflate, Gravity.CENTER);
        }
        baseDialog.show();
    }
}
