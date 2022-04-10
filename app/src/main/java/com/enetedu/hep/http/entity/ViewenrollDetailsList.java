package com.enetedu.hep.http.entity;

import com.enetedu.hep.base.BaseEntityImpl;

public class ViewenrollDetailsList extends BaseEntityImpl {
    private int id;
    private String name;
    private String is_finished;
    private String start_time;
    private String cmsidurl;

    public ViewenrollDetailsList() {
    }

    public ViewenrollDetailsList(int id, String name, String is_finished, String start_time, String cmsidurl) {
        this.id = id;
        this.name = name;
        this.is_finished = is_finished;
        this.start_time = start_time;
        this.cmsidurl = cmsidurl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIs_finished() {
        return is_finished;
    }

    public void setIs_finished(String is_finished) {
        this.is_finished = is_finished;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getCmsidurl() {
        return cmsidurl;
    }

    public void setCmsidurl(String cmsidurl) {
        this.cmsidurl = cmsidurl;
    }

    @Override
    public String toString() {
        return "ViewenrollDetailsList{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", is_finished='" + is_finished + '\'' +
                ", start_time='" + start_time + '\'' +
                ", cmsidurl='" + cmsidurl + '\'' +
                '}';
    }
}
