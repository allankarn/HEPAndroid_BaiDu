package com.enetedu.hep.http.entity;

import com.enetedu.hep.base.BaseEntityImpl;
import com.enetedu.hep.http.HEPMSProxy;
import com.enetedu.hep.http.IHEPMSProxy;
import com.enetedu.hep.http.RespBase;
import com.enetedu.hep.http.req.ReqUnfinishedList;

import java.util.ArrayList;

public class Course2ViewListEntity extends BaseEntityImpl {
    private int id;
    private String Name;
    private String CourseType;
    private String CourseStatus;
    private String StartTime;
    private String EndTime;
    private String CreateTime;
    private String FinishTime;
    private String is_payoffed;
    private String is_video_finished;
    private String credit_remain_event;
    private String is_work_finished;
    private String StatusName;
    private int courehour;
    private int is_new;
    private int is_postpone;
    private String operate;
    private ArrayList<CourseList> courseLists;

    public Course2ViewListEntity() {
    }

    public Course2ViewListEntity(int id, String name, String courseType, String courseStatus, String startTime, String endTime, String createTime, String finishTime, String is_payoffed, String is_video_finished, String credit_remain_event, String is_work_finished, String statusName, int courehour, int is_new, int is_postpone, String operate, ArrayList<CourseList> courseLists) {
        this.id = id;
        Name = name;
        CourseType = courseType;
        CourseStatus = courseStatus;
        StartTime = startTime;
        EndTime = endTime;
        CreateTime = createTime;
        FinishTime = finishTime;
        this.is_payoffed = is_payoffed;
        this.is_video_finished = is_video_finished;
        this.credit_remain_event = credit_remain_event;
        this.is_work_finished = is_work_finished;
        StatusName = statusName;
        this.courehour = courehour;
        this.is_new = is_new;
        this.is_postpone = is_postpone;
        this.operate = operate;
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

    public String getIs_video_finished() {
        return is_video_finished;
    }

    public void setIs_video_finished(String is_video_finished) {
        this.is_video_finished = is_video_finished;
    }

    public String getCredit_remain_event() {
        return credit_remain_event;
    }

    public void setCredit_remain_event(String credit_remain_event) {
        this.credit_remain_event = credit_remain_event;
    }

    public String getIs_work_finished() {
        return is_work_finished;
    }

    public void setIs_work_finished(String is_work_finished) {
        this.is_work_finished = is_work_finished;
    }

    public String getStatusName() {
        return StatusName;
    }

    public void setStatusName(String statusName) {
        StatusName = statusName;
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

    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate;
    }

    public ArrayList<CourseList> getCourseLists() {
        return courseLists;
    }

    public void setCourseLists(ArrayList<CourseList> courseLists) {
        this.courseLists = courseLists;
    }

    @Override
    public String toString() {
        return "Course2ViewListEntity{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", CourseType='" + CourseType + '\'' +
                ", CourseStatus='" + CourseStatus + '\'' +
                ", StartTime='" + StartTime + '\'' +
                ", EndTime='" + EndTime + '\'' +
                ", CreateTime='" + CreateTime + '\'' +
                ", FinishTime='" + FinishTime + '\'' +
                ", is_payoffed='" + is_payoffed + '\'' +
                ", is_video_finished='" + is_video_finished + '\'' +
                ", credit_remain_event='" + credit_remain_event + '\'' +
                ", is_work_finished='" + is_work_finished + '\'' +
                ", StatusName='" + StatusName + '\'' +
                ", courehour=" + courehour +
                ", is_new=" + is_new +
                ", is_postpone=" + is_postpone +
                ", operate='" + operate + '\'' +
                ", courseLists=" + courseLists +
                '}';
    }

    ReqUnfinishedList reqUnfinishedList;

    public void getUnfinishedList(String UserToKen, int userid, int PageNo, int PageSize, final OnBaseResp onBaseResp) {
        if (reqUnfinishedList == null) reqUnfinishedList = new ReqUnfinishedList();
        reqUnfinishedList.setUserToKen(UserToKen);
        reqUnfinishedList.setUserID(userid);
        reqUnfinishedList.setPageNo(PageNo);
        reqUnfinishedList.setPageSize(PageSize);

        HEPMSProxy.GetUnfinishedList(reqUnfinishedList, new IHEPMSProxy.OnResp() {
            @Override
            public void onResp(RespBase response) {
                resp(onBaseResp, response);
            }
        });
    }
}
