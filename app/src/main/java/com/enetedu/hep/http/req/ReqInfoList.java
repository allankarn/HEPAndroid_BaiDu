package com.enetedu.hep.http.req;

import com.enetedu.hep.http.ReqBase;

import org.ksoap2.serialization.SoapObject;

public class ReqInfoList extends ReqBase {
    private int InfoClassifyid;
    private String type;
    private int PageNo;
    private int PageSize;

    public void setInfoClassifyid(int infoClassifyid) {
        InfoClassifyid = infoClassifyid;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPageNo(int pageNo) {
        PageNo = pageNo;
    }

    public void setPageSize(int pageSize) {
        PageSize = pageSize;
    }

    @Override
    public void addProperty(SoapObject soapObject) {
        soapObject.addProperty("InfoClassifyid", InfoClassifyid);
        soapObject.addProperty("type", type);
        soapObject.addProperty("PageNo", PageNo);
        soapObject.addProperty("PageSize", PageSize);
    }

    @Override
    public String getMethodName() {
        return "InfoList";
    }

    @Override
    public String toString() {
        return "ReqInfoList{" +
                "InfoClassifyid=" + InfoClassifyid +
                ", type='" + type + '\'' +
                ", PageNo=" + PageNo +
                ", PageSize=" + PageSize +
                '}';
    }
}
