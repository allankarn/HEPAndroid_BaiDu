package com.enetedu.hep.http.req;

import com.enetedu.hep.http.ReqBase;

import org.ksoap2.serialization.SoapObject;

public class ReqCdnurl extends ReqBase {
    private String EndPoint;
    private int cmsid;

    public void setEndPoint(String endPoint) {
        EndPoint = endPoint;
    }

    public void setCmsid(int cmsid) {
        this.cmsid = cmsid;
    }

    @Override
    public void addProperty(SoapObject soapObject) {
        soapObject.addProperty("EndPoint", EndPoint);
        soapObject.addProperty("cmsid", cmsid);
    }

    @Override
    public String getMethodName() {
        return "Cdnurl";
    }

    @Override
    public String toString() {
        return "ReqCdnurl{" +
                "EndPoint='" + EndPoint + '\'' +
                ", cmsid=" + cmsid +
                '}';
    }
}
