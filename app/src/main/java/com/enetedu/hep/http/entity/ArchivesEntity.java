package com.enetedu.hep.http.entity;

import com.enetedu.hep.base.BaseEntityImpl;
import com.enetedu.hep.http.HEPMSProxy;
import com.enetedu.hep.http.IHEPMSProxy;
import com.enetedu.hep.http.RespBase;
import com.enetedu.hep.http.req.ReqArchives;

public class ArchivesEntity extends BaseEntityImpl {

    private String IN_OUT_FLAG;
    private String REMARK;
    private String CREDIT_TIME;
    private Double CREDIT;

    public ArchivesEntity() {
    }

    public ArchivesEntity(String IN_OUT_FLAG, String REMARK, String CREDIT_TIME, Double CREDIT) {
        this.IN_OUT_FLAG = IN_OUT_FLAG;
        this.REMARK = REMARK;
        this.CREDIT_TIME = CREDIT_TIME;
        this.CREDIT = CREDIT;
    }

    public String getIN_OUT_FLAG() {
        return IN_OUT_FLAG;
    }

    public void setIN_OUT_FLAG(String IN_OUT_FLAG) {
        this.IN_OUT_FLAG = IN_OUT_FLAG;
    }

    public String getREMARK() {
        return REMARK;
    }

    public void setREMARK(String REMARK) {
        this.REMARK = REMARK;
    }

    public String getCREDIT_TIME() {
        return CREDIT_TIME;
    }

    public void setCREDIT_TIME(String CREDIT_TIME) {
        this.CREDIT_TIME = CREDIT_TIME;
    }

    public Double getCREDIT() {
        return CREDIT;
    }

    public void setCREDIT(Double CREDIT) {
        this.CREDIT = CREDIT;
    }

    @Override
    public String toString() {
        return "ArchivesEntity{" +
                "IN_OUT_FLAG='" + IN_OUT_FLAG + '\'' +
                ", REMARK='" + REMARK + '\'' +
                ", CREDIT_TIME='" + CREDIT_TIME + '\'' +
                ", CREDIT=" + CREDIT +
                '}';
    }

    private ReqArchives reqArchives;

    public void getArchives(String userToKen, int userID, int pageNo, int pageSize, final OnBaseResp onBaseResp) {
        if (reqArchives == null) reqArchives = new ReqArchives();
        reqArchives.setUserToKen(userToKen);
        reqArchives.setUserID(userID);
        reqArchives.setPageNo(pageNo);
        reqArchives.setPageSize(pageSize);

        HEPMSProxy.GetArchives(reqArchives, new IHEPMSProxy.OnResp() {
            @Override
            public void onResp(RespBase response) {
                resp(onBaseResp, response);
            }
        });
    }
}
