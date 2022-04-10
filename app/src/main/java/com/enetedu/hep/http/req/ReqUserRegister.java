package com.enetedu.hep.http.req;

import com.enetedu.hep.http.ReqBase;

import org.ksoap2.serialization.SoapObject;

public class ReqUserRegister extends ReqBase {
    private String EndPoint;
    private String LoginName;
    private String LoginPwd;
    private String TelPhone;
    private String School;
    private String UserRealName;

    public void setEndPoint(String endPoint) {
        EndPoint = endPoint;
    }

    public void setLoginName(String loginName) {
        LoginName = loginName;
    }

    public void setLoginPwd(String loginPwd) {
        LoginPwd = loginPwd;
    }

    public void setTelPhone(String telPhone) {
        TelPhone = telPhone;
    }

    public void setSchool(String school) {
        School = school;
    }

    public void setUserRealName(String userRealName) {
        UserRealName = userRealName;
    }

    @Override
    public void addProperty(SoapObject soapObject) {
        soapObject.addProperty("EndPoint",EndPoint);
        soapObject.addProperty("LoginName",LoginName);
        soapObject.addProperty("LoginPwd",LoginPwd);
        soapObject.addProperty("TelPhone",TelPhone);
        soapObject.addProperty("School",School);
        soapObject.addProperty("UserRealName",UserRealName);
    }

    @Override
    public String getMethodName() {
        return "UserRegister";
    }

    @Override
    public String toString() {
        return "ReqUserRegister{" +
                "EndPoint='" + EndPoint + '\'' +
                ", LoginName='" + LoginName + '\'' +
                ", LoginPwd='" + LoginPwd + '\'' +
                ", TelPhone='" + TelPhone + '\'' +
                ", School='" + School + '\'' +
                ", UserRealName='" + UserRealName + '\'' +
                '}';
    }
}
