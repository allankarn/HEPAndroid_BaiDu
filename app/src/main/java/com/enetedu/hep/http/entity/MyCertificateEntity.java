package com.enetedu.hep.http.entity;

import com.enetedu.hep.base.BaseEntityImpl;
import com.enetedu.hep.http.HEPMSProxy;
import com.enetedu.hep.http.IHEPMSProxy;
import com.enetedu.hep.http.RespBase;
import com.enetedu.hep.http.req.ReqMyCertificate;

public class MyCertificateEntity extends BaseEntityImpl {
    private int ID;
    private String COURSE_NAME;
    private Double CREDIT;
    private String credit_start_time;

    public MyCertificateEntity() {
    }

    public MyCertificateEntity(int ID, String COURSE_NAME, Double CREDIT, String credit_start_time) {
        this.ID = ID;
        this.COURSE_NAME = COURSE_NAME;
        this.CREDIT = CREDIT;
        this.credit_start_time = credit_start_time;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCOURSE_NAME() {
        return COURSE_NAME;
    }

    public void setCOURSE_NAME(String COURSE_NAME) {
        this.COURSE_NAME = COURSE_NAME;
    }

    public Double getCREDIT() {
        return CREDIT;
    }

    public void setCREDIT(Double CREDIT) {
        this.CREDIT = CREDIT;
    }

    public String getCredit_start_time() {
        return credit_start_time;
    }

    public void setCredit_start_time(String credit_start_time) {
        this.credit_start_time = credit_start_time;
    }

    @Override
    public String toString() {
        return "MyCertificateEntity{" +
                "ID=" + ID +
                ", COURSE_NAME='" + COURSE_NAME + '\'' +
                ", CREDIT=" + CREDIT +
                ", credit_start_time='" + credit_start_time + '\'' +
                '}';
    }

    private ReqMyCertificate reqMyCertificate;

    public void getMyCertificate(String userToKen, int userID, int pageNo, int pageSize, final OnBaseResp onBaseResp) {
        if (reqMyCertificate == null) reqMyCertificate = new ReqMyCertificate();
        reqMyCertificate.setUserToKen(userToKen);
        reqMyCertificate.setUserID(userID);
        reqMyCertificate.setPageNo(pageNo);
        reqMyCertificate.setPageSize(pageSize);

        HEPMSProxy.GetMyCertificate(reqMyCertificate, new IHEPMSProxy.OnResp() {
            @Override
            public void onResp(RespBase response) {
                resp(onBaseResp, response);
            }
        });
    }
}
