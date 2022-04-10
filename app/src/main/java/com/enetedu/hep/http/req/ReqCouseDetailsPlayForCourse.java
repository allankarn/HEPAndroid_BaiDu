package com.enetedu.hep.http.req;

import com.enetedu.hep.http.ReqBase;

import org.ksoap2.serialization.SoapObject;

public class ReqCouseDetailsPlayForCourse extends ReqBase {
    private int id;
    private int UserID;
    private String UserToKen;

    public void setId(int id) {
        this.id = id;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public void setUserToKen(String userToKen) {
        UserToKen = userToKen;
    }

    @Override
    public void addProperty(SoapObject soapObject) {
        soapObject.addProperty("id", id);
        soapObject.addProperty("UserID", UserID);
        soapObject.addProperty("UserToKen", UserToKen);
    }

    @Override
    public String getMethodName() {
        return "CouseDetailsPlayForCourse";
    }

    @Override
    public String toString() {
        return "ReqCouseDetailsPlayForCourse{" +
                "id=" + id +
                ", UserID=" + UserID +
                ", UserToKen='" + UserToKen + '\'' +
                '}';
    }
}
