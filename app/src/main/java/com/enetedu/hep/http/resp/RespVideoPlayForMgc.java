package com.enetedu.hep.http.resp;

import com.enetedu.hep.http.RespBase;
import com.enetedu.hep.http.entity.CourseWareListEntity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class RespVideoPlayForMgc extends RespBase {

    private ArrayList<CourseWareListEntity> list = new ArrayList<>();
    private CourseWareListEntity courseWareListEntity;

    @Override
    public void onResp(String result) {
        JSONObject jo = converToJson(result);

        if (jo != null) {
            JSONObject resultData = getJSONObj(jo, "ResultData");

            String userObj = getJsonString(resultData, "coursewareList", "");

            if (userObj != null) {
                JSONArray jsonArray = getJsonArray(userObj);

                if (jsonArray != null && jsonArray.length() > 0) {
                    for (int i = 0; i < jsonArray.length(); i++) {
                        try {
                            JSONObject jsonObject = (JSONObject) jsonArray.get(i);

                            int cmsid = jsonObject.optInt("cmsid");
                            String name = jsonObject.optString("name");
                            int coursewareid = jsonObject.optInt("coursewareid");
                            courseWareListEntity = new CourseWareListEntity(cmsid, name, coursewareid);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        list.add(courseWareListEntity);
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
        return "RespVideoPlayForMgc{" +
                "list=" + list +
                ", courseWareListEntity=" + courseWareListEntity +
                '}';
    }
}
