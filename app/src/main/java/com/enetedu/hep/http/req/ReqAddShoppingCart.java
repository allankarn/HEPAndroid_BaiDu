package com.enetedu.hep.http.req;

import com.enetedu.hep.http.ReqBase;

import org.ksoap2.serialization.SoapObject;

public class ReqAddShoppingCart extends ReqBase {
    private String EndPoint;
    private String UserToKen;
    private int UserID;
    private int CourseID;
    private String flag;

    public void setEndPoint(String endPoint) {
        EndPoint = endPoint;
    }

    public void setUserToKen(String userToKen) {
        UserToKen = userToKen;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public void setCourseID(int courseID) {
        CourseID = courseID;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public void addProperty(SoapObject soapObject) {
        soapObject.addProperty("EndPoint", EndPoint);
        soapObject.addProperty("UserToKen", UserToKen);
        soapObject.addProperty("UserID", UserID);
        soapObject.addProperty("CourseID", CourseID);
        soapObject.addProperty("flag", flag);
    }

    @Override
    public String getMethodName() {
        return "AddShoppingCart";
    }

    @Override
    public String toString() {
        return "ReqAddShoppingCart{" +
                "EndPoint='" + EndPoint + '\'' +
                ", UserToKen='" + UserToKen + '\'' +
                ", UserID=" + UserID +
                ", CourseID=" + CourseID +
                ", flag='" + flag + '\'' +
                '}';
    }
}
