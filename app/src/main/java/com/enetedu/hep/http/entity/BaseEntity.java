package com.enetedu.hep.http.entity;

import com.enetedu.hep.http.RespBase;

import java.io.Serializable;

public interface BaseEntity extends Serializable{
    interface OnBaseResp{
        void onResp(RespBase resp);
    }
}
