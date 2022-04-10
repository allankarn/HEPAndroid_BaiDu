package com.enetedu.hep.http.resp;

import com.enetedu.hep.http.RespBase;
import com.enetedu.hep.http.entity.Course2ViewListEntity;
import com.enetedu.hep.http.entity.CourseList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class RespUnfinishedList extends RespBase {

    private ArrayList<Course2ViewListEntity> list = new ArrayList<>();
   // private Course2ViewListEntity course2ViewListEntity;

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
                            String is_video_finished = jsonObject.optString("is_video_finished");
                            String credit_remain_event = jsonObject.optString("credit_remain_event");
                            String is_work_finished = jsonObject.optString("is_work_finished");
                            String statusName = jsonObject.optString("StatusName");
                            int courehour = jsonObject.optInt("courehour");
                            int is_new = jsonObject.optInt("is_new");
                            int is_postpone = jsonObject.optInt("is_postpone");
                            String operate = jsonObject.optString("operate");

                            JSONArray courseList = jsonObject.getJSONArray("CourseList");
                            ArrayList<CourseList> courseLists = new ArrayList<>();
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
                            Course2ViewListEntity course2ViewListEntity = new Course2ViewListEntity(id, name, courseType, courseStatus, startTime, endTime, createTime, finishTime,
                                    is_payoffed, is_video_finished, credit_remain_event, is_work_finished, statusName, courehour, is_new, is_postpone, operate, courseLists);
                            list.add(course2ViewListEntity);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

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
        return "RespUnfinishedList{" +
                "list=" + list +
                '}';
    }
}
