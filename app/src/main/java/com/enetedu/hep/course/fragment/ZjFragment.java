package com.enetedu.hep.course.fragment;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.enetedu.hep.R;
import com.enetedu.hep.course.adapter.ZjAdapter;
import com.enetedu.hep.http.entity.TeacherListEntity;
import com.enetedu.hep.my.WebViewActivity;
import com.enetedu.hep.utils.Constant;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class ZjFragment extends Fragment {

    private View inflate;
    private View view;
    private RecyclerView mRlv;
    private ZjAdapter myAdapter;
    private static final String TAG = "ZjFragment";
    private ArrayList<TeacherListEntity> listEntities = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        inflate = inflater.inflate(R.layout.fragment_zj, container, false);
        Bundle arguments = getArguments();
        if (arguments != null) {

            String o = (String) arguments.get("111");
            Log.d(TAG, "onCreateView: " + o);
        }

        initView(inflate);


        return inflate;
    }

    public void getList(ArrayList<TeacherListEntity> list) {
        this.listEntities = list;

        getDataList();
    }

    private void initView(View inflate) {
        mRlv = (RecyclerView) inflate.findViewById(R.id.rlv);
    }

    private void getDataList() {

        mRlv.setLayoutManager(new LinearLayoutManager(getActivity()));
        myAdapter = new ZjAdapter();
        myAdapter.addData(listEntities);
        mRlv.setAdapter(myAdapter);
        myAdapter.setOnItemListener(new ZjAdapter.OnItemListener() {
            @Override
            public void onlick(View v, int position) {
                Intent intent = new Intent(getActivity(), WebViewActivity.class);
                intent.putExtra(Constant.INTENT_KEY_VALUE, "https://www.enetedu.com/Course2/TeacherDetail?teacherId=" + myAdapter.mList.get(position).getId());
                intent.putExtra("title", "教师介绍");
                startActivity(intent);
            }
        });
    }
}
