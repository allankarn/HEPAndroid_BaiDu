package com.enetedu.hep.http.req;

import com.enetedu.hep.http.ReqBase;

import org.ksoap2.serialization.SoapObject;

public class ReqCourseList extends ReqBase {
    private String EndPoint;
    private String flag;
    private int PageNo;
    private int PageSize;

    public void setEndPoint(String endPoint) {
        EndPoint = endPoint;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public void setPageNo(int pageNo) {
        PageNo = pageNo;
    }

    public void setPageSize(int pageSize) {
        PageSize = pageSize;
    }

    @Override
    public void addProperty(SoapObject soapObject) {
        soapObject.addProperty("EndPoint",EndPoint);
        soapObject.addProperty("flag", flag);
        soapObject.addProperty("PageNo", PageNo);
        soapObject.addProperty("PageSize", PageSize);
    }

    @Override
    public String getMethodName() {
        return "Course2List";
    }
}
