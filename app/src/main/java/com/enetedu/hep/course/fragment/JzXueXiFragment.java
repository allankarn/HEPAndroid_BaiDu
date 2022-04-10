package com.enetedu.hep.course.fragment;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.enetedu.hep.R;
import com.enetedu.hep.course.adapter.FenAdapter;
import com.enetedu.hep.course.adapter.JzXueXiAdapter;
import com.enetedu.hep.http.entity.SubcList;
import com.enetedu.hep.http.entity.TjList;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class JzXueXiFragment extends Fragment {
    private View inflate;
    /**
     * 主会场
     */
    private TextView mTvZhu;
    private RecyclerView rlv_zhu;
    private JzXueXiAdapter jzXueXiAdapter;
    private ArrayList<TjList> tjlist;
    private RecyclerView rlv_fen;
    private String name;
    private ArrayList<SubcList> subcList;
    private FenAdapter fenAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_jz_xue_xi, container, false);
        Bundle arguments = getArguments();
        if (arguments != null) {
            name = arguments.getString("Name");
            tjlist = (ArrayList<TjList>) arguments.getSerializable("tjlist");
            subcList = (ArrayList<SubcList>) arguments.getSerializable("subcList");

        }

        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        mTvZhu = (TextView) inflate.findViewById(R.id.tv_zhu);
        rlv_zhu = inflate.findViewById(R.id.rlv_zhu);
        rlv_fen = inflate.findViewById(R.id.rlv_fen);

        rlv_zhu.setLayoutManager(new LinearLayoutManager(getActivity()));


        mTvZhu.setText("主会场" + "    " + name);
        jzXueXiAdapter = new JzXueXiAdapter();
        jzXueXiAdapter.addData(tjlist);
        rlv_zhu.setAdapter(jzXueXiAdapter);

        //分会场
        rlv_fen.setLayoutManager(new LinearLayoutManager(getActivity()));
        fenAdapter = new FenAdapter();
        fenAdapter.addData(subcList);
        rlv_fen.setAdapter(fenAdapter);
    }
}
