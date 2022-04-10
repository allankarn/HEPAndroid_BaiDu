package com.enetedu.hep.http.entity;

import com.enetedu.hep.base.BaseEntityImpl;
import com.enetedu.hep.http.HEPMSProxy;
import com.enetedu.hep.http.IHEPMSProxy;
import com.enetedu.hep.http.RespBase;
import com.enetedu.hep.http.req.ReqHomeWorkEdit3;
import com.enetedu.hep.http.req.ReqHomeWorkEditSave3;

public class HomeWorkEdit3Entity extends BaseEntityImpl {

    private int id;
    private String traing_notice;
    private PapermodelEntity papermodelEntity;


    public HomeWorkEdit3Entity() {
    }

    public HomeWorkEdit3Entity(int id, String traing_notice, PapermodelEntity papermodelEntity) {
        this.id = id;
        this.traing_notice = traing_notice;
        this.papermodelEntity = papermodelEntity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTraing_notice() {
        return traing_notice;
    }

    public void setTraing_notice(String traing_notice) {
        this.traing_notice = traing_notice;
    }

    public PapermodelEntity getPapermodelEntity() {
        return papermodelEntity;
    }

    public void setPapermodelEntity(PapermodelEntity papermodelEntity) {
        this.papermodelEntity = papermodelEntity;
    }

    @Override
    public String toString() {
        return "HomeWorkEdit3Entity{" +
                "id=" + id +
                ", papermodelEntity=" + papermodelEntity +
                '}';
    }

    private ReqHomeWorkEdit3 reqHomeWorkEdit3;

    public void getHomeWorkEdit3(String UserToKen, int UserID, int courseid, final OnBaseResp onBaseResp) {
        if (reqHomeWorkEdit3 == null) reqHomeWorkEdit3 = new ReqHomeWorkEdit3();
        reqHomeWorkEdit3.setUserToKen(UserToKen);
        reqHomeWorkEdit3.setUserID(UserID);
        reqHomeWorkEdit3.setCourseid(courseid);

        HEPMSProxy.GetHomeWorkEdit3(reqHomeWorkEdit3, new IHEPMSProxy.OnResp() {
            @Override
            public void onResp(RespBase response) {
                resp(onBaseResp, response);
            }
        });
    }

    private ReqHomeWorkEditSave3 reqHomeWorkEditSave3;

    public void getHomeWorkEditSave3(String UserToKen, int UserID, int courseid, String homework_title, String homework_content, int homeworkid, final OnBaseResp onBaseResp) {
        if (reqHomeWorkEditSave3 == null) reqHomeWorkEditSave3 = new ReqHomeWorkEditSave3();
        reqHomeWorkEditSave3.setUserToKen(UserToKen);
        reqHomeWorkEditSave3.setUserID(UserID);
        reqHomeWorkEditSave3.setCourseid(courseid);
        reqHomeWorkEditSave3.setHomework_title(homework_title);
        reqHomeWorkEditSave3.setHomework_content(homework_content);
        reqHomeWorkEditSave3.setHomeworkid(homeworkid);

        HEPMSProxy.GetHomeWorkEditSave3(reqHomeWorkEditSave3, new IHEPMSProxy.OnResp() {
            @Override
            public void onResp(RespBase response) {
                resp(onBaseResp, response);
            }
        });
    }
}
