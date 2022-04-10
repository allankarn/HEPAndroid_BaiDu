package com.enetedu.hep.http.entity;

import com.enetedu.hep.base.BaseEntityImpl;
import com.enetedu.hep.http.HEPMSProxy;
import com.enetedu.hep.http.IHEPMSProxy;
import com.enetedu.hep.http.RespBase;
import com.enetedu.hep.http.req.ReqStudyMyCourse;
import com.enetedu.hep.http.req.ReqStudyMyCourseForChoice;
import com.enetedu.hep.http.req.ReqStudyMyCourseForCourse2;

import java.util.ArrayList;

public class StudyMyCourseEntity extends BaseEntityImpl {
    private int id;
    private String name;
    private int courseType;
    private int enroid;
    private String is_payoffed;
    private ArrayList<ViewenrollDetailsList> viewenrolldetails;

    public StudyMyCourseEntity() {
    }

    public StudyMyCourseEntity(int id, String name, int courseType, int enroid, String is_payoffed, ArrayList<ViewenrollDetailsList> viewenrolldetails) {
        this.id = id;
        this.name = name;
        this.courseType = courseType;
        this.enroid = enroid;
        this.is_payoffed = is_payoffed;
        this.viewenrolldetails = viewenrolldetails;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCourseType() {
        return courseType;
    }

    public void setCourseType(int courseType) {
        this.courseType = courseType;
    }

    public int getEnroid() {
        return enroid;
    }

    public void setEnroid(int enroid) {
        this.enroid = enroid;
    }

    public String getIs_payoffed() {
        return is_payoffed;
    }

    public void setIs_payoffed(String is_payoffed) {
        this.is_payoffed = is_payoffed;
    }

    public ArrayList<ViewenrollDetailsList> getViewenrolldetails() {
        return viewenrolldetails;
    }

    public void setViewenrolldetails(ArrayList<ViewenrollDetailsList> viewenrolldetails) {
        this.viewenrolldetails = viewenrolldetails;
    }

    @Override
    public String toString() {
        return "StudyMyCourseEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", courseType=" + courseType +
                ", enroid=" + enroid +
                ", is_payoffed='" + is_payoffed + '\'' +
                ", viewenrolldetails=" + viewenrolldetails +
                '}';
    }

    private ReqStudyMyCourse reqStudyMyCourse;

    public void getStudyMyCourse(String UserToKen, int UserID, int enrchoid, final OnBaseResp onBaseResp) {
        if (reqStudyMyCourse == null) reqStudyMyCourse = new ReqStudyMyCourse();
        reqStudyMyCourse.setUserToKen(UserToKen);
        reqStudyMyCourse.setUserID(UserID);
        reqStudyMyCourse.setEnrchoid(enrchoid);

        HEPMSProxy.GetStudyMyCourse(reqStudyMyCourse, new IHEPMSProxy.OnResp() {
            @Override
            public void onResp(RespBase response) {
                resp(onBaseResp, response);
            }
        });
    }

    private ReqStudyMyCourseForCourse2 reqStudyMyCourseForCourse2;

    public void getStudyMyCourseForCourse2(String UserToKen, int UserID, int enrchoid, int courseid, int coursewareid, final OnBaseResp onBaseResp) {
        if (reqStudyMyCourseForCourse2 == null) reqStudyMyCourseForCourse2 = new ReqStudyMyCourseForCourse2();
        reqStudyMyCourseForCourse2.setUserToKen(UserToKen);
        reqStudyMyCourseForCourse2.setUserID(UserID);
        reqStudyMyCourseForCourse2.setEnrchoid(enrchoid);
        reqStudyMyCourseForCourse2.setCourseid(courseid);
        reqStudyMyCourseForCourse2.setCoursewareid(coursewareid);

        HEPMSProxy.GetStudyMyCourseForCourse2(reqStudyMyCourseForCourse2, new IHEPMSProxy.OnResp() {
            @Override
            public void onResp(RespBase response) {
                resp(onBaseResp, response);
            }
        });
    }

    private ReqStudyMyCourseForChoice reqStudyMyCourseForChoice;
    public void getStudyMyCourseForChoice(String UserToKen, int UserID, int enrchoid, int courseid, int coursewareid, final OnBaseResp onBaseResp) {
        if (reqStudyMyCourseForChoice == null) reqStudyMyCourseForChoice = new ReqStudyMyCourseForChoice();
        reqStudyMyCourseForChoice.setUserToKen(UserToKen);
        reqStudyMyCourseForChoice.setUserID(UserID);
        reqStudyMyCourseForChoice.setEnrchoid(enrchoid);
        reqStudyMyCourseForChoice.setCourseid(courseid);
        reqStudyMyCourseForChoice.setCoursewareid(coursewareid);

        HEPMSProxy.GetStudyMyCourseForChoice(reqStudyMyCourseForChoice, new IHEPMSProxy.OnResp() {
            @Override
            public void onResp(RespBase response) {
                resp(onBaseResp, response);
            }
        });
    }
}
