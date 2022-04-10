package com.enetedu.hep.http.resp;

import com.enetedu.hep.http.RespBase;
import com.enetedu.hep.http.entity.HomeWorkEdit3Entity;
import com.enetedu.hep.http.entity.PapermodelEntity;

import org.json.JSONException;
import org.json.JSONObject;

public class RespHomeWorkEdit3 extends RespBase {

    private HomeWorkEdit3Entity homeWorkEdit3Entity;

    @Override
    public void onResp(String result) {
        try {
            JSONObject jsonObject = new JSONObject(result);
            JSONObject resultData = jsonObject.optJSONObject("ResultData");

            if (resultData!=null){
                JSONObject coursemodel = resultData.optJSONObject("coursemodel");
                int id = coursemodel.optInt("ID");
                String traing_notice = coursemodel.optString("traing_notice");


                JSONObject papermodel = resultData.optJSONObject("papermodel");
                int id1 = papermodel.optInt("id");
                String title = papermodel.optString("Title");
                String content = papermodel.optString("content");
                String addtime = papermodel.optString("Addtime");
                String username = papermodel.optString("username");
                String paper_ifshow = papermodel.optString("Paper_ifshow");
                int hits = papermodel.optInt("hits");
                int centerid = papermodel.optInt("centerid");
                int courseid = papermodel.optInt("courseid");
                int userid = papermodel.optInt("userid");
                String usermyname = papermodel.optString("Usermyname");
                String coursetime = papermodel.optString("coursetime");

                PapermodelEntity papermodelEntity = new PapermodelEntity(id1, title, content, addtime, username, paper_ifshow, hits, centerid, courseid, userid, usermyname, coursetime);


                homeWorkEdit3Entity = new HomeWorkEdit3Entity(id, traing_notice, papermodelEntity);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Object getData() {
        return homeWorkEdit3Entity;
    }

    @Override
    public String toString() {
        return "RespHomeWorkEdit3{" +
                "homeWorkEdit3Entity=" + homeWorkEdit3Entity +
                '}';
    }
}
