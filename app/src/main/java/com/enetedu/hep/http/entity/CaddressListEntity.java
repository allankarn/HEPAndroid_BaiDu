package com.enetedu.hep.http.entity;

import com.enetedu.hep.base.BaseEntityImpl;

import java.util.ArrayList;

public class CaddressListEntity extends BaseEntityImpl {

    private String centerid;
    private int count;
    private int netpayCount;
    private String centermoney;
    private String address;
    private ArrayList<TjList> tjLists;

    public CaddressListEntity() {
    }

    public CaddressListEntity(String centerid, int count, int netpayCount, String centermoney, String address, ArrayList<TjList> tjLists) {
        this.centerid = centerid;
        this.count = count;
        this.netpayCount = netpayCount;
        this.centermoney = centermoney;
        this.address = address;
        this.tjLists = tjLists;
    }

    public String getCenterid() {
        return centerid;
    }

    public void setCenterid(String centerid) {
        this.centerid = centerid;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getNetpayCount() {
        return netpayCount;
    }

    public void setNetpayCount(int netpayCount) {
        this.netpayCount = netpayCount;
    }

    public String getCentermoney() {
        return centermoney;
    }

    public void setCentermoney(String centermoney) {
        this.centermoney = centermoney;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<TjList> getTjLists() {
        return tjLists;
    }

    public void setTjLists(ArrayList<TjList> tjLists) {
        this.tjLists = tjLists;
    }

    @Override
    public String toString() {
        return "CaddressListEntity{" +
                "centerid='" + centerid + '\'' +
                ", count=" + count +
                ", netpayCount=" + netpayCount +
                ", centermoney='" + centermoney + '\'' +
                ", address='" + address + '\'' +
                ", tjLists=" + tjLists +
                '}';
    }
}
