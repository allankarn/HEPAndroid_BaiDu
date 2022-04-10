package com.enetedu.hep.http.req;

import com.enetedu.hep.http.ReqBase;

import org.ksoap2.serialization.SoapObject;

public class ReqSMSUpdateLoginPwd extends ReqBase {
    private String loginName;
    private String SMSCode;
    private String NewLoginPwd;
    private String ReLoginPwd;

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public void setSMSCode(String SMSCode) {
        this.SMSCode = SMSCode;
    }

    public void setNewLoginPwd(String newLoginPwd) {
        NewLoginPwd = newLoginPwd;
    }

    public void setReLoginPwd(String reLoginPwd) {
        ReLoginPwd = reLoginPwd;
    }

    @Override
    public void addProperty(SoapObject soapObject) {
        soapObject.addProperty("loginName", loginName);
        soapObject.addProperty("SMSCode", SMSCode);
        soapObject.addProperty("NewLoginPwd", NewLoginPwd);
        soapObject.addProperty("ReLoginPwd", ReLoginPwd);
    }

    @Override
    public String getMethodName() {
        return "SMSUpdateLoginPwd";
    }

    @Override
    public String toString() {
        return "ReqSMSUpdateLoginPwd{" +
                "loginName='" + loginName + '\'' +
                ", SMSCode='" + SMSCode + '\'' +
                ", NewLoginPwd='" + NewLoginPwd + '\'' +
                ", ReLoginPwd='" + ReLoginPwd + '\'' +
                '}';
    }
}
