package com.enetedu.hep.http.entity;

import com.enetedu.hep.base.BaseEntityImpl;
import com.enetedu.hep.http.HEPMSProxy;
import com.enetedu.hep.http.IHEPMSProxy;
import com.enetedu.hep.http.RespBase;
import com.enetedu.hep.http.req.ReqAddShoppingCart;
import com.enetedu.hep.http.req.ReqCourse2Detail;
import com.enetedu.hep.http.req.ReqCourseConfirm;
import com.enetedu.hep.http.req.ReqCourseXueXi;

import java.util.ArrayList;

public class Course2DetailEntity extends BaseEntityImpl {
    private Course2ModelEntity course2ModelEntity;
    private ArrayList<TeacherListEntity> teacherListEntities;
    private int courseid;

    public Course2DetailEntity() {
    }


    public Course2ModelEntity getCourse2ModelEntity() {
        return course2ModelEntity;
    }

    public void setCourse2ModelEntity(Course2ModelEntity course2ModelEntity) {
        this.course2ModelEntity = course2ModelEntity;
    }

    public ArrayList<TeacherListEntity> getTeacherListEntities() {
        return teacherListEntities;
    }

    public void setTeacherListEntities(ArrayList<TeacherListEntity> teacherListEntities) {
        this.teacherListEntities = teacherListEntities;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    @Override
    public String toString() {
        return "Course2DetailEntity{" +
                "course2ModelEntity=" + course2ModelEntity +
                ", teacherListEntities=" + teacherListEntities +
                ", courseid=" + courseid +
                '}';
    }

    private ReqCourse2Detail reqCourse2Detail;

    public void getCourse2Detail(String EndPoint, int id, int userid, final OnBaseResp onBaseResp) {
        if (reqCourse2Detail == null) reqCourse2Detail = new ReqCourse2Detail();
        reqCourse2Detail.setEndPoint(EndPoint);
        reqCourse2Detail.setId(id);
        reqCourse2Detail.setUserID(userid);
        HEPMSProxy.GetCourse2Detail(reqCourse2Detail, new IHEPMSProxy.OnResp() {
            @Override
            public void onResp(RespBase response) {
                resp(onBaseResp, response);
            }
        });
    }

    public void getCourse22Detail(String EndPoint, int id, int userid, final OnBaseResp onBaseResp) {
        if (reqCourse2Detail == null) reqCourse2Detail = new ReqCourse2Detail();
        reqCourse2Detail.setEndPoint(EndPoint);
        reqCourse2Detail.setId(id);
        reqCourse2Detail.setUserID(userid);
        HEPMSProxy.GetCourse22Detail(reqCourse2Detail, new IHEPMSProxy.OnResp() {
            @Override
            public void onResp(RespBase response) {
                resp(onBaseResp, response);
            }
        });
    }


    private ReqAddShoppingCart reqAddShoppingCart;

    public void getAddShoppingCart(String EndPoint, String UserToKen, int UserID, int CourseID, String flag, final OnBaseResp onBaseResp) {
        if (reqAddShoppingCart == null) reqAddShoppingCart = new ReqAddShoppingCart();
        reqAddShoppingCart.setEndPoint(EndPoint);
        reqAddShoppingCart.setUserToKen(UserToKen);
        reqAddShoppingCart.setUserID(UserID);
        reqAddShoppingCart.setCourseID(CourseID);
        reqAddShoppingCart.setFlag(flag);

        HEPMSProxy.GetAddShoppingCart(reqAddShoppingCart, new IHEPMSProxy.OnResp() {
            @Override
            public void onResp(RespBase response) {
                resp(onBaseResp, response);
            }
        });
    }

    private ReqCourseConfirm reqCourseConfirm;

    public void getCourseConfirm(String EndPoint, String UserToKen, int UserID, int CourseID, final OnBaseResp onBaseResp) {
        if (reqCourseConfirm == null) reqCourseConfirm = new ReqCourseConfirm();
        reqCourseConfirm.setEndPoint(EndPoint);
        reqCourseConfirm.setUserToKen(UserToKen);
        reqCourseConfirm.setUserID(UserID);
        reqCourseConfirm.setCourseid(CourseID);

        HEPMSProxy.GetCourseConfirm(reqCourseConfirm, new IHEPMSProxy.OnResp() {
            @Override
            public void onResp(RespBase response) {
                resp(onBaseResp, response);
            }
        });
    }

    private ReqCourseXueXi reqCourseXueXi;

    public void getCourseXueXi(String EndPoint, String UserToKen, int UserID, String useremail, int CourseID, String coursename, String usermyname, String userschoolname, String userschooldepartment, String usermob, String usersheng, String usershi, String userqu, final OnBaseResp onBaseResp) {
        if (reqCourseXueXi == null) reqCourseXueXi = new ReqCourseXueXi();
        reqCourseXueXi.setEndPoint(EndPoint);
        reqCourseXueXi.setUserToKen(UserToKen);
        reqCourseXueXi.setUserID(UserID);
        reqCourseXueXi.setUseremail(useremail);
        reqCourseXueXi.setCourseid(CourseID);
        reqCourseXueXi.setCoursename(coursename);
        reqCourseXueXi.setUsermyname(usermyname);
        reqCourseXueXi.setUserschoolname(userschoolname);
        reqCourseXueXi.setUserschooldepartment(userschooldepartment);
        reqCourseXueXi.setUsermob(usermob);
        reqCourseXueXi.setUsersheng(usersheng);
        reqCourseXueXi.setUsershi(usershi);
        reqCourseXueXi.setUserqu(userqu);


        HEPMSProxy.GetCourseXueXi(reqCourseXueXi, new IHEPMSProxy.OnResp() {
            @Override
            public void onResp(RespBase response) {
                resp(onBaseResp, response);
            }
        });
    }

}
