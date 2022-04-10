package com.enetedu.hep.http.entity;

import com.enetedu.hep.base.BaseEntityImpl;
import com.enetedu.hep.http.HEPMSProxy;
import com.enetedu.hep.http.IHEPMSProxy;
import com.enetedu.hep.http.RespBase;
import com.enetedu.hep.http.req.ReqCourseSign;
import com.enetedu.hep.http.req.ReqCourseWhetherStudy;
import com.enetedu.hep.http.req.ReqCouseDetailsPlayForCourse;
import com.enetedu.hep.http.req.ReqCouseDetailsPlayForCourseLive;
import com.enetedu.hep.http.req.ReqNewCourseDetails;
import com.enetedu.hep.http.req.ReqSignUp;

import java.util.ArrayList;

public class NewCourseDetailsEntity extends BaseEntityImpl {
    private ArrayList<TeacherListEntity> teacherListEntities;
    private CourseModelList courseModelList;
    private MainCenterList mainCenterList;
    private int courseid;
    private ArrayList<SubcList> subcLists;
    private int enrchoid;

    public NewCourseDetailsEntity() {
    }

    public NewCourseDetailsEntity(ArrayList<TeacherListEntity> teacherListEntities, CourseModelList courseModelList, MainCenterList mainCenterList, int courseid, ArrayList<SubcList> subcLists, int enrchoid) {
        this.teacherListEntities = teacherListEntities;
        this.courseModelList = courseModelList;
        this.mainCenterList = mainCenterList;
        this.courseid = courseid;
        this.subcLists = subcLists;
        this.enrchoid = enrchoid;
    }

    public ArrayList<TeacherListEntity> getTeacherListEntities() {
        return teacherListEntities;
    }

    public void setTeacherListEntities(ArrayList<TeacherListEntity> teacherListEntities) {
        this.teacherListEntities = teacherListEntities;
    }

    public CourseModelList getCourseModelList() {
        return courseModelList;
    }

    public void setCourseModelList(CourseModelList courseModelList) {
        this.courseModelList = courseModelList;
    }

    public MainCenterList getMainCenterList() {
        return mainCenterList;
    }

    public void setMainCenterList(MainCenterList mainCenterList) {
        this.mainCenterList = mainCenterList;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public ArrayList<SubcList> getSubcLists() {
        return subcLists;
    }

    public void setSubcLists(ArrayList<SubcList> subcLists) {
        this.subcLists = subcLists;
    }

    public int getEnrchoid() {
        return enrchoid;
    }

    public void setEnrchoid(int enrchoid) {
        this.enrchoid = enrchoid;
    }

    @Override
    public String toString() {
        return "NewCourseDetailsEntity{" +
                "teacherListEntities=" + teacherListEntities +
                ", courseModelList=" + courseModelList +
                ", mainCenterList=" + mainCenterList +
                ", courseid=" + courseid +
                ", subcLists=" + subcLists +
                ", enrchoid=" + enrchoid +
                '}';
    }

    private ReqNewCourseDetails reqNewCourseDetails;

    public void getNewCourseDetails(int id, int userid, final OnBaseResp onBaseResp) {
        if (reqNewCourseDetails == null) reqNewCourseDetails = new ReqNewCourseDetails();
        reqNewCourseDetails.setId(id);
        reqNewCourseDetails.setUserID(userid);
        HEPMSProxy.GetNewCourseDetails(reqNewCourseDetails, new IHEPMSProxy.OnResp() {
            @Override
            public void onResp(RespBase response) {
                resp(onBaseResp, response);
            }
        });
    }

    //旁听观摩（集中）
    private ReqCouseDetailsPlayForCourse reqCouseDetailsPlayForCourse;

    public void getCouseDetailsPlayForCourse(int id, int userid, String UserToKen, final OnBaseResp onBaseResp) {
        if (reqCouseDetailsPlayForCourse == null) reqCouseDetailsPlayForCourse = new ReqCouseDetailsPlayForCourse();
        reqCouseDetailsPlayForCourse.setId(id);
        reqCouseDetailsPlayForCourse.setUserID(userid);
        reqCouseDetailsPlayForCourse.setUserToKen(UserToKen);
        HEPMSProxy.GetCouseDetailsPlayForCourse(reqCouseDetailsPlayForCourse, new IHEPMSProxy.OnResp() {
            @Override
            public void onResp(RespBase response) {
                resp(onBaseResp, response);
            }
        });
    }

    //现在报名
    private ReqSignUp reqSignUp;

    public void getSignUp(int id, int userid, String UserToKen, final OnBaseResp onBaseResp) {
        if (reqSignUp == null) reqSignUp = new ReqSignUp();
        reqSignUp.setId(id);
        reqSignUp.setUserID(userid);
        reqSignUp.setUserToKen(UserToKen);
        HEPMSProxy.GetSignUp(reqSignUp, new IHEPMSProxy.OnResp() {
            @Override
            public void onResp(RespBase response) {
                resp(onBaseResp, response);
            }
        });
    }

    //旁听观摩（直播）
    private ReqCouseDetailsPlayForCourseLive reqCouseDetailsPlayForCourseLive;

    public void getCouseDetailsPlayForCourseLive(int id, int userid, String UserToKen, final OnBaseResp onBaseResp) {
        if (reqCouseDetailsPlayForCourseLive == null) reqCouseDetailsPlayForCourseLive = new ReqCouseDetailsPlayForCourseLive();
        reqCouseDetailsPlayForCourseLive.setId(id);
        reqCouseDetailsPlayForCourseLive.setUserID(userid);
        reqCouseDetailsPlayForCourseLive.setUserToKen(UserToKen);
        HEPMSProxy.GetCouseDetailsPlayForCourseLive(reqCouseDetailsPlayForCourseLive, new IHEPMSProxy.OnResp() {
            @Override
            public void onResp(RespBase response) {
                resp(onBaseResp, response);
            }
        });
    }
    //
    private ReqCourseWhetherStudy reqCourseWhetherStudy;

    public void getCourseWhetherStudy(int id, int userid, String UserToKen, String flag, final OnBaseResp onBaseResp) {
        if (reqCourseWhetherStudy == null) reqCourseWhetherStudy = new ReqCourseWhetherStudy();
        reqCourseWhetherStudy.setId(id);
        reqCourseWhetherStudy.setUserID(userid);
        reqCourseWhetherStudy.setUserToKen(UserToKen);
        reqCourseWhetherStudy.setFlag(flag);
        HEPMSProxy.GetCourseWhetherStudy(reqCourseWhetherStudy, new IHEPMSProxy.OnResp() {
            @Override
            public void onResp(RespBase response) {
                resp(onBaseResp, response);
            }
        });
    }
    //集中课加入课程购物车
    private ReqCourseSign reqCourseSign;
    public void getCourseSign(int id, int userid, String UserToKen, String flag, final OnBaseResp onBaseResp) {
        if (reqCourseSign == null) reqCourseSign = new ReqCourseSign();
        reqCourseSign.setId(id);
        reqCourseSign.setUserID(userid);
        reqCourseSign.setUserToKen(UserToKen);
        reqCourseSign.setFlag(flag);
        HEPMSProxy.GetCourseSign(reqCourseSign, new IHEPMSProxy.OnResp() {
            @Override
            public void onResp(RespBase response) {
                resp(onBaseResp, response);
            }
        });
    }
}
