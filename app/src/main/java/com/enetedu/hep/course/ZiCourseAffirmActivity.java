package com.enetedu.hep.course;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.enetedu.hep.R;
import com.enetedu.hep.config.UserInfoSharePreference;
import com.enetedu.hep.http.RespBase;
import com.enetedu.hep.http.entity.BaseEntity;
import com.enetedu.hep.http.entity.UserInfo;
import com.enetedu.hep.utils.SimpleToolbar;
import com.enetedu.hep.utils.StringUtil;
import com.lljjcoder.Interface.OnCityItemClickListener;
import com.lljjcoder.bean.CityBean;
import com.lljjcoder.bean.DistrictBean;
import com.lljjcoder.bean.ProvinceBean;
import com.lljjcoder.citywheel.CityConfig;
import com.lljjcoder.style.citypickerview.CityPickerView;

import java.util.ArrayList;

//自组课程确认单
public class ZiCourseAffirmActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 返回
     */
    private TextView mTxtLeftTitle;
    /**
     * 自组课程确认单
     */
    private TextView mTxtMainTitle;
    private SimpleToolbar mSimpleToolbar;
    /**
     * 请输入
     */
    private EditText mEdEmail;
    /**
     * 请输入
     */
    private EditText mEdCourseName;
    /**
     * 请输入
     */
    private EditText mEdName;
    /**
     * 请输入
     */
    private EditText mEdPhone;
    /**
     * 请输入
     */
    private EditText mEdSchool;
    /**
     * 请输入
     */
    private EditText mEdYuanxi;
    /**
     * 请输入
     */
    private TextView mEdDiqu;
    /**
     * 请输入
     */
    private EditText mEdJiedao;
    private LinearLayout mLlTijiao;
    CityPickerView mPicker = new CityPickerView();
    private String sheng;
    private String shi;
    private String qu;
    private LinearLayout mLlDiqu;
    private UserInfo userInfo;

    /**
     * 自组课程：标题
     */
    private TextView mTvTitle;
    private ArrayList<String> name;
    private static final String TAG = "ZiCourseAffirmActivity";
    private ArrayList<String> id;
    private String eid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zi_course_affirm);
        Intent intent = getIntent();
        name = intent.getStringArrayListExtra("name");
        id = intent.getStringArrayListExtra("id");
        Log.d(TAG, "onCreate: -------size:" + id.size());
        Log.d(TAG, "onCreate: -------id:" + id.toString());

        eid = StringUtil.join(id, ",");
        Log.d(TAG, "onCreate: " + eid);
        initView();
    }

    private void initView() {
        mTxtLeftTitle = (TextView) findViewById(R.id.txt_left_title);
        mTxtMainTitle = (TextView) findViewById(R.id.txt_main_title);
        mSimpleToolbar = (SimpleToolbar) findViewById(R.id.simple_toolbar);
        mEdEmail = (EditText) findViewById(R.id.ed_email);
        mEdCourseName = (EditText) findViewById(R.id.ed_course_name);
        mEdName = (EditText) findViewById(R.id.ed_name);
        mEdPhone = (EditText) findViewById(R.id.ed_phone);
        mEdSchool = (EditText) findViewById(R.id.ed_school);
        mEdYuanxi = (EditText) findViewById(R.id.ed_yuanxi);
        mEdDiqu = (TextView) findViewById(R.id.ed_diqu);
        mEdJiedao = (EditText) findViewById(R.id.ed_jiedao);
        mLlTijiao = (LinearLayout) findViewById(R.id.ll_tijiao);
        mLlTijiao.setOnClickListener(this);
        mLlDiqu = (LinearLayout) findViewById(R.id.ll_diqu);
        mTvTitle = (TextView) findViewById(R.id.tv_title);
        userInfo = UserInfoSharePreference.getIns().get(this);
        mPicker.init(this);
        initAddressDialog();

        mLlDiqu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mPicker.showCityPicker();
            }
        });

        String a = "";
        if (name.size() > 0) {
            a = "[在线]";
            for (int i = 0; i < name.size(); i++) {
                if (i + 1 == name.size()) {
                    a = a + name.get(i);
                } else {
                    a = a + name.get(i) + "\n" + "[在线]";
                }
            }
            mTvTitle.setText(a);
        }

        mTxtLeftTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ZiCourseAffirmActivity.this.finish();
            }
        });

    }

    private void loadOrderConfirm() {
        userInfo.getOrderConfirm("ENDPOINT_ANDROID", userInfo.getUserToken(), userInfo.getUserId(), eid, mEdName.getText().toString(), sheng, qu, shi,
                mEdPhone.getText().toString(), mEdJiedao.getText().toString(), mEdSchool.getText().toString(), mEdYuanxi.getText().toString(), name.toString(), new BaseEntity.OnBaseResp() {
                    @Override
                    public void onResp(RespBase resp) {
                        if (resp.getResCode() == 0) {
                            Toast.makeText(ZiCourseAffirmActivity.this, resp.getDesc(), Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(ZiCourseAffirmActivity.this, resp.getDesc(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void initAddressDialog() {

        CityConfig cityConfig = new CityConfig.Builder()
                .title(" ")//标题
                .titleTextSize(18)//标题文字大小
                .titleTextColor("#585858")//标题文字颜  色
                .titleBackgroundColor("#FFFFFF")//标题栏背景色
                .confirTextColor("#3287F6")//确认按钮文字颜色
                .confirmText("确定")//确认按钮文字
                .confirmTextSize(16)//确认按钮文字大小
                .cancelTextColor("#333333")//取消按钮文字颜色
                .cancelText("取消")//取消按钮文字
                .cancelTextSize(16)//取消按钮文字大小
                .setCityWheelType(CityConfig.WheelType.PRO_CITY_DIS)//显示类，只显示省份一级，显示省市两级还是显示省市区三级
                .showBackground(true)//是否显示半透明背景
                .visibleItemsCount(5)//显示item的数量
                .province("北京")//默认显示的省份
                .city("北京")//默认显示省份下面的城市
                .district("东城区")//默认显示省市下面的区县数据
                .provinceCyclic(false)//省份滚轮是否可以循环滚动
                .cityCyclic(false)//城市滚轮是否可以循环滚动
                .districtCyclic(false)//区县滚轮是否循环滚动
                .drawShadows(false)//滚轮不显示模糊效果
                .setLineColor("#f5f5f5")//中间横线的颜色
                .setLineHeigh(1)//中间横线的高度
                .setShowGAT(true)//是否显示港澳台数据，默认不显示
                .build();

        //设置自定义的属性配置
        mPicker.setConfig(cityConfig);
        //监听选择点击事件及返回结果
        mPicker.setOnCityItemClickListener(new OnCityItemClickListener() {
            @Override
            public void onSelected(ProvinceBean province, CityBean city, DistrictBean district) {
                sheng = province.getName();
                shi = city.getName();
                qu = district.getName();
                mEdDiqu.setText(province.getName() + city.getName() + district.getName());
            }

            @Override
            public void onCancel() {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.ll_tijiao:
                loadOrderConfirm();
                break;
        }
    }
}
