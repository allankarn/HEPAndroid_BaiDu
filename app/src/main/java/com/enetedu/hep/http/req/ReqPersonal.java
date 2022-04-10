package com.enetedu.hep.http.req;

import com.enetedu.hep.http.ReqBase;

import org.ksoap2.serialization.SoapObject;

public class ReqPersonal extends ReqBase {
    private String UserToKen;
    private int UserID;

    public void setUserToKen(String userToKen) {
        UserToKen = userToKen;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    @Override
    public void addProperty(SoapObject soapObject) {
        soapObject.addProperty("UserToKen", UserToKen);
        soapObject.addProperty("UserID", UserID);
    }

    @Override
    public String getMethodName() {
        return "Personal";
    }

    @Override
    public String toString() {
        return "ReqPersonal{" +
                "UserToKen='" + UserToKen + '\'' +
                ", UserID='" + UserID + '\'' +
                '}';
    }
}
