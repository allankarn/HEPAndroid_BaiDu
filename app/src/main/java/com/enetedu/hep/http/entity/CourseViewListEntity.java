package com.enetedu.hep.http.entity;

import com.enetedu.hep.base.BaseEntityImpl;
import com.enetedu.hep.http.HEPMSProxy;
import com.enetedu.hep.http.IHEPMSProxy;
import com.enetedu.hep.http.RespBase;
import com.enetedu.hep.http.req.ReqPreparationList;
import com.enetedu.hep.http.req.ReqPublicClass;

import java.util.ArrayList;

public class CourseViewListEntity extends BaseEntityImpl {
    private int id;
    private String Name;
    private String CourseType;
    private String CourseStatus;
    private String StartTime;
    private String EndTime;
    private String CreateTime;
    private String FinishTime;
    private String is_payoffed;
    private String CourseTeach;
    private String PaySel;
    private int courehour;
    private int is_new;
    private int is_postpone;
    private ArrayList<CourseList> courseLists;

    public CourseViewListEntity() {
    }

    public CourseViewListEntity(int id, String name, String courseType, String courseStatus, String startTime, String endTime, String createTime, String finishTime, String is_payoffed, String courseTeach, String paySel, int courehour, int is_new, int is_postpone, ArrayList<CourseList> courseLists) {
        this.id = id;
        Name = name;
        CourseType = courseType;
        CourseStatus = courseStatus;
        StartTime = startTime;
        EndTime = endTime;
        CreateTime = createTime;
        FinishTime = finishTime;
        this.is_payoffed = is_payoffed;
        CourseTeach = courseTeach;
        PaySel = paySel;
        this.courehour = courehour;
        this.is_new = is_new;
        this.is_postpone = is_postpone;
        this.courseLists = courseLists;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCourseType() {
        return CourseType;
    }

    public void setCourseType(String courseType) {
        CourseType = courseType;
    }

    public String getCourseStatus() {
        return CourseStatus;
    }

    public void setCourseStatus(String courseStatus) {
        CourseStatus = courseStatus;
    }

    public String getStartTime() {
        return StartTime;
    }

    public void setStartTime(String startTime) {
        StartTime = startTime;
    }

    public String getEndTime() {
        return EndTime;
    }

    public void setEndTime(String endTime) {
        EndTime = endTime;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String createTime) {
        CreateTime = createTime;
    }

    public String getFinishTime() {
        return FinishTime;
    }

    public void setFinishTime(String finishTime) {
        FinishTime = finishTime;
    }

    public String getIs_payoffed() {
        return is_payoffed;
    }

    public void setIs_payoffed(String is_payoffed) {
        this.is_payoffed = is_payoffed;
    }

    public String getCourseTeach() {
        return CourseTeach;
    }

    public void setCourseTeach(String courseTeach) {
        CourseTeach = courseTeach;
    }

    public String getPaySel() {
        return PaySel;
    }

    public void setPaySel(String paySel) {
        PaySel = paySel;
    }

    public int getCourehour() {
        return courehour;
    }

    public void setCourehour(int courehour) {
        this.courehour = courehour;
    }

    public int getIs_new() {
        return is_new;
    }

    public void setIs_new(int is_new) {
        this.is_new = is_new;
    }

    public int getIs_postpone() {
        return is_postpone;
    }

    public void setIs_postpone(int is_postpone) {
        this.is_postpone = is_postpone;
    }

    public ArrayList<CourseList> getCourseLists() {
        return courseLists;
    }

    public void setCourseLists(ArrayList<CourseList> courseLists) {
        this.courseLists = courseLists;
    }

    @Override
    public String toString() {
        return "CourseViewListEntity{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", CourseType='" + CourseType + '\'' +
                ", CourseStatus='" + CourseStatus + '\'' +
                ", StartTime='" + StartTime + '\'' +
                ", EndTime='" + EndTime + '\'' +
                ", CreateTime='" + CreateTime + '\'' +
                ", FinishTime='" + FinishTime + '\'' +
                ", is_payoffed='" + is_payoffed + '\'' +
                ", CourseTeach='" + CourseTeach + '\'' +
                ", PaySel='" + PaySel + '\'' +
                ", courehour=" + courehour +
                ", is_new=" + is_new +
                ", is_postpone=" + is_postpone +
                ", courseLists=" + courseLists +
                '}';
    }

    ReqPreparationList reqPreparationList;

    public void getPreparationList(String UserToKen, int userid, int PageNo, int PageSize, final OnBaseResp onBaseResp) {
        if (reqPreparationList == null) reqPreparationList = new ReqPreparationList();
        reqPreparationList.setUserToKen(UserToKen);
        reqPreparationList.setUserID(userid);
        reqPreparationList.setPageNo(PageNo);
        reqPreparationList.setPageSize(PageSize);

        HEPMSProxy.GetPreparationList(reqPreparationList, new IHEPMSProxy.OnResp() {
            @Override
            public void onResp(RespBase response) {
                resp(onBaseResp, response);
            }
        });
    }
}
