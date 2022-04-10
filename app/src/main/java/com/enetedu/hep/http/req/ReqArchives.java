package com.enetedu.hep.http.req;

import com.enetedu.hep.http.ReqBase;

import org.ksoap2.serialization.SoapObject;

public class ReqArchives extends ReqBase {
    private String UserToKen;
    private int UserID;
    private int PageNo;
    private int PageSize;

    public void setUserToKen(String userToKen) {
        UserToKen = userToKen;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public void setPageNo(int pageNo) {
        PageNo = pageNo;
    }

    public void setPageSize(int pageSize) {
        PageSize = pageSize;
    }

    @Override
    public void addProperty(SoapObject soapObject) {
        soapObject.addProperty("UserToKen",UserToKen);
        soapObject.addProperty("UserID",UserID);
        soapObject.addProperty("PageNo",PageNo);
        soapObject.addProperty("PageSize",PageSize);
    }

    @Override
    public String getMethodName() {
        return "Archives";
    }

    @Override
    public String toString() {
        return "ReqArchives{" +
                "UserToKen='" + UserToKen + '\'' +
                ", UserID=" + UserID +
                ", PageNo=" + PageNo +
                ", PageSize=" + PageSize +
                '}';
    }
}
