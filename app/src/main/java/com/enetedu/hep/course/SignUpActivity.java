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
import com.enetedu.hep.http.entity.CaddressListEntity;
import com.enetedu.hep.http.entity.UserInfo;
import com.enetedu.hep.utils.SimpleToolbar;
import com.lljjcoder.Interface.OnCityItemClickListener;
import com.lljjcoder.bean.CityBean;
import com.lljjcoder.bean.DistrictBean;
import com.lljjcoder.bean.ProvinceBean;
import com.lljjcoder.citywheel.CityConfig;
import com.lljjcoder.style.citypickerview.CityPickerView;
import java.util.ArrayList;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

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
     * 个人信息
     */
    private TextView mTvTitle;
    /**
     * 请输入
     */
    private EditText mEdEmail;
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
     * 请选择地区
     */
    private TextView mEdDiqu;
    private LinearLayout mLlDiqu;
    /**
     * 请输入
     */
    private EditText mEdFapiao;
    private LinearLayout mLlTijiao;
    CityPickerView mPicker = new CityPickerView();
    private String sheng;
    private String shi;
    private String qu;
    private static final String TAG = "SignUpActivity";
    private ArrayList<CaddressListEntity> cadd;
    private int id;
    private UserInfo userInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);
        cadd = (ArrayList<CaddressListEntity>) intent.getSerializableExtra("cadd");
        Log.d(TAG, "cadd: " + cadd.toString());
        initView();
    }

    private void initView() {
        mTxtLeftTitle = (TextView) findViewById(R.id.txt_left_title);
        mTxtMainTitle = (TextView) findViewById(R.id.txt_main_title);
        mSimpleToolbar = (SimpleToolbar) findViewById(R.id.simple_toolbar);
        mTvTitle = (TextView) findViewById(R.id.tv_title);
        mEdEmail = (EditText) findViewById(R.id.ed_email);
        mEdName = (EditText) findViewById(R.id.ed_name);
        mEdPhone = (EditText) findViewById(R.id.ed_phone);
        mEdSchool = (EditText) findViewById(R.id.ed_school);
        mEdYuanxi = (EditText) findViewById(R.id.ed_yuanxi);
        mEdDiqu = (TextView) findViewById(R.id.ed_diqu);
        mLlDiqu = (LinearLayout) findViewById(R.id.ll_diqu);
        mEdFapiao = (EditText) findViewById(R.id.ed_fapiao);
        mLlTijiao = (LinearLayout) findViewById(R.id.ll_tijiao);
        mLlTijiao.setOnClickListener(this);
        mLlDiqu.setOnClickListener(this);
        userInfo = UserInfoSharePreference.getIns().get(this);
        mPicker.init(this);
        initAddressDialog();

        mEdEmail.setText(userInfo.getLoginName());
        mEdName.setText(userInfo.getUserName());
        mEdSchool.setText(userInfo.getSchool());

        mTxtLeftTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SignUpActivity.this.finish();
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
                if (!mEdEmail.getText().toString().equals("") && !mEdName.getText().toString().equals("") && !mEdPhone.getText().toString().equals("") && !mEdSchool.getText().toString().equals("") && !mEdYuanxi.getText().toString().equals("")
                        && !sheng.toString().equals("") && !shi.toString().equals("") && !qu.toString().equals("") && !mEdFapiao.getText().toString().equals("")) {
                    Intent intent = new Intent(SignUpActivity.this, SignUpSaveEditActivity.class);
                    intent.putExtra("email", mEdEmail.getText().toString());
                    intent.putExtra("name", mEdName.getText().toString());
                    intent.putExtra("phone", mEdPhone.getText().toString());
                    intent.putExtra("school", mEdSchool.getText().toString());
                    intent.putExtra("yuanxi", mEdYuanxi.getText().toString());
                    intent.putExtra("sheng", sheng.toString());
                    intent.putExtra("shi", shi.toString());
                    intent.putExtra("qu", qu.toString());
                    intent.putExtra("fapiaodizhi", mEdFapiao.getText().toString());
                    intent.putExtra("cadd", cadd);
                    intent.putExtra("id", id);
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "信息不能为空！", Toast.LENGTH_SHORT).show();
                }


                break;
            case R.id.ll_diqu:

                mPicker.showCityPicker();
                break;
        }
    }
}
