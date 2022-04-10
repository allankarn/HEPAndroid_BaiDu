package com.enetedu.hep.course.fragment;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.enetedu.hep.R;

/**
 * 学习任务
 * A simple {@link Fragment} subclass.
 */
public class XxFragment extends Fragment {

    private TextView mTvXuzhi;
    private String traing_notice;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View inflate = inflater.inflate(R.layout.fragment_xx, container, false);
        Bundle arguments = getArguments();
        if (arguments != null) {
            traing_notice = arguments.getString("traing_notice");


        }
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        mTvXuzhi = (TextView) inflate.findViewById(R.id.tv_xuzhi);
        mTvXuzhi.setText(traing_notice);
    }


}
