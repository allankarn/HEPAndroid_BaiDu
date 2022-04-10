package com.enetedu.hep.my;

import android.content.Intent;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.enetedu.hep.R;
import com.enetedu.hep.base.BaseActivityPro;
import com.enetedu.hep.http.RespBase;
import com.enetedu.hep.http.entity.BaseEntity;
import com.enetedu.hep.http.entity.NationEntity;
import com.enetedu.hep.my.adapter.NationAdapter;
import com.enetedu.hep.utils.SimpleToolbar;

import java.util.ArrayList;

public class NationActivity extends BaseActivityPro {

    /**
     * 返回
     */
    private TextView mTxtLeftTitle;
    /**
     * 选择民族
     */
    private TextView mTxtMainTitle;
    private SimpleToolbar mSimpleToolbar;
    private RecyclerView mRlv;
    private NationAdapter nationAdapter;
    private NationEntity nationEntity;
    private static final String TAG = "NationActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nation);
        initView();
        loadGetNation();
    }

    private void initView() {
        mTxtLeftTitle = (TextView) findViewById(R.id.txt_left_title);
        mTxtMainTitle = (TextView) findViewById(R.id.txt_main_title);
        mSimpleToolbar = (SimpleToolbar) findViewById(R.id.simple_toolbar);
        mRlv = (RecyclerView) findViewById(R.id.rlv);

        nationEntity = new NationEntity();
        mRlv.setLayoutManager(new LinearLayoutManager(this));
        nationAdapter = new NationAdapter();
        mRlv.setAdapter(nationAdapter);

        mTxtLeftTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NationActivity.this.finish();
            }
        });
    }

    private void loadGetNation() {
        nationEntity.getNation(new BaseEntity.OnBaseResp() {
            @Override
            public void onResp(RespBase resp) {
                Log.d(TAG, "onResp: " + resp);
                if (resp.getResCode() == 0) {
                    ArrayList<NationEntity> data = (ArrayList<NationEntity>) resp.getData();

                    if (data != null && data.size() > 0) {
                        nationAdapter.addData(data);
                        nationAdapter.setOnItemListener(new NationAdapter.OnItemListener() {
                            @Override
                            public void onlick(View v, int position) {
                                Intent intent = new Intent();
                                intent.putExtra("nation", nationAdapter.mList.get(position).getName());
                                setResult(RESULT_OK, intent);
                                NationActivity.this.finish();
                            }
                        });
                    }
                }
            }
        });
    }
}
