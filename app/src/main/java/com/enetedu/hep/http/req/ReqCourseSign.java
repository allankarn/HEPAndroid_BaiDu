package com.enetedu.hep.http.req;

import com.enetedu.hep.http.ReqBase;

import org.ksoap2.serialization.SoapObject;

public class ReqCourseSign extends ReqBase {
    private int id;
    private int UserID;
    private String UserToKen;
    private String flag;

    public void setId(int id) {
        this.id = id;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public void setUserToKen(String userToKen) {
        UserToKen = userToKen;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public void addProperty(SoapObject soapObject) {
        soapObject.addProperty("id", id);
        soapObject.addProperty("UserID", UserID);
        soapObject.addProperty("UserToKen", UserToKen);
        soapObject.addProperty("flag", flag);
    }

    @Override
    public String getMethodName() {
        return "CourseSign";
    }

    @Override
    public String toString() {
        return "ReqCourseSign{" +
                "id=" + id +
                ", UserID=" + UserID +
                ", UserToKen='" + UserToKen + '\'' +
                ", flag='" + flag + '\'' +
                '}';
    }
}
