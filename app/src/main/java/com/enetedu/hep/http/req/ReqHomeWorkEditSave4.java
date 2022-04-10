package com.enetedu.hep.http.req;

import com.enetedu.hep.http.ReqBase;

import org.ksoap2.serialization.SoapObject;

public class ReqHomeWorkEditSave4 extends ReqBase {

    private String UserToKen;
    private int UserID;
    private int enrchoid;
    private String homework_title;
    private String homework_content;
    private int homeworkid;

    public void setUserToKen(String userToKen) {
        UserToKen = userToKen;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public void setEnrchoid(int enrchoid) {
        this.enrchoid = enrchoid;
    }

    public void setHomework_title(String homework_title) {
        this.homework_title = homework_title;
    }

    public void setHomework_content(String homework_content) {
        this.homework_content = homework_content;
    }

    public void setHomeworkid(int homeworkid) {
        this.homeworkid = homeworkid;
    }

    @Override
    public void addProperty(SoapObject soapObject) {
        soapObject.addProperty("UserToKen", UserToKen);
        soapObject.addProperty("UserID", UserID);
        soapObject.addProperty("enrchoid", enrchoid);
        soapObject.addProperty("homework_title", homework_title);
        soapObject.addProperty("homework_content", homework_content);
        soapObject.addProperty("homeworkid", homeworkid);
    }

    @Override
    public String getMethodName() {
        return "HomeWorkEditSave4";
    }

    @Override
    public String toString() {
        return "ReqHomeWorkEditSave4{" +
                "UserToKen='" + UserToKen + '\'' +
                ", UserID=" + UserID +
                ", enrchoid=" + enrchoid +
                ", homework_title='" + homework_title + '\'' +
                ", homework_content='" + homework_content + '\'' +
                ", homeworkid=" + homeworkid +
                '}';
    }
}
