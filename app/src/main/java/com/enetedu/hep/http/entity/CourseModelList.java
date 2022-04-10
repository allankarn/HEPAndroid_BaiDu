package com.enetedu.hep.http.entity;

import com.enetedu.hep.base.BaseEntityImpl;

public class CourseModelList extends BaseEntityImpl {
    private int id;
    private String coursename;
    private String classname;
    private String boardname;
    private String coursetime;
    private int courseday;
    private int courseseladd;
    private String courseaddress;
    private String courseteacher;
    private String coursemoney;
    private String begin_t;
    private String end_t;
    private String courseinfo;
    private String coursearran_one_am;
    private String coursearran_one_pm;
    private String coursearran_two_am;
    private String coursearran_two_pm;
    private String courseact_one_am;
    private String courseact_one_pm;
    private String courseact_two_am;
    private String courseact_two_pm;
    private String tz_teacher;
    private String tz_ren;
    private String tz_tel;
    private String tz_mob;
    private String tz_fax;
    private String tz_email;
    private String wordpath;
    private String writer;
    private String ifgood;
    private int hits;
    private int voteid;
    private int voteendid;
    private String ifshow;
    private String ifxc;
    private String ifcw;
    private String addtime;
    private int banzhurenid;
    private String banzhuren;
    private String coursetype;
    private int meeting_gbt;
    private int classid;
    private int extend_course;
    private int boardid;
    private int froum_id;
    private String hddy;
    private String event_ids;
    private String kzxx;
    private String LIVE_TYPE;
    private String Client;
    private String Browser;
    private String PlannerPwd;
    private String JoinPwd;
    private String guestPwd;
    private String LIVE_BACK;
    private String imgpath;
    private String caiwuhao;
    private String uzhusu;
    private String paper_title;
    private String main_meeting_place;
    private String fen_course_money;
    private String courseaim_one_am_time;
    private String courseaim_one_pm_time;
    private String courseaim_two_am_time;
    private String courseaim_two_pm_time;
    private String traing_notice;
    private String teach_type;
    private String course_category;
    private String course_category_disp;
    private String submitbut;
    private String noticebut;

    public CourseModelList() {
    }

    public CourseModelList(int id, String coursename, String classname, String boardname, String coursetime, int courseday, int courseseladd, String courseaddress, String courseteacher, String coursemoney, String begin_t, String end_t, String courseinfo, String coursearran_one_am, String coursearran_one_pm, String coursearran_two_am, String coursearran_two_pm, String courseact_one_am, String courseact_one_pm, String courseact_two_am, String courseact_two_pm, String tz_teacher, String tz_ren, String tz_tel, String tz_mob, String tz_fax, String tz_email, String wordpath, String writer, String ifgood, int hits, int voteid, int voteendid, String ifshow, String ifxc, String ifcw, String addtime, int banzhurenid, String banzhuren, String coursetype, int meeting_gbt, int classid, int extend_course, int boardid, int froum_id, String hddy, String event_ids, String kzxx, String LIVE_TYPE, String client, String browser, String plannerPwd, String joinPwd, String guestPwd, String LIVE_BACK, String imgpath, String caiwuhao, String uzhusu, String paper_title, String main_meeting_place, String fen_course_money, String courseaim_one_am_time, String courseaim_one_pm_time, String courseaim_two_am_time, String courseaim_two_pm_time, String traing_notice, String teach_type, String course_category, String course_category_disp, String submitbut, String noticebut) {
        this.id = id;
        this.coursename = coursename;
        this.classname = classname;
        this.boardname = boardname;
        this.coursetime = coursetime;
        this.courseday = courseday;
        this.courseseladd = courseseladd;
        this.courseaddress = courseaddress;
        this.courseteacher = courseteacher;
        this.coursemoney = coursemoney;
        this.begin_t = begin_t;
        this.end_t = end_t;
        this.courseinfo = courseinfo;
        this.coursearran_one_am = coursearran_one_am;
        this.coursearran_one_pm = coursearran_one_pm;
        this.coursearran_two_am = coursearran_two_am;
        this.coursearran_two_pm = coursearran_two_pm;
        this.courseact_one_am = courseact_one_am;
        this.courseact_one_pm = courseact_one_pm;
        this.courseact_two_am = courseact_two_am;
        this.courseact_two_pm = courseact_two_pm;
        this.tz_teacher = tz_teacher;
        this.tz_ren = tz_ren;
        this.tz_tel = tz_tel;
        this.tz_mob = tz_mob;
        this.tz_fax = tz_fax;
        this.tz_email = tz_email;
        this.wordpath = wordpath;
        this.writer = writer;
        this.ifgood = ifgood;
        this.hits = hits;
        this.voteid = voteid;
        this.voteendid = voteendid;
        this.ifshow = ifshow;
        this.ifxc = ifxc;
        this.ifcw = ifcw;
        this.addtime = addtime;
        this.banzhurenid = banzhurenid;
        this.banzhuren = banzhuren;
        this.coursetype = coursetype;
        this.meeting_gbt = meeting_gbt;
        this.classid = classid;
        this.extend_course = extend_course;
        this.boardid = boardid;
        this.froum_id = froum_id;
        this.hddy = hddy;
        this.event_ids = event_ids;
        this.kzxx = kzxx;
        this.LIVE_TYPE = LIVE_TYPE;
        Client = client;
        Browser = browser;
        PlannerPwd = plannerPwd;
        JoinPwd = joinPwd;
        this.guestPwd = guestPwd;
        this.LIVE_BACK = LIVE_BACK;
        this.imgpath = imgpath;
        this.caiwuhao = caiwuhao;
        this.uzhusu = uzhusu;
        this.paper_title = paper_title;
        this.main_meeting_place = main_meeting_place;
        this.fen_course_money = fen_course_money;
        this.courseaim_one_am_time = courseaim_one_am_time;
        this.courseaim_one_pm_time = courseaim_one_pm_time;
        this.courseaim_two_am_time = courseaim_two_am_time;
        this.courseaim_two_pm_time = courseaim_two_pm_time;
        this.traing_notice = traing_notice;
        this.teach_type = teach_type;
        this.course_category = course_category;
        this.course_category_disp = course_category_disp;
        this.submitbut = submitbut;
        this.noticebut = noticebut;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getBoardname() {
        return boardname;
    }

    public void setBoardname(String boardname) {
        this.boardname = boardname;
    }

    public String getCoursetime() {
        return coursetime;
    }

    public void setCoursetime(String coursetime) {
        this.coursetime = coursetime;
    }

    public int getCourseday() {
        return courseday;
    }

    public void setCourseday(int courseday) {
        this.courseday = courseday;
    }

    public int getCourseseladd() {
        return courseseladd;
    }

    public void setCourseseladd(int courseseladd) {
        this.courseseladd = courseseladd;
    }

    public String getCourseaddress() {
        return courseaddress;
    }

    public void setCourseaddress(String courseaddress) {
        this.courseaddress = courseaddress;
    }

    public String getCourseteacher() {
        return courseteacher;
    }

    public void setCourseteacher(String courseteacher) {
        this.courseteacher = courseteacher;
    }

    public String getCoursemoney() {
        return coursemoney;
    }

    public void setCoursemoney(String coursemoney) {
        this.coursemoney = coursemoney;
    }

    public String getBegin_t() {
        return begin_t;
    }

    public void setBegin_t(String begin_t) {
        this.begin_t = begin_t;
    }

    public String getEnd_t() {
        return end_t;
    }

    public void setEnd_t(String end_t) {
        this.end_t = end_t;
    }

    public String getCourseinfo() {
        return courseinfo;
    }

    public void setCourseinfo(String courseinfo) {
        this.courseinfo = courseinfo;
    }

    public String getCoursearran_one_am() {
        return coursearran_one_am;
    }

    public void setCoursearran_one_am(String coursearran_one_am) {
        this.coursearran_one_am = coursearran_one_am;
    }

    public String getCoursearran_one_pm() {
        return coursearran_one_pm;
    }

    public void setCoursearran_one_pm(String coursearran_one_pm) {
        this.coursearran_one_pm = coursearran_one_pm;
    }

    public String getCoursearran_two_am() {
        return coursearran_two_am;
    }

    public void setCoursearran_two_am(String coursearran_two_am) {
        this.coursearran_two_am = coursearran_two_am;
    }

    public String getCoursearran_two_pm() {
        return coursearran_two_pm;
    }

    public void setCoursearran_two_pm(String coursearran_two_pm) {
        this.coursearran_two_pm = coursearran_two_pm;
    }

    public String getCourseact_one_am() {
        return courseact_one_am;
    }

    public void setCourseact_one_am(String courseact_one_am) {
        this.courseact_one_am = courseact_one_am;
    }

    public String getCourseact_one_pm() {
        return courseact_one_pm;
    }

    public void setCourseact_one_pm(String courseact_one_pm) {
        this.courseact_one_pm = courseact_one_pm;
    }

    public String getCourseact_two_am() {
        return courseact_two_am;
    }

    public void setCourseact_two_am(String courseact_two_am) {
        this.courseact_two_am = courseact_two_am;
    }

    public String getCourseact_two_pm() {
        return courseact_two_pm;
    }

    public void setCourseact_two_pm(String courseact_two_pm) {
        this.courseact_two_pm = courseact_two_pm;
    }

    public String getTz_teacher() {
        return tz_teacher;
    }

    public void setTz_teacher(String tz_teacher) {
        this.tz_teacher = tz_teacher;
    }

    public String getTz_ren() {
        return tz_ren;
    }

    public void setTz_ren(String tz_ren) {
        this.tz_ren = tz_ren;
    }

    public String getTz_tel() {
        return tz_tel;
    }

    public void setTz_tel(String tz_tel) {
        this.tz_tel = tz_tel;
    }

    public String getTz_mob() {
        return tz_mob;
    }

    public void setTz_mob(String tz_mob) {
        this.tz_mob = tz_mob;
    }

    public String getTz_fax() {
        return tz_fax;
    }

    public void setTz_fax(String tz_fax) {
        this.tz_fax = tz_fax;
    }

    public String getTz_email() {
        return tz_email;
    }

    public void setTz_email(String tz_email) {
        this.tz_email = tz_email;
    }

    public String getWordpath() {
        return wordpath;
    }

    public void setWordpath(String wordpath) {
        this.wordpath = wordpath;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getIfgood() {
        return ifgood;
    }

    public void setIfgood(String ifgood) {
        this.ifgood = ifgood;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public int getVoteid() {
        return voteid;
    }

    public void setVoteid(int voteid) {
        this.voteid = voteid;
    }

    public int getVoteendid() {
        return voteendid;
    }

    public void setVoteendid(int voteendid) {
        this.voteendid = voteendid;
    }

    public String getIfshow() {
        return ifshow;
    }

    public void setIfshow(String ifshow) {
        this.ifshow = ifshow;
    }

    public String getIfxc() {
        return ifxc;
    }

    public void setIfxc(String ifxc) {
        this.ifxc = ifxc;
    }

    public String getIfcw() {
        return ifcw;
    }

    public void setIfcw(String ifcw) {
        this.ifcw = ifcw;
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }

    public int getBanzhurenid() {
        return banzhurenid;
    }

    public void setBanzhurenid(int banzhurenid) {
        this.banzhurenid = banzhurenid;
    }

    public String getBanzhuren() {
        return banzhuren;
    }

    public void setBanzhuren(String banzhuren) {
        this.banzhuren = banzhuren;
    }

    public String getCoursetype() {
        return coursetype;
    }

    public void setCoursetype(String coursetype) {
        this.coursetype = coursetype;
    }

    public int getMeeting_gbt() {
        return meeting_gbt;
    }

    public void setMeeting_gbt(int meeting_gbt) {
        this.meeting_gbt = meeting_gbt;
    }

    public int getClassid() {
        return classid;
    }

    public void setClassid(int classid) {
        this.classid = classid;
    }

    public int getExtend_course() {
        return extend_course;
    }

    public void setExtend_course(int extend_course) {
        this.extend_course = extend_course;
    }

    public int getBoardid() {
        return boardid;
    }

    public void setBoardid(int boardid) {
        this.boardid = boardid;
    }

    public int getFroum_id() {
        return froum_id;
    }

    public void setFroum_id(int froum_id) {
        this.froum_id = froum_id;
    }

    public String getHddy() {
        return hddy;
    }

    public void setHddy(String hddy) {
        this.hddy = hddy;
    }

    public String getEvent_ids() {
        return event_ids;
    }

    public void setEvent_ids(String event_ids) {
        this.event_ids = event_ids;
    }

    public String getKzxx() {
        return kzxx;
    }

    public void setKzxx(String kzxx) {
        this.kzxx = kzxx;
    }

    public String getLIVE_TYPE() {
        return LIVE_TYPE;
    }

    public void setLIVE_TYPE(String LIVE_TYPE) {
        this.LIVE_TYPE = LIVE_TYPE;
    }

    public String getClient() {
        return Client;
    }

    public void setClient(String client) {
        Client = client;
    }

    public String getBrowser() {
        return Browser;
    }

    public void setBrowser(String browser) {
        Browser = browser;
    }

    public String getPlannerPwd() {
        return PlannerPwd;
    }

    public void setPlannerPwd(String plannerPwd) {
        PlannerPwd = plannerPwd;
    }

    public String getJoinPwd() {
        return JoinPwd;
    }

    public void setJoinPwd(String joinPwd) {
        JoinPwd = joinPwd;
    }

    public String getGuestPwd() {
        return guestPwd;
    }

    public void setGuestPwd(String guestPwd) {
        this.guestPwd = guestPwd;
    }

    public String getLIVE_BACK() {
        return LIVE_BACK;
    }

    public void setLIVE_BACK(String LIVE_BACK) {
        this.LIVE_BACK = LIVE_BACK;
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }

    public String getCaiwuhao() {
        return caiwuhao;
    }

    public void setCaiwuhao(String caiwuhao) {
        this.caiwuhao = caiwuhao;
    }

    public String getUzhusu() {
        return uzhusu;
    }

    public void setUzhusu(String uzhusu) {
        this.uzhusu = uzhusu;
    }

    public String getPaper_title() {
        return paper_title;
    }

    public void setPaper_title(String paper_title) {
        this.paper_title = paper_title;
    }

    public String getMain_meeting_place() {
        return main_meeting_place;
    }

    public void setMain_meeting_place(String main_meeting_place) {
        this.main_meeting_place = main_meeting_place;
    }

    public String getFen_course_money() {
        return fen_course_money;
    }

    public void setFen_course_money(String fen_course_money) {
        this.fen_course_money = fen_course_money;
    }

    public String getCourseaim_one_am_time() {
        return courseaim_one_am_time;
    }

    public void setCourseaim_one_am_time(String courseaim_one_am_time) {
        this.courseaim_one_am_time = courseaim_one_am_time;
    }

    public String getCourseaim_one_pm_time() {
        return courseaim_one_pm_time;
    }

    public void setCourseaim_one_pm_time(String courseaim_one_pm_time) {
        this.courseaim_one_pm_time = courseaim_one_pm_time;
    }

    public String getCourseaim_two_am_time() {
        return courseaim_two_am_time;
    }

    public void setCourseaim_two_am_time(String courseaim_two_am_time) {
        this.courseaim_two_am_time = courseaim_two_am_time;
    }

    public String getCourseaim_two_pm_time() {
        return courseaim_two_pm_time;
    }

    public void setCourseaim_two_pm_time(String courseaim_two_pm_time) {
        this.courseaim_two_pm_time = courseaim_two_pm_time;
    }

    public String getTraing_notice() {
        return traing_notice;
    }

    public void setTraing_notice(String traing_notice) {
        this.traing_notice = traing_notice;
    }

    public String getTeach_type() {
        return teach_type;
    }

    public void setTeach_type(String teach_type) {
        this.teach_type = teach_type;
    }

    public String getCourse_category() {
        return course_category;
    }

    public void setCourse_category(String course_category) {
        this.course_category = course_category;
    }

    public String getCourse_category_disp() {
        return course_category_disp;
    }

    public void setCourse_category_disp(String course_category_disp) {
        this.course_category_disp = course_category_disp;
    }

    public String getSubmitbut() {
        return submitbut;
    }

    public void setSubmitbut(String submitbut) {
        this.submitbut = submitbut;
    }

    public String getNoticebut() {
        return noticebut;
    }

    public void setNoticebut(String noticebut) {
        this.noticebut = noticebut;
    }

    @Override
    public String toString() {
        return "CourseModelList{" +
                "id=" + id +
                ", coursename='" + coursename + '\'' +
                ", classname='" + classname + '\'' +
                ", boardname='" + boardname + '\'' +
                ", coursetime='" + coursetime + '\'' +
                ", courseday=" + courseday +
                ", courseseladd=" + courseseladd +
                ", courseaddress='" + courseaddress + '\'' +
                ", courseteacher='" + courseteacher + '\'' +
                ", coursemoney='" + coursemoney + '\'' +
                ", begin_t='" + begin_t + '\'' +
                ", end_t='" + end_t + '\'' +
                ", courseinfo='" + courseinfo + '\'' +
                ", coursearran_one_am='" + coursearran_one_am + '\'' +
                ", coursearran_one_pm='" + coursearran_one_pm + '\'' +
                ", coursearran_two_am='" + coursearran_two_am + '\'' +
                ", coursearran_two_pm='" + coursearran_two_pm + '\'' +
                ", courseact_one_am='" + courseact_one_am + '\'' +
                ", courseact_one_pm='" + courseact_one_pm + '\'' +
                ", courseact_two_am='" + courseact_two_am + '\'' +
                ", courseact_two_pm='" + courseact_two_pm + '\'' +
                ", tz_teacher='" + tz_teacher + '\'' +
                ", tz_ren='" + tz_ren + '\'' +
                ", tz_tel='" + tz_tel + '\'' +
                ", tz_mob='" + tz_mob + '\'' +
                ", tz_fax='" + tz_fax + '\'' +
                ", tz_email='" + tz_email + '\'' +
                ", wordpath='" + wordpath + '\'' +
                ", writer='" + writer + '\'' +
                ", ifgood='" + ifgood + '\'' +
                ", hits=" + hits +
                ", voteid=" + voteid +
                ", voteendid=" + voteendid +
                ", ifshow='" + ifshow + '\'' +
                ", ifxc='" + ifxc + '\'' +
                ", ifcw='" + ifcw + '\'' +
                ", addtime='" + addtime + '\'' +
                ", banzhurenid=" + banzhurenid +
                ", banzhuren='" + banzhuren + '\'' +
                ", coursetype='" + coursetype + '\'' +
                ", meeting_gbt=" + meeting_gbt +
                ", classid=" + classid +
                ", extend_course=" + extend_course +
                ", boardid=" + boardid +
                ", froum_id=" + froum_id +
                ", hddy='" + hddy + '\'' +
                ", event_ids='" + event_ids + '\'' +
                ", kzxx='" + kzxx + '\'' +
                ", LIVE_TYPE='" + LIVE_TYPE + '\'' +
                ", Client='" + Client + '\'' +
                ", Browser='" + Browser + '\'' +
                ", PlannerPwd='" + PlannerPwd + '\'' +
                ", JoinPwd='" + JoinPwd + '\'' +
                ", guestPwd='" + guestPwd + '\'' +
                ", LIVE_BACK='" + LIVE_BACK + '\'' +
                ", imgpath='" + imgpath + '\'' +
                ", caiwuhao='" + caiwuhao + '\'' +
                ", uzhusu='" + uzhusu + '\'' +
                ", paper_title='" + paper_title + '\'' +
                ", main_meeting_place='" + main_meeting_place + '\'' +
                ", fen_course_money='" + fen_course_money + '\'' +
                ", courseaim_one_am_time='" + courseaim_one_am_time + '\'' +
                ", courseaim_one_pm_time='" + courseaim_one_pm_time + '\'' +
                ", courseaim_two_am_time='" + courseaim_two_am_time + '\'' +
                ", courseaim_two_pm_time='" + courseaim_two_pm_time + '\'' +
                ", traing_notice='" + traing_notice + '\'' +
                ", teach_type='" + teach_type + '\'' +
                ", course_category='" + course_category + '\'' +
                ", course_category_disp='" + course_category_disp + '\'' +
                ", submitbut='" + submitbut + '\'' +
                ", noticebut='" + noticebut + '\'' +
                '}';
    }
}
