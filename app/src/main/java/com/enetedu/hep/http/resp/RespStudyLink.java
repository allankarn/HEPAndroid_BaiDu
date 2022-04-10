package com.enetedu.hep.http.resp;

import com.enetedu.hep.http.RespBase;
import com.enetedu.hep.http.entity.StudyLinkEntity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class RespStudyLink extends RespBase {

    private ArrayList<StudyLinkEntity> list = new ArrayList<>();
    private StudyLinkEntity studyLinkEntity;

    @Override
    public void onResp(String result) {
        JSONObject jo = converToJson(result);

        if (jo != null) {
            JSONObject resultData = getJSONObj(jo, "ResultData");

            String userObj = getJsonString(resultData, "StudyLinkList", "");

            if (userObj != null) {
                JSONArray jsonArray = getJsonArray(userObj);

                if (jsonArray != null && jsonArray.length() > 0) {
                    for (int i = 0; i < jsonArray.length(); i++) {
                        try {
                            JSONObject jsonObject = (JSONObject) jsonArray.get(i);

                            int id = jsonObject.optInt("ID");
                            String name = jsonObject.optString("Name");
                            int state = jsonObject.optInt("State");
                            int display = jsonObject.optInt("Display");
                            int order = jsonObject.optInt("Order");
                            int flag = jsonObject.optInt("Flag");
                            int credit1 = jsonObject.optInt("Credit1");
                            int credit2 = jsonObject.optInt("Credit2");
                            int creditDY = jsonObject.optInt("CreditDY");
                            int creditDYSY = jsonObject.optInt("CreditDYSY");

                            studyLinkEntity = new StudyLinkEntity(id, name, state, display, order, flag, credit1, credit2, creditDY, creditDYSY);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        list.add(studyLinkEntity);
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
        return "RespStudyLink{" +
                "list=" + list +
                ", studyLinkEntity=" + studyLinkEntity +
                '}';
    }
}
