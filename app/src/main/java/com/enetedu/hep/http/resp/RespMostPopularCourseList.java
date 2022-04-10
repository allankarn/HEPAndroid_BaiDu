package com.enetedu.hep.http.resp;


import com.enetedu.hep.http.RespBase;
import com.enetedu.hep.http.entity.HaoKeEntity;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

//好课推荐
public class RespMostPopularCourseList extends RespBase {
    private ArrayList<HaoKeEntity> list = new ArrayList<>();
    private HaoKeEntity haoKeEntity;

    @Override
    public void onResp(String result) {
        JSONObject jo = converToJson(result);

        if (jo != null) {
            JSONObject resultData = getJSONObj(jo, "ResultData");

            String userObj = getJsonString(resultData, "course2List", "");

            if (userObj != null) {
                JSONArray jsonArray = getJsonArray(userObj);

                if (jsonArray != null && jsonArray.length() > 0) {
                    for (int i = 0; i < jsonArray.length(); i++) {
                        try {
                            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                            int id = jsonObject.optInt("ID");
                            String name = jsonObject.optString("NAME");
                            int primal_subject_id = jsonObject.optInt("PRIMAL_SUBJECT_ID");
                            int sub_subject_id = jsonObject.optInt("SUB_SUBJECT_ID");
                            int payment = jsonObject.optInt("PAYMENT");
                            int days = jsonObject.optInt("DAYS");
                            String description = jsonObject.optString("DESCRIPTION");
                            int order_number = jsonObject.optInt("ORDER_NUMBER");
                            String is_recommended = jsonObject.optString("IS_RECOMMENDED");
                            int clicks = jsonObject.optInt("CLICKS");
                            String is_approvaled = jsonObject.optString("IS_APPROVALED");
                            String approval_time = jsonObject.optString("APPROVAL_TIME");
                            int admin_id = jsonObject.optInt("ADMIN_ID");
                            int enter_admin_id = jsonObject.optInt("ENTER_ADMIN_ID");
                            String enter_time = jsonObject.optString("ENTER_TIME");
                            String enroll_start_time = jsonObject.optString("ENROLL_START_TIME");
                            String enroll_end_time = jsonObject.optString("ENROLL_END_TIME");
                            int forum_id = jsonObject.optInt("FORUM_ID");
                            String head_img_url = jsonObject.optString("HEAD_IMG_URL");
                            int elective_count = jsonObject.optInt("ELECTIVE_COUNT");
                            String main_requery = jsonObject.optString("MAIN_REQUERY");
                            String select_requery = jsonObject.optString("SELECT_REQUERY");
                            String work_description = jsonObject.optString("WORK_DESCRIPTION");
                            String work_requery = jsonObject.optString("WORK_REQUERY");
                            String certificate_description = jsonObject.optString("CERTIFICATE_DESCRIPTION");
                            String certificate_requery = jsonObject.optString("CERTIFICATE_REQUERY");
                            String primal_subject_name = jsonObject.optString("PRIMAL_SUBJECT_NAME");
                            String sub_subject_name = jsonObject.optString("SUB_SUBJECT_NAME");
                            int adviser_id = jsonObject.optInt("ADVISER_ID");
                            String adviser_name = jsonObject.optString("ADVISER_NAME");
                            String sub_teacher = jsonObject.optString("SUB_TEACHER");
                            String sub_teacher_name = jsonObject.optString("SUB_TEACHER_NAME");
                            String is_free = jsonObject.optString("IS_FREE");
                            String teach_type = jsonObject.optString("TEACH_TYPE");
                            int rd_edit_id = jsonObject.optInt("RD_EDIT_ID");
                            String rd_edit_name = jsonObject.optString("RD_EDIT_NAME");
                            String required_length = jsonObject.optString("REQUIRED_LENGTH");
                            String course_category = jsonObject.optString("COURSE_CATEGORY");
                            int studyState = jsonObject.optInt("studyState");
                            int state = jsonObject.optInt("state");
                            String enrollmentCount = jsonObject.optString("enrollmentCount");
                            haoKeEntity = new HaoKeEntity(id, name, primal_subject_id, sub_subject_id, payment, days, description, order_number, is_recommended, clicks, is_approvaled, approval_time, admin_id, enter_admin_id,
                                    enter_time, enroll_start_time, enroll_end_time, forum_id, head_img_url, elective_count, main_requery, select_requery, work_description, work_requery, certificate_description
                                    , certificate_requery, primal_subject_name, sub_subject_name, adviser_id, adviser_name, sub_teacher, sub_teacher_name, is_free, teach_type, rd_edit_id, rd_edit_name, required_length
                                    , course_category, studyState, state, enrollmentCount);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        list.add(haoKeEntity);
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
        return "RespMostPopularCourseList{" +
                "list=" + list +
                ", haoKeEntity=" + haoKeEntity +
                '}';
    }
}
