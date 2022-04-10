package com.enetedu.hep.base;

import com.enetedu.hep.config.MyApp;
import com.enetedu.hep.http.RespBase;
import com.enetedu.hep.http.entity.BaseEntity;

public class BaseEntityImpl implements BaseEntity {

    protected void resp(final OnBaseResp onBaseResp, final RespBase response){
        MyApp.getMainHandler().post(new Runnable() {
            @Override
            public void run() {
                if(onBaseResp!=null)onBaseResp.onResp(response);
            }
        });
    }
}
