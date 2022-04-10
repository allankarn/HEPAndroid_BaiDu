package com.enetedu.hep.http.entity;

import com.enetedu.hep.base.BaseEntityImpl;
import com.enetedu.hep.http.HEPMSProxy;
import com.enetedu.hep.http.IHEPMSProxy;
import com.enetedu.hep.http.RespBase;
import com.enetedu.hep.http.req.ReqCourseJH;
import com.enetedu.hep.http.req.ReqPrintZSByChoice;
import com.enetedu.hep.http.req.ReqPrintZSByNetpay;
import com.enetedu.hep.http.req.ReqStudyLink;

public class StudyLinkEntity extends BaseEntityImpl {
    private int id;
    private String Name;
    private int State;
    private int Display;
    private int Order;
    private int Flag;
    private int Credit1;
    private int Credit2;
    private int CreditDY;
    private int CreditDYSY;

    public StudyLinkEntity() {
    }

    public StudyLinkEntity(int id, String name, int state, int display, int order, int flag, int credit1, int credit2, int creditDY, int creditDYSY) {
        this.id = id;
        Name = name;
        State = state;
        Display = display;
        Order = order;
        Flag = flag;
        Credit1 = credit1;
        Credit2 = credit2;
        CreditDY = creditDY;
        CreditDYSY = creditDYSY;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getState() {
        return State;
    }

    public void setState(int state) {
        State = state;
    }

    public int getDisplay() {
        return Display;
    }

    public void setDisplay(int display) {
        Display = display;
    }

    public int getOrder() {
        return Order;
    }

    public void setOrder(int order) {
        Order = order;
    }

    public int getFlag() {
        return Flag;
    }

    public void setFlag(int flag) {
        Flag = flag;
    }

    public int getCredit1() {
        return Credit1;
    }

    public void setCredit1(int credit1) {
        Credit1 = credit1;
    }

    public int getCredit2() {
        return Credit2;
    }

    public void setCredit2(int credit2) {
        Credit2 = credit2;
    }

    public int getCreditDY() {
        return CreditDY;
    }

    public void setCreditDY(int creditDY) {
        CreditDY = creditDY;
    }

    public int getCreditDYSY() {
        return CreditDYSY;
    }

    public void setCreditDYSY(int creditDYSY) {
        CreditDYSY = creditDYSY;
    }

    @Override
    public String toString() {
        return "StudyLinkEntity{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", State=" + State +
                ", Display=" + Display +
                ", Order=" + Order +
                ", Flag=" + Flag +
                ", Credit1=" + Credit1 +
                ", Credit2=" + Credit2 +
                ", CreditDY=" + CreditDY +
                ", CreditDYSY=" + CreditDYSY +
                '}';
    }

    private ReqStudyLink reqStudyLink;

    public void getStudyLink(String UserToKen, int UserID, String CourseType, int courseid, final OnBaseResp onBaseResp) {
        if (reqStudyLink == null) reqStudyLink = new ReqStudyLink();
        reqStudyLink.setUserToKen(UserToKen);
        reqStudyLink.setUserID(UserID);
        reqStudyLink.setCourseType(CourseType);
        reqStudyLink.setCourseid(courseid);

        HEPMSProxy.GetStudyLink(reqStudyLink, new IHEPMSProxy.OnResp() {
            @Override
            public void onResp(RespBase response) {
                resp(onBaseResp, response);
            }
        });
    }

    //多课
    private ReqPrintZSByChoice reqPrintZSByChoice;

    public void getPrintZSByChoice(String UserToKen, int UserID, int id, final OnBaseResp onBaseResp) {
        if (reqPrintZSByChoice == null) reqPrintZSByChoice = new ReqPrintZSByChoice();
        reqPrintZSByChoice.setUserToKen(UserToKen);
        reqPrintZSByChoice.setUserID(UserID);
        reqPrintZSByChoice.setId(id);

        HEPMSProxy.GetPrintZSByChoice(reqPrintZSByChoice, new IHEPMSProxy.OnResp() {
            @Override
            public void onResp(RespBase response) {
                resp(onBaseResp, response);
            }
        });
    }

    //单课
    private ReqPrintZSByNetpay reqPrintZSByNetpay;

    public void getPrintZSByNetpay(String UserToKen, int UserID, int id, final OnBaseResp onBaseResp) {
        if (reqPrintZSByNetpay == null) reqPrintZSByNetpay = new ReqPrintZSByNetpay();
        reqPrintZSByNetpay.setUserToKen(UserToKen);
        reqPrintZSByNetpay.setUserID(UserID);
        reqPrintZSByNetpay.setCourseid(id);

        HEPMSProxy.GetPrintZSByNetpay(reqPrintZSByNetpay, new IHEPMSProxy.OnResp() {
            @Override
            public void onResp(RespBase response) {
                resp(onBaseResp, response);
            }
        });
    }

    //直播回放 登录视频课堂
    private ReqCourseJH reqCourseJH;

    public void getCourseJH(String UserToKen, int UserID, int id, final OnBaseResp onBaseResp) {
        if (reqCourseJH == null) reqCourseJH = new ReqCourseJH();
        reqCourseJH.setUserToKen(UserToKen);
        reqCourseJH.setUserID(UserID);
        reqCourseJH.setCourseid(id);

        HEPMSProxy.GetCourseJH(reqCourseJH, new IHEPMSProxy.OnResp() {
            @Override
            public void onResp(RespBase response) {
                resp(onBaseResp, response);
            }
        });
    }
}
