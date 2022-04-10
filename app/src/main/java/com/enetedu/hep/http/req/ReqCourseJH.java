package com.enetedu.hep.http.req;

import com.enetedu.hep.http.ReqBase;

import org.ksoap2.serialization.SoapObject;

public class ReqCourseJH extends ReqBase {
    private String UserToKen;
    private int UserID;
    private int courseid;

    public void setUserToKen(String userToKen) {
        UserToKen = userToKen;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    @Override
    public void addProperty(SoapObject soapObject) {
        soapObject.addProperty("UserToKen",UserToKen);
        soapObject.addProperty("UserID",UserID);
        soapObject.addProperty("courseid",courseid);
    }

    @Override
    public String getMethodName() {
        return "CourseJH";
    }

    @Override
    public String toString() {
        return "ReqCourseJH{" +
                "UserToKen='" + UserToKen + '\'' +
                ", UserID=" + UserID +
                ", courseid=" + courseid +
                '}';
    }
}
