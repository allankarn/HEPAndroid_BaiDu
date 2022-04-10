package com.enetedu.hep.http.entity;

import com.enetedu.hep.base.BaseEntityImpl;
import com.enetedu.hep.http.HEPMSProxy;
import com.enetedu.hep.http.IHEPMSProxy;
import com.enetedu.hep.http.RespBase;
import com.enetedu.hep.http.req.ReqInfoClassifyList;

public class InfoClassifyListEntity extends BaseEntityImpl {
    private String id;
    private String name;

    public InfoClassifyListEntity() {
    }

    public InfoClassifyListEntity(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "InfoClassifyListEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    ReqInfoClassifyList reqInfoClassifyList;

    public void getInfoClassifyList(final OnBaseResp onBaseResp) {
        if (reqInfoClassifyList == null) reqInfoClassifyList = new ReqInfoClassifyList();

        HEPMSProxy.GetInfoClassifyList(reqInfoClassifyList, new IHEPMSProxy.OnResp() {
            @Override
            public void onResp(RespBase response) {
                resp(onBaseResp, response);
            }
        });
    }
}
