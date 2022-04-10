package com.enetedu.hep.course;

import android.content.Intent;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.enetedu.hep.R;
import com.enetedu.hep.base.BaseActivityPro;
import com.enetedu.hep.config.UserInfoSharePreference;
import com.enetedu.hep.course.adapter.ShopAdapter;
import com.enetedu.hep.http.RespBase;
import com.enetedu.hep.http.entity.BaseEntity;
import com.enetedu.hep.http.entity.ShoppingCartListEntity;
import com.enetedu.hep.http.entity.UserInfo;
import com.enetedu.hep.utils.BaseDialog;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

//购物车
public class ShopActivity extends BaseActivityPro implements View.OnClickListener {

    private static final String TAG = "ShopActivity";
    private RecyclerView mRlv;
    /**
     * 合计：
     */
    private TextView mHeji;
    /**
     * 提交所选课程
     */
    private TextView mTijiao;

    private ShopAdapter myAdapter;
    private ShoppingCartListEntity shoppingCartListEntity;
    private TextView tv_xueshi;
    private float courseCerdit = 0;
    private UserInfo userInfo;
    /**
     * 返回
     */
    private TextView mTxtLeftTitle;
    private String checked;
    private ArrayList<String> courseName = new ArrayList<>();
    private ArrayList<String> id = new ArrayList<>();
    private BaseDialog baseDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        initView();
        //初始化列表
        getDataList();
        //处理多选的方法
        initLogic();
    }

    private void initView() {
        mRlv = (RecyclerView) findViewById(R.id.rv);
        mHeji = (TextView) findViewById(R.id.heji);
        mTijiao = (TextView) findViewById(R.id.tijiao);
        tv_xueshi = findViewById(R.id.tv_xueshi);
        userInfo = UserInfoSharePreference.getIns().get(this);
        shoppingCartListEntity = new ShoppingCartListEntity();
        mTxtLeftTitle = (TextView) findViewById(R.id.txt_left_title);

        mTxtLeftTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShopActivity.this.finish();
            }
        });


        mTijiao.setOnClickListener(this);
    }

    private void initLogic() {
        //每次点击多选框，记录当前position的状态
        myAdapter.onItemCheck(new ShopAdapter.onItemCheckListener() {
            @Override
            public void onItemCheck(int position) {
                //先获取当前的选中或未选中状态
                boolean check = myAdapter.mList.get(position).isCheck();

                //改变数据集合里当前下标的状态属性
                myAdapter.mList.get(position).setCheck(!check);
                //刷新适配器
                myAdapter.notifyDataSetChanged();

                if (myAdapter.mList.get(position).isCheck() == true) {
                    courseCerdit = courseCerdit + Float.parseFloat(myAdapter.mList.get(position).getCourseCerdit());
                    BigDecimal bigDecimal = new BigDecimal(courseCerdit);
                    tv_xueshi.setText(bigDecimal.setScale(2, RoundingMode.HALF_UP) + "课时");

                    courseName.add(myAdapter.mList.get(position).getCourseName());
                    id.add(myAdapter.mList.get(position).getID());
                }
                if (myAdapter.mList.get(position).isCheck() == false) {
                    courseCerdit = courseCerdit - Float.parseFloat(myAdapter.mList.get(position).getCourseCerdit());
                    BigDecimal bigDecimal = new BigDecimal(courseCerdit);
                    tv_xueshi.setText(bigDecimal.setScale(2, RoundingMode.HALF_UP) + "课时");

                    courseName.remove(myAdapter.mList.get(position).getCourseName());
                    id.remove(myAdapter.mList.get(position).getID());
                }
            }
        });
    }

    private void getDataList() {

        mRlv.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new ShopAdapter();
        mRlv.setAdapter(myAdapter);
        loadShoppingCartList();

    }

    private void loadShoppingCartList() {
        shoppingCartListEntity.getShoppingCartList("ENDPOINT_ANDROID", userInfo.getUserToken(), userInfo.getUserId(), 1, 50, new BaseEntity.OnBaseResp() {
            @Override
            public void onResp(RespBase resp) {
                if (resp.getResCode() == 0) {
                    ArrayList<ShoppingCartListEntity> data = (ArrayList<ShoppingCartListEntity>) resp.getData();

                    if (data != null && data.size() > 0) {
                        for (int i = 0; i < data.size(); i++) {
                            data.get(i).setCheck(false);
                        }
                        myAdapter.addData(data);
                        myAdapter.setOnItemListener(new ShopAdapter.OnItemListener() {
                            @Override
                            public void onlick(View v, int position) {
                                Log.d(TAG, "myAdapter: --------------------------" + position);
                                initCountDialog(position);
                            }

                        });

                    }
                }
            }
        });
    }

    private void loadGetDeleteShoppingCartByCourseID(int position) {
        Log.d(TAG, "loadGetDeleteShoppingCartByCourseID: -----------------" + position);
        int i = Integer.parseInt(myAdapter.mList.get(position).getID());
        shoppingCartListEntity.getDeleteShoppingCartByCourseID("ENDPOINT_ANDROID", userInfo.getUserToken(), userInfo.getUserId(), i, new BaseEntity.OnBaseResp() {
            @Override
            public void onResp(RespBase resp) {
                if (resp.getResCode() == 0) {
                    Toast.makeText(ShopActivity.this, resp.getDesc(), Toast.LENGTH_SHORT).show();
                    loadShoppingCartList();

                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.tijiao:
                if (courseCerdit == 0) {
                    Toast.makeText(this, "请选择课程，最多不能超过25学时", Toast.LENGTH_SHORT).show();
                } else if (courseCerdit < 25) {
                    Intent intent = new Intent(ShopActivity.this, ZiCourseAffirmActivity.class);
                    intent.putExtra("name", courseName);
                    intent.putExtra("id", id);
                    startActivity(intent);
                    id.clear();
                    courseName.clear();
                } else {
                    Toast.makeText(this, "生成课程的时长最多25学时！", Toast.LENGTH_SHORT).show();
                }

                break;
        }
    }

    private void initCountDialog(int position1) {
        View inflate = LayoutInflater.from(this).inflate(R.layout.dialog, null);
        Button btn_no = inflate.findViewById(R.id.btn_no);
        Button btn_yes = inflate.findViewById(R.id.btn_yes);
        TextView tv_tishi = inflate.findViewById(R.id.tv_tishi);
        tv_tishi.setText("确定要删除吗？");

        btn_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                baseDialog.dismiss();
            }
        });

        btn_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "btn_yes: --------------------" + position1);
                loadGetDeleteShoppingCartByCourseID(position1);
                baseDialog.dismiss();
            }
        });

        if (baseDialog == null) {
            baseDialog = new BaseDialog(this, inflate, Gravity.CENTER);
        }
        baseDialog.show();
    }
}
