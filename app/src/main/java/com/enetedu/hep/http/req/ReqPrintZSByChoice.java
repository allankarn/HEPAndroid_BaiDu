package com.enetedu.hep.http.req;

import com.enetedu.hep.http.ReqBase;

import org.ksoap2.serialization.SoapObject;
//多课
public class ReqPrintZSByChoice extends ReqBase {
    private String UserToKen;
    private int UserID;
    private int id;

    public void setUserToKen(String userToKen) {
        UserToKen = userToKen;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void addProperty(SoapObject soapObject) {
        soapObject.addProperty("UserToKen", UserToKen);
        soapObject.addProperty("UserID", UserID);
        soapObject.addProperty("id", id);
    }

    @Override
    public String getMethodName() {
        return "PrintZSByChoice";
    }

    @Override
    public String toString() {
        return "ReqPrintZSByChoice{" +
                "UserToKen='" + UserToKen + '\'' +
                ", UserID=" + UserID +
                ", id=" + id +
                '}';
    }
}
