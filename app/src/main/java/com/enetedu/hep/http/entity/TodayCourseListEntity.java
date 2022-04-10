package com.enetedu.hep.http.entity;

import com.enetedu.hep.base.BaseEntityImpl;
import com.enetedu.hep.http.HEPMSProxy;
import com.enetedu.hep.http.IHEPMSProxy;
import com.enetedu.hep.http.RespBase;
import com.enetedu.hep.http.req.ReqCourseListjz1;
import com.enetedu.hep.http.req.ReqCourseListjz2;
import com.enetedu.hep.http.req.ReqCourseListjz3;

import java.util.Date;


public class TodayCourseListEntity extends BaseEntityImpl {
    private int id;
    private String time;
    private String name;
    private String coursetype;
    private String ctype;

    public TodayCourseListEntity() {
    }

    public TodayCourseListEntity(int id, String time, String name, String coursetype, String ctype) {
        this.id = id;
        this.time = time;
        this.name = name;
        this.coursetype = coursetype;
        this.ctype = ctype;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoursetype() {
        return coursetype;
    }

    public void setCoursetype(String coursetype) {
        this.coursetype = coursetype;
    }

    public String getCtype() {
        return ctype;
    }

    public void setCtype(String ctype) {
        this.ctype = ctype;
    }

    @Override
    public String toString() {
        return "TodayCourseListEntity{" +
                "id=" + id +
                ", time='" + time + '\'' +
                ", name='" + name + '\'' +
                ", coursetype='" + coursetype + '\'' +
                ", ctype='" + ctype + '\'' +
                '}';
    }

    private ReqCourseListjz1 reqCourseListjz1;

    public void getCourseListjz1(String time, final OnBaseResp onBaseResp) {
        if (reqCourseListjz1 == null) reqCourseListjz1 = new ReqCourseListjz1();
        reqCourseListjz1.setTime(time);

        HEPMSProxy.GetCourseListjz1(reqCourseListjz1, new IHEPMSProxy.OnResp() {
            @Override
            public void onResp(RespBase response) {
                resp(onBaseResp, response);
            }
        });
    }

    private ReqCourseListjz2 reqCourseListjz2;
    public void getCourseListjz2(final OnBaseResp onBaseResp) {
        if (reqCourseListjz2 == null) reqCourseListjz2 = new ReqCourseListjz2();


        HEPMSProxy.GetCourseListjz2(reqCourseListjz2, new IHEPMSProxy.OnResp() {
            @Override
            public void onResp(RespBase response) {
                resp(onBaseResp, response);
            }
        });
    }

    private ReqCourseListjz3 reqCourseListjz3;
    public void getCourseListjz3(final OnBaseResp onBaseResp) {
        if (reqCourseListjz3 == null) reqCourseListjz3 = new ReqCourseListjz3();


        HEPMSProxy.GetCourseListjz3(reqCourseListjz3, new IHEPMSProxy.OnResp() {
            @Override
            public void onResp(RespBase response) {
                resp(onBaseResp, response);
            }
        });
    }
}
