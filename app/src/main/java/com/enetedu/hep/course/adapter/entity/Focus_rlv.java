package com.enetedu.hep.course.adapter.entity;

public class Focus_rlv {

    //默认接口的属性
    private String biaoqian;
    private String course;
    private String time;
    private String zhuangtai;

    public Focus_rlv(String biaoqian, String course, String time, String zhuangtai) {
        this.biaoqian = biaoqian;
        this.course = course;
        this.time = time;
        this.zhuangtai = zhuangtai;
    }

    public String getBiaoqian() {
        return biaoqian;
    }

    public void setBiaoqian(String biaoqian) {
        this.biaoqian = biaoqian;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getZhuangtai() {
        return zhuangtai;
    }

    public void setZhuangtai(String zhuangtai) {
        this.zhuangtai = zhuangtai;
    }
}
