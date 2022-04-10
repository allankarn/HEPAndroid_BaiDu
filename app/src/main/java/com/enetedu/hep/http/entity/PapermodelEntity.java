package com.enetedu.hep.http.entity;

import com.enetedu.hep.base.BaseEntityImpl;

public class PapermodelEntity extends BaseEntityImpl {

    private int id;
    private String title;
    private String content;
    private String Addtime;
    private String username;
    private String Paper_ifshow;
    private int hits;
    private int centerid;
    private int courseid;
    private int userid;
    private String Usermyname;
    private String coursetime;

    public PapermodelEntity() {
    }

    public PapermodelEntity(int id, String title, String content, String addtime, String username, String paper_ifshow, int hits, int centerid, int courseid, int userid, String usermyname, String coursetime) {
        this.id = id;
        this.title = title;
        this.content = content;
        Addtime = addtime;
        this.username = username;
        Paper_ifshow = paper_ifshow;
        this.hits = hits;
        this.centerid = centerid;
        this.courseid = courseid;
        this.userid = userid;
        Usermyname = usermyname;
        this.coursetime = coursetime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAddtime() {
        return Addtime;
    }

    public void setAddtime(String addtime) {
        Addtime = addtime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPaper_ifshow() {
        return Paper_ifshow;
    }

    public void setPaper_ifshow(String paper_ifshow) {
        Paper_ifshow = paper_ifshow;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public int getCenterid() {
        return centerid;
    }

    public void setCenterid(int centerid) {
        this.centerid = centerid;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsermyname() {
        return Usermyname;
    }

    public void setUsermyname(String usermyname) {
        Usermyname = usermyname;
    }

    public String getCoursetime() {
        return coursetime;
    }

    public void setCoursetime(String coursetime) {
        this.coursetime = coursetime;
    }

    @Override
    public String toString() {
        return "PapermodelEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", Addtime='" + Addtime + '\'' +
                ", username='" + username + '\'' +
                ", Paper_ifshow='" + Paper_ifshow + '\'' +
                ", hits=" + hits +
                ", centerid=" + centerid +
                ", courseid=" + courseid +
                ", userid=" + userid +
                ", Usermyname='" + Usermyname + '\'' +
                ", coursetime='" + coursetime + '\'' +
                '}';
    }
}
