package com.enetedu.hep.http.entity;

import java.io.Serializable;

public class CourseList implements Serializable {
    private int ID;

    private String CourseName;

    private String Info;

    private String CourseType;

    private String CourseTime;

    public CourseList() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    public String getInfo() {
        return Info;
    }

    public void setInfo(String info) {
        Info = info;
    }

    public String getCourseType() {
        return CourseType;
    }

    public void setCourseType(String courseType) {
        CourseType = courseType;
    }

    public String getCourseTime() {
        return CourseTime;
    }

    public void setCourseTime(String courseTime) {
        CourseTime = courseTime;
    }

    @Override
    public String toString() {
        return "CourseList{" +
                "ID=" + ID +
                ", CourseName='" + CourseName + '\'' +
                ", Info='" + Info + '\'' +
                ", CourseType='" + CourseType + '\'' +
                ", CourseTime='" + CourseTime + '\'' +
                '}';
    }
}
