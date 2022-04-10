package com.enetedu.hep.http.resp;


import android.util.Log;

import com.enetedu.hep.http.RespBase;
import com.enetedu.hep.http.entity.Course2DetailEntity;
import com.enetedu.hep.http.entity.Course2ModelEntity;
import com.enetedu.hep.http.entity.TeacherListEntity;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class RespCourse2Detail extends RespBase {
    private Course2DetailEntity course2DetailEntity = new Course2DetailEntity();
    ;
    private Course2ModelEntity course2ModelEntity;
    private ArrayList<TeacherListEntity> teacherListEntityArrayList;
    private static final String TAG = "RespCourse2Detail";


    @Override
    public void onResp(String result) {
        try {
            JSONObject jsonObject = new JSONObject(result);
            JSONObject resultData = jsonObject.getJSONObject("ResultData");
            int courseid = resultData.getInt("courseid");

            JSONObject course2model = resultData.getJSONObject("course2model");
            String name = course2model.optString("NAME");
            int days = course2model.optInt("DAYS");
            String course_category_disp = course2model.optString("course_category_disp");
            String money = course2model.optString("money");
            String primal_subject_name = course2model.optString("PRIMAL_SUBJECT_NAME");
            String head_img_url = course2model.optString("HEAD_IMG_URL");
            int studyState = course2model.optInt("studyState");
            String description = course2model.optString("DESCRIPTION");
            course2ModelEntity = new Course2ModelEntity();
            course2ModelEntity.setName(name);
            course2ModelEntity.setMoney(money);
            course2ModelEntity.setHead_img_url(head_img_url);
            course2ModelEntity.setCourse_category_disp(course_category_disp);
            course2ModelEntity.setPrimal_subject_name(primal_subject_name);
            course2ModelEntity.setDays(days);
            course2ModelEntity.setStudyState(studyState);
            course2ModelEntity.setDescription(description);


            JSONArray teacherlist = resultData.getJSONArray("teacherlist");
            teacherListEntityArrayList = new ArrayList<>();
            for (int i = 0; i < teacherlist.length(); i++) {
                TeacherListEntity teacherListEntity = new TeacherListEntity();
                JSONObject object = teacherlist.getJSONObject(i);
                int id = object.optInt("id");
                String teachername = object.optString("teachername");
                String imgpath = object.optString("imgpath");
                String teacherzhicheng = object.optString("teacherzhicheng");
                String teacherschool = object.optString("teacherschool");
                teacherListEntity.setId(id);
                teacherListEntity.setTeachername(teachername);
                teacherListEntity.setTeacherschool(teacherschool);
                teacherListEntity.setTeacherzhicheng(teacherzhicheng);
                teacherListEntity.setImgpath(imgpath);
                teacherListEntityArrayList.add(teacherListEntity);
            }


            course2DetailEntity.setCourse2ModelEntity(course2ModelEntity);
            course2DetailEntity.setTeacherListEntities(teacherListEntityArrayList);
            course2DetailEntity.setCourseid(courseid);
//            Log.d(TAG, "RespCourse2Detail: "+course2DetailEntity.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    @Override
    public Object getData() {
        Log.d(TAG, "RespCourse2Detail: " + course2DetailEntity.toString());
        return course2DetailEntity;
    }

    @Override
    public String toString() {
        return "RespCourse2Detail [info=" + course2DetailEntity.toString() + ", " + super.toString() + "]";
    }
}
