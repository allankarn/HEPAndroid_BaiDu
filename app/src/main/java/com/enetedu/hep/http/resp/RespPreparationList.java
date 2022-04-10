package com.enetedu.hep.http.resp;

import com.enetedu.hep.http.RespBase;
import com.enetedu.hep.http.entity.CourseList;
import com.enetedu.hep.http.entity.CourseViewListEntity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class RespPreparationList extends RespBase {
    private ArrayList<CourseViewListEntity> list = new ArrayList<>();
    private ArrayList<CourseList> courseLists = new ArrayList<>();
    private CourseViewListEntity courseViewListEntity;

    @Override
    public void onResp(String result) {
        JSONObject jo = converToJson(result);

        if (jo != null) {
            JSONObject resultData = getJSONObj(jo, "ResultData");

            String userObj = getJsonString(resultData, "courseViewList", "");

            if (userObj != null) {
                JSONArray jsonArray = getJsonArray(userObj);

                if (jsonArray != null && jsonArray.length() > 0) {
                    for (int i = 0; i < jsonArray.length(); i++) {
                        try {
                            JSONObject jsonObject = (JSONObject) jsonArray.get(i);

                            int id = jsonObject.optInt("ID");
                            String name = jsonObject.optString("Name");
                            String courseType = jsonObject.optString("CourseType");
                            String courseStatus = jsonObject.optString("CourseStatus");
                            String startTime = jsonObject.optString("StartTime");
                            String endTime = jsonObject.optString("EndTime");
                            String createTime = jsonObject.optString("CreateTime");
                            String finishTime = jsonObject.optString("FinishTime");
                            String is_payoffed = jsonObject.optString("is_payoffed");
                            String courseTeach = jsonObject.optString("CourseTeach");
                            String paySel = jsonObject.optString("PaySel");
                            int courehour = jsonObject.optInt("courehour");
                            int is_new = jsonObject.optInt("is_new");
                            int is_postpone = jsonObject.optInt("is_postpone");

                            JSONArray courseList = jsonObject.getJSONArray("CourseList");
                            if (courseList != null && courseList.length() > 0) {
                                for (int j = 0; j < courseList.length(); j++) {
                                    JSONObject o = (JSONObject) courseList.get(j);
                                    int id1 = o.optInt("ID");
                                    String courseName = o.optString("CourseName");
                                    String info = o.optString("Info");
                                    String courseType1 = o.optString("CourseType");
                                    String courseTime = o.optString("CourseTime");
                                    CourseList courseList1 = new CourseList();
                                    courseList1.setID(id1);
                                    courseList1.setCourseName(courseName);
                                    courseList1.setInfo(info);
                                    courseList1.setCourseType(courseType1);
                                    courseList1.setCourseTime(courseTime);
                                    courseLists.add(courseList1);
                                }
                            }

                            courseViewListEntity = new CourseViewListEntity(id, name, courseType, courseStatus, startTime, endTime, createTime, finishTime,
                                    is_payoffed, courseTeach, paySel, courehour, is_new, is_postpone, courseLists);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        list.add(courseViewListEntity);
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
        return "RespPreparationList{" +
                "list=" + list +
                ", courseLists=" + courseLists +
                ", courseViewListEntity=" + courseViewListEntity +
                '}';
    }
}
