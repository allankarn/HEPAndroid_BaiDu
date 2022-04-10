package com.enetedu.hep.course;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.enetedu.hep.R;
import com.enetedu.hep.config.UserInfoSharePreference;
import com.enetedu.hep.course.adapter.JzXueXiAdapter;
import com.enetedu.hep.course.adapter.PeiXunAdapter;
import com.enetedu.hep.http.RespBase;
import com.enetedu.hep.http.entity.BaseEntity;
import com.enetedu.hep.http.entity.CaddressListEntity;
import com.enetedu.hep.http.entity.UserInfo;
import com.enetedu.hep.utils.BaseDialog;
import com.enetedu.hep.utils.SimpleToolbar;
import com.weigan.loopview.LoopView;

import java.util.ArrayList;

public class SignUpSaveEditActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 返回
     */
    private TextView mTxtLeftTitle;
    /**
     * 集中报名
     */
    private TextView mTxtMainTitle;
    /**
     * 下一步
     */
    private TextView mTvTijiao;
    private SimpleToolbar mSimpleToolbar;
    /**
     * 住宿信息
     */
    private TextView mTvTitle;
    /**
     * 请选择
     */
    private TextView mTvDidian;
    /**
     * 请输入
     */
    private TextView mTvFeiyong;
    /**
     * 请选择：
     */
    private TextView mTvAnpai;
    /**
     * 请选择：
     */
    private TextView tv_time;
    private RecyclerView mRlv;
    private ArrayList<CaddressListEntity> cadd;
    private BaseDialog baseDialog;
    private BaseDialog baseDialog2;
    private BaseDialog baseDialog3;
    private LinearLayout mLlDidian;
    private UserInfo userInfo;
    private int id;
    private String email;
    private String name;
    private String phone;
    private String school;
    private String yuanxi;
    private String sheng;
    private String shi;
    private String qu;
    private String fapiaodizhi;
    private String centerid;
    private String yearStr;
    private String monthStr;
    private String dayStr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_save_edit);
        Intent intent = getIntent();
        cadd = (ArrayList<CaddressListEntity>) intent.getSerializableExtra("cadd");
        id = intent.getIntExtra("id", 0);
        email = intent.getStringExtra("email");
        name = intent.getStringExtra("name");
        phone = intent.getStringExtra("phone");
        school = intent.getStringExtra("school");
        yuanxi = intent.getStringExtra("yuanxi");
        sheng = intent.getStringExtra("sheng");
        shi = intent.getStringExtra("shi");
        qu = intent.getStringExtra("qu");
        fapiaodizhi = intent.getStringExtra("fapiaodizhi");


        initView();
    }

    private void initView() {
        mTxtLeftTitle = (TextView) findViewById(R.id.txt_left_title);
        mTxtMainTitle = (TextView) findViewById(R.id.txt_main_title);
        mTvTijiao = (TextView) findViewById(R.id.tv_tijiao);
        mTvTijiao.setOnClickListener(this);
        mSimpleToolbar = (SimpleToolbar) findViewById(R.id.simple_toolbar);
        mTvTitle = (TextView) findViewById(R.id.tv_title);
        mTvDidian = (TextView) findViewById(R.id.tv_didian);
        mTvFeiyong = (TextView) findViewById(R.id.tv_feiyong);
        mTvAnpai = (TextView) findViewById(R.id.tv_anpai);
        mTvAnpai.setOnClickListener(this);
        tv_time = (TextView) findViewById(R.id.tv_time);
        tv_time.setOnClickListener(this);
        mRlv = (RecyclerView) findViewById(R.id.rlv);
        mLlDidian = (LinearLayout) findViewById(R.id.ll_didian);
        mLlDidian.setOnClickListener(this);
        userInfo = UserInfoSharePreference.getIns().get(this);

    }

    private void loadSignUpSaveEdit() {
        userInfo.getSignUpSaveEdit(id, userInfo.getUserId(), userInfo.getUserToken(), centerid, mTvAnpai.getText().toString(), tv_time.getText().toString(), email, name, phone, sheng, shi, qu,
                fapiaodizhi, school, yuanxi, userInfo.getUserbill(), userInfo.getBill_taxpayernumber(), userInfo.getBill_addressphone(), userInfo.getBill_banknumber(),
                "1", userInfo.getBill_remark(), new BaseEntity.OnBaseResp() {
                    @Override
                    public void onResp(RespBase resp) {
                        if (resp.getResCode() == 0) {
                            Toast.makeText(SignUpSaveEditActivity.this, resp.getDesc(), Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(SignUpSaveEditActivity.this, resp.getDesc(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }


    private void initCountDialog() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.dialog_rlv, null);
        TextView tv_no = inflate.findViewById(R.id.tv_no);
        RecyclerView rlv_dialog = inflate.findViewById(R.id.rlv_dialog);
        rlv_dialog.setLayoutManager(new LinearLayoutManager(this));
        PeiXunAdapter peiXunAdapter = new PeiXunAdapter();
        rlv_dialog.setAdapter(peiXunAdapter);
        peiXunAdapter.addData(cadd);

        peiXunAdapter.setOnItemListener(new PeiXunAdapter.OnItemListener() {
            @Override
            public void onlick(View v, int position) {
                mTvDidian.setText(peiXunAdapter.mList.get(position).getAddress());
                mTvFeiyong.setText(peiXunAdapter.mList.get(position).getCentermoney());
                centerid = peiXunAdapter.mList.get(position).getCenterid();
                mRlv.setLayoutManager(new LinearLayoutManager(SignUpSaveEditActivity.this));
                JzXueXiAdapter jzXueXiAdapter = new JzXueXiAdapter();
                mRlv.setAdapter(jzXueXiAdapter);
                jzXueXiAdapter.addData(cadd.get(position).getTjLists());
                baseDialog.dismiss();
            }
        });
        tv_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                baseDialog.dismiss();
            }
        });

        if (baseDialog == null) {
            baseDialog = new BaseDialog(this, inflate, Gravity.CENTER);
        }
        baseDialog.show();
    }

    private void initCountDialog2() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.dialog_zhusu, null);
        TextView tv_hezhu = inflate.findViewById(R.id.tv_hezhu);
        TextView tv_danzhu = inflate.findViewById(R.id.tv_danzhu);
        TextView tv_no = inflate.findViewById(R.id.tv_no);


        tv_hezhu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTvAnpai.setText("合住");
                baseDialog2.dismiss();
            }
        });

        tv_danzhu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTvAnpai.setText("单住");
                baseDialog2.dismiss();
            }
        });

        tv_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTvAnpai.setText("不安排");
                baseDialog2.dismiss();
            }
        });

        if (baseDialog2 == null) {
            baseDialog2 = new BaseDialog(this, inflate, Gravity.CENTER);
        }
        baseDialog2.show();
    }

    private void initTimeDialog() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.dialog_birth, null);
        TextView cancle = inflate.findViewById(R.id.cancle);
        TextView sure = inflate.findViewById(R.id.sure);
        LoopView loop = inflate.findViewById(R.id.loop);
        LoopView loop2 = inflate.findViewById(R.id.loop2);
        LoopView loop3 = inflate.findViewById(R.id.loop3);
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<String> list3 = new ArrayList<>();
        sure.setOnClickListener(v -> {
            int selectedItem = loop.getSelectedItem();
            yearStr = list.get(selectedItem);
            int selectedItem2 = loop2.getSelectedItem();
            monthStr = list2.get(selectedItem2);
            int selectedItem3 = loop3.getSelectedItem();
            dayStr = list3.get(selectedItem3);

            tv_time.setText(yearStr + "-" + monthStr + "-" + dayStr);

            baseDialog3.dismiss();
        });

        loop.setNotLoop();
        for (int i = 2020; i <= 2050; i++) {
            list.add(i + "");
        }

        for (int i = 1; i <= 12; i++) {
            if (i < 10) {
                list2.add("0" + i);
            } else {
                list2.add(i + "");
            }
        }
        for (int i = 1; i <= 31; i++) {
            if (i < 10) {
                list3.add("0" + i);
            } else {
                list3.add(i + "");
            }
        }

        loop.setItems(list);
        loop2.setItems(list2);
        loop3.setItems(list3);

        loop.setListener(index -> yearStr = list.get(index));
        loop2.setListener(index -> monthStr = list2.get(index));
        loop3.setListener(index -> dayStr = list3.get(index));

        cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baseDialog3.dismiss();
            }
        });


        if (baseDialog3 == null) {
            baseDialog3 = new BaseDialog(this, inflate, Gravity.BOTTOM);
        }
        baseDialog3.show();

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.ll_didian:
                initCountDialog();
                break;
            case R.id.tv_anpai:
                initCountDialog2();
                break;
            case R.id.tv_time:
                initTimeDialog();
                break;
            case R.id.tv_tijiao:
                loadSignUpSaveEdit();
                break;
        }
    }
}
