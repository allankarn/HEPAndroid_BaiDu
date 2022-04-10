package com.enetedu.hep.http.entity;

import com.enetedu.hep.base.BaseEntityImpl;

import java.util.ArrayList;

public class SubcList extends BaseEntityImpl {
    private int id;
    private String centerType;
    private String name;
    private String money;
    private ArrayList<TjList> tjLists;

    public SubcList() {
    }

    public SubcList(int id, String centerType, String name, String money, ArrayList<TjList> tjLists) {
        this.id = id;
        this.centerType = centerType;
        this.name = name;
        this.money = money;
        this.tjLists = tjLists;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCenterType() {
        return centerType;
    }

    public void setCenterType(String centerType) {
        this.centerType = centerType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public ArrayList<TjList> getTjLists() {
        return tjLists;
    }

    public void setTjLists(ArrayList<TjList> tjLists) {
        this.tjLists = tjLists;
    }

    @Override
    public String toString() {
        return "SubcList{" +
                "id=" + id +
                ", centerType='" + centerType + '\'' +
                ", name='" + name + '\'' +
                ", money='" + money + '\'' +
                ", tjLists=" + tjLists +
                '}';
    }
}
