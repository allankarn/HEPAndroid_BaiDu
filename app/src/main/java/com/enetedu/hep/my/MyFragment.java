package com.enetedu.hep.my;


import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.enetedu.hep.R;
import com.enetedu.hep.base.MyBaseFragment;
import com.enetedu.hep.config.UserInfoSharePreference;
import com.enetedu.hep.http.RespBase;
import com.enetedu.hep.http.entity.BaseEntity;
import com.enetedu.hep.http.entity.UserInfo;
import com.enetedu.hep.utils.Constant;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends MyBaseFragment implements View.OnClickListener {


    private RelativeLayout mXuefen;
    private RelativeLayout mZhengshu;
    private RelativeLayout mShezhi;
    private RelativeLayout mYinsixieyi;
    private UserInfo userInfo;
    private View view;
    private ImageView mIvImg;
    /**
     * 春申
     */
    private TextView mTvName;
    /**
     * 海南大学 市场营销学院
     */
    private TextView mTvSchool;
    private LinearLayout mLlWode;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View inflate = inflater.inflate(R.layout.fragment_my, container, false);
        initView(inflate);
        loadPersonal();
        return inflate;
    }

    private void initView(View inflate) {
        mXuefen = (RelativeLayout) inflate.findViewById(R.id.xuefen);
        mZhengshu = (RelativeLayout) inflate.findViewById(R.id.zhengshu);
        mYinsixieyi = (RelativeLayout) inflate.findViewById(R.id.yinsixieyi);
        mShezhi = (RelativeLayout) inflate.findViewById(R.id.shezhi);
        mIvImg = (ImageView) inflate.findViewById(R.id.iv_img);
        mTvName = (TextView) inflate.findViewById(R.id.tv_name);
        mTvSchool = (TextView) inflate.findViewById(R.id.tv_school);
        mLlWode = (LinearLayout) inflate.findViewById(R.id.ll_wode);
        mLlWode.setOnClickListener(this);

        mXuefen.setOnClickListener(this);
        mZhengshu.setOnClickListener(this);
        mYinsixieyi.setOnClickListener(this);
        mShezhi.setOnClickListener(this);

        userInfo = UserInfoSharePreference.getIns().get(getActivity());
    }

    private void loadPersonal() {
        userInfo.getPersonal(userInfo.getUserToken(), userInfo.getUserId(), new BaseEntity.OnBaseResp() {
            @Override
            public void onResp(RespBase resp) {
                if (resp.getResCode() == 0) {
                    UserInfo userInfo1 = (UserInfo) resp.getData();
                    RequestOptions requestOptions = new RequestOptions().circleCrop().error(R.mipmap.ic_launcher);
                    if (userInfo1.getHeadImg() != null) {
                        Glide.with(getActivity()).load(userInfo1.getHeadImg()).apply(requestOptions).into(mIvImg);
                    }

                    mTvName.setText(userInfo1.getUserName());

                    mTvSchool.setText(userInfo1.getSchool() + "   " + userInfo1.getUserschooldepartment());

                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.xuefen:
                Intent intent1 = new Intent(getActivity(), ArchivesActivity.class);
                getActivity().startActivity(intent1);
                break;
            case R.id.zhengshu:
                Intent intent = new Intent(getActivity(), MyCertificateActivity.class);
                getActivity().startActivity(intent);
                break;
            case R.id.yinsixieyi:
                Intent intent3 = new Intent(getActivity(), WebViewActivity.class);
                intent3.putExtra(Constant.INTENT_KEY_VALUE, "https://wxcs.enetedu.com/index.php/Index/gonggaoapp");//http://app.tea.chinabett.com/common/notice
                intent3.putExtra("title", "隐私协议");
                getActivity().startActivity(intent3);
                break;
            case R.id.shezhi:
                Intent intent2 = new Intent(getActivity(), SetActivity.class);
                getActivity().startActivity(intent2);
                break;
            case R.id.ll_wode:
                Intent intent4 = new Intent(getActivity(), UserEditActivity.class);
                getActivity().startActivity(intent4);
                break;
        }
    }
}
