package com.enetedu.hep.http.resp;

import com.enetedu.hep.http.RespBase;
import com.enetedu.hep.http.entity.Course2ModelEntity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class RespPublicClass extends RespBase {

    private ArrayList<Course2ModelEntity> list = new ArrayList<>();
    private Course2ModelEntity course2ModelEntity;

    @Override
    public void onResp(String result) {
        JSONObject jo = converToJson(result);

        if (jo != null) {
            JSONObject resultData = getJSONObj(jo, "ResultData");

            String userObj = getJsonString(resultData, "course2List", "");

            if (userObj != null) {
                JSONArray jsonArray = getJsonArray(userObj);

                if (jsonArray != null && jsonArray.length() > 0) {
                    for (int i = 0; i < jsonArray.length(); i++) {
                        try {
                            JSONObject jsonObject = (JSONObject) jsonArray.get(i);

                            int id = jsonObject.optInt("ID");
                            String name = jsonObject.optString("NAME");
                            String head_img_url = jsonObject.optString("HEAD_IMG_URL");
                            int studyState = jsonObject.optInt("studyState");
                            int clicks = jsonObject.optInt("CLICKS");
                            String enrollmentCount = jsonObject.optString("enrollmentCount");
                            String sub_teacher_name = jsonObject.optString("SUB_TEACHER_NAME");
                            course2ModelEntity = new Course2ModelEntity();
                            course2ModelEntity.setId(id);
                            course2ModelEntity.setName(name);
                            course2ModelEntity.setHead_img_url(head_img_url);
                            course2ModelEntity.setStudyState(studyState);
                            course2ModelEntity.setClicks(clicks);
                            course2ModelEntity.setEnrollmentCount(enrollmentCount);
                            course2ModelEntity.setSub_teacher_name(sub_teacher_name);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        list.add(course2ModelEntity);
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
        return "RespPublicClass{" +
                "list=" + list +
                ", course2ModelEntity=" + course2ModelEntity +
                '}';
    }
}
