package com.enetedu.hep.http.req;

import com.enetedu.hep.http.ReqBase;

import org.ksoap2.serialization.SoapObject;

public class ReqUserLoginCode extends ReqBase {
    private String TelPhone;
    public String getTelPhone() {
        return TelPhone;
    }

    public void setTelPhone(String telPhone) {
        TelPhone = telPhone;
    }

    @Override
    public void addProperty(SoapObject soapObject) {
        soapObject.addProperty("TelPhone",TelPhone);
    }

    @Override
    public String getMethodName() {
        return "telPhone";
    }

    @Override
    public String toString() {
        return "ReqUserLoginCode{" +
                "TelPhone='" + TelPhone + '\'' +
                '}';
    }
}
