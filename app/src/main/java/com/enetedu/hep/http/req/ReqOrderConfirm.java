package com.enetedu.hep.http.req;

import com.enetedu.hep.http.ReqBase;

import org.ksoap2.serialization.SoapObject;

public class ReqOrderConfirm extends ReqBase {
    private String EndPoint;
    private String UserToKen;
    private int UserID;
    private String eID;
    private String tUsermyname;
    private String province;
    private String district;
    private String city;
    private String tUsermob;
    private String tUseraddress;
    private String tUserschoolname;
    private String tUserschooldepartment;
    private String course_name;

    public void setEndPoint(String endPoint) {
        EndPoint = endPoint;
    }

    public void setUserToKen(String userToKen) {
        UserToKen = userToKen;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public void seteID(String eID) {
        this.eID = eID;
    }

    public void settUsermyname(String tUsermyname) {
        this.tUsermyname = tUsermyname;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void settUsermob(String tUsermob) {
        this.tUsermob = tUsermob;
    }

    public void settUseraddress(String tUseraddress) {
        this.tUseraddress = tUseraddress;
    }

    public void settUserschoolname(String tUserschoolname) {
        this.tUserschoolname = tUserschoolname;
    }

    public void settUserschooldepartment(String tUserschooldepartment) {
        this.tUserschooldepartment = tUserschooldepartment;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    @Override
    public void addProperty(SoapObject soapObject) {
        soapObject.addProperty("EndPoint",EndPoint);
        soapObject.addProperty("UserToKen",UserToKen);
        soapObject.addProperty("UserID",UserID);
        soapObject.addProperty("eID",eID);
        soapObject.addProperty("tUsermyname",tUsermyname);
        soapObject.addProperty("province",province);
        soapObject.addProperty("district",district);
        soapObject.addProperty("city",city);
        soapObject.addProperty("tUsermob",tUsermob);
        soapObject.addProperty("tUseraddress",tUseraddress);
        soapObject.addProperty("tUserschoolname",tUserschoolname);
        soapObject.addProperty("tUserschooldepartment",tUserschooldepartment);
        soapObject.addProperty("course_name",course_name);
    }

    @Override
    public String getMethodName() {
        return "OrderConfirm";
    }

    @Override
    public String toString() {
        return "ReqOrderConfirm{" +
                "EndPoint='" + EndPoint + '\'' +
                ", UserToKen='" + UserToKen + '\'' +
                ", UserID=" + UserID +
                ", eID='" + eID + '\'' +
                ", tUsermyname='" + tUsermyname + '\'' +
                ", province='" + province + '\'' +
                ", district='" + district + '\'' +
                ", city='" + city + '\'' +
                ", tUsermob='" + tUsermob + '\'' +
                ", tUseraddress='" + tUseraddress + '\'' +
                ", tUserschoolname='" + tUserschoolname + '\'' +
                ", tUserschooldepartment='" + tUserschooldepartment + '\'' +
                ", course_name='" + course_name + '\'' +
                '}';
    }
}
