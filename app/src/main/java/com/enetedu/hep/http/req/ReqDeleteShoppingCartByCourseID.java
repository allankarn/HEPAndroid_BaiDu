package com.enetedu.hep.http.req;

import com.enetedu.hep.http.ReqBase;

import org.ksoap2.serialization.SoapObject;

public class ReqDeleteShoppingCartByCourseID extends ReqBase {
    private String EndPoint;
    private String UserToKen;
    private int UserID;
    private int eID;

    public void setEndPoint(String endPoint) {
        EndPoint = endPoint;
    }

    public void setUserToKen(String userToKen) {
        UserToKen = userToKen;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public void seteID(int eID) {
        this.eID = eID;
    }

    @Override
    public void addProperty(SoapObject soapObject) {
        soapObject.addProperty("EndPoint", EndPoint);
        soapObject.addProperty("UserToKen", UserToKen);
        soapObject.addProperty("UserID", UserID);
        soapObject.addProperty("eID", eID);
    }

    @Override
    public String getMethodName() {
        return "DeleteShoppingCartByCourseID";
    }

    @Override
    public String toString() {
        return "ReqDeleteShoppingCartByCourseID{" +
                "EndPoint='" + EndPoint + '\'' +
                ", UserToKen='" + UserToKen + '\'' +
                ", UserID=" + UserID +
                ", eID=" + eID +
                '}';
    }
}
