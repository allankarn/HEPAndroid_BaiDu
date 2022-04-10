package com.enetedu.hep.http.resp;

import android.util.Log;

import com.enetedu.hep.http.RespBase;
import com.enetedu.hep.http.entity.CourseListEntity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class RespCourseList extends RespBase {
    private static final String TAG = "RespCourseList";
    private ArrayList<CourseListEntity> list = new ArrayList<>();
    private CourseListEntity courseListEntity;

    @Override
    public void onResp(String result) {
        JSONObject jo = converToJson(result);

        if (jo != null) {
            JSONObject resultData = getJSONObj(jo, "ResultData");

            String userObj = getJsonString(resultData, "courseView", "");

            if (userObj != null) {
                JSONArray jsonArray = getJsonArray(userObj);

                if (jsonArray != null && jsonArray.length() > 0) {
                    for (int i = 0; i < jsonArray.length(); i++) {
                        try {
                            JSONObject jsonObject = (JSONObject) jsonArray.get(i);

                            int id = jsonObject.getInt("id");
                            String name = jsonObject.getString("name");
                            String teacherName = jsonObject.getString("teacherName");
                            String des = jsonObject.getString("des");
                            String img_url = jsonObject.getString("img_url");
                            String showType = jsonObject.getString("showType");
                            String videoTime = jsonObject.getString("videoTime");
                            courseListEntity = new CourseListEntity(id,name,teacherName,des,img_url,showType,videoTime);
                            Log.d(TAG, "onResp: ======="+courseListEntity.toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        list.add(courseListEntity);
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
        return "RespCourseList [info=" + "" + courseListEntity.toString() + super.toString() + "]";
    }
}
