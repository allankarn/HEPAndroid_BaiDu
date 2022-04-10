package com.enetedu.hep.course.adapter.entity;

public class Course_Rlv {
    //默认接口的属性
    private String zhibo;
    private String course;

    public Course_Rlv(String zhibo, String course) {
        this.zhibo = zhibo;
        this.course = course;
    }

    public String getZhibo() {
        return zhibo;
    }

    public void setZhibo(String zhibo) {
        this.zhibo = zhibo;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
