package com.enetedu.hep.http.entity;

import com.enetedu.hep.base.BaseEntityImpl;
import com.enetedu.hep.http.HEPMSProxy;
import com.enetedu.hep.http.IHEPMSProxy;
import com.enetedu.hep.http.RespBase;
import com.enetedu.hep.http.req.ReqRotationChart;
import com.enetedu.hep.http.req.ReqRotationChartCommunity;

public class LunBoTuEntity extends BaseEntityImpl {
    private int id;
    private String TITLE;
    private String DESCRIPTION;
    private String HYPERLINK;
    private String PICTURE_URL;
    private String PICTURE_TYPE;
    private String IS_APPROVALED;
    private int picture_number;

    public LunBoTuEntity() {
    }

    public LunBoTuEntity(int id, String TITLE, String DESCRIPTION, String HYPERLINK, String PICTURE_URL, String PICTURE_TYPE, String IS_APPROVALED, int picture_number) {
        this.id = id;
        this.TITLE = TITLE;
        this.DESCRIPTION = DESCRIPTION;
        this.HYPERLINK = HYPERLINK;
        this.PICTURE_URL = PICTURE_URL;
        this.PICTURE_TYPE = PICTURE_TYPE;
        this.IS_APPROVALED = IS_APPROVALED;
        this.picture_number = picture_number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTITLE() {
        return TITLE;
    }

    public void setTITLE(String TITLE) {
        this.TITLE = TITLE;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public String getHYPERLINK() {
        return HYPERLINK;
    }

    public void setHYPERLINK(String HYPERLINK) {
        this.HYPERLINK = HYPERLINK;
    }

    public String getPICTURE_URL() {
        return PICTURE_URL;
    }

    public void setPICTURE_URL(String PICTURE_URL) {
        this.PICTURE_URL = PICTURE_URL;
    }

    public String getPICTURE_TYPE() {
        return PICTURE_TYPE;
    }

    public void setPICTURE_TYPE(String PICTURE_TYPE) {
        this.PICTURE_TYPE = PICTURE_TYPE;
    }

    public String getIS_APPROVALED() {
        return IS_APPROVALED;
    }

    public void setIS_APPROVALED(String IS_APPROVALED) {
        this.IS_APPROVALED = IS_APPROVALED;
    }

    public int getPicture_number() {
        return picture_number;
    }

    public void setPicture_number(int picture_number) {
        this.picture_number = picture_number;
    }

    @Override
    public String toString() {
        return "LunBoTuEntity{" +
                "id=" + id +
                ", TITLE='" + TITLE + '\'' +
                ", DESCRIPTION='" + DESCRIPTION + '\'' +
                ", HYPERLINK='" + HYPERLINK + '\'' +
                ", PICTURE_URL='" + PICTURE_URL + '\'' +
                ", PICTURE_TYPE='" + PICTURE_TYPE + '\'' +
                ", IS_APPROVALED='" + IS_APPROVALED + '\'' +
                ", picture_number=" + picture_number +
                '}';
    }

    private ReqRotationChart reqRotationChart;

    public void getRotationChart(final OnBaseResp onBaseResp) {
        if (reqRotationChart == null) reqRotationChart = new ReqRotationChart();

        HEPMSProxy.GetRotationChart(reqRotationChart, new IHEPMSProxy.OnResp() {
            @Override
            public void onResp(RespBase response) {
                resp(onBaseResp, response);
            }
        });
    }

    private ReqRotationChartCommunity reqRotationChartCommunity;

    public void getRotationChartCommunity(final OnBaseResp onBaseResp) {
        if (reqRotationChartCommunity == null) reqRotationChartCommunity = new ReqRotationChartCommunity();

        HEPMSProxy.GetRotationChartCommunity(reqRotationChartCommunity, new IHEPMSProxy.OnResp() {
            @Override
            public void onResp(RespBase response) {
                resp(onBaseResp, response);
            }
        });
    }
}
