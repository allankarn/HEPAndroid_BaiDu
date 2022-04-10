package com.enetedu.hep.http.req;

import com.enetedu.hep.http.ReqBase;

import org.ksoap2.serialization.SoapObject;

public class ReqHomeWorkEdit4 extends ReqBase {
    private String UserToKen;
    private int UserID;
    private int enrchoid;

    public void setUserToKen(String userToKen) {
        UserToKen = userToKen;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public void setEnrchoid(int enrchoid) {
        this.enrchoid = enrchoid;
    }

    @Override
    public void addProperty(SoapObject soapObject) {
        soapObject.addProperty("UserToKen", UserToKen);
        soapObject.addProperty("UserID", UserID);
        soapObject.addProperty("enrchoid", enrchoid);
    }

    @Override
    public String getMethodName() {
        return "HomeWorkEdit4";
    }

    @Override
    public String toString() {
        return "ReqHomeWorkEdit4{" +
                "UserToKen='" + UserToKen + '\'' +
                ", UserID=" + UserID +
                ", enrchoid=" + enrchoid +
                '}';
    }
}
