package com.enetedu.hep.http.req;

import com.enetedu.hep.http.ReqBase;

import org.ksoap2.serialization.SoapObject;

public class ReqNewCourseDetails extends ReqBase {
    private int id;
    private int UserID;

    public void setId(int id) {
        this.id = id;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    @Override
    public void addProperty(SoapObject soapObject) {
        soapObject.addProperty("id", id);
        soapObject.addProperty("UserID", UserID);
    }

    @Override
    public String getMethodName() {
        return "NewCourseDetails";
    }

    @Override
    public String toString() {
        return "ReqNewCourseDetails{" +
                "id=" + id +
                ", UserID=" + UserID +
                '}';
    }
}
