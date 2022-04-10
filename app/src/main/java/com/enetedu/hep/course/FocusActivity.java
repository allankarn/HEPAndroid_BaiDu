package com.enetedu.hep.course;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;

import com.enetedu.hep.R;
import com.enetedu.hep.base.BaseActivityPro;
import com.enetedu.hep.course.adapter.FocusAdapter;

import com.enetedu.hep.http.RespBase;
import com.enetedu.hep.http.entity.BaseEntity;
import com.enetedu.hep.http.entity.TodayCourseListEntity;
import com.enetedu.hep.utils.CalenderUtilss;

import java.util.ArrayList;


public class FocusActivity extends BaseActivityPro {

    private RecyclerView mRlvDangtian;
    private RecyclerView mRlv2tian;
    private RecyclerView mBantian;
    private FocusAdapter focusAdapter;
    private FocusAdapter focusAdapter2;
    private FocusAdapter focusAdapter3;
    private CalendarView mCalendarView;
    /**
     * 2018-10-17当天课程
     */
    private TextView mTvTime;
    private TodayCourseListEntity todayCourseListEntity;
    private static final String TAG = "FocusActivity";
    /**
     * 返回
     */
    private TextView mTxtLeftTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_focus);

        initView();
        getDataList();

    }

    private void initView() {
        mRlvDangtian = (RecyclerView) findViewById(R.id.rlv_dangtian);
        mRlv2tian = (RecyclerView) findViewById(R.id.rlv_2tian);
        mBantian = (RecyclerView) findViewById(R.id.bantian);
        mTvTime = (TextView) findViewById(R.id.tv_time);
        mCalendarView = (CalendarView) findViewById(R.id.calendar_view);
        mTxtLeftTitle = (TextView) findViewById(R.id.txt_left_title);

        todayCourseListEntity = new TodayCourseListEntity();
        mTvTime.setText(CalenderUtilss.getYear() + "-" + CalenderUtilss.getMonth() + "-" + CalenderUtilss.getCurrentMonthDay() + "当天课程");

        mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                int ii = i1 + 1;
                mTvTime.setText(i + "-" + ii + "-" + i2 + "当天课程");
                String a = "";
                if (ii < 10) {
                    a = "0" + ii;
                } else {
                    a = "" + ii;
                }
                String a2 = "";
                if (i2 < 10) {
                    a2 = "0" + i2;
                } else {
                    a2 = "" + i2;
                }
                todayCourseListEntity.getCourseListjz1(i + "-" + a + "-" + a2, new BaseEntity.OnBaseResp() {
                    @Override
                    public void onResp(RespBase resp) {
                        if (resp.getResCode() == 0) {
                            ArrayList<TodayCourseListEntity> data = (ArrayList<TodayCourseListEntity>) resp.getData();
                            if (data != null && data.size() > 0) {
                                focusAdapter.addData(data);
                                focusAdapter.setOnItemListener(new FocusAdapter.OnItemListener() {
                                    @Override
                                    public void onlick(View v, int position) {
                                        if (focusAdapter.mList.get(position).getCoursetype().equals("集中")) {
                                            Intent intent = new Intent(FocusActivity.this, FocusDetailsActivity.class);
                                            intent.putExtra("id", focusAdapter.mList.get(position).getId());
                                            startActivity(intent);
                                        } else if (focusAdapter.mList.get(position).getCoursetype().equals("直播")) {

                                            Intent intent = new Intent(FocusActivity.this, LiveDetailsActivity.class);
                                            intent.putExtra("id", focusAdapter.mList.get(position).getId());
                                            startActivity(intent);
                                        }
                                    }
                                });
                            } else {
                                focusAdapter.addData(data);
                            }
                        }
                    }
                });
            }
        });
        mTxtLeftTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FocusActivity.this.finish();
            }
        });

    }

    private void getDataList() {
        mRlvDangtian.setLayoutManager(new LinearLayoutManager(this));
        mRlv2tian.setLayoutManager(new LinearLayoutManager(this));
        mBantian.setLayoutManager(new LinearLayoutManager(this));

        focusAdapter = new FocusAdapter();
        focusAdapter2 = new FocusAdapter();
        focusAdapter3 = new FocusAdapter();

        mRlvDangtian.setAdapter(focusAdapter);
        mRlv2tian.setAdapter(focusAdapter2);
        mBantian.setAdapter(focusAdapter3);

        loadCourseListjz1();
        loadCourseListjz2();
        loadCourseListjz3();
    }

    private void loadCourseListjz1() {
        String a = "";
        if (CalenderUtilss.getMonth() < 10) {
            a = "0" + CalenderUtilss.getMonth();
        }
        todayCourseListEntity.getCourseListjz1(CalenderUtilss.getYear() + "-" + a + "-" + CalenderUtilss.getCurrentMonthDay(), new BaseEntity.OnBaseResp() {
            @Override
            public void onResp(RespBase resp) {
                if (resp.getResCode() == 0) {
                    ArrayList<TodayCourseListEntity> data = (ArrayList<TodayCourseListEntity>) resp.getData();
                    if (data != null && data.size() > 0) {
                        focusAdapter.addData(data);
                        focusAdapter.setOnItemListener(new FocusAdapter.OnItemListener() {
                            @Override
                            public void onlick(View v, int position) {
                                if (focusAdapter.mList.get(position).getCoursetype().equals("集中")) {
                                    Intent intent = new Intent(FocusActivity.this, FocusDetailsActivity.class);
                                    intent.putExtra("id", focusAdapter.mList.get(position).getId());
                                    startActivity(intent);
                                } else if (focusAdapter.mList.get(position).getCoursetype().equals("直播")) {

                                    Intent intent = new Intent(FocusActivity.this, LiveDetailsActivity.class);
                                    intent.putExtra("id", focusAdapter.mList.get(position).getId());
                                    startActivity(intent);
                                }
                            }
                        });
                    }
                }
            }
        });
    }

    private void loadCourseListjz2() {
        todayCourseListEntity.getCourseListjz2(new BaseEntity.OnBaseResp() {
            @Override
            public void onResp(RespBase resp) {
                if (resp.getResCode() == 0) {
                    ArrayList<TodayCourseListEntity> data = (ArrayList<TodayCourseListEntity>) resp.getData();
                    if (data != null && data.size() > 0) {
                        focusAdapter2.addData(data);
                        focusAdapter2.setOnItemListener(new FocusAdapter.OnItemListener() {
                            @Override
                            public void onlick(View v, int position) {
                                Intent intent = new Intent(FocusActivity.this, FocusDetailsActivity.class);
                                intent.putExtra("id", focusAdapter2.mList.get(position).getId());
                                startActivity(intent);
                            }
                        });
                    }
                }
            }
        });
    }

    private void loadCourseListjz3() {
        todayCourseListEntity.getCourseListjz3(new BaseEntity.OnBaseResp() {
            @Override
            public void onResp(RespBase resp) {
                if (resp.getResCode() == 0) {
                    ArrayList<TodayCourseListEntity> data = (ArrayList<TodayCourseListEntity>) resp.getData();
                    if (data != null && data.size() > 0) {
                        focusAdapter3.addData(data);
                        focusAdapter3.setOnItemListener(new FocusAdapter.OnItemListener() {
                            @Override
                            public void onlick(View v, int position) {
                                Intent intent = new Intent(FocusActivity.this, LiveDetailsActivity.class);
                                intent.putExtra("id", focusAdapter3.mList.get(position).getId());
                                startActivity(intent);
                            }
                        });
                    }
                }
            }
        });
    }
}
