package com.enetedu.hep.http.entity;

import com.enetedu.hep.base.BaseEntityImpl;
import com.enetedu.hep.http.HEPMSProxy;
import com.enetedu.hep.http.IHEPMSProxy;
import com.enetedu.hep.http.RespBase;
import com.enetedu.hep.http.req.ReqDeleteShoppingCartByCourseID;
import com.enetedu.hep.http.req.ReqShoppingCartList;

public class ShoppingCartListEntity extends BaseEntityImpl {
    private String ID;
    private String CourseID;
    private String StudentID;
    private String CourseName;
    private String CourseCerdit;
    private int CourseType;
    private String imgurl;
    private int courseid;

    //自己加的属性
    private boolean isCheck;


    public ShoppingCartListEntity() {
    }

    public ShoppingCartListEntity(String ID, String courseID, String studentID, String courseName, String courseCerdit, int courseType, String imgurl, int courseid) {
        this.ID = ID;
        CourseID = courseID;
        StudentID = studentID;
        CourseName = courseName;
        CourseCerdit = courseCerdit;
        CourseType = courseType;
        this.imgurl = imgurl;
        this.courseid = courseid;
        this.reqShoppingCartList = reqShoppingCartList;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getCourseID() {
        return CourseID;
    }

    public void setCourseID(String courseID) {
        CourseID = courseID;
    }

    public String getStudentID() {
        return StudentID;
    }

    public void setStudentID(String studentID) {
        StudentID = studentID;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    public String getCourseCerdit() {
        return CourseCerdit;
    }

    public void setCourseCerdit(String courseCerdit) {
        CourseCerdit = courseCerdit;
    }

    public int getCourseType() {
        return CourseType;
    }

    public void setCourseType(int courseType) {
        CourseType = courseType;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }

    @Override
    public String toString() {
        return "ShoppingCartListEntity{" +
                "ID='" + ID + '\'' +
                ", CourseID='" + CourseID + '\'' +
                ", StudentID='" + StudentID + '\'' +
                ", CourseName='" + CourseName + '\'' +
                ", CourseCerdit='" + CourseCerdit + '\'' +
                ", CourseType=" + CourseType +
                ", imgurl='" + imgurl + '\'' +
                '}';
    }

    private ReqShoppingCartList reqShoppingCartList;

    public void getShoppingCartList(String EndPoint, String UserToKen, int UserID, int PageNo, int PageSize, final OnBaseResp onBaseResp) {
        if (reqShoppingCartList == null) reqShoppingCartList = new ReqShoppingCartList();
        reqShoppingCartList.setEndPoint(EndPoint);
        reqShoppingCartList.setUserToKen(UserToKen);
        reqShoppingCartList.setUserID(UserID);
        reqShoppingCartList.setPageNo(PageNo);
        reqShoppingCartList.setPageSize(PageSize);
        HEPMSProxy.GetShoppingCartList(reqShoppingCartList, new IHEPMSProxy.OnResp() {
            @Override
            public void onResp(RespBase response) {
                resp(onBaseResp, response);
            }
        });
    }

    private ReqDeleteShoppingCartByCourseID reqDeleteShoppingCartByCourseID;

    public void getDeleteShoppingCartByCourseID(String EndPoint, String UserToKen, int UserID, int eID, final OnBaseResp onBaseResp) {
        if (reqDeleteShoppingCartByCourseID == null) reqDeleteShoppingCartByCourseID = new ReqDeleteShoppingCartByCourseID();
        reqDeleteShoppingCartByCourseID.setEndPoint(EndPoint);
        reqDeleteShoppingCartByCourseID.setUserToKen(UserToKen);
        reqDeleteShoppingCartByCourseID.setUserID(UserID);
        reqDeleteShoppingCartByCourseID.seteID(eID);
        HEPMSProxy.GetDeleteShoppingCartByCourseID(reqDeleteShoppingCartByCourseID, new IHEPMSProxy.OnResp() {
            @Override
            public void onResp(RespBase response) {
                resp(onBaseResp, response);
            }
        });
    }
}
