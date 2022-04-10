package com.enetedu.hep.http.resp;

import com.enetedu.hep.http.RespBase;
import com.enetedu.hep.http.entity.InfoListEntity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class RespInfoList extends RespBase {
    private ArrayList<InfoListEntity> list = new ArrayList<>();
    private InfoListEntity infoListEntity;

    @Override
    public void onResp(String result) {
        JSONObject jo = converToJson(result);

        if (jo != null) {
            JSONObject resultData = getJSONObj(jo, "ResultData");

            String userObj = getJsonString(resultData, "notice", "");

            if (userObj != null) {
                JSONArray jsonArray = getJsonArray(userObj);

                if (jsonArray != null && jsonArray.length() > 0) {
                    for (int i = 0; i < jsonArray.length(); i++) {
                        try {
                            JSONObject jsonObject = (JSONObject) jsonArray.get(i);

                            int id = jsonObject.optInt("ID");
                            String title = jsonObject.optString("TITLE");
                            int notice_type = jsonObject.optInt("NOTICE_TYPE");
                            String prog_set = jsonObject.optString("PROG_SET");
                            String content = jsonObject.optString("CONTENT");
                            int order_number = jsonObject.optInt("ORDER_NUMBER");
                            String is_approvaled = jsonObject.optString("IS_APPROVALED");
                            int clicks = jsonObject.optInt("CLICKS");
                            String input_time = jsonObject.optString("INPUT_TIME");
                            int input_user_id = jsonObject.optInt("INPUT_USER_ID");
                            String update_time = jsonObject.optString("UPDATE_TIME");
                            int update_user_id = jsonObject.optInt("UPDATE_USER_ID");
                            String is_good = jsonObject.optString("IS_GOOD");
                            String update_user_name = jsonObject.optString("UPDATE_USER_NAME");
                            String if_focus = jsonObject.optString("if_focus");
                            int message_num = jsonObject.optInt("MESSAGE_NUM");
                            infoListEntity = new InfoListEntity(id, title, notice_type, prog_set, content, order_number, is_approvaled, clicks, input_time, input_user_id, update_time, update_user_id, is_good, update_user_name, if_focus, message_num);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        list.add(infoListEntity);
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
        return "RespInfoList{" +
                "list=" + list +
                ", infoListEntity=" + infoListEntity +
                '}';
    }
}
