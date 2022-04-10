package com.enetedu.hep.http.req;

import com.enetedu.hep.http.ReqBase;

import org.ksoap2.serialization.SoapObject;

public class ReqMostPopularCourseList extends ReqBase {
    @Override
    public void addProperty(SoapObject soapObject) {

    }

    @Override
    public String getMethodName() {
        return "MostPopularCourseList";
    }
}
