package com.enetedu.hep.http.req;

import com.enetedu.hep.http.ReqBase;

import org.ksoap2.serialization.SoapObject;

public class ReqCourse2Detail extends ReqBase {
    private String EndPoint;
    private int id;
    private int UserID;

    public void setEndPoint(String endPoint) {
        EndPoint = endPoint;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    @Override
    public void addProperty(SoapObject soapObject) {
        soapObject.addProperty("EndPoint",EndPoint);
        soapObject.addProperty("id",id);
        soapObject.addProperty("UserID",UserID);
    }

    @Override
    public String getMethodName() {
        return "Course2Detail";
    }

    @Override
    public String toString() {
        return "ReqCourse2Detail{" +
                "EndPoint='" + EndPoint + '\'' +
                ", id=" + id +
                ", UserID=" + UserID +
                '}';
    }
}
