package com.enetedu.hep.http.req;

import com.enetedu.hep.http.ReqBase;

import org.ksoap2.serialization.SoapObject;

public class ReqCourseXueXi extends ReqBase {
    private String EndPoint;
    private String UserToKen;
    private int UserID;
    private String useremail;
    private int courseid;
    private String coursename;
    private String usermyname;
    private String userschoolname;
    private String userschooldepartment;
    private String usermob;
    private String usersheng;
    private String usershi;
    private String userqu;

    public void setEndPoint(String endPoint) {
        EndPoint = endPoint;
    }

    public void setUserToKen(String userToKen) {
        UserToKen = userToKen;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public void setUsermyname(String usermyname) {
        this.usermyname = usermyname;
    }

    public void setUserschoolname(String userschoolname) {
        this.userschoolname = userschoolname;
    }

    public void setUserschooldepartment(String userschooldepartment) {
        this.userschooldepartment = userschooldepartment;
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

    @Override
    public void addProperty(SoapObject soapObject) {
        soapObject.addProperty("EndPoint",EndPoint);
        soapObject.addProperty("UserToKen",UserToKen);
        soapObject.addProperty("UserID",UserID);
        soapObject.addProperty("useremail",useremail);
        soapObject.addProperty("courseid",courseid);
        soapObject.addProperty("coursename",coursename);
        soapObject.addProperty("usermyname",usermyname);
        soapObject.addProperty("userschoolname",userschoolname);
        soapObject.addProperty("userschooldepartment",userschooldepartment);
        soapObject.addProperty("usermob",usermob);
        soapObject.addProperty("usersheng",usersheng);
        soapObject.addProperty("usershi",usershi);
        soapObject.addProperty("userqu",userqu);

    }

    @Override
    public String getMethodName() {
        return "CourseXueXi";
    }

    @Override
    public String toString() {
        return "ReqCourseXueXi{" +
                "EndPoint='" + EndPoint + '\'' +
                ", UserToKen='" + UserToKen + '\'' +
                ", UserID=" + UserID +
                ", useremail='" + useremail + '\'' +
                ", courseid=" + courseid +
                ", coursename='" + coursename + '\'' +
                ", usermyname='" + usermyname + '\'' +
                ", userschoolname='" + userschoolname + '\'' +
                ", userschooldepartment='" + userschooldepartment + '\'' +
                ", usermob='" + usermob + '\'' +
                ", usersheng='" + usersheng + '\'' +
                ", usershi='" + usershi + '\'' +
                ", userqu='" + userqu + '\'' +
                '}';
    }
}
