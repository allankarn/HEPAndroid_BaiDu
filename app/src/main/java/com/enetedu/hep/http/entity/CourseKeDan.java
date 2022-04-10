package com.enetedu.hep.http.entity;

import java.io.Serializable;
import java.util.ArrayList;

public class CourseKeDan implements Serializable {
    private int ID;

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

    private ArrayList<CourseList> CourseList ;

    private String is_video_finished;

    private String is_work_finished;

    private String StatusName;

    public CourseKeDan() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public ArrayList<com.enetedu.hep.http.entity.CourseList> getCourseList() {
        return CourseList;
    }

    public void setCourseList(ArrayList<com.enetedu.hep.http.entity.CourseList> courseList) {
        CourseList = courseList;
    }

    public String getIs_video_finished() {
        return is_video_finished;
    }

    public void setIs_video_finished(String is_video_finished) {
        this.is_video_finished = is_video_finished;
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
}
