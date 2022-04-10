package com.enetedu.hep.course;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Looper;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.Toast;

import com.enetedu.hep.R;
import com.enetedu.hep.base.BaseActivityPro;
import com.enetedu.hep.config.UserInfoSharePreference;
import com.enetedu.hep.course.adapter.OnlineStuAdapter;
import com.enetedu.hep.http.RespBase;
import com.enetedu.hep.http.entity.BaseEntity;
import com.enetedu.hep.http.entity.CourseWareListEntity;
import com.enetedu.hep.http.entity.UserInfo;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class VideoPlayForMgcActivity extends BaseActivityPro {

    private JCVideoPlayerStandard jcVideoPlayerStandard;
    private RecyclerView mRlv;
    private UserInfo userInfo;
    private CourseWareListEntity courseWareListEntity;
    private OnlineStuAdapter onlineStuAdapter;
    private SensorManager sensorManager;
    private JCVideoPlayer.JCAutoFullscreenListener sensorEventListener;
    private int id;

    private BufferedReader bufferedReader;
    protected String replace;
    private static final String TAG = "VideoPlayForMgcActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_play_for_mgc);
        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);
        initView();
        loadVideoPlayForMgc();

    }

    private void initView() {
        jcVideoPlayerStandard = (JCVideoPlayerStandard) findViewById(R.id.videoplayer);
        mRlv = (RecyclerView) findViewById(R.id.rlv);

        userInfo = UserInfoSharePreference.getIns().get(this);
        courseWareListEntity = new CourseWareListEntity();

        mRlv.setLayoutManager(new LinearLayoutManager(this));
        onlineStuAdapter = new OnlineStuAdapter();
        mRlv.setAdapter(onlineStuAdapter);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorEventListener = new JCVideoPlayer.JCAutoFullscreenListener();


        jcVideoPlayerStandard.tinyBackImageView.setVisibility(View.GONE);
        jcVideoPlayerStandard.backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VideoPlayForMgcActivity.this.finish();
            }
        });
    }

    private void loadVideoPlayForMgc() {
        courseWareListEntity.getVideoPlayForMgc("ENDPOINT_ANDROID", userInfo.getUserToken(), userInfo.getUserId(), id, new BaseEntity.OnBaseResp() {
            @Override
            public void onResp(RespBase resp) {
                if (resp.getResCode() == 0) {
                    final ArrayList<CourseWareListEntity> data = (ArrayList<CourseWareListEntity>) resp.getData();
                    if (data != null && data.size() > 0) {
                        onlineStuAdapter.addData(data);

                        courseWareListEntity.getCdnurl("ENDPOINT_ANDROID", data.get(0).getCmsid(), new BaseEntity.OnBaseResp() {
                            @Override
                            public void onResp(RespBase resp) {
                                if (resp.getResCode() == 0) {
                                    getUrlAndPrepareAsync(resp.getDesc());
                                }
                            }
                        });
                        onlineStuAdapter.setOnItemListener(new OnlineStuAdapter.OnItemListener() {
                            @Override
                            public void onlick(View v, int position) {
                                courseWareListEntity.getCdnurl("ENDPOINT_ANDROID", data.get(position).getCmsid(), new BaseEntity.OnBaseResp() {
                                    @Override
                                    public void onResp(RespBase resp) {
                                        if (resp.getResCode() == 0) {
                                            getUrlAndPrepareAsync(resp.getDesc());
                                        }
                                    }
                                });
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
                    //三分钟请求一次接口
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

                                        jcVideoPlayerStandard.setUp(replace, JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL);
                                        jcVideoPlayerStandard.startVideo();
                                    }
                                });
                                /*CommonUtil.runOnUIThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Log.d(TAG, "run: ================================" + replace);
                                        jcVideoPlayerStandard.setUp(replace, JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL);
                                        jcVideoPlayerStandard.startVideo();
                                    }
                                });*/
                            } else {
                                Toast.makeText(VideoPlayForMgcActivity.this, "视频暂无法播放", Toast.LENGTH_SHORT).show();
                            }
                        }
                    } else {
                        Toast.makeText(VideoPlayForMgcActivity.this, "视频暂无法播放", Toast.LENGTH_SHORT).show();
                    }
                } catch (MalformedURLException e) {
                    Toast.makeText(VideoPlayForMgcActivity.this, "视频暂无法播放", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    Toast.makeText(VideoPlayForMgcActivity.this, "视频暂无法播放", Toast.LENGTH_SHORT).show();
                } catch (JSONException e1) {
                    Toast.makeText(VideoPlayForMgcActivity.this, "视频暂无法播放", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(VideoPlayForMgcActivity.this, "视频暂无法播放", Toast.LENGTH_SHORT).show();
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
