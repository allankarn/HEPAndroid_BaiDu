package com.enetedu.hep.http.entity;

import com.enetedu.hep.base.BaseEntityImpl;
import com.enetedu.hep.http.HEPMSProxy;
import com.enetedu.hep.http.IHEPMSProxy;
import com.enetedu.hep.http.RespBase;
import com.enetedu.hep.http.req.ReqMostPopularCourseList;

public class HaoKeEntity extends BaseEntityImpl {
    private int id;
    private String NAME;
    private int PRIMAL_SUBJECT_ID;
    private int SUB_SUBJECT_ID;
    private int PAYMENT;
    private int DAYS;
    private String DESCRIPTION;
    private int ORDER_NUMBER;
    private String IS_RECOMMENDED;
    private int CLICKS;
    private String IS_APPROVALED;
    private String APPROVAL_TIME;
    private int ADMIN_ID;
    private int ENTER_ADMIN_ID;
    private String ENTER_TIME;
    private String ENROLL_START_TIME;
    private String ENROLL_END_TIME;
    private int FORUM_ID;
    private String HEAD_IMG_URL;
    private int ELECTIVE_COUNT;
    private String MAIN_REQUERY;
    private String SELECT_REQUERY;
    private String WORK_DESCRIPTION;
    private String WORK_REQUERY;
    private String CERTIFICATE_DESCRIPTION;
    private String CERTIFICATE_REQUERY;
    private String PRIMAL_SUBJECT_NAME;
    private String SUB_SUBJECT_NAME;
    private int ADVISER_ID;
    private String ADVISER_NAME;
    private String SUB_TEACHER;
    private String SUB_TEACHER_NAME;
    private String IS_FREE;
    private String TEACH_TYPE;
    private int RD_EDIT_ID;
    private String RD_EDIT_NAME;
    private String REQUIRED_LENGTH;
    private String COURSE_CATEGORY;
    private int studyState;
    private int state;
    private String enrollmentCount;

    public HaoKeEntity() {
    }

    public HaoKeEntity(int id, String NAME, int PRIMAL_SUBJECT_ID, int SUB_SUBJECT_ID, int PAYMENT, int DAYS, String DESCRIPTION, int ORDER_NUMBER, String IS_RECOMMENDED, int CLICKS, String IS_APPROVALED, String APPROVAL_TIME, int ADMIN_ID, int ENTER_ADMIN_ID, String ENTER_TIME, String ENROLL_START_TIME, String ENROLL_END_TIME, int FORUM_ID, String HEAD_IMG_URL, int ELECTIVE_COUNT, String MAIN_REQUERY, String SELECT_REQUERY, String WORK_DESCRIPTION, String WORK_REQUERY, String CERTIFICATE_DESCRIPTION, String CERTIFICATE_REQUERY, String PRIMAL_SUBJECT_NAME, String SUB_SUBJECT_NAME, int ADVISER_ID, String ADVISER_NAME, String SUB_TEACHER, String SUB_TEACHER_NAME, String IS_FREE, String TEACH_TYPE, int RD_EDIT_ID, String RD_EDIT_NAME, String REQUIRED_LENGTH, String COURSE_CATEGORY, int studyState, int state, String enrollmentCount) {
        this.id = id;
        this.NAME = NAME;
        this.PRIMAL_SUBJECT_ID = PRIMAL_SUBJECT_ID;
        this.SUB_SUBJECT_ID = SUB_SUBJECT_ID;
        this.PAYMENT = PAYMENT;
        this.DAYS = DAYS;
        this.DESCRIPTION = DESCRIPTION;
        this.ORDER_NUMBER = ORDER_NUMBER;
        this.IS_RECOMMENDED = IS_RECOMMENDED;
        this.CLICKS = CLICKS;
        this.IS_APPROVALED = IS_APPROVALED;
        this.APPROVAL_TIME = APPROVAL_TIME;
        this.ADMIN_ID = ADMIN_ID;
        this.ENTER_ADMIN_ID = ENTER_ADMIN_ID;
        this.ENTER_TIME = ENTER_TIME;
        this.ENROLL_START_TIME = ENROLL_START_TIME;
        this.ENROLL_END_TIME = ENROLL_END_TIME;
        this.FORUM_ID = FORUM_ID;
        this.HEAD_IMG_URL = HEAD_IMG_URL;
        this.ELECTIVE_COUNT = ELECTIVE_COUNT;
        this.MAIN_REQUERY = MAIN_REQUERY;
        this.SELECT_REQUERY = SELECT_REQUERY;
        this.WORK_DESCRIPTION = WORK_DESCRIPTION;
        this.WORK_REQUERY = WORK_REQUERY;
        this.CERTIFICATE_DESCRIPTION = CERTIFICATE_DESCRIPTION;
        this.CERTIFICATE_REQUERY = CERTIFICATE_REQUERY;
        this.PRIMAL_SUBJECT_NAME = PRIMAL_SUBJECT_NAME;
        this.SUB_SUBJECT_NAME = SUB_SUBJECT_NAME;
        this.ADVISER_ID = ADVISER_ID;
        this.ADVISER_NAME = ADVISER_NAME;
        this.SUB_TEACHER = SUB_TEACHER;
        this.SUB_TEACHER_NAME = SUB_TEACHER_NAME;
        this.IS_FREE = IS_FREE;
        this.TEACH_TYPE = TEACH_TYPE;
        this.RD_EDIT_ID = RD_EDIT_ID;
        this.RD_EDIT_NAME = RD_EDIT_NAME;
        this.REQUIRED_LENGTH = REQUIRED_LENGTH;
        this.COURSE_CATEGORY = COURSE_CATEGORY;
        this.studyState = studyState;
        this.state = state;
        this.enrollmentCount = enrollmentCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
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

    public int getPAYMENT() {
        return PAYMENT;
    }

    public void setPAYMENT(int PAYMENT) {
        this.PAYMENT = PAYMENT;
    }

    public int getDAYS() {
        return DAYS;
    }

    public void setDAYS(int DAYS) {
        this.DAYS = DAYS;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public int getORDER_NUMBER() {
        return ORDER_NUMBER;
    }

    public void setORDER_NUMBER(int ORDER_NUMBER) {
        this.ORDER_NUMBER = ORDER_NUMBER;
    }

    public String getIS_RECOMMENDED() {
        return IS_RECOMMENDED;
    }

    public void setIS_RECOMMENDED(String IS_RECOMMENDED) {
        this.IS_RECOMMENDED = IS_RECOMMENDED;
    }

    public int getCLICKS() {
        return CLICKS;
    }

    public void setCLICKS(int CLICKS) {
        this.CLICKS = CLICKS;
    }

    public String getIS_APPROVALED() {
        return IS_APPROVALED;
    }

    public void setIS_APPROVALED(String IS_APPROVALED) {
        this.IS_APPROVALED = IS_APPROVALED;
    }

    public String getAPPROVAL_TIME() {
        return APPROVAL_TIME;
    }

    public void setAPPROVAL_TIME(String APPROVAL_TIME) {
        this.APPROVAL_TIME = APPROVAL_TIME;
    }

    public int getADMIN_ID() {
        return ADMIN_ID;
    }

    public void setADMIN_ID(int ADMIN_ID) {
        this.ADMIN_ID = ADMIN_ID;
    }

    public int getENTER_ADMIN_ID() {
        return ENTER_ADMIN_ID;
    }

    public void setENTER_ADMIN_ID(int ENTER_ADMIN_ID) {
        this.ENTER_ADMIN_ID = ENTER_ADMIN_ID;
    }

    public String getENTER_TIME() {
        return ENTER_TIME;
    }

    public void setENTER_TIME(String ENTER_TIME) {
        this.ENTER_TIME = ENTER_TIME;
    }

    public String getENROLL_START_TIME() {
        return ENROLL_START_TIME;
    }

    public void setENROLL_START_TIME(String ENROLL_START_TIME) {
        this.ENROLL_START_TIME = ENROLL_START_TIME;
    }

    public String getENROLL_END_TIME() {
        return ENROLL_END_TIME;
    }

    public void setENROLL_END_TIME(String ENROLL_END_TIME) {
        this.ENROLL_END_TIME = ENROLL_END_TIME;
    }

    public int getFORUM_ID() {
        return FORUM_ID;
    }

    public void setFORUM_ID(int FORUM_ID) {
        this.FORUM_ID = FORUM_ID;
    }

    public String getHEAD_IMG_URL() {
        return HEAD_IMG_URL;
    }

    public void setHEAD_IMG_URL(String HEAD_IMG_URL) {
        this.HEAD_IMG_URL = HEAD_IMG_URL;
    }

    public int getELECTIVE_COUNT() {
        return ELECTIVE_COUNT;
    }

    public void setELECTIVE_COUNT(int ELECTIVE_COUNT) {
        this.ELECTIVE_COUNT = ELECTIVE_COUNT;
    }

    public String getMAIN_REQUERY() {
        return MAIN_REQUERY;
    }

    public void setMAIN_REQUERY(String MAIN_REQUERY) {
        this.MAIN_REQUERY = MAIN_REQUERY;
    }

    public String getSELECT_REQUERY() {
        return SELECT_REQUERY;
    }

    public void setSELECT_REQUERY(String SELECT_REQUERY) {
        this.SELECT_REQUERY = SELECT_REQUERY;
    }

    public String getWORK_DESCRIPTION() {
        return WORK_DESCRIPTION;
    }

    public void setWORK_DESCRIPTION(String WORK_DESCRIPTION) {
        this.WORK_DESCRIPTION = WORK_DESCRIPTION;
    }

    public String getWORK_REQUERY() {
        return WORK_REQUERY;
    }

    public void setWORK_REQUERY(String WORK_REQUERY) {
        this.WORK_REQUERY = WORK_REQUERY;
    }

    public String getCERTIFICATE_DESCRIPTION() {
        return CERTIFICATE_DESCRIPTION;
    }

    public void setCERTIFICATE_DESCRIPTION(String CERTIFICATE_DESCRIPTION) {
        this.CERTIFICATE_DESCRIPTION = CERTIFICATE_DESCRIPTION;
    }

    public String getCERTIFICATE_REQUERY() {
        return CERTIFICATE_REQUERY;
    }

    public void setCERTIFICATE_REQUERY(String CERTIFICATE_REQUERY) {
        this.CERTIFICATE_REQUERY = CERTIFICATE_REQUERY;
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

    public int getADVISER_ID() {
        return ADVISER_ID;
    }

    public void setADVISER_ID(int ADVISER_ID) {
        this.ADVISER_ID = ADVISER_ID;
    }

    public String getADVISER_NAME() {
        return ADVISER_NAME;
    }

    public void setADVISER_NAME(String ADVISER_NAME) {
        this.ADVISER_NAME = ADVISER_NAME;
    }

    public String getSUB_TEACHER() {
        return SUB_TEACHER;
    }

    public void setSUB_TEACHER(String SUB_TEACHER) {
        this.SUB_TEACHER = SUB_TEACHER;
    }

    public String getSUB_TEACHER_NAME() {
        return SUB_TEACHER_NAME;
    }

    public void setSUB_TEACHER_NAME(String SUB_TEACHER_NAME) {
        this.SUB_TEACHER_NAME = SUB_TEACHER_NAME;
    }

    public String getIS_FREE() {
        return IS_FREE;
    }

    public void setIS_FREE(String IS_FREE) {
        this.IS_FREE = IS_FREE;
    }

    public String getTEACH_TYPE() {
        return TEACH_TYPE;
    }

    public void setTEACH_TYPE(String TEACH_TYPE) {
        this.TEACH_TYPE = TEACH_TYPE;
    }

    public int getRD_EDIT_ID() {
        return RD_EDIT_ID;
    }

    public void setRD_EDIT_ID(int RD_EDIT_ID) {
        this.RD_EDIT_ID = RD_EDIT_ID;
    }

    public String getRD_EDIT_NAME() {
        return RD_EDIT_NAME;
    }

    public void setRD_EDIT_NAME(String RD_EDIT_NAME) {
        this.RD_EDIT_NAME = RD_EDIT_NAME;
    }

    public String getREQUIRED_LENGTH() {
        return REQUIRED_LENGTH;
    }

    public void setREQUIRED_LENGTH(String REQUIRED_LENGTH) {
        this.REQUIRED_LENGTH = REQUIRED_LENGTH;
    }

    public String getCOURSE_CATEGORY() {
        return COURSE_CATEGORY;
    }

    public void setCOURSE_CATEGORY(String COURSE_CATEGORY) {
        this.COURSE_CATEGORY = COURSE_CATEGORY;
    }

    public int getStudyState() {
        return studyState;
    }

    public void setStudyState(int studyState) {
        this.studyState = studyState;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getEnrollmentCount() {
        return enrollmentCount;
    }

    public void setEnrollmentCount(String enrollmentCount) {
        this.enrollmentCount = enrollmentCount;
    }

    @Override
    public String toString() {
        return "HaoKeEntity{" +
                "id=" + id +
                ", NAME='" + NAME + '\'' +
                ", PRIMAL_SUBJECT_ID=" + PRIMAL_SUBJECT_ID +
                ", SUB_SUBJECT_ID=" + SUB_SUBJECT_ID +
                ", PAYMENT=" + PAYMENT +
                ", DAYS=" + DAYS +
                ", DESCRIPTION='" + DESCRIPTION + '\'' +
                ", ORDER_NUMBER=" + ORDER_NUMBER +
                ", IS_RECOMMENDED='" + IS_RECOMMENDED + '\'' +
                ", CLICKS=" + CLICKS +
                ", IS_APPROVALED='" + IS_APPROVALED + '\'' +
                ", APPROVAL_TIME='" + APPROVAL_TIME + '\'' +
                ", ADMIN_ID=" + ADMIN_ID +
                ", ENTER_ADMIN_ID=" + ENTER_ADMIN_ID +
                ", ENTER_TIME='" + ENTER_TIME + '\'' +
                ", ENROLL_START_TIME='" + ENROLL_START_TIME + '\'' +
                ", ENROLL_END_TIME='" + ENROLL_END_TIME + '\'' +
                ", FORUM_ID=" + FORUM_ID +
                ", HEAD_IMG_URL='" + HEAD_IMG_URL + '\'' +
                ", ELECTIVE_COUNT=" + ELECTIVE_COUNT +
                ", MAIN_REQUERY='" + MAIN_REQUERY + '\'' +
                ", SELECT_REQUERY='" + SELECT_REQUERY + '\'' +
                ", WORK_DESCRIPTION='" + WORK_DESCRIPTION + '\'' +
                ", WORK_REQUERY='" + WORK_REQUERY + '\'' +
                ", CERTIFICATE_DESCRIPTION='" + CERTIFICATE_DESCRIPTION + '\'' +
                ", CERTIFICATE_REQUERY='" + CERTIFICATE_REQUERY + '\'' +
                ", PRIMAL_SUBJECT_NAME='" + PRIMAL_SUBJECT_NAME + '\'' +
                ", SUB_SUBJECT_NAME='" + SUB_SUBJECT_NAME + '\'' +
                ", ADVISER_ID=" + ADVISER_ID +
                ", ADVISER_NAME='" + ADVISER_NAME + '\'' +
                ", SUB_TEACHER='" + SUB_TEACHER + '\'' +
                ", SUB_TEACHER_NAME='" + SUB_TEACHER_NAME + '\'' +
                ", IS_FREE='" + IS_FREE + '\'' +
                ", TEACH_TYPE='" + TEACH_TYPE + '\'' +
                ", RD_EDIT_ID=" + RD_EDIT_ID +
                ", RD_EDIT_NAME='" + RD_EDIT_NAME + '\'' +
                ", REQUIRED_LENGTH='" + REQUIRED_LENGTH + '\'' +
                ", COURSE_CATEGORY='" + COURSE_CATEGORY + '\'' +
                ", studyState=" + studyState +
                ", state=" + state +
                ", enrollmentCount='" + enrollmentCount + '\'' +
                '}';
    }
    private ReqMostPopularCourseList reqMostPopularCourseList;
    public void getMostPopularCourseList( final OnBaseResp onBaseResp) {
        if (reqMostPopularCourseList == null) reqMostPopularCourseList = new ReqMostPopularCourseList();

        HEPMSProxy.GetMostPopularCourseList(reqMostPopularCourseList, new IHEPMSProxy.OnResp() {
            @Override
            public void onResp(RespBase response) {
                resp(onBaseResp, response);
            }
        });
    }
}
