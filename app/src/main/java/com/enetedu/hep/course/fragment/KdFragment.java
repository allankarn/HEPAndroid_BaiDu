package com.enetedu.hep.course.fragment;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.enetedu.hep.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class KdFragment extends Fragment {


    private View view;
    /**
     * 培训通知查看
     */
    private TextView mTvTongzhi;
    private String wordpath;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View inflate = inflater.inflate(R.layout.fragment_kd, container, false);

        Bundle arguments = getArguments();
        if (arguments != null) {
            wordpath = arguments.getString("wordpath");

        }
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {

        mTvTongzhi = (TextView) inflate.findViewById(R.id.tv_tongzhi);
        mTvTongzhi.setText(wordpath);
    }
}
