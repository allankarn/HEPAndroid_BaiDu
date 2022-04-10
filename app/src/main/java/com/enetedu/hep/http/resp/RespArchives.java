package com.enetedu.hep.http.resp;

import com.enetedu.hep.http.RespBase;
import com.enetedu.hep.http.entity.ArchivesEntity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class RespArchives extends RespBase {

    private ArrayList<ArchivesEntity> list = new ArrayList<>();
    private ArchivesEntity archivesEntity;

    @Override
    public void onResp(String result) {
        JSONObject jo = converToJson(result);

        if (jo != null) {
            JSONObject resultData = getJSONObj(jo, "ResultData");

            String userObj = getJsonString(resultData, "credititemList", "");

            if (userObj != null) {
                JSONArray jsonArray = getJsonArray(userObj);

                if (jsonArray != null && jsonArray.length() > 0) {
                    for (int i = 0; i < jsonArray.length(); i++) {
                        try {
                            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                            String in_out_flag = jsonObject.optString("IN_OUT_FLAG");
                            String remark = jsonObject.optString("REMARK");
                            String credit_time = jsonObject.optString("CREDIT_TIME");
                            Double credit = jsonObject.optDouble("CREDIT");
                            archivesEntity = new ArchivesEntity(in_out_flag, remark, credit_time, credit);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        list.add(archivesEntity);
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
        return "RespArchives{" +
                "list=" + list +
                ", archivesEntity=" + archivesEntity +
                '}';
    }
}
