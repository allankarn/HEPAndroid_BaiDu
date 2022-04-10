package com.enetedu.hep.study;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import com.enetedu.hep.R;
import com.enetedu.hep.base.BaseActivityPro;
import com.enetedu.hep.config.UserInfoSharePreference;
import com.enetedu.hep.http.RespBase;
import com.enetedu.hep.http.entity.BaseEntity;
import com.enetedu.hep.http.entity.StudyMyCourseEntity;
import com.enetedu.hep.http.entity.UserInfo;
import com.enetedu.hep.study.adapter.MyExpandableListViewAdapter;
import com.enetedu.hep.utils.CommonUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class StudyMyCourseActivity extends BaseActivityPro {

    private static final String TAG = "StudyMyCourseActivity";
    private JCVideoPlayerStandard jcVideoPlayerStandard;
    private BufferedReader bufferedReader;
    protected String replace;
    private SensorManager sensorManager;
    private JCVideoPlayer.JCAutoFullscreenListener sensorEventListener;
    /**
     * 标题
     */
    private TextView mTvTitle;
    private ExpandableListView mExpandableListView;
    private StudyMyCourseEntity studyMyCourseEntity;
    private UserInfo userInfo;
    private int id;
    private int courseid;
    private MyExpandableListViewAdapter myExpandableListViewAdapter;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_my_course);

        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);
        courseid = intent.getIntExtra("courseid", 0);
        name = intent.getStringExtra("name");
        initView();
        loadStudyMyCourse();

    }

    private void initView() {
        jcVideoPlayerStandard = (JCVideoPlayerStandard) findViewById(R.id.videoplayer);
        mTvTitle = (TextView) findViewById(R.id.tv_title);
        mExpandableListView = (ExpandableListView) findViewById(R.id.expandableListView);

        mTvTitle.setText(name);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorEventListener = new JCVideoPlayer.JCAutoFullscreenListener();
        userInfo = UserInfoSharePreference.getIns().get(this);
        studyMyCourseEntity = new StudyMyCourseEntity();


        jcVideoPlayerStandard.tinyBackImageView.setVisibility(View.GONE);
        jcVideoPlayerStandard.backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StudyMyCourseActivity.this.finish();
            }
        });

    }


    private void loadStudyMyCourse() {
        studyMyCourseEntity.getStudyMyCourse(userInfo.getUserToken(), userInfo.getUserId(), id, new BaseEntity.OnBaseResp() {
            @Override
            public void onResp(RespBase resp) {
                if (resp.getResCode() == 0) {
                    ArrayList<StudyMyCourseEntity> data = (ArrayList<StudyMyCourseEntity>) resp.getData();

                    if (data != null && data.size() > 0) {
                        myExpandableListViewAdapter = new MyExpandableListViewAdapter(StudyMyCourseActivity.this, data);
                        mExpandableListView.setAdapter(myExpandableListViewAdapter);

                        //进入页面直接播放第一个视频
                        if (myExpandableListViewAdapter.mList.get(0).getCourseType() == 1) {
                            studyMyCourseEntity.getStudyMyCourseForCourse2(userInfo.getUserToken(), userInfo.getUserId(), id, myExpandableListViewAdapter.mList.get(0).getId(), myExpandableListViewAdapter.mList.get(0).getViewenrolldetails().get(0).getId(), new BaseEntity.OnBaseResp() {
                                @Override
                                public void onResp(RespBase resp) {
                                    if (resp.getResCode() == 0) {
                                        ArrayList<StudyMyCourseEntity> data1 = (ArrayList<StudyMyCourseEntity>) resp.getData();
                                        if (data1 != null && data1.size() > 0) {

                                            getUrlAndPrepareAsync(data1.get(0).getViewenrolldetails().get(0).getCmsidurl());
                                        }
                                    } else {
                                        Toast.makeText(StudyMyCourseActivity.this, resp.getDesc(), Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                        }else if (myExpandableListViewAdapter.mList.get(0).getCourseType() == 2) {

                            studyMyCourseEntity.getStudyMyCourseForChoice(userInfo.getUserToken(), userInfo.getUserId(), id, myExpandableListViewAdapter.mList.get(0).getId(), myExpandableListViewAdapter.mList.get(0).getViewenrolldetails().get(0).getId(), new BaseEntity.OnBaseResp() {
                                @Override
                                public void onResp(RespBase resp) {
                                    if (resp.getResCode() == 0) {
                                        ArrayList<StudyMyCourseEntity> data2 = (ArrayList<StudyMyCourseEntity>) resp.getData();
                                        if (data2 != null && data2.size() > 0) {

                                            getUrlAndPrepareAsync(data2.get(0).getViewenrolldetails().get(0).getCmsidurl());

                                        }
                                    } else {
                                        Toast.makeText(StudyMyCourseActivity.this, resp.getDesc(), Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                        }
                        //点击条目挑选课程播放
                        mExpandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
                            @Override
                            public boolean onChildClick(ExpandableListView expandableListView, View view, final int groupPosition, final int childPosition, long l) {

                                //Log.d(TAG, "CourseType: " + myExpandableListViewAdapter.mList.get(groupPosition).getCourseType());
                                if (myExpandableListViewAdapter.mList.get(groupPosition).getCourseType() == 1) {
                                    //Log.d(TAG, "StudyMyCourseForCourse2:--- " + id + "----" + myExpandableListViewAdapter.mList.get(groupPosition).getId() + "----" + myExpandableListViewAdapter.mList.get(groupPosition).getViewenrolldetails().get(childPosition).getId());
                                    studyMyCourseEntity.getStudyMyCourseForCourse2(userInfo.getUserToken(), userInfo.getUserId(), id, myExpandableListViewAdapter.mList.get(groupPosition).getId(), myExpandableListViewAdapter.mList.get(groupPosition).getViewenrolldetails().get(childPosition).getId(), new BaseEntity.OnBaseResp() {
                                        @Override
                                        public void onResp(RespBase resp) {
                                            if (resp.getResCode() == 0) {
                                                ArrayList<StudyMyCourseEntity> data1 = (ArrayList<StudyMyCourseEntity>) resp.getData();
                                                //Log.d(TAG, "onResp: " + data1.size());
                                                if (data1 != null && data1.size() > 0) {
                                                   // Log.d(TAG, "onResp: " + data1.get(groupPosition).getViewenrolldetails().get(childPosition).getCmsidurl());

                                                    getUrlAndPrepareAsync(data1.get(groupPosition).getViewenrolldetails().get(childPosition).getCmsidurl());

                                                }
                                            } else {
                                                Toast.makeText(StudyMyCourseActivity.this, resp.getDesc(), Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    });
                                } else if (myExpandableListViewAdapter.mList.get(groupPosition).getCourseType() == 2) {

                                    //Log.d(TAG, "StudyMyCourseForChoice:--- " + id + "----" + myExpandableListViewAdapter.mList.get(groupPosition).getId() + "----" + myExpandableListViewAdapter.mList.get(groupPosition).getViewenrolldetails().get(childPosition).getId());
                                    studyMyCourseEntity.getStudyMyCourseForChoice(userInfo.getUserToken(), userInfo.getUserId(), id, myExpandableListViewAdapter.mList.get(groupPosition).getId(), myExpandableListViewAdapter.mList.get(groupPosition).getViewenrolldetails().get(childPosition).getId(), new BaseEntity.OnBaseResp() {
                                        @Override
                                        public void onResp(RespBase resp) {
                                            if (resp.getResCode() == 0) {
                                                ArrayList<StudyMyCourseEntity> data2 = (ArrayList<StudyMyCourseEntity>) resp.getData();
                                               // Log.d(TAG, "onResp: " + data2.size());
                                                if (data2 != null && data2.size() > 0) {
                                                   // Log.d(TAG, "onResp: " + data2.get(groupPosition).getViewenrolldetails().get(childPosition).getCmsidurl());

                                                    getUrlAndPrepareAsync(data2.get(groupPosition).getViewenrolldetails().get(childPosition).getCmsidurl());

                                                }
                                            } else {
                                                Toast.makeText(StudyMyCourseActivity.this, resp.getDesc(), Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    });
                                }

                                return false;
                            }
                        });

                    }
                }
            }
        });
    }


    private void getUrlAndPrepareAsync(final String vedioUrl) {
        new Thread() {
            public void run() {
                Looper.prepare();
                try {
                    URL url = new URL(vedioUrl);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setConnectTimeout(6 * 1000);
                    conn.setRequestMethod("GET");
                    if (conn.getResponseCode() == 200) {//从Internet获取网页,发送请求,将网页以流的形式读回来
                        InputStream is = conn.getInputStream();
                        bufferedReader = new BufferedReader(new InputStreamReader(is));
                        String line = null;
                        StringBuffer strBuffer = null;
                        if (bufferedReader != null) {
                            strBuffer = new StringBuffer();
                            try {
                                while ((line = bufferedReader.readLine()) != null) {
                                    strBuffer.append(line);
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                                // GenseeLog.e(e);
                            }
                        }
                        String recordUrl = null;
                        if (strBuffer != null) {
                            String result = strBuffer.toString();
                            JSONObject object = new JSONObject(result);
                            if (object != null) {
                                recordUrl = object.getString("dl_link");
                            }
                            if (recordUrl.contains("record.xml")) {
                                replace = recordUrl.replace("record.xml", "nor/record.m3u8");

                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Log.d(TAG, "run: ================================" + replace);
                                        jcVideoPlayerStandard.setUp(replace, JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL);
                                        jcVideoPlayerStandard.startVideo();
                                    }
                                });
                               /* CommonUtil.runOnUIThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Log.d(TAG, "run: ================================" + replace);
                                        jcVideoPlayerStandard.setUp(replace, JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL);
                                        jcVideoPlayerStandard.startVideo();
                                    }
                                });*/
                            } else {
                                Toast.makeText(StudyMyCourseActivity.this, "视频暂无法播放", Toast.LENGTH_SHORT).show();
                            }
                        }
                    } else {
                        Toast.makeText(StudyMyCourseActivity.this, "视频暂无法播放", Toast.LENGTH_SHORT).show();
                    }
                } catch (MalformedURLException e) {
                    Toast.makeText(StudyMyCourseActivity.this, "视频暂无法播放", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    Toast.makeText(StudyMyCourseActivity.this, "视频暂无法播放", Toast.LENGTH_SHORT).show();
                } catch (JSONException e1) {
                    Toast.makeText(StudyMyCourseActivity.this, "视频暂无法播放", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(StudyMyCourseActivity.this, "视频暂无法播放", Toast.LENGTH_SHORT).show();
                }
            }
        }.start();
        Looper.loop();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Sensor accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(sensorEventListener, accelerometerSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(sensorEventListener);
        JCVideoPlayer.releaseAllVideos();
    }

    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }
}
