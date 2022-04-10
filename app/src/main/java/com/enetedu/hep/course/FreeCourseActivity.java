package com.enetedu.hep.course;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.enetedu.hep.R;
import com.enetedu.hep.base.BaseActivityPro;
import com.enetedu.hep.course.adapter.FreeCourseAdapter;
import com.enetedu.hep.http.RespBase;
import com.enetedu.hep.http.entity.BaseEntity;
import com.enetedu.hep.http.entity.Course2ModelEntity;

import java.util.ArrayList;

public class FreeCourseActivity extends BaseActivityPro {

    /**
     * 返回
     */
    private TextView mTxtLeftTitle;
    private RecyclerView mRlv;
    private FreeCourseAdapter freeCourseAdapter;
    private Course2ModelEntity course2ModelEntity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_course);
        initView();
        loadPublicClass();
    }

    private void initView() {
        mTxtLeftTitle = (TextView) findViewById(R.id.txt_left_title);
        mRlv = (RecyclerView) findViewById(R.id.rlv);

        course2ModelEntity = new Course2ModelEntity();
        mRlv.setLayoutManager(new LinearLayoutManager(this));
        freeCourseAdapter = new FreeCourseAdapter();
        mRlv.setAdapter(freeCourseAdapter);

        mTxtLeftTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FreeCourseActivity.this.finish();
            }
        });
    }

    private void loadPublicClass() {
        course2ModelEntity.getPublicClass(new BaseEntity.OnBaseResp() {
            @Override
            public void onResp(RespBase resp) {
                if (resp.getResCode() == 0) {
                    ArrayList<Course2ModelEntity> data = (ArrayList<Course2ModelEntity>) resp.getData();

                    if (data != null && data.size() > 0) {
                        freeCourseAdapter.addData(data);
                        freeCourseAdapter.setOnItemListener(new FreeCourseAdapter.OnItemListener() {
                            @Override
                            public void onlick(View v, int position) {
                                Intent intent = new Intent(FreeCourseActivity.this, OnlineDetailsActivity.class);
                                intent.putExtra("id", freeCourseAdapter.mList.get(position).getId());
                                intent.putExtra("1",1);
                                startActivity(intent);
                            }
                        });
                    }
                }
            }
        });
    }
}
