package com.enetedu.hep.http.req;

import com.enetedu.hep.http.ReqBase;

import org.ksoap2.serialization.SoapObject;

public class ReqSignUpSaveEdit extends ReqBase {
    private int id;
    private int UserID;
    private String UserToKen;
    private String centerid;
    private String uzhusu;
    private String baodaotime;
    private String useremail;
    private String usermyname;
    private String usermob;
    private String usersheng;
    private String usershi;
    private String userqu;
    private String useraddress;
    private String userschoolname;
    private String userschooldepartment;
    private String userbill;
    private String bill_taxpayernumber;
    private String bill_addressphone;
    private String bill_banknumber;
    private String bug_falx;
    private String bill_remark;

    public void setId(int id) {
        this.id = id;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public void setUserToKen(String userToKen) {
        UserToKen = userToKen;
    }

    public void setCenterid(String centerid) {
        this.centerid = centerid;
    }

    public void setUzhusu(String uzhusu) {
        this.uzhusu = uzhusu;
    }

    public void setBaodaotime(String baodaotime) {
        this.baodaotime = baodaotime;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public void setUsermyname(String usermyname) {
        this.usermyname = usermyname;
    }

    public void setUsermob(String usermob) {
        this.usermob = usermob;
    }

    public void setUsersheng(String usersheng) {
        this.usersheng = usersheng;
    }

    public void setUsershi(String usershi) {
        this.usershi = usershi;
    }

    public void setUserqu(String userqu) {
        this.userqu = userqu;
    }

    public void setUseraddress(String useraddress) {
        this.useraddress = useraddress;
    }

    public void setUserschoolname(String userschoolname) {
        this.userschoolname = userschoolname;
    }

    public void setUserschooldepartment(String userschooldepartment) {
        this.userschooldepartment = userschooldepartment;
    }

    public void setUserbill(String userbill) {
        this.userbill = userbill;
    }

    public void setBill_taxpayernumber(String bill_taxpayernumber) {
        this.bill_taxpayernumber = bill_taxpayernumber;
    }

    public void setBill_addressphone(String bill_addressphone) {
        this.bill_addressphone = bill_addressphone;
    }

    public void setBill_banknumber(String bill_banknumber) {
        this.bill_banknumber = bill_banknumber;
    }

    public void setBug_falx(String bug_falx) {
        this.bug_falx = bug_falx;
    }

    public void setBill_remark(String bill_remark) {
        this.bill_remark = bill_remark;
    }

    @Override
    public void addProperty(SoapObject soapObject) {
        soapObject.addProperty("id", id);
        soapObject.addProperty("UserID", UserID);
        soapObject.addProperty("UserToKen", UserToKen);
        soapObject.addProperty("centerid", centerid);
        soapObject.addProperty("uzhusu", uzhusu);
        soapObject.addProperty("baodaotime", baodaotime);
        soapObject.addProperty("useremail", useremail);
        soapObject.addProperty("usermyname", usermyname);
        soapObject.addProperty("usermob", usermob);
        soapObject.addProperty("usersheng", usersheng);
        soapObject.addProperty("usershi", usershi);
        soapObject.addProperty("userqu", userqu);
        soapObject.addProperty("useraddress", useraddress);
        soapObject.addProperty("userschoolname", userschoolname);
        soapObject.addProperty("userschooldepartment", userschooldepartment);
        soapObject.addProperty("userbill", userbill);
        soapObject.addProperty("bill_taxpayernumber", bill_taxpayernumber);
        soapObject.addProperty("bill_addressphone", bill_addressphone);
        soapObject.addProperty("bill_banknumber", bill_banknumber);
        soapObject.addProperty("bug_falx", bug_falx);
        soapObject.addProperty("bill_remark", bill_remark);
    }

    @Override
    public String getMethodName() {
        return "SignUpSaveEdit";
    }

    @Override
    public String toString() {
        return "ReqSignUpSaveEdit{" +
                "id=" + id +
                ", UserID=" + UserID +
                ", UserToKen='" + UserToKen + '\'' +
                ", centerid='" + centerid + '\'' +
                ", uzhusu='" + uzhusu + '\'' +
                ", baodaotime='" + baodaotime + '\'' +
                ", useremail='" + useremail + '\'' +
                ", usermyname='" + usermyname + '\'' +
                ", usermob='" + usermob + '\'' +
                ", usersheng='" + usersheng + '\'' +
                ", usershi='" + usershi + '\'' +
                ", userqu='" + userqu + '\'' +
                ", useraddress='" + useraddress + '\'' +
                ", userschoolname='" + userschoolname + '\'' +
                ", userschooldepartment='" + userschooldepartment + '\'' +
                ", userbill='" + userbill + '\'' +
                ", bill_taxpayernumber='" + bill_taxpayernumber + '\'' +
                ", bill_addressphone='" + bill_addressphone + '\'' +
                ", bill_banknumber='" + bill_banknumber + '\'' +
                ", bug_falx='" + bug_falx + '\'' +
                ", bill_remark='" + bill_remark + '\'' +
                '}';
    }
}
