package com.enetedu.hep.http.entity;

import com.enetedu.hep.base.BaseEntityImpl;
import com.enetedu.hep.http.HEPMSProxy;
import com.enetedu.hep.http.IHEPMSProxy;
import com.enetedu.hep.http.RespBase;
import com.enetedu.hep.http.req.ReqCourseClassifyList;
import com.enetedu.hep.http.req.ReqInfoClassifyList;

public class CourseClassifyListEntity extends BaseEntityImpl{
    private String ID;
    private String Name;

    public CourseClassifyListEntity(String id, String name) {

        ID = id;
        Name = name;
    }

    public CourseClassifyListEntity() {

    }

    @Override
    public String toString() {
        return "CourseClassifyListEntity{" +
                "id='" + ID + '\'' +
                ", name='" + Name + '\'' +
                '}';
    }


    public String getId() {
        return ID;
    }

    public void setId(String id) {
        this.ID = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }


    private ReqCourseClassifyList reqCourseClassifyList;
    public void getCourseClassifyList(String EndPoint,final OnBaseResp onBaseResp) {
        if (reqCourseClassifyList == null) reqCourseClassifyList = new ReqCourseClassifyList();
        reqCourseClassifyList.setEndPoint(EndPoint);
        HEPMSProxy.GetCourseClassifyList(reqCourseClassifyList, new IHEPMSProxy.OnResp() {
            @Override
            public void onResp(RespBase response) {
                resp(onBaseResp,response);
            }
        });
    }

    ReqInfoClassifyList reqInfoClassifyList;

    public void getInfoClassifyList(final OnBaseResp onBaseResp) {
        if (reqInfoClassifyList == null) reqInfoClassifyList = new ReqInfoClassifyList();

        HEPMSProxy.GetInfoClassifyList(reqInfoClassifyList, new IHEPMSProxy.OnResp() {
            @Override
            public void onResp(RespBase response) {
                resp(onBaseResp, response);
            }
        });
    }
}
