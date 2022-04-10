package com.enetedu.hep.http.req;

import com.enetedu.hep.http.ReqBase;

import org.ksoap2.serialization.SoapObject;

public class ReqStudyLink extends ReqBase {
    private String UserToKen;
    private int UserID;
    private String CourseType;
    private int courseid;

    public void setUserToKen(String userToKen) {
        UserToKen = userToKen;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public void setCourseType(String courseType) {
        CourseType = courseType;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    @Override
    public void addProperty(SoapObject soapObject) {
        soapObject.addProperty("UserToKen", UserToKen);
        soapObject.addProperty("UserID", UserID);
        soapObject.addProperty("CourseType", CourseType);
        soapObject.addProperty("courseid", courseid);
    }

    @Override
    public String getMethodName() {
        return "StudyLink";
    }

    @Override
    public String toString() {
        return "ReqStudyLink{" +
                "UserToKen='" + UserToKen + '\'' +
                ", UserID=" + UserID +
                ", CourseType='" + CourseType + '\'' +
                ", courseid=" + courseid +
                '}';
    }
}
