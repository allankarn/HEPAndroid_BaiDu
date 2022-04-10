package com.enetedu.hep.http.entity;

import com.enetedu.hep.base.BaseEntityImpl;
import com.enetedu.hep.http.HEPMSProxy;
import com.enetedu.hep.http.IHEPMSProxy;
import com.enetedu.hep.http.RespBase;
import com.enetedu.hep.http.req.ReqHomeWorkEdit3;
import com.enetedu.hep.http.req.ReqHomeWorkEdit4;
import com.enetedu.hep.http.req.ReqHomeWorkEditSave4;

public class HomeWorkEditEntity extends BaseEntityImpl {
    private int id;
    private String HOMEWORK_TITLE;
    private String HOMEWORK_CONTENT;
    private String IS_EVALUATED;
    private String CREATE_TIME;
    private int STUDENT_ID;
    private int COURSE_ID;
    private String STUDENT_EMAIL;
    private String STUDENT_NAME;
    private String COURSE_NAME;
    private int TOPIC_COUNT;
    private String SCHOOL_EDU;
    private int PRIMAL_SUBJECT_ID;
    private int SUB_SUBJECT_ID;
    private String PRIMAL_SUBJECT_NAME;
    private String SUB_SUBJECT_NAME;
    private String title;

    public HomeWorkEditEntity() {
    }

    public HomeWorkEditEntity(int id, String HOMEWORK_TITLE, String HOMEWORK_CONTENT, String IS_EVALUATED, String CREATE_TIME, int STUDENT_ID, int COURSE_ID, String STUDENT_EMAIL, String STUDENT_NAME, String COURSE_NAME, int TOPIC_COUNT, String SCHOOL_EDU, int PRIMAL_SUBJECT_ID, int SUB_SUBJECT_ID, String PRIMAL_SUBJECT_NAME, String SUB_SUBJECT_NAME, String title) {
        this.id = id;
        this.HOMEWORK_TITLE = HOMEWORK_TITLE;
        this.HOMEWORK_CONTENT = HOMEWORK_CONTENT;
        this.IS_EVALUATED = IS_EVALUATED;
        this.CREATE_TIME = CREATE_TIME;
        this.STUDENT_ID = STUDENT_ID;
        this.COURSE_ID = COURSE_ID;
        this.STUDENT_EMAIL = STUDENT_EMAIL;
        this.STUDENT_NAME = STUDENT_NAME;
        this.COURSE_NAME = COURSE_NAME;
        this.TOPIC_COUNT = TOPIC_COUNT;
        this.SCHOOL_EDU = SCHOOL_EDU;
        this.PRIMAL_SUBJECT_ID = PRIMAL_SUBJECT_ID;
        this.SUB_SUBJECT_ID = SUB_SUBJECT_ID;
        this.PRIMAL_SUBJECT_NAME = PRIMAL_SUBJECT_NAME;
        this.SUB_SUBJECT_NAME = SUB_SUBJECT_NAME;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHOMEWORK_TITLE() {
        return HOMEWORK_TITLE;
    }

    public void setHOMEWORK_TITLE(String HOMEWORK_TITLE) {
        this.HOMEWORK_TITLE = HOMEWORK_TITLE;
    }

    public String getHOMEWORK_CONTENT() {
        return HOMEWORK_CONTENT;
    }

    public void setHOMEWORK_CONTENT(String HOMEWORK_CONTENT) {
        this.HOMEWORK_CONTENT = HOMEWORK_CONTENT;
    }

    public String getIS_EVALUATED() {
        return IS_EVALUATED;
    }

    public void setIS_EVALUATED(String IS_EVALUATED) {
        this.IS_EVALUATED = IS_EVALUATED;
    }

    public String getCREATE_TIME() {
        return CREATE_TIME;
    }

    public void setCREATE_TIME(String CREATE_TIME) {
        this.CREATE_TIME = CREATE_TIME;
    }

    public int getSTUDENT_ID() {
        return STUDENT_ID;
    }

    public void setSTUDENT_ID(int STUDENT_ID) {
        this.STUDENT_ID = STUDENT_ID;
    }

    public int getCOURSE_ID() {
        return COURSE_ID;
    }

    public void setCOURSE_ID(int COURSE_ID) {
        this.COURSE_ID = COURSE_ID;
    }

    public String getSTUDENT_EMAIL() {
        return STUDENT_EMAIL;
    }

    public void setSTUDENT_EMAIL(String STUDENT_EMAIL) {
        this.STUDENT_EMAIL = STUDENT_EMAIL;
    }

    public String getSTUDENT_NAME() {
        return STUDENT_NAME;
    }

    public void setSTUDENT_NAME(String STUDENT_NAME) {
        this.STUDENT_NAME = STUDENT_NAME;
    }

    public String getCOURSE_NAME() {
        return COURSE_NAME;
    }

    public void setCOURSE_NAME(String COURSE_NAME) {
        this.COURSE_NAME = COURSE_NAME;
    }

    public int getTOPIC_COUNT() {
        return TOPIC_COUNT;
    }

    public void setTOPIC_COUNT(int TOPIC_COUNT) {
        this.TOPIC_COUNT = TOPIC_COUNT;
    }

    public String getSCHOOL_EDU() {
        return SCHOOL_EDU;
    }

    public void setSCHOOL_EDU(String SCHOOL_EDU) {
        this.SCHOOL_EDU = SCHOOL_EDU;
    }

    public int getPRIMAL_SUBJECT_ID() {
        return PRIMAL_SUBJECT_ID;
    }

    public void setPRIMAL_SUBJECT_ID(int PRIMAL_SUBJECT_ID) {
        this.PRIMAL_SUBJECT_ID = PRIMAL_SUBJECT_ID;
    }

    public int getSUB_SUBJECT_ID() {
        return SUB_SUBJECT_ID;
    }

    public void setSUB_SUBJECT_ID(int SUB_SUBJECT_ID) {
        this.SUB_SUBJECT_ID = SUB_SUBJECT_ID;
    }

    public String getPRIMAL_SUBJECT_NAME() {
        return PRIMAL_SUBJECT_NAME;
    }

    public void setPRIMAL_SUBJECT_NAME(String PRIMAL_SUBJECT_NAME) {
        this.PRIMAL_SUBJECT_NAME = PRIMAL_SUBJECT_NAME;
    }

    public String getSUB_SUBJECT_NAME() {
        return SUB_SUBJECT_NAME;
    }

    public void setSUB_SUBJECT_NAME(String SUB_SUBJECT_NAME) {
        this.SUB_SUBJECT_NAME = SUB_SUBJECT_NAME;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "HomeWorkEditEntity{" +
                "id=" + id +
                ", HOMEWORK_TITLE='" + HOMEWORK_TITLE + '\'' +
                ", HOMEWORK_CONTENT='" + HOMEWORK_CONTENT + '\'' +
                ", IS_EVALUATED='" + IS_EVALUATED + '\'' +
                ", CREATE_TIME='" + CREATE_TIME + '\'' +
                ", STUDENT_ID=" + STUDENT_ID +
                ", COURSE_ID=" + COURSE_ID +
                ", STUDENT_EMAIL='" + STUDENT_EMAIL + '\'' +
                ", STUDENT_NAME='" + STUDENT_NAME + '\'' +
                ", COURSE_NAME='" + COURSE_NAME + '\'' +
                ", TOPIC_COUNT=" + TOPIC_COUNT +
                ", SCHOOL_EDU='" + SCHOOL_EDU + '\'' +
                ", PRIMAL_SUBJECT_ID=" + PRIMAL_SUBJECT_ID +
                ", SUB_SUBJECT_ID=" + SUB_SUBJECT_ID +
                ", PRIMAL_SUBJECT_NAME='" + PRIMAL_SUBJECT_NAME + '\'' +
                ", SUB_SUBJECT_NAME='" + SUB_SUBJECT_NAME + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    private ReqHomeWorkEdit4 reqHomeWorkEdit4;

    public void getHomeWorkEdit4(String UserToKen, int UserID, int enrchoid, final OnBaseResp onBaseResp) {
        if (reqHomeWorkEdit4 == null) reqHomeWorkEdit4 = new ReqHomeWorkEdit4();
        reqHomeWorkEdit4.setUserToKen(UserToKen);
        reqHomeWorkEdit4.setUserID(UserID);
        reqHomeWorkEdit4.setEnrchoid(enrchoid);

        HEPMSProxy.GetHomeWorkEdit4(reqHomeWorkEdit4, new IHEPMSProxy.OnResp() {
            @Override
            public void onResp(RespBase response) {
                resp(onBaseResp, response);
            }
        });
    }

    private ReqHomeWorkEditSave4 reqHomeWorkEditSave4;

    public void getHomeWorkEditSave4(String UserToKen, int UserID, int enrchoid, String homework_title, String homework_content, int homeworkid, final OnBaseResp onBaseResp) {
        if (reqHomeWorkEditSave4 == null) reqHomeWorkEditSave4 = new ReqHomeWorkEditSave4();
        reqHomeWorkEditSave4.setUserToKen(UserToKen);
        reqHomeWorkEditSave4.setUserID(UserID);
        reqHomeWorkEditSave4.setEnrchoid(enrchoid);
        reqHomeWorkEditSave4.setHomework_title(homework_title);
        reqHomeWorkEditSave4.setHomework_content(homework_content);
        reqHomeWorkEditSave4.setHomeworkid(homeworkid);

        HEPMSProxy.GetHomeWorkEditSave4(reqHomeWorkEditSave4, new IHEPMSProxy.OnResp() {
            @Override
            public void onResp(RespBase response) {
                resp(onBaseResp, response);
            }
        });
    }


}
