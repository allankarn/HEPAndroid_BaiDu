package com.enetedu.hep.http.resp;

import android.util.Log;

import com.enetedu.hep.http.RespBase;
import com.enetedu.hep.http.entity.CourseListEntity;
import com.enetedu.hep.http.entity.TodayCourseListEntity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class RespCourseListjz1 extends RespBase {
    private ArrayList<TodayCourseListEntity> list = new ArrayList<>();
    private TodayCourseListEntity todayCourseListEntity;

    @Override
    public void onResp(String result) {
        JSONObject jo = converToJson(result);

        if (jo != null) {
            JSONObject resultData = getJSONObj(jo, "ResultData");

            String userObj = getJsonString(resultData, "TodayCourseList", "");

            if (userObj != null) {
                JSONArray jsonArray = getJsonArray(userObj);

                if (jsonArray != null && jsonArray.length() > 0) {
                    for (int i = 0; i < jsonArray.length(); i++) {
                        try {
                            JSONObject jsonObject = (JSONObject) jsonArray.get(i);

                            int id = jsonObject.getInt("id");
                            String time = jsonObject.optString("time");
                            String name = jsonObject.optString("name");
                            String coursetype = jsonObject.optString("coursetype");
                            String ctype = jsonObject.optString("ctype");
                            todayCourseListEntity = new TodayCourseListEntity(id, time, name, coursetype, ctype);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        list.add(todayCourseListEntity);
                    }
                }
            }
        }
    }

    @Override
    public Object getData() {
        return list;
    }

    @Override
    public String toString() {
        return "RespCourseListjz1{" +
                "list=" + list +
                ", todayCourseListEntity=" + todayCourseListEntity +
                '}';
    }
}
