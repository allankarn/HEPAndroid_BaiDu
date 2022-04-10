package com.enetedu.hep.http.req;

import com.enetedu.hep.http.ReqBase;

import org.ksoap2.serialization.SoapObject;

public class ReqLogin extends ReqBase {
    private String endPoint = ENDPOINT_ANDROID;
    private String loginName;
    private String loginPwd;
    private String timeStamp;
    private String type;


    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void addProperty(SoapObject soapObject) {
        soapObject.addProperty("EndPoint", endPoint == null ? ENDPOINT_ANDROID : endPoint);
        soapObject.addProperty("LoginName", loginName == null ? "" : loginName);
        soapObject.addProperty("LoginPwd", loginPwd == null ? "" : loginPwd);
        soapObject.addProperty("Timestamp", timeStamp);
        soapObject.addProperty("type", type);
    }

    @Override
    public String getMethodName() {
        return "UserLogin";
    }

    @Override
    public String toString() {
        return "ReqLogin{" +
                "endPoint='" + endPoint + '\'' +
                ", loginName='" + loginName + '\'' +
                ", loginPwd='" + loginPwd + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
