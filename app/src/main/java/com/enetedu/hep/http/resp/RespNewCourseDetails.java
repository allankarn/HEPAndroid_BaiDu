package com.enetedu.hep.http.resp;

import com.enetedu.hep.http.RespBase;
import com.enetedu.hep.http.entity.CourseModelList;
import com.enetedu.hep.http.entity.MainCenterList;
import com.enetedu.hep.http.entity.NewCourseDetailsEntity;
import com.enetedu.hep.http.entity.SubcList;
import com.enetedu.hep.http.entity.TeacherListEntity;
import com.enetedu.hep.http.entity.TjList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class RespNewCourseDetails extends RespBase {

    private NewCourseDetailsEntity newCourseDetailsEntity = new NewCourseDetailsEntity();
    private CourseModelList courseModelList;
    private ArrayList<TjList> tjLists;
    private MainCenterList mainCenterList;
    private ArrayList<SubcList> subcLists;
    private ArrayList<TeacherListEntity> teacherListEntityArrayList;

    @Override
    public void onResp(String result) {
        try {
            JSONObject jsonObject = new JSONObject(result);
            JSONObject resultData = jsonObject.getJSONObject("ResultData");


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

            JSONObject coursemodel = resultData.getJSONObject("coursemodel");
            int id = coursemodel.optInt("id");
            String coursename = coursemodel.optString("coursename");
            String classname = coursemodel.optString("classname");
            String boardname = coursemodel.optString("boardname");
            String coursetime = coursemodel.optString("coursetime");
            int courseday = coursemodel.optInt("courseday");
            int courseseladd = coursemodel.optInt("courseseladd");
            String courseaddress = coursemodel.optString("courseaddress");
            String courseteacher = coursemodel.optString("courseteacher");
            String coursemoney = coursemodel.optString("coursemoney");
            String begin_t = coursemodel.optString("begin_t");
            String end_t = coursemodel.optString("end_t");
            String courseinfo = coursemodel.optString("courseinfo");
            String coursearran_one_am = coursemodel.optString("coursearran_one_am");
            String coursearran_one_pm = coursemodel.optString("coursearran_one_pm");
            String coursearran_two_am = coursemodel.optString("coursearran_two_am");
            String coursearran_two_pm = coursemodel.optString("coursearran_two_pm");
            String courseact_one_am = coursemodel.optString("courseact_one_am");
            String courseact_one_pm = coursemodel.optString("courseact_one_pm");
            String courseact_two_am = coursemodel.optString("courseact_two_am");
            String courseact_two_pm = coursemodel.optString("courseact_two_pm");
            String tz_teacher = coursemodel.optString("tz_teacher");
            String tz_ren = coursemodel.optString("tz_ren");
            String tz_tel = coursemodel.optString("tz_tel");
            String tz_mob = coursemodel.optString("tz_mob");
            String tz_fax = coursemodel.optString("tz_fax");
            String tz_email = coursemodel.optString("tz_email");
            String wordpath = coursemodel.optString("wordpath");
            String writer = coursemodel.optString("writer");
            String ifgood = coursemodel.optString("ifgood");
            int hits = coursemodel.optInt("hits");
            int voteid = coursemodel.optInt("voteid");
            int voteendid = coursemodel.optInt("voteendid");
            String ifshow = coursemodel.optString("ifshow");
            String ifxc = coursemodel.optString("ifxc");
            String ifcw = coursemodel.optString("ifcw");
            String addtime = coursemodel.optString("addtime");
            int banzhurenid = coursemodel.optInt("banzhurenid");
            String banzhuren = coursemodel.optString("banzhuren");
            String coursetype = coursemodel.optString("coursetype");
            int meeting_gbt = coursemodel.optInt("meeting_gbt");
            int classid = coursemodel.optInt("classid");
            int extend_course = coursemodel.optInt("extend_course");
            int boardid = coursemodel.optInt("boardid");
            int froum_id = coursemodel.optInt("froum_id");
            String hddy = coursemodel.optString("hddy");
            String event_ids = coursemodel.optString("event_ids");
            String kzxx = coursemodel.optString("kzxx");
            String live_type = coursemodel.optString("LIVE_TYPE");
            String client = coursemodel.optString("Client");
            String browser = coursemodel.optString("Browser");
            String plannerPwd = coursemodel.optString("PlannerPwd");
            String joinPwd = coursemodel.optString("JoinPwd");
            String guestPwd = coursemodel.optString("guestPwd");
            String live_back = coursemodel.optString("LIVE_BACK");
            String imgpath = coursemodel.optString("imgpath");
            String caiwuhao = coursemodel.optString("caiwuhao");
            String uzhusu = coursemodel.optString("uzhusu");
            String paper_title = coursemodel.optString("paper_title");
            String main_meeting_place = coursemodel.optString("main_meeting_place");
            String fen_course_money = coursemodel.optString("fen_course_money");
            String courseaim_one_am_time = coursemodel.optString("courseaim_one_am_time");
            String courseaim_one_pm_time = coursemodel.optString("courseaim_one_pm_time");
            String courseaim_two_am_time = coursemodel.optString("courseaim_two_am_time");
            String courseaim_two_pm_time = coursemodel.optString("courseaim_two_pm_time");
            String traing_notice = coursemodel.optString("traing_notice");
            String teach_type = coursemodel.optString("teach_type");
            String course_category = coursemodel.optString("course_category");
            String course_category_disp = coursemodel.optString("course_category_disp");
            String submitbut = coursemodel.optString("submitbut");
            String noticebut = coursemodel.optString("noticebut");
            courseModelList = new CourseModelList(id, coursename, classname, boardname, coursetime, courseday, courseseladd, courseaddress, courseteacher, coursemoney, begin_t, end_t, courseinfo, coursearran_one_am, coursearran_one_pm, coursearran_two_am, coursearran_two_pm, courseact_one_am, courseact_one_pm, courseact_two_am, courseact_two_pm, tz_teacher, tz_ren, tz_tel, tz_mob, tz_fax, tz_email, wordpath, writer, ifgood, hits, voteid, voteendid, ifshow, ifxc, ifcw, addtime, banzhurenid, banzhuren, coursetype, meeting_gbt, classid, extend_course, boardid, froum_id, hddy, event_ids, kzxx, live_type, client, browser, plannerPwd, joinPwd, guestPwd, live_back, imgpath, caiwuhao, uzhusu, paper_title, main_meeting_place, fen_course_money, courseaim_one_am_time, courseaim_one_pm_time, courseaim_two_am_time, courseaim_two_pm_time, traing_notice, teach_type, course_category, course_category_disp, submitbut, noticebut);


            JSONObject maincenter = resultData.getJSONObject("maincenter");
            int id1 = maincenter.optInt("ID");
            String centerType = maincenter.optString("centerType");
            String name = maincenter.optString("Name");
            String money = maincenter.optString("money");
            JSONArray tjList = maincenter.getJSONArray("tjList");
            tjLists = new ArrayList<>();
            for (int i = 0; i < tjList.length(); i++) {
                JSONObject jsonObject1 = tjList.getJSONObject(i);
                int id2 = jsonObject1.optInt("id");
                int courseid = jsonObject1.optInt("courseid");
                String courseday1 = jsonObject1.optString("courseday");
                String coursericheng = jsonObject1.optString("coursericheng");
                String coursexueyuan = jsonObject1.optString("coursexueyuan");
                int is_main = jsonObject1.optInt("is_main");
                int centerid = jsonObject1.optInt("centerid");
                TjList tjList1 = new TjList(id2, courseid, courseday1, coursericheng, coursexueyuan, is_main, centerid);
                tjLists.add(tjList1);
            }
            mainCenterList = new MainCenterList(id1, centerType, name, money, tjLists);


            JSONArray subcList = resultData.getJSONArray("subcList");
            subcLists = new ArrayList<>();
            for (int i = 0; i < subcList.length(); i++) {
                JSONObject jsonObject1 = subcList.getJSONObject(i);
                int id2 = jsonObject1.optInt("ID");
                String centerType1 = jsonObject1.optString("centerType");
                String name1 = jsonObject1.optString("Name");
                String money1 = jsonObject1.optString("money");
                JSONArray tjList1 = jsonObject1.getJSONArray("tjList");
                for (int j = 0; j < tjList1.length(); j++) {
                    JSONObject jsonObject2 = tjList.getJSONObject(j);
                    int id3 = jsonObject2.optInt("id");
                    int courseid = jsonObject2.optInt("courseid");
                    String courseday1 = jsonObject2.optString("courseday");
                    String coursericheng = jsonObject2.optString("coursericheng");
                    String coursexueyuan = jsonObject2.optString("coursexueyuan");
                    int is_main = jsonObject2.optInt("is_main");
                    int centerid = jsonObject2.optInt("centerid");
                    TjList tjList2 = new TjList(id3, courseid, courseday1, coursericheng, coursexueyuan, is_main, centerid);
                    tjLists.add(tjList2);
                }
                SubcList subcList1 = new SubcList(id2, centerType1, name1, money1, tjLists);
                subcLists.add(subcList1);
            }

            newCourseDetailsEntity.setTeacherListEntities(teacherListEntityArrayList);
            newCourseDetailsEntity.setCourseModelList(courseModelList);
            newCourseDetailsEntity.setMainCenterList(mainCenterList);
            newCourseDetailsEntity.setSubcLists(subcLists);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object getData() {
        return newCourseDetailsEntity;
    }

    @Override
    public String toString() {
        return "RespNewCourseDetails{" +
                "newCourseDetailsEntity=" + newCourseDetailsEntity +
                ", courseModelList=" + courseModelList +
                ", tjLists=" + tjLists +
                ", mainCenterList=" + mainCenterList +
                ", subcLists=" + subcLists +
                '}';
    }
}
