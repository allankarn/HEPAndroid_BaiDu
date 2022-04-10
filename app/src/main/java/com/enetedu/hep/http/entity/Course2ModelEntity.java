package com.enetedu.hep.http.entity;

import com.enetedu.hep.base.BaseEntityImpl;
import com.enetedu.hep.http.HEPMSProxy;
import com.enetedu.hep.http.IHEPMSProxy;
import com.enetedu.hep.http.RespBase;
import com.enetedu.hep.http.req.ReqPublicClass;

public class Course2ModelEntity extends BaseEntityImpl {
    private int id;
    private String name;
    private int primal_subject_id;
    private int payment;
    private int days;
    private String description;
    private int order_number;
    private String is_recommended;
    private int clicks;
    private String is_approvaled;
    private String approval_time;
    private int admin_id;
    private int enter_admin_id;
    private String enter_time;
    private String enroll_start_time;
    private String enroll_end_time;
    private int forum_id;
    private String head_img_url;
    private int elective_count;
    private String main_requery;
    private String select_requery;
    private String book_review;
    private String bbs_description;
    private String active_description;
    private String work_description;
    private String work_requery;
    private String certificate_description;
    private String certificate_requery;
    private String team_teacher;
    private String primal_subject_name;
    private String sub_subject_name;
    private int adviser_id;
    private String adviser_name;
    private String event_ids;
    private String sub_teacher;
    private String sub_teacher_name;
    private String special_teacher;
    private String special_teacher_name;
    private String group_teacher;
    private String group_teacher_name;
    private String is_free;
    private String teach_type;
    private String sort;
    private int rd_edit_id;
    private String rd_edit_name;
    private String required_length;
    private String course_category;
    private String money;
    private String course_category_disp;
    private int studyState;
    private int state;
    private String enrollmentCount;
    private String courseWareCount;


    public Course2ModelEntity() {
    }


    public String getEnrollmentCount() {
        return enrollmentCount;
    }

    public void setEnrollmentCount(String enrollmentCount) {
        this.enrollmentCount = enrollmentCount;
    }

    public String getCourseWareCount() {
        return courseWareCount;
    }

    public void setCourseWareCount(String courseWareCount) {
        this.courseWareCount = courseWareCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrimal_subject_id() {
        return primal_subject_id;
    }

    public void setPrimal_subject_id(int primal_subject_id) {
        this.primal_subject_id = primal_subject_id;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getOrder_number() {
        return order_number;
    }

    public void setOrder_number(int order_number) {
        this.order_number = order_number;
    }

    public String getIs_recommended() {
        return is_recommended;
    }

    public void setIs_recommended(String is_recommended) {
        this.is_recommended = is_recommended;
    }

    public int getClicks() {
        return clicks;
    }

    public void setClicks(int clicks) {
        this.clicks = clicks;
    }

    public String getIs_approvaled() {
        return is_approvaled;
    }

    public void setIs_approvaled(String is_approvaled) {
        this.is_approvaled = is_approvaled;
    }

    public String getApproval_time() {
        return approval_time;
    }

    public void setApproval_time(String approval_time) {
        this.approval_time = approval_time;
    }

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public int getEnter_admin_id() {
        return enter_admin_id;
    }

    public void setEnter_admin_id(int enter_admin_id) {
        this.enter_admin_id = enter_admin_id;
    }

    public String getEnter_time() {
        return enter_time;
    }

    public void setEnter_time(String enter_time) {
        this.enter_time = enter_time;
    }

    public String getEnroll_start_time() {
        return enroll_start_time;
    }

    public void setEnroll_start_time(String enroll_start_time) {
        this.enroll_start_time = enroll_start_time;
    }

    public String getEnroll_end_time() {
        return enroll_end_time;
    }

    public void setEnroll_end_time(String enroll_end_time) {
        this.enroll_end_time = enroll_end_time;
    }

    public int getForum_id() {
        return forum_id;
    }

    public void setForum_id(int forum_id) {
        this.forum_id = forum_id;
    }

    public String getHead_img_url() {
        return head_img_url;
    }

    public void setHead_img_url(String head_img_url) {
        this.head_img_url = head_img_url;
    }

    public int getElective_count() {
        return elective_count;
    }

    public void setElective_count(int elective_count) {
        this.elective_count = elective_count;
    }

    public String getMain_requery() {
        return main_requery;
    }

    public void setMain_requery(String main_requery) {
        this.main_requery = main_requery;
    }

    public String getSelect_requery() {
        return select_requery;
    }

    public void setSelect_requery(String select_requery) {
        this.select_requery = select_requery;
    }

    public String getBook_review() {
        return book_review;
    }

    public void setBook_review(String book_review) {
        this.book_review = book_review;
    }

    public String getBbs_description() {
        return bbs_description;
    }

    public void setBbs_description(String bbs_description) {
        this.bbs_description = bbs_description;
    }

    public String getActive_description() {
        return active_description;
    }

    public void setActive_description(String active_description) {
        this.active_description = active_description;
    }

    public String getWork_description() {
        return work_description;
    }

    public void setWork_description(String work_description) {
        this.work_description = work_description;
    }

    public String getWork_requery() {
        return work_requery;
    }

    public void setWork_requery(String work_requery) {
        this.work_requery = work_requery;
    }

    public String getCertificate_description() {
        return certificate_description;
    }

    public void setCertificate_description(String certificate_description) {
        this.certificate_description = certificate_description;
    }

    public String getCertificate_requery() {
        return certificate_requery;
    }

    public void setCertificate_requery(String certificate_requery) {
        this.certificate_requery = certificate_requery;
    }

    public String getTeam_teacher() {
        return team_teacher;
    }

    public void setTeam_teacher(String team_teacher) {
        this.team_teacher = team_teacher;
    }

    public String getPrimal_subject_name() {
        return primal_subject_name;
    }

    public void setPrimal_subject_name(String primal_subject_name) {
        this.primal_subject_name = primal_subject_name;
    }

    public String getSub_subject_name() {
        return sub_subject_name;
    }

    public void setSub_subject_name(String sub_subject_name) {
        this.sub_subject_name = sub_subject_name;
    }

    public int getAdviser_id() {
        return adviser_id;
    }

    public void setAdviser_id(int adviser_id) {
        this.adviser_id = adviser_id;
    }

    public String getAdviser_name() {
        return adviser_name;
    }

    public void setAdviser_name(String adviser_name) {
        this.adviser_name = adviser_name;
    }

    public String getEvent_ids() {
        return event_ids;
    }

    public void setEvent_ids(String event_ids) {
        this.event_ids = event_ids;
    }

    public String getSub_teacher() {
        return sub_teacher;
    }

    public void setSub_teacher(String sub_teacher) {
        this.sub_teacher = sub_teacher;
    }

    public String getSub_teacher_name() {
        return sub_teacher_name;
    }

    public void setSub_teacher_name(String sub_teacher_name) {
        this.sub_teacher_name = sub_teacher_name;
    }

    public String getSpecial_teacher() {
        return special_teacher;
    }

    public void setSpecial_teacher(String special_teacher) {
        this.special_teacher = special_teacher;
    }

    public String getSpecial_teacher_name() {
        return special_teacher_name;
    }

    public void setSpecial_teacher_name(String special_teacher_name) {
        this.special_teacher_name = special_teacher_name;
    }

    public String getGroup_teacher() {
        return group_teacher;
    }

    public void setGroup_teacher(String group_teacher) {
        this.group_teacher = group_teacher;
    }

    public String getGroup_teacher_name() {
        return group_teacher_name;
    }

    public void setGroup_teacher_name(String group_teacher_name) {
        this.group_teacher_name = group_teacher_name;
    }

    public String getIs_free() {
        return is_free;
    }

    public void setIs_free(String is_free) {
        this.is_free = is_free;
    }

    public String getTeach_type() {
        return teach_type;
    }

    public void setTeach_type(String teach_type) {
        this.teach_type = teach_type;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public int getRd_edit_id() {
        return rd_edit_id;
    }

    public void setRd_edit_id(int rd_edit_id) {
        this.rd_edit_id = rd_edit_id;
    }

    public String getRd_edit_name() {
        return rd_edit_name;
    }

    public void setRd_edit_name(String rd_edit_name) {
        this.rd_edit_name = rd_edit_name;
    }

    public String getRequired_length() {
        return required_length;
    }

    public void setRequired_length(String required_length) {
        this.required_length = required_length;
    }

    public String getCourse_category() {
        return course_category;
    }

    public void setCourse_category(String course_category) {
        this.course_category = course_category;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getCourse_category_disp() {
        return course_category_disp;
    }

    public void setCourse_category_disp(String course_category_disp) {
        this.course_category_disp = course_category_disp;
    }

    public int getStudyState() {
        return studyState;
    }

    public void setStudyState(int studyState) {
        this.studyState = studyState;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Course2ModelEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", primal_subject_id=" + primal_subject_id +
                ", payment=" + payment +
                ", days=" + days +
                ", description='" + description + '\'' +
                ", order_number=" + order_number +
                ", is_recommended='" + is_recommended + '\'' +
                ", clicks=" + clicks +
                ", is_approvaled='" + is_approvaled + '\'' +
                ", approval_time='" + approval_time + '\'' +
                ", admin_id=" + admin_id +
                ", enter_admin_id=" + enter_admin_id +
                ", enter_time='" + enter_time + '\'' +
                ", enroll_start_time='" + enroll_start_time + '\'' +
                ", enroll_end_time='" + enroll_end_time + '\'' +
                ", forum_id=" + forum_id +
                ", head_img_url='" + head_img_url + '\'' +
                ", elective_count=" + elective_count +
                ", main_requery='" + main_requery + '\'' +
                ", select_requery='" + select_requery + '\'' +
                ", book_review='" + book_review + '\'' +
                ", bbs_description='" + bbs_description + '\'' +
                ", active_description='" + active_description + '\'' +
                ", work_description='" + work_description + '\'' +
                ", work_requery='" + work_requery + '\'' +
                ", certificate_description='" + certificate_description + '\'' +
                ", certificate_requery='" + certificate_requery + '\'' +
                ", team_teacher='" + team_teacher + '\'' +
                ", primal_subject_name='" + primal_subject_name + '\'' +
                ", sub_subject_name='" + sub_subject_name + '\'' +
                ", adviser_id=" + adviser_id +
                ", adviser_name='" + adviser_name + '\'' +
                ", event_ids='" + event_ids + '\'' +
                ", sub_teacher='" + sub_teacher + '\'' +
                ", sub_teacher_name='" + sub_teacher_name + '\'' +
                ", special_teacher='" + special_teacher + '\'' +
                ", special_teacher_name='" + special_teacher_name + '\'' +
                ", group_teacher='" + group_teacher + '\'' +
                ", group_teacher_name='" + group_teacher_name + '\'' +
                ", is_free='" + is_free + '\'' +
                ", teach_type='" + teach_type + '\'' +
                ", sort='" + sort + '\'' +
                ", rd_edit_id=" + rd_edit_id +
                ", rd_edit_name='" + rd_edit_name + '\'' +
                ", required_length='" + required_length + '\'' +
                ", course_category='" + course_category + '\'' +
                ", money='" + money + '\'' +
                ", course_category_disp='" + course_category_disp + '\'' +
                ", studyState=" + studyState +
                ", state=" + state +
                '}';
    }

    ReqPublicClass reqPublicClass;
    public void getPublicClass(final OnBaseResp onBaseResp) {
        if (reqPublicClass == null) reqPublicClass = new ReqPublicClass();


        HEPMSProxy.GetPublicClass(reqPublicClass, new IHEPMSProxy.OnResp() {
            @Override
            public void onResp(RespBase response) {
                resp(onBaseResp, response);
            }
        });
    }
}
