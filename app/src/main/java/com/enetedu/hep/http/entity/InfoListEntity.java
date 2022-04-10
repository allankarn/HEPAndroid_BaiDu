package com.enetedu.hep.http.entity;

import com.enetedu.hep.base.BaseEntityImpl;
import com.enetedu.hep.http.HEPMSProxy;
import com.enetedu.hep.http.IHEPMSProxy;
import com.enetedu.hep.http.RespBase;
import com.enetedu.hep.http.req.ReqInfoList;

public class InfoListEntity extends BaseEntityImpl {
    private int ID;
    private String TITLE;
    private int NOTICE_TYPE;
    private String PROG_SET;
    private String CONTENT;
    private int ORDER_NUMBER;
    private String IS_APPROVALED;
    private int CLICKS;
    private String INPUT_TIME;
    private int INPUT_USER_ID;
    private String UPDATE_TIME;
    private int UPDATE_USER_ID;
    private String IS_GOOD;
    private String UPDATE_USER_NAME;
    private String if_focus;
    private int MESSAGE_NUM;

    public InfoListEntity() {
    }

    public InfoListEntity(int ID, String TITLE, int NOTICE_TYPE, String PROG_SET, String CONTENT, int ORDER_NUMBER, String IS_APPROVALED, int CLICKS, String INPUT_TIME, int INPUT_USER_ID, String UPDATE_TIME, int UPDATE_USER_ID, String IS_GOOD, String UPDATE_USER_NAME, String if_focus, int MESSAGE_NUM) {
        this.ID = ID;
        this.TITLE = TITLE;
        this.NOTICE_TYPE = NOTICE_TYPE;
        this.PROG_SET = PROG_SET;
        this.CONTENT = CONTENT;
        this.ORDER_NUMBER = ORDER_NUMBER;
        this.IS_APPROVALED = IS_APPROVALED;
        this.CLICKS = CLICKS;
        this.INPUT_TIME = INPUT_TIME;
        this.INPUT_USER_ID = INPUT_USER_ID;
        this.UPDATE_TIME = UPDATE_TIME;
        this.UPDATE_USER_ID = UPDATE_USER_ID;
        this.IS_GOOD = IS_GOOD;
        this.UPDATE_USER_NAME = UPDATE_USER_NAME;
        this.if_focus = if_focus;
        this.MESSAGE_NUM = MESSAGE_NUM;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTITLE() {
        return TITLE;
    }

    public void setTITLE(String TITLE) {
        this.TITLE = TITLE;
    }

    public int getNOTICE_TYPE() {
        return NOTICE_TYPE;
    }

    public void setNOTICE_TYPE(int NOTICE_TYPE) {
        this.NOTICE_TYPE = NOTICE_TYPE;
    }

    public String getPROG_SET() {
        return PROG_SET;
    }

    public void setPROG_SET(String PROG_SET) {
        this.PROG_SET = PROG_SET;
    }

    public String getCONTENT() {
        return CONTENT;
    }

    public void setCONTENT(String CONTENT) {
        this.CONTENT = CONTENT;
    }

    public int getORDER_NUMBER() {
        return ORDER_NUMBER;
    }

    public void setORDER_NUMBER(int ORDER_NUMBER) {
        this.ORDER_NUMBER = ORDER_NUMBER;
    }

    public String getIS_APPROVALED() {
        return IS_APPROVALED;
    }

    public void setIS_APPROVALED(String IS_APPROVALED) {
        this.IS_APPROVALED = IS_APPROVALED;
    }

    public int getCLICKS() {
        return CLICKS;
    }

    public void setCLICKS(int CLICKS) {
        this.CLICKS = CLICKS;
    }

    public String getINPUT_TIME() {
        return INPUT_TIME;
    }

    public void setINPUT_TIME(String INPUT_TIME) {
        this.INPUT_TIME = INPUT_TIME;
    }

    public int getINPUT_USER_ID() {
        return INPUT_USER_ID;
    }

    public void setINPUT_USER_ID(int INPUT_USER_ID) {
        this.INPUT_USER_ID = INPUT_USER_ID;
    }

    public String getUPDATE_TIME() {
        return UPDATE_TIME;
    }

    public void setUPDATE_TIME(String UPDATE_TIME) {
        this.UPDATE_TIME = UPDATE_TIME;
    }

    public int getUPDATE_USER_ID() {
        return UPDATE_USER_ID;
    }

    public void setUPDATE_USER_ID(int UPDATE_USER_ID) {
        this.UPDATE_USER_ID = UPDATE_USER_ID;
    }

    public String getIS_GOOD() {
        return IS_GOOD;
    }

    public void setIS_GOOD(String IS_GOOD) {
        this.IS_GOOD = IS_GOOD;
    }

    public String getUPDATE_USER_NAME() {
        return UPDATE_USER_NAME;
    }

    public void setUPDATE_USER_NAME(String UPDATE_USER_NAME) {
        this.UPDATE_USER_NAME = UPDATE_USER_NAME;
    }

    public String getIf_focus() {
        return if_focus;
    }

    public void setIf_focus(String if_focus) {
        this.if_focus = if_focus;
    }

    public int getMESSAGE_NUM() {
        return MESSAGE_NUM;
    }

    public void setMESSAGE_NUM(int MESSAGE_NUM) {
        this.MESSAGE_NUM = MESSAGE_NUM;
    }

    @Override
    public String toString() {
        return "InfoListEntity{" +
                "ID=" + ID +
                ", TITLE='" + TITLE + '\'' +
                ", NOTICE_TYPE=" + NOTICE_TYPE +
                ", PROG_SET='" + PROG_SET + '\'' +
                ", CONTENT='" + CONTENT + '\'' +
                ", ORDER_NUMBER=" + ORDER_NUMBER +
                ", IS_APPROVALED='" + IS_APPROVALED + '\'' +
                ", CLICKS=" + CLICKS +
                ", INPUT_TIME='" + INPUT_TIME + '\'' +
                ", INPUT_USER_ID=" + INPUT_USER_ID +
                ", UPDATE_TIME='" + UPDATE_TIME + '\'' +
                ", UPDATE_USER_ID=" + UPDATE_USER_ID +
                ", IS_GOOD='" + IS_GOOD + '\'' +
                ", UPDATE_USER_NAME='" + UPDATE_USER_NAME + '\'' +
                ", if_focus='" + if_focus + '\'' +
                ", MESSAGE_NUM=" + MESSAGE_NUM +
                '}';
    }

    ReqInfoList reqInfoList;

    public void getInfoList(int id, String type, int pageno, int pagesize, final OnBaseResp onBaseResp) {
        if (reqInfoList == null) reqInfoList = new ReqInfoList();
        reqInfoList.setInfoClassifyid(id);
        reqInfoList.setType(type);
        reqInfoList.setPageNo(pageno);
        reqInfoList.setPageSize(pagesize);
        HEPMSProxy.GetInfoList(reqInfoList, new IHEPMSProxy.OnResp() {
            @Override
            public void onResp(RespBase response) {
                resp(onBaseResp, response);
            }
        });
    }
}
