package com.enetedu.hep.http.req;

import com.enetedu.hep.http.ReqBase;

import org.ksoap2.serialization.SoapObject;

public class ReqPersonalSave extends ReqBase{
    private String UserToKen;
    private int UserID;
    private String userface;
    private String usermyname;
    private String usersex;
    private String nation;
    private String userschoolname;
    private String userschooldepartment;
    private String username;

    public void setUserToKen(String userToKen) {
        UserToKen = userToKen;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public void setUserface(String userface) {
        this.userface = userface;
    }

    public void setUsermyname(String usermyname) {
        this.usermyname = usermyname;
    }

    public void setUsersex(String usersex) {
        this.usersex = usersex;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public void setUserschoolname(String userschoolname) {
        this.userschoolname = userschoolname;
    }

    public void setUserschooldepartment(String userschooldepartment) {
        this.userschooldepartment = userschooldepartment;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public void addProperty(SoapObject soapObject) {
        soapObject.addProperty("UserToKen",UserToKen);
        soapObject.addProperty("UserID",UserID);
        soapObject.addProperty("userface",userface);
        soapObject.addProperty("usermyname",usermyname);
        soapObject.addProperty("usersex",usersex);
        soapObject.addProperty("nation",nation);
        soapObject.addProperty("userschoolname",userschoolname);
        soapObject.addProperty("userschooldepartment",userschooldepartment);
        soapObject.addProperty("username",username);
    }

    @Override
    public String getMethodName() {
        return "PersonalSave";
    }

    @Override
    public String toString() {
        return "ReqPersonalSave{" +
                "UserToKen='" + UserToKen + '\'' +
                ", UserID=" + UserID +
                ", userface='" + userface + '\'' +
                ", usermyname='" + usermyname + '\'' +
                ", usersex='" + usersex + '\'' +
                ", nation='" + nation + '\'' +
                ", userschoolname='" + userschoolname + '\'' +
                ", userschooldepartment='" + userschooldepartment + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
