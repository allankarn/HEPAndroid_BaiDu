package com.enetedu.hep.http.resp;

import com.enetedu.hep.http.RespBase;
import com.enetedu.hep.http.entity.HomeWorkEditEntity;

import org.json.JSONException;
import org.json.JSONObject;

public class RespHomeWorkEdit4 extends RespBase {


    private HomeWorkEditEntity homeWorkEditEntity;

    @Override
    public void onResp(String result) {
        try {
            JSONObject jsonObject = new JSONObject(result);
            JSONObject resultData = jsonObject.getJSONObject("ResultData");

            JSONObject homework = resultData.getJSONObject("homework");
            int id = homework.optInt("ID");
            String homework_title = homework.optString("HOMEWORK_TITLE");
            String homework_content = homework.optString("HOMEWORK_CONTENT");
            String is_evaluated = homework.optString("IS_EVALUATED");
            String create_time = homework.optString("CREATE_TIME");
            int student_id = homework.optInt("STUDENT_ID");
            int course_id = homework.optInt("COURSE_ID");
            String student_email = homework.optString("STUDENT_EMAIL");
            String student_name = homework.optString("STUDENT_NAME");
            String course_name = homework.optString("COURSE_NAME");
            int topic_count = homework.optInt("TOPIC_COUNT");
            String school_edu = homework.optString("SCHOOL_EDU");
            int primal_subject_id = homework.optInt("PRIMAL_SUBJECT_ID");
            int sub_subject_id = homework.optInt("SUB_SUBJECT_ID");
            String primal_subject_name = homework.optString("PRIMAL_SUBJECT_NAME");
            String sub_subject_name = homework.optString("SUB_SUBJECT_NAME");
            String title = homework.optString("title");
            homeWorkEditEntity = new HomeWorkEditEntity(id, homework_title, homework_content, is_evaluated, create_time, student_id, course_id, student_email, student_name, course_name,
                    topic_count, school_edu, primal_subject_id, sub_subject_id, primal_subject_name, sub_subject_name, title);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object getData() {
        return homeWorkEditEntity;
    }

    @Override
    public String toString() {
        return "RespHomeWorkEdit4{" +
                "homeWorkEditEntity=" + homeWorkEditEntity +
                '}';
    }
}
