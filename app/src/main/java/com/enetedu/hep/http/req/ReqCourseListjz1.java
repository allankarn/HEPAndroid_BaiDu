package com.enetedu.hep.http.req;

import com.enetedu.hep.http.ReqBase;

import org.ksoap2.serialization.SoapObject;

import java.util.Date;


public class ReqCourseListjz1 extends ReqBase {
    private String time;

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public void addProperty(SoapObject soapObject) {
        soapObject.addProperty("time", time);
    }

    @Override
    public String getMethodName() {
        return "CourseListjz1";
    }

    @Override
    public String toString() {
        return "ReqCourseListjz1{" +
                "time=" + time +
                '}';
    }
}
