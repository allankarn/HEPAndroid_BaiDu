package com.enetedu.hep.http.entity;

import com.enetedu.hep.base.BaseEntityImpl;
import com.enetedu.hep.http.HEPMSProxy;
import com.enetedu.hep.http.IHEPMSProxy;
import com.enetedu.hep.http.RespBase;
import com.enetedu.hep.http.req.ReqCourseList;

public class CourseListEntity extends BaseEntityImpl {
    private int id;
    private String name;
    private String teacherName;
    private String des;
    private String img_url;
    private String showType;
    private String videoTime;

    public CourseListEntity(int id, String name, String teacherName, String des, String img_url, String showType, String videoTime) {
        this.id = id;
        this.name = name;
        this.teacherName = teacherName;
        this.des = des;
        this.img_url = img_url;
        this.showType = showType;
        this.videoTime = videoTime;

    }

    public CourseListEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getShowType() {
        return showType;
    }

    public void setShowType(String showType) {
        this.showType = showType;
    }

    public String getVideoTime() {
        return videoTime;
    }

    public void setVideoTime(String videoTime) {
        this.videoTime = videoTime;
    }

    public ReqCourseList getReqCourseList() {
        return reqCourseList;
    }

    public void setReqCourseList(ReqCourseList reqCourseList) {
        this.reqCourseList = reqCourseList;
    }

    @Override
    public String toString() {
        return "CourseListEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", des='" + des + '\'' +
                ", img_url='" + img_url + '\'' +
                ", showType='" + showType + '\'' +
                ", videoTime='" + videoTime + '\'' +
                ", reqCourseList=" + reqCourseList +
                '}';
    }

    private ReqCourseList reqCourseList;

    public void getCourseList(String EndPoint,String flag, int PageNo, int PageSize, final OnBaseResp onBaseResp) {
        if (reqCourseList == null) reqCourseList = new ReqCourseList();
        reqCourseList.setEndPoint(EndPoint);
        reqCourseList.setFlag(flag);
        reqCourseList.setPageNo(PageNo);
        reqCourseList.setPageSize(PageSize);
        HEPMSProxy.GetCourseList(reqCourseList, new IHEPMSProxy.OnResp() {
            @Override
            public void onResp(RespBase response) {
                resp(onBaseResp,response);
            }
        });
    }
}
