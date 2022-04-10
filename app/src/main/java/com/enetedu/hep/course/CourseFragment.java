package com.enetedu.hep.course;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.enetedu.hep.R;
import com.enetedu.hep.base.MyBaseFragment;
import com.enetedu.hep.course.adapter.CourseAdapter;
import com.enetedu.hep.http.RespBase;
import com.enetedu.hep.http.entity.BaseEntity;
import com.enetedu.hep.http.entity.HaoKeEntity;
import com.enetedu.hep.http.entity.LunBoTuEntity;
import com.enetedu.hep.my.WebViewActivity;
import com.enetedu.hep.utils.Constant;
import com.xw.banner.Banner;
import com.xw.banner.BannerConfig;
import com.xw.banner.listener.OnBannerListener;
import com.xw.banner.loader.ImageLoader;


import java.util.ArrayList;

/**
 * 课程
 * A simple {@link Fragment} subclass.
 */
public class CourseFragment extends MyBaseFragment implements View.OnClickListener {


    private View inflate;
    private Banner mBanner;
    private ImageView mIvFocus;
    private ImageView mIvLive;
    private ImageView mIvOnline;
    private ImageView mIvWorkshop;
    private ImageView mIvFree;
    private ImageView mIvOrder;
    private ImageView mIvMicro;

    private CourseAdapter myAdapter;

    private RecyclerView mRlvCourse;
    private HaoKeEntity haoKeEntity;
    private static final String TAG = "CourseFragment";
    private LunBoTuEntity lunBoTuEntity;
    private ArrayList<String> bannertitle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        inflate = inflater.inflate(R.layout.fragment_course, container, false);
        initView(inflate);
        loadRotationChart();
        loadMostPopularCourseList();
        return inflate;
    }

    private void initView(View inflate) {
        mBanner = (Banner) inflate.findViewById(R.id.banner);
        mBanner.setOnClickListener(this);
        mIvFocus = (ImageView) inflate.findViewById(R.id.iv_focus);
        mIvFocus.setOnClickListener(this);
        mIvLive = (ImageView) inflate.findViewById(R.id.iv_live);
        mIvLive.setOnClickListener(this);
        mIvOnline = (ImageView) inflate.findViewById(R.id.iv_online);
        mIvOnline.setOnClickListener(this);
        mIvWorkshop = (ImageView) inflate.findViewById(R.id.iv_workshop);
        mIvWorkshop.setOnClickListener(this);
        mIvFree = (ImageView) inflate.findViewById(R.id.iv_free);
        mIvFree.setOnClickListener(this);
        mIvOrder = (ImageView) inflate.findViewById(R.id.iv_order);
        mIvOrder.setOnClickListener(this);
        mIvMicro = (ImageView) inflate.findViewById(R.id.iv_micro);
        mIvMicro.setOnClickListener(this);
        mRlvCourse = (RecyclerView) inflate.findViewById(R.id.rlv_course);
        mRlvCourse.setOnClickListener(this);

        haoKeEntity = new HaoKeEntity();
        lunBoTuEntity = new LunBoTuEntity();
        mRlvCourse.setLayoutManager(new LinearLayoutManager(getActivity()));
        myAdapter = new CourseAdapter();
        mRlvCourse.setAdapter(myAdapter);
        mRlvCourse.setNestedScrollingEnabled(false);
        mRlvCourse.setHasFixedSize(true);
        bannertitle = new ArrayList<>();

    }


    private void loadRotationChart() {
        lunBoTuEntity.getRotationChart(new BaseEntity.OnBaseResp() {
            @Override
            public void onResp(RespBase resp) {
                if (resp.getResCode() == 0) {
                    final ArrayList<LunBoTuEntity> data = (ArrayList<LunBoTuEntity>) resp.getData();
                    if (data != null && data.size() > 0) {

                        ArrayList<String> objects = new ArrayList<>();

                        for (int i = 0; i < data.size(); i++) {
                            objects.add(data.get(i).getPICTURE_URL());
                            bannertitle.add(data.get(i).getTITLE());
                        }
                        mBanner.setBannerTitles(bannertitle)
                                .setImages(objects).setImageLoader(new ImageLoader() {
                            @Override
                            public void displayImage(Context context, Object path, ImageView imageView) {
                                String path1 = (String) path;
                                Glide.with(context).load(path1).into(imageView);
                            }
                        }).setDelayTime(4000)
                                .isAutoPlay(true)
                                .setIndicatorGravity(Gravity.CENTER_VERTICAL)
                                .setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE)
                                .setOnBannerListener(new OnBannerListener() {
                                    @Override
                                    public void OnBannerClick(int position) {
                                        Intent intent = new Intent(getActivity(), WebViewActivity.class);
                                        intent.putExtra(Constant.INTENT_KEY_VALUE, data.get(position).getHYPERLINK());
                                        intent.putExtra("title", data.get(position).getTITLE());
                                        getActivity().startActivity(intent);
                                    }
                                }).start();
                    }
                }
            }
        });
    }


    private void loadMostPopularCourseList() {
        haoKeEntity.getMostPopularCourseList(new BaseEntity.OnBaseResp() {
            @Override
            public void onResp(RespBase resp) {
                if (resp.getResCode() == 0) {
                    ArrayList<HaoKeEntity> data = (ArrayList<HaoKeEntity>) resp.getData();

                    if (data != null && data.size() > 0) {
                        myAdapter.addData(data);

                        myAdapter.setOnItemListener(new CourseAdapter.OnItemListener() {
                            @Override
                            public void onlick(View v, int position) {
                                Intent intent = new Intent(getActivity(), OnlineDetailsActivity.class);
                                intent.putExtra("id", myAdapter.mList.get(position).getId());
                                getActivity().startActivity(intent);
                            }
                        });
                    }
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.banner:
                break;
            case R.id.iv_focus:
                Intent intent = new Intent(getActivity(), FocusActivity.class);
                getActivity().startActivity(intent);
                break;
            case R.id.iv_live:
                Intent intent2 = new Intent(getActivity(), FocusActivity.class);
                getActivity().startActivity(intent2);
                break;
            case R.id.iv_online:
                Intent intent1 = new Intent(getActivity(), OnlineActivity.class);
                getActivity().startActivity(intent1);
                break;
            case R.id.iv_workshop:
                Intent intent4 = new Intent(getActivity(), WebViewActivity.class);
                intent4.putExtra(Constant.INTENT_KEY_VALUE, "https://newtc.enetedu.com/Portal/Home");
                intent4.putExtra("title", "在线工作坊");
                getActivity().startActivity(intent4);
                break;
            case R.id.iv_free:
                Intent intent3 = new Intent(getActivity(), FreeCourseActivity.class);
                getActivity().startActivity(intent3);
                break;
            case R.id.iv_order:
                Intent intent5 = new Intent(getActivity(), WebViewActivity.class);
                intent5.putExtra(Constant.INTENT_KEY_VALUE, "https://custom.enetedu.com/");
                intent5.putExtra("title", "项目定制");
                getActivity().startActivity(intent5);
                break;
            case R.id.iv_micro:
                Intent intent6 = new Intent(getActivity(), WebViewActivity.class);
                intent6.putExtra(Constant.INTENT_KEY_VALUE, "http://weike.enetedu.com/");
                intent6.putExtra("title", "微课");
                getActivity().startActivity(intent6);
                break;

            case R.id.rlv_course:
                break;
        }
    }
}
