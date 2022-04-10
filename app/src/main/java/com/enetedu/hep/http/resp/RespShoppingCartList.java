package com.enetedu.hep.http.resp;

import android.util.Log;

import com.enetedu.hep.http.RespBase;
import com.enetedu.hep.http.entity.ShoppingCartListEntity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class RespShoppingCartList extends RespBase {
    private static final String TAG = "RespShoppingCartList";
    private ShoppingCartListEntity shoppingCartListEntity;
    private ArrayList<ShoppingCartListEntity> list = new ArrayList<>();

    @Override
    public void onResp(String result) {
        JSONObject jo = converToJson(result);

        if (jo != null) {
            shoppingCartListEntity = new ShoppingCartListEntity();
            shoppingCartListEntity.setCourseid(getJSONInt(jo, "courseid", 0));

            JSONObject resultData = getJSONObj(jo, "ResultData");

            String shoplist = getJsonString(resultData, "gouwuceList", "");

            if (shoplist != null) {
                JSONArray jsonArray = getJsonArray(shoplist);

                if (jsonArray != null && jsonArray.length() > 0) {
                    for (int i = 0; i < jsonArray.length(); i++) {
                        ShoppingCartListEntity shoppingCartListEntity = new ShoppingCartListEntity();
                        try {
                            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                            String id = jsonObject.getString("ID");
                            String courseID = jsonObject.getString("CourseID");
                            String studentID = jsonObject.getString("StudentID");
                            String courseName = jsonObject.getString("CourseName");
                            String courseCerdit = jsonObject.getString("CourseCerdit");
                            int courseType = jsonObject.getInt("CourseType");
                            String imgurl = jsonObject.getString("imgurl");
                            shoppingCartListEntity.setID(id);
                            shoppingCartListEntity.setCourseID(courseID);
                            shoppingCartListEntity.setStudentID(studentID);
                            shoppingCartListEntity.setCourseName(courseName);
                            shoppingCartListEntity.setCourseCerdit(courseCerdit);
                            shoppingCartListEntity.setCourseType(courseType);
                            shoppingCartListEntity.setImgurl(imgurl);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        list.add(shoppingCartListEntity);
                    }

                }
            }
        }

    }

    @Override
    public Object getData() {
        Log.d(TAG, "getData: " + list.toString());
        return list;
    }

    @Override
    public String toString() {
        return "RespCourseList [info=" + "" + shoppingCartListEntity.toString() + super.toString() + "]";
    }
}
