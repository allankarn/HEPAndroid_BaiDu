package com.enetedu.hep.http.resp;

import com.enetedu.hep.http.RespBase;
import com.enetedu.hep.http.entity.Course2ViewListEntity;
import com.enetedu.hep.http.entity.CourseList;
import com.enetedu.hep.http.entity.StudyMyCourseEntity;
import com.enetedu.hep.http.entity.ViewenrollDetailsList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class RespStudyMyCourse extends RespBase {
    private ArrayList<StudyMyCourseEntity> list = new ArrayList<>();
    private StudyMyCourseEntity studyMyCourseEntity;

    @Override
    public void onResp(String result) {
        JSONObject jo = converToJson(result);

        if (jo != null) {
            JSONObject resultData = getJSONObj(jo, "ResultData");

            String userObj = getJsonString(resultData, "ViewEnrollList", "");

            if (userObj != null) {
                JSONArray jsonArray = getJsonArray(userObj);

                if (jsonArray != null && jsonArray.length() > 0) {
                    for (int i = 0; i < jsonArray.length(); i++) {
                        try {
                            JSONObject jsonObject = (JSONObject) jsonArray.get(i);

                            int id = jsonObject.optInt("id");
                            String name = jsonObject.optString("name");
                            int courseType = jsonObject.optInt("courseType");
                            int enroid = jsonObject.optInt("enroid");
                            String is_payoffed = jsonObject.optString("is_payoffed");

                            JSONArray viewenrolldetails = jsonObject.getJSONArray("viewenrolldetails");


                            ArrayList<ViewenrollDetailsList> viewenrollDetailsLists = new ArrayList<>();
                            if (viewenrolldetails != null && viewenrolldetails.length() > 0) {
                                for (int j = 0; j < viewenrolldetails.length(); j++) {
                                    JSONObject o = (JSONObject) viewenrolldetails.get(j);
                                    int id1 = o.optInt("id");
                                    String name1 = o.optString("name");
                                    String is_finished = o.optString("is_finished");
                                    String start_time = o.optString("start_time");
                                    String cmsidurl = o.optString("cmsidurl");

                                    ViewenrollDetailsList viewenrollDetailsList = new ViewenrollDetailsList();
                                    viewenrollDetailsList.setId(id1);
                                    viewenrollDetailsList.setName(name1);
                                    viewenrollDetailsList.setIs_finished(is_finished);
                                    viewenrollDetailsList.setStart_time(start_time);
                                    viewenrollDetailsList.setCmsidurl(cmsidurl);

                                    viewenrollDetailsLists.add(viewenrollDetailsList);
                                }
                            }
                            studyMyCourseEntity = new StudyMyCourseEntity(id, name, courseType, enroid, is_payoffed, viewenrollDetailsLists);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        list.add(studyMyCourseEntity);
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
        return "RespStudyMyCourse{" +
                "list=" + list +
                ", studyMyCourseEntity=" + studyMyCourseEntity +
                '}';
    }
}
