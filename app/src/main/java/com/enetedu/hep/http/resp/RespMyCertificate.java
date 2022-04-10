package com.enetedu.hep.http.resp;

import android.util.Log;

import com.enetedu.hep.http.RespBase;
import com.enetedu.hep.http.entity.MyCertificateEntity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class RespMyCertificate extends RespBase {
    private ArrayList<MyCertificateEntity> list = new ArrayList<>();
    private MyCertificateEntity myCertificateEntity;
    private static final String TAG = "RespMyCertificate";

    @Override
    public void onResp(String result) {
        JSONObject jo = converToJson(result);

        if (jo != null) {
            JSONObject resultData = getJSONObj(jo, "ResultData");

            String userObj = getJsonString(resultData, "creditprintitemList", "");

            if (userObj != null) {
                JSONArray jsonArray = getJsonArray(userObj);

                if (jsonArray != null && jsonArray.length() > 0) {
                    for (int i = 0; i < jsonArray.length(); i++) {
                        try {
                            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                            int id = jsonObject.optInt("ID");
                            String course_name = jsonObject.optString("COURSE_NAME");
                            Double credit = jsonObject.optDouble("CREDIT");
                            String credit_start_time = jsonObject.optString("credit_start_time");
                            myCertificateEntity = new MyCertificateEntity(id, course_name, credit, credit_start_time);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        Log.d(TAG, "onResp: "+myCertificateEntity.toString());
                        list.add(myCertificateEntity);
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
        return "RespMyCertificate{" +
                "list=" + list +
                ", myCertificateEntity=" + myCertificateEntity +
                '}';
    }
}
