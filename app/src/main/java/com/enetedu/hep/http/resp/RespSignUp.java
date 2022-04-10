package com.enetedu.hep.http.resp;

import com.enetedu.hep.http.RespBase;
import com.enetedu.hep.http.entity.CaddressListEntity;
import com.enetedu.hep.http.entity.TjList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class RespSignUp extends RespBase {
    private ArrayList<CaddressListEntity> list = new ArrayList<>();

    @Override
    public void onResp(String result) {
        JSONObject jo = converToJson(result);

        if (jo != null) {
            JSONObject resultData = getJSONObj(jo, "ResultData");

            String userObj = getJsonString(resultData, "caddressList", "");
            if (userObj != null) {
                JSONArray jsonArray = getJsonArray(userObj);

                if (jsonArray != null && jsonArray.length() > 0) {


                    for (int i = 0; i < jsonArray.length(); i++) {
                        CaddressListEntity caddressListEntity = new CaddressListEntity();
                        try {
                            JSONObject jsonObject = (JSONObject) jsonArray.get(i);

                            String centerid = jsonObject.optString("centerid");
                            int count = jsonObject.optInt("count");
                            int netpayCount = jsonObject.optInt("netpayCount");
                            String centermoney = jsonObject.optString("centermoney");
                            String address = jsonObject.optString("address");

                            JSONArray tjList = jsonObject.optJSONArray("tjList");


                            ArrayList<TjList> tjLists = new ArrayList<>();
                            if (tjList != null && tjList.length() > 0) {
                                for (int j = 0; j < tjList.length(); j++) {
                                    TjList tjList1 = new TjList();
                                    JSONObject jsonObject1 = (JSONObject) tjList.get(j);
                                    int id = jsonObject1.optInt("id");
                                    int courseid = jsonObject1.optInt("courseid");
                                    String courseday = jsonObject1.optString("courseday");
                                    String coursericheng = jsonObject1.optString("coursericheng");
                                    String coursexueyuan = jsonObject1.optString("coursexueyuan");
                                    int is_main = jsonObject1.optInt("is_main");
                                    int centerid1 = jsonObject1.optInt("centerid");
                                    tjList1.setId(id);
                                    tjList1.setCourseid(courseid);
                                    tjList1.setCourseday(courseday);
                                    tjList1.setCoursericheng(coursericheng);
                                    tjList1.setCoursexueyuan(coursexueyuan);
                                    tjList1.setIs_main(is_main);
                                    tjList1.setCenterid(centerid1);
                                    tjLists.add(tjList1);
                                }
                            }
                            caddressListEntity.setCenterid(centerid);
                            caddressListEntity.setCount(count);
                            caddressListEntity.setNetpayCount(netpayCount);
                            caddressListEntity.setCentermoney(centermoney);
                            caddressListEntity.setAddress(address);
                            caddressListEntity.setTjLists(tjLists);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        list.add(caddressListEntity);
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
        return "RespSignUp{" +
                "list=" + list +
                '}';
    }
}
