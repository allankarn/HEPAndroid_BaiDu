package com.enetedu.hep.course.adapter.entity;

public class Zj_rlv {
    //默认接口的属性
    private int touxiang;
    private String name;
    private String zhicheng;
    private String danwei;

    public int getTouxiang() {
        return touxiang;
    }

    public void setTouxiang(int touxiang) {
        this.touxiang = touxiang;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZhicheng() {
        return zhicheng;
    }

    public void setZhicheng(String zhicheng) {
        this.zhicheng = zhicheng;
    }

    public String getDanwei() {
        return danwei;
    }

    public void setDanwei(String danwei) {
        this.danwei = danwei;
    }

    public Zj_rlv(int touxiang, String name, String zhicheng, String danwei) {
        this.touxiang = touxiang;
        this.name = name;
        this.zhicheng = zhicheng;
        this.danwei = danwei;
    }
}
