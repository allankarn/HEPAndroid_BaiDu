package com.enetedu.hep.course.fragment;


import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.enetedu.hep.R;
import com.enetedu.hep.http.entity.Course2ModelEntity;
import com.enetedu.hep.http.entity.CourseModelList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PxFragment extends Fragment {

    private static final String TAG = "PxFragment";
    private WebView mTvNeirong;

    private Course2ModelEntity course2ModelEntity1;

    private CourseModelList courseModelList1;
    private String courseinfo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_px, container, false);

        Bundle arguments = getArguments();
        if (arguments != null) {
            courseinfo = arguments.getString("courseinfo");
        }

        initView(inflate);
        return inflate;
    }

    public void getList(Course2ModelEntity course2ModelEntity) {
        course2ModelEntity1 = new Course2ModelEntity();
        course2ModelEntity1 = course2ModelEntity;
        mTvNeirong.loadDataWithBaseURL("", course2ModelEntity1.getDescription(), "text/html", "UTF-8", "");
    }

    private void initView(View inflate) {

        mTvNeirong = (WebView) inflate.findViewById(R.id.tv_neirong);
        mTvNeirong.loadDataWithBaseURL("", courseinfo, "text/html", "UTF-8", "");
    }
}
