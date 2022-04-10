package com.enetedu.hep.http.entity;

import com.enetedu.hep.base.BaseEntityImpl;
import com.enetedu.hep.http.HEPMSProxy;
import com.enetedu.hep.http.IHEPMSProxy;
import com.enetedu.hep.http.RespBase;
import com.enetedu.hep.http.req.ReqLogin;
import com.enetedu.hep.http.req.ReqOrderConfirm;
import com.enetedu.hep.http.req.ReqPassWordEditSave;
import com.enetedu.hep.http.req.ReqPersonal;
import com.enetedu.hep.http.req.ReqPersonalSave;
import com.enetedu.hep.http.req.ReqSMSUpdateLoginPwd;
import com.enetedu.hep.http.req.ReqSignUpSaveEdit;
import com.enetedu.hep.http.req.ReqUserRegister;
import com.enetedu.hep.utils.ResourceUtil;

import java.io.Serializable;

public class UserInfo extends BaseEntityImpl implements Serializable {

    private static final long serialVersionUID = 8138831908757365964L;

    private String userToken;

    private int userId;
    private String loginName = "";
    private String loginPwd = "";
    private String nickName = "";
    private String email = "";
    private String userName = "";
    private String headImg;
    private String mobile = "";
    private String school = "";
    private String signature;
    private String address;
    private int userType;
    private String menuCodeState;
    private String regTime;
    private String bill_companyname;
    private String UserSex;
    private String nation;
    private String Userschooldepartment;
    private String Userbill;
    private String bill_banknumber;
    private String bill_taxpayernumber;
    private String bill_addressphone;
    private String bill_remark;



    public UserInfo() {
    }

    public String getUserbill() {
        return Userbill;
    }

    public void setUserbill(String userbill) {
        Userbill = userbill;
    }

    public String getBill_banknumber() {
        return bill_banknumber;
    }

    public void setBill_banknumber(String bill_banknumber) {
        this.bill_banknumber = bill_banknumber;
    }

    public String getBill_taxpayernumber() {
        return bill_taxpayernumber;
    }

    public void setBill_taxpayernumber(String bill_taxpayernumber) {
        this.bill_taxpayernumber = bill_taxpayernumber;
    }

    public String getBill_addressphone() {
        return bill_addressphone;
    }

    public void setBill_addressphone(String bill_addressphone) {
        this.bill_addressphone = bill_addressphone;
    }


    public String getBill_remark() {
        return bill_remark;
    }

    public void setBill_remark(String bill_remark) {
        this.bill_remark = bill_remark;
    }

    public String getUserschooldepartment() {
        return Userschooldepartment;
    }

    public void setUserschooldepartment(String userschooldepartment) {
        Userschooldepartment = userschooldepartment;
    }

    public String getUserSex() {
        return UserSex;
    }

    public void setUserSex(String userSex) {
        UserSex = userSex;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }


    public String getBill_companyname() {
        return bill_companyname;
    }

    public void setBill_companyname(String bill_companyname) {
        this.bill_companyname = bill_companyname;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getLoginName() {
        return ResourceUtil.checkNull(loginName);
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPwd() {
        return ResourceUtil.checkNull(loginPwd);
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getNickName() {
        return ResourceUtil.checkNull(nickName);
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return ResourceUtil.checkNull(email);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        if ("(null)".equals(userName)) {
            return "";
        }
        return ResourceUtil.checkNull(userName);
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getHeadImg() {
        return ResourceUtil.checkNull(headImg);
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getMobile() {
        return ResourceUtil.checkNull(mobile);
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSchool() {
        return ResourceUtil.checkNull(school);
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getSignature() {
        return ResourceUtil.checkNull(signature);
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getAddress() {
        return ResourceUtil.checkNull(address);
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public String getMenuCodeState() {
        return ResourceUtil.checkNull(menuCodeState);
    }

    public void setMenuCodeState(String menuCodeState) {
        this.menuCodeState = menuCodeState;
    }

    public String getUserToken() {
        return ResourceUtil.checkNull(userToken);
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public String getRegTime() {
        return ResourceUtil.checkNull(regTime);
    }

    public void setRegTime(String regTime) {
        this.regTime = regTime;
    }

  /*  @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + userId;
        return result;
    }*/


    @Override
    public boolean equals(Object obj) {


        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UserInfo other = (UserInfo) obj;
        if (userId != other.userId)
            return false;
        return true;
    }

    private ReqLogin reqLogin;

    public void getUserLogin(String EndPoint, String LoginName, String LoginPwd, String Timestamp,String type, final OnBaseResp onBaseResp) {
        if (reqLogin == null) reqLogin = new ReqLogin();
        reqLogin.setEndPoint(EndPoint);
        reqLogin.setLoginName(LoginName);
        reqLogin.setLoginPwd(LoginPwd);
        reqLogin.setTimeStamp(Timestamp);
        reqLogin.setType(type);
        HEPMSProxy.GetUserLogin(reqLogin, new IHEPMSProxy.OnResp() {
            @Override
            public void onResp(RespBase response) {
                resp(onBaseResp, response);
            }
        });
    }

    private ReqUserRegister reqUserRegister;

    public void getUserRegister(String EndPoint, String LoginName, String LoginPwd, String TelPhone, String School, String UserRealName, final OnBaseResp onBaseResp) {
        if (reqUserRegister == null) reqUserRegister = new ReqUserRegister();
        reqUserRegister.setEndPoint(EndPoint);
        reqUserRegister.setLoginName(LoginName);
        reqUserRegister.setLoginPwd(LoginPwd);
        reqUserRegister.setTelPhone(TelPhone);
        reqUserRegister.setSchool(School);
        reqUserRegister.setUserRealName(UserRealName);
        HEPMSProxy.GetUserRegister(reqUserRegister, new IHEPMSProxy.OnResp() {
            @Override
            public void onResp(RespBase response) {
                resp(onBaseResp, response);
            }
        });
    }

    private ReqSMSUpdateLoginPwd reqSMSUpdateLoginPwd;

    public void getSMSUpdateLoginPwd(String loginName, String SMSCode, String NewLoginPwd, String ReLoginPwd, final OnBaseResp onBaseResp) {
        if (reqSMSUpdateLoginPwd == null) reqSMSUpdateLoginPwd = new ReqSMSUpdateLoginPwd();
        reqSMSUpdateLoginPwd.setLoginName(loginName);
        reqSMSUpdateLoginPwd.setSMSCode(SMSCode);
        reqSMSUpdateLoginPwd.setNewLoginPwd(NewLoginPwd);
        reqSMSUpdateLoginPwd.setReLoginPwd(ReLoginPwd);
        HEPMSProxy.GetSMSUpdateLoginPwd(reqSMSUpdateLoginPwd, new IHEPMSProxy.OnResp() {
            @Override
            public void onResp(RespBase response) {
                resp(onBaseResp, response);
            }
        });
    }

    private ReqPassWordEditSave reqPassWordEditSave;

    public void getPassWordEditSave(String UserToKen, int UserID, String oldpwd, String pwd, String savepwd, final OnBaseResp onBaseResp) {
        if (reqPassWordEditSave == null) reqPassWordEditSave = new ReqPassWordEditSave();
        reqPassWordEditSave.setUserToKen(UserToKen);
        reqPassWordEditSave.setUserID(UserID);
        reqPassWordEditSave.setOldpwd(oldpwd);
        reqPassWordEditSave.setPwd(pwd);
        reqPassWordEditSave.setSavepwd(savepwd);
        HEPMSProxy.GetPassWordEditSave(reqPassWordEditSave, new IHEPMSProxy.OnResp() {
            @Override
            public void onResp(RespBase response) {
                resp(onBaseResp, response);
            }
        });
    }

    private ReqPersonal reqPersonal;

    public void getPersonal(String UserToKen, int UserID, final OnBaseResp onBaseResp) {
        if (reqPersonal == null) reqPersonal = new ReqPersonal();
        reqPersonal.setUserToKen(UserToKen);
        reqPersonal.setUserID(UserID);

        HEPMSProxy.GetPersonal(reqPersonal, new IHEPMSProxy.OnResp() {
            @Override
            public void onResp(RespBase response) {
                resp(onBaseResp, response);
            }
        });
    }

    private ReqPersonalSave reqPersonalSave;

    public void getPersonalSave(String UserToKen, int UserID, String userface, String usermyname, String usersex, String nation, String userschoolname, String userschooldepartment, String username, final OnBaseResp onBaseResp) {
        if (reqPersonalSave == null) reqPersonalSave = new ReqPersonalSave();
        reqPersonalSave.setUserToKen(UserToKen);
        reqPersonalSave.setUserID(UserID);
        reqPersonalSave.setUserface(userface);
        reqPersonalSave.setUsermyname(usermyname);
        reqPersonalSave.setUsersex(usersex);
        reqPersonalSave.setNation(nation);
        reqPersonalSave.setUserschoolname(userschoolname);
        reqPersonalSave.setUserschooldepartment(userschooldepartment);
        reqPersonalSave.setUsername(username);

        HEPMSProxy.GetPersonalSave(reqPersonalSave, new IHEPMSProxy.OnResp() {
            @Override
            public void onResp(RespBase response) {
                resp(onBaseResp, response);
            }
        });

    }

    //集中课现在报名提交
    private ReqSignUpSaveEdit reqSignUpSaveEdit;

    public void getSignUpSaveEdit(int id, int UserID, String userToken, String centerid, String uzhusu, String baodaotime, String useremail, String usermyname, String usermob,
                                  String usersheng, String usershi, String userqu, String useraddress, String userschoolname, String userschooldepartment, String userbill, String bill_taxpayernumber,
                                  String bill_addressphone, String bill_banknumber, String bug_falx, String bill_remark, final OnBaseResp onBaseResp) {
        if (reqSignUpSaveEdit == null) reqSignUpSaveEdit = new ReqSignUpSaveEdit();
        reqSignUpSaveEdit.setId(id);
        reqSignUpSaveEdit.setUserID(UserID);
        reqSignUpSaveEdit.setUserToKen(userToken);
        reqSignUpSaveEdit.setCenterid(centerid);
        reqSignUpSaveEdit.setUzhusu(uzhusu);
        reqSignUpSaveEdit.setBaodaotime(baodaotime);
        reqSignUpSaveEdit.setUseremail(useremail);
        reqSignUpSaveEdit.setUsermyname(usermyname);
        reqSignUpSaveEdit.setUsermob(usermob);
        reqSignUpSaveEdit.setUsersheng(usersheng);
        reqSignUpSaveEdit.setUsershi(usershi);
        reqSignUpSaveEdit.setUserqu(userqu);
        reqSignUpSaveEdit.setUseraddress(useraddress);
        reqSignUpSaveEdit.setUserschoolname(userschoolname);
        reqSignUpSaveEdit.setUserschooldepartment(userschooldepartment);
        reqSignUpSaveEdit.setUserbill(userbill);
        reqSignUpSaveEdit.setBill_taxpayernumber(bill_taxpayernumber);
        reqSignUpSaveEdit.setBill_addressphone(bill_addressphone);
        reqSignUpSaveEdit.setBill_banknumber(bill_banknumber);
        reqSignUpSaveEdit.setBug_falx(bug_falx);
        reqSignUpSaveEdit.setBill_remark(bill_remark);

        HEPMSProxy.GetSignUpSaveEdit(reqSignUpSaveEdit, new IHEPMSProxy.OnResp() {
            @Override
            public void onResp(RespBase response) {
                resp(onBaseResp, response);
            }
        });
    }

    private ReqOrderConfirm reqOrderConfirm;

    public void getOrderConfirm(String EndPoint, String UserToKen, int UserID, String eID, String tUsermyname, String province, String district, String city,
                                String tUsermob, String tUseraddress, String tUserschoolname, String tUserschooldepartment, String course_name, final OnBaseResp onBaseResp) {
        if (reqOrderConfirm == null) reqOrderConfirm = new ReqOrderConfirm();
        reqOrderConfirm.setEndPoint(EndPoint);
        reqOrderConfirm.setUserToKen(UserToKen);
        reqOrderConfirm.setUserID(UserID);
        reqOrderConfirm.seteID(eID);
        reqOrderConfirm.settUsermyname(tUsermyname);
        reqOrderConfirm.setProvince(province);
        reqOrderConfirm.setDistrict(district);
        reqOrderConfirm.setCity(city);
        reqOrderConfirm.settUsermob(tUsermob);
        reqOrderConfirm.settUseraddress(tUseraddress);
        reqOrderConfirm.settUserschoolname(tUserschoolname);
        reqOrderConfirm.settUserschooldepartment(tUserschooldepartment);
        reqOrderConfirm.setCourse_name(course_name);

        HEPMSProxy.GetOrderConfirm(reqOrderConfirm, new IHEPMSProxy.OnResp() {
            @Override
            public void onResp(RespBase response) {
                resp(onBaseResp, response);
            }
        });
    }


    @Override
    public String toString() {
        return "UserInfo{" +
                "userToken='" + userToken + '\'' +
                ", userId=" + userId +
                ", loginName='" + loginName + '\'' +
                ", loginPwd='" + loginPwd + '\'' +
                ", nickName='" + nickName + '\'' +
                ", email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                ", headImg='" + headImg + '\'' +
                ", mobile='" + mobile + '\'' +
                ", school='" + school + '\'' +
                ", signature='" + signature + '\'' +
                ", address='" + address + '\'' +
                ", userType=" + userType +
                ", menuCodeState='" + menuCodeState + '\'' +
                ", regTime='" + regTime + '\'' +
                ", bill_companyname='" + bill_companyname + '\'' +
                ", UserSex='" + UserSex + '\'' +
                ", nation='" + nation + '\'' +
                ", Userschooldepartment='" + Userschooldepartment + '\'' +
                ", Userbill='" + Userbill + '\'' +
                ", bill_banknumber='" + bill_banknumber + '\'' +
                ", bill_taxpayernumber='" + bill_taxpayernumber + '\'' +
                ", bill_addressphone='" + bill_addressphone + '\'' +
                ", bill_remark='" + bill_remark + '\'' +
                ", reqLogin=" + reqLogin +
                ", reqPassWordEditSave=" + reqPassWordEditSave +
                ", reqPersonal=" + reqPersonal +
                ", reqPersonalSave=" + reqPersonalSave +
                '}';
    }
}
