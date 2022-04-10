package com.enetedu.hep.http.entity;

import com.enetedu.hep.base.BaseEntityImpl;
import com.enetedu.hep.http.HEPMSProxy;
import com.enetedu.hep.http.IHEPMSProxy;
import com.enetedu.hep.http.RespBase;
import com.enetedu.hep.http.req.ReqCdnurl;
import com.enetedu.hep.http.req.ReqVideoPlayForMgc;

public class CourseWareListEntity extends BaseEntityImpl {
    private int cmsid;
    private String name;
    private int coursewareid;

    public CourseWareListEntity() {
    }

    public CourseWareListEntity(int cmsid, String name, int coursewareid) {
        this.cmsid = cmsid;
        this.name = name;
        this.coursewareid = coursewareid;
    }

    public int getCmsid() {
        return cmsid;
    }

    public void setCmsid(int cmsid) {
        this.cmsid = cmsid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCoursewareid() {
        return coursewareid;
    }

    public void setCoursewareid(int coursewareid) {
        this.coursewareid = coursewareid;
    }

    @Override
    public String toString() {
        return "CourseWareListEntity{" +
                "cmsid=" + cmsid +
                ", name='" + name + '\'' +
                ", coursewareid=" + coursewareid +
                '}';
    }

    private ReqVideoPlayForMgc reqVideoPlayForMgc;

    public void getVideoPlayForMgc(String EndPoint, String UserToKen, int UserID, int CourseID, final OnBaseResp onBaseResp) {
        if (reqVideoPlayForMgc == null) reqVideoPlayForMgc = new ReqVideoPlayForMgc();
        reqVideoPlayForMgc.setEndPoint(EndPoint);
        reqVideoPlayForMgc.setUserToKen(UserToKen);
        reqVideoPlayForMgc.setUserID(UserID);
        reqVideoPlayForMgc.setCourseid(CourseID);


        HEPMSProxy.GetVideoPlayForMgc(reqVideoPlayForMgc, new IHEPMSProxy.OnResp() {
            @Override
            public void onResp(RespBase response) {
                resp(onBaseResp, response);
            }
        });
    }

    private ReqCdnurl reqCdnurl;

    public void getCdnurl(String EndPoint, int cmsid, final OnBaseResp onBaseResp) {
        if (reqCdnurl == null) reqCdnurl = new ReqCdnurl();
        reqCdnurl.setEndPoint(EndPoint);
        reqCdnurl.setCmsid(cmsid);


        HEPMSProxy.GetCdnurl(reqCdnurl, new IHEPMSProxy.OnResp() {
            @Override
            public void onResp(RespBase response) {
                resp(onBaseResp, response);
            }
        });
    }
}
