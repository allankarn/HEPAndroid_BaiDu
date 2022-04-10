package com.enetedu.hep.http.req;

import com.enetedu.hep.http.ReqBase;

import org.ksoap2.serialization.SoapObject;

public class ReqPassWordEditSave extends ReqBase {
    private String UserToKen;
    private int UserID;
    private String oldpwd;
    private String pwd;
    private String savepwd;

    public void setUserToKen(String userToKen) {
        UserToKen = userToKen;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public void setOldpwd(String oldpwd) {
        this.oldpwd = oldpwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setSavepwd(String savepwd) {
        this.savepwd = savepwd;
    }

    @Override
    public void addProperty(SoapObject soapObject) {
        soapObject.addProperty("UserToKen", UserToKen);
        soapObject.addProperty("UserID", UserID);
        soapObject.addProperty("oldpwd", oldpwd);
        soapObject.addProperty("pwd", pwd);
        soapObject.addProperty("savepwd", savepwd);
    }

    @Override
    public String getMethodName() {
        return "PassWordEditSave";
    }

    @Override
    public String toString() {
        return "ReqPassWordEditSave{" +
                "UserToKen='" + UserToKen + '\'' +
                ", UserID=" + UserID +
                ", oldpwd='" + oldpwd + '\'' +
                ", pwd='" + pwd + '\'' +
                ", savepwd='" + savepwd + '\'' +
                '}';
    }
}
