package com.enetedu.hep.http.entity;

import com.enetedu.hep.base.BaseEntityImpl;

public class TjList extends BaseEntityImpl {
    private int id;
    private int courseid;
    private String courseday;
    private String coursericheng;
    private String coursexueyuan;
    private int is_main;
    private int centerid;

    public TjList() {
    }

    public TjList(int id, int courseid, String courseday, String coursericheng, String coursexueyuan, int is_main, int centerid) {
        this.id = id;
        this.courseid = courseid;
        this.courseday = courseday;
        this.coursericheng = coursericheng;
        this.coursexueyuan = coursexueyuan;
        this.is_main = is_main;
        this.centerid = centerid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public String getCourseday() {
        return courseday;
    }

    public void setCourseday(String courseday) {
        this.courseday = courseday;
    }

    public String getCoursericheng() {
        return coursericheng;
    }

    public void setCoursericheng(String coursericheng) {
        this.coursericheng = coursericheng;
    }

    public String getCoursexueyuan() {
        return coursexueyuan;
    }

    public void setCoursexueyuan(String coursexueyuan) {
        this.coursexueyuan = coursexueyuan;
    }

    public int getIs_main() {
        return is_main;
    }

    public void setIs_main(int is_main) {
        this.is_main = is_main;
    }

    public int getCenterid() {
        return centerid;
    }

    public void setCenterid(int centerid) {
        this.centerid = centerid;
    }

    @Override
    public String toString() {
        return "TjList{" +
                "id=" + id +
                ", courseid=" + courseid +
                ", courseday='" + courseday + '\'' +
                ", coursericheng='" + coursericheng + '\'' +
                ", coursexueyuan='" + coursexueyuan + '\'' +
                ", is_main=" + is_main +
                ", centerid=" + centerid +
                '}';
    }
}
