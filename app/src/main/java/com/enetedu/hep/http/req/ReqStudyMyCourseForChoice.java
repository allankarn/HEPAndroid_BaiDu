package com.enetedu.hep.http.req;

import com.enetedu.hep.http.ReqBase;

import org.ksoap2.serialization.SoapObject;

public class ReqStudyMyCourseForChoice extends ReqBase {
    private String UserToKen;
    private int UserID;
    private int enrchoid;
    private int courseid;
    private int coursewareid;

    public void setUserToKen(String userToKen) {
        UserToKen = userToKen;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public void setEnrchoid(int enrchoid) {
        this.enrchoid = enrchoid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public void setCoursewareid(int coursewareid) {
        this.coursewareid = coursewareid;
    }

    @Override
    public void addProperty(SoapObject soapObject) {
        soapObject.addProperty("UserToKen", UserToKen);
        soapObject.addProperty("UserID", UserID);
        soapObject.addProperty("enrchoid", enrchoid);
        soapObject.addProperty("courseid", courseid);
        soapObject.addProperty("coursewareid", coursewareid);
    }

    @Override
    public String getMethodName() {
        return "StudyMyCourseForChoice";
    }

    @Override
    public String toString() {
        return "ReqStudyMyCourseForChoice{" +
                "UserToKen='" + UserToKen + '\'' +
                ", UserID=" + UserID +
                ", enrchoid=" + enrchoid +
                ", courseid=" + courseid +
                ", coursewareid=" + coursewareid +
                '}';
    }
}
