package com.enetedu.hep.http.resp;

import android.util.Log;

import com.enetedu.hep.http.RespBase;
import com.enetedu.hep.http.entity.CourseClassifyListEntity;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class RespCourseClassifyList extends RespBase {
    private ArrayList<CourseClassifyListEntity> list = new ArrayList<>();
    private static final String TAG = "RespCourseClassifyList";

    private CourseClassifyListEntity courseClassifyListEntity;

    /**
     * @param result
     */
    @Override
    public void onResp(String result) {

        Gson gson = new Gson();
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
                            String id = jsonObject.getString("ID");
                            String name = jsonObject.getString("Name");
                            courseClassifyListEntity = new CourseClassifyListEntity(id, name);
                            Log.d(TAG, "onResp: ======="+courseClassifyListEntity.toString());
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
        return "RespCourseClassifyList [info=" + "" + courseClassifyListEntity.toString() + super.toString() + "]";
    }
}
