package com.enetedu.hep.http.resp;

import com.enetedu.hep.http.RespBase;
import com.enetedu.hep.http.entity.LunBoTuEntity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class RespRotationChart extends RespBase {
    private ArrayList<LunBoTuEntity> list = new ArrayList<>();
    private LunBoTuEntity lunBoTuEntity;

    @Override
    public void onResp(String result) {
        JSONObject jo = converToJson(result);

        if (jo != null) {
            JSONObject resultData = getJSONObj(jo, "ResultData");

            String userObj = getJsonString(resultData, "coverpicture", "");

            if (userObj != null) {
                JSONArray jsonArray = getJsonArray(userObj);

                if (jsonArray != null && jsonArray.length() > 0) {
                    for (int i = 0; i < jsonArray.length(); i++) {
                        try {
                            JSONObject jsonObject = (JSONObject) jsonArray.get(i);

                            int id = jsonObject.optInt("ID");
                            String title = jsonObject.optString("TITLE");
                            String description = jsonObject.optString("DESCRIPTION");
                            String hyperlink = jsonObject.optString("HYPERLINK");
                            String picture_url = jsonObject.optString("PICTURE_URL");
                            String picture_type = jsonObject.optString("PICTURE_TYPE");
                            String is_approvaled = jsonObject.optString("IS_APPROVALED");
                            int picture_number = jsonObject.optInt("picture_number");
                            lunBoTuEntity = new LunBoTuEntity(id, title, description, hyperlink, picture_url, picture_type, is_approvaled, picture_number);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        list.add(lunBoTuEntity);
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
        return "RespRotationChart{" +
                "list=" + list +
                ", lunBoTuEntity=" + lunBoTuEntity +
                '}';
    }
}
