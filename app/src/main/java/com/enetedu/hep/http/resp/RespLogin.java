package com.enetedu.hep.http.resp;

import android.util.Log;

import com.enetedu.hep.http.RespBase;
import com.enetedu.hep.http.entity.UserInfo;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class RespLogin extends RespBase {
    private static final String TAG = "RespLogin";
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
                    info.setLoginPwd(getJsonString(userInfoObj, "LoginPwd", ""));
                    info.setNickName(getJsonString(userInfoObj, "NikeName", ""));
                    info.setEmail(getJsonString(userInfoObj, "Email", ""));
                    info.setUserName(getJsonString(userInfoObj, "UserRealName", ""));
//					info.set(getJsonString(userInfoObj, "MyName", ""));
                    info.setHeadImg(getJsonString(userInfoObj, "UserImage", ""));
                    info.setMobile(getJsonString(userInfoObj, "Mobile", ""));
                    info.setSchool(getJsonString(userInfoObj, "UserSchool", ""));
                    info.setSignature(getJsonString(userInfoObj, "UserSignature", ""));
                    info.setAddress(getJsonString(userInfoObj, "UserAddress", ""));
                    info.setMenuCodeState(getJsonString(userInfoObj, "MenuCodeState", ""));
                    info.setUserType(getJSONInt(userInfoObj, "UserType", 0));
                    info.setRegTime(getJsonString(userInfoObj, "RegTime", ""));
                    info.setHeadImg(getJsonString(userInfoObj, "UserImage", ""));
                    info.setBill_companyname(getJsonString(userInfoObj, "bill_companyname", ""));
                    info.setUserSex(getJsonString(userInfoObj, "UserSex", ""));
                    info.setNation(getJsonString(userInfoObj, "nation", ""));
                    info.setUserbill(getJsonString(userInfoObj,"Userbill",""));
                    info.setBill_companyname(getJsonString(userInfoObj,"bill_companyname",""));
                    info.setBill_banknumber(getJsonString(userInfoObj,"bill_banknumber",""));
                    info.setBill_taxpayernumber(getJsonString(userInfoObj,"bill_taxpayernumber",""));
                    info.setBill_addressphone(getJsonString(userInfoObj,"bill_addressphone",""));
                    info.setBill_remark(getJsonString(userInfoObj,"bill_remark",""));
                    Log.d(TAG, "onResp: " + info.toString());
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
        return "RespLogin [info=" + "" + info.toString() + super.toString() + "]";
    }
}
