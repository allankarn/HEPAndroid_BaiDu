package com.enetedu.hep.http.resp;

import com.enetedu.hep.http.RespBase;
import com.enetedu.hep.http.entity.CourseClassifyListEntity;
import com.enetedu.hep.http.entity.InfoClassifyListEntity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class RespInfoClassifyList extends RespBase {

    private ArrayList<CourseClassifyListEntity> list = new ArrayList<>();
    private CourseClassifyListEntity courseClassifyListEntity;

    @Override
    public void onResp(String result) {
        JSONObject jo = converToJson(result);

        if (jo != null) {
            JSONObject resultData = getJSONObj(jo, "ResultData");

            String userObj = getJsonString(resultData, "CourseClassifyList", "");

            if (userObj != null) {
                JSONArray jsonArray = getJsonArray(userObj);

                if (jsonArray != null && jsonArray.length() > 0) {
                    for (int i = 0; i < jsonArray.length(); i++) {
                        try {
                            JSONObject jsonObject = (JSONObject) jsonArray.get(i);

                            String id = jsonObject.optString("ID");
                            String name = jsonObject.optString("Name");
                            courseClassifyListEntity = new CourseClassifyListEntity(id, name);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        list.add(courseClassifyListEntity);
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
        return "RespInfoClassifyList{" +
                "list=" + list +
                ", infoClassifyListEntity=" + courseClassifyListEntity +
                '}';
    }
}
