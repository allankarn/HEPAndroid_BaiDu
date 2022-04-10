package com.enetedu.hep.http.req;

import com.enetedu.hep.http.ReqBase;

import org.ksoap2.serialization.SoapObject;

public class ReqCourseClassifyList extends ReqBase{

    private String EndPoint;

    public void setEndPoint(String endPoint) {
        EndPoint = endPoint;
    }

    @Override
    public void addProperty(SoapObject soapObject) {
        soapObject.addProperty("EndPoint", EndPoint);
    }

    @Override
    public String getMethodName() {
        return "CourseClassifyList";
    }

    @Override
    public String toString() {
        return "ReqCourseClassifyList{" +
                '}';
    }
}
