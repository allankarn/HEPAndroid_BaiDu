package com.enetedu.hep.http.req;

import com.enetedu.hep.http.RespBase;
import com.enetedu.hep.http.entity.UserInfo;

import org.json.JSONObject;

public class RespPersonal extends RespBase {
    private UserInfo info;


    @Override
    public void onResp(String result) {

        JSONObject jo = converToJson(result);
        if (jo != null) {
            info = new UserInfo();
            info.setUserToken(getJsonString(jo, "UserToKen", ""));
            JSONObject resultDataObj = getJSONObj(jo, "ResultData");
            if (resultDataObj != null) {
                JSONObject userInfoObj = getJSONObj(resultDataObj, "UserInfo");
                if (userInfoObj != null) {
                    info.setUserId(getJSONInt(userInfoObj, "UserID", 0));
                    info.setLoginName(getJsonString(userInfoObj, "LoginName", ""));

                    info.setNickName(getJsonString(userInfoObj, "NikeName", ""));

                    info.setUserName(getJsonString(userInfoObj, "UserRealName", ""));
//					info.set(getJsonString(userInfoObj, "MyName", ""));
                    info.setHeadImg(getJsonString(userInfoObj, "UserImage", ""));
                    info.setMobile(getJsonString(userInfoObj, "Mobile", ""));
                    info.setSchool(getJsonString(userInfoObj, "UserSchool", ""));

                    info.setMenuCodeState(getJsonString(userInfoObj, "MenuCodeState", ""));

                    info.setRegTime(getJsonString(userInfoObj, "RegTime", ""));

                    info.setBill_companyname(getJsonString(userInfoObj, "bill_companyname", ""));
                    info.setUserSex(getJsonString(userInfoObj, "UserSex", ""));
                    info.setNation(getJsonString(userInfoObj, "nation", ""));
                    info.setUserschooldepartment(getJsonString(userInfoObj, "Userschooldepartment", ""));

                }
            }
        }
    }

    @Override
    public Object getData() {
        return info;
    }

    @Override
    public String toString() {
        return "RespPersonal{" +
                "info=" + info +
                '}';
    }
}
