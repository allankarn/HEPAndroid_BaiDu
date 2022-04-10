package com.enetedu.hep.http.entity;

import com.enetedu.hep.base.BaseEntityImpl;
import com.enetedu.hep.http.HEPMSProxy;
import com.enetedu.hep.http.IHEPMSProxy;
import com.enetedu.hep.http.RespBase;
import com.enetedu.hep.http.req.ReqNation;

public class NationEntity extends BaseEntityImpl {
    private String Name;

    public NationEntity() {
    }

    public NationEntity(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "NationEntity{" +
                "Name='" + Name + '\'' +
                '}';
    }

    private ReqNation reqNation;

    public void getNation(final OnBaseResp onBaseResp) {
        if (reqNation == null) reqNation = new ReqNation();


        HEPMSProxy.GetNation(reqNation, new IHEPMSProxy.OnResp() {
            @Override
            public void onResp(RespBase response) {
                resp(onBaseResp, response);
            }
        });
    }
}
