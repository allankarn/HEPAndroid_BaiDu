package com.enetedu.hep.community;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.enetedu.hep.R;
import com.enetedu.hep.base.MyBaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class CommunityFragment extends MyBaseFragment {


    public CommunityFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_community, container, false);
    }

}
