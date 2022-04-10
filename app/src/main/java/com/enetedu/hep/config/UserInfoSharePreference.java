package com.enetedu.hep.config;

import android.content.Context;
import android.content.SharedPreferences;

import com.enetedu.hep.http.entity.UserInfo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class UserInfoSharePreference {
    public static final String SP_NAME_HEP = "hep.android";
    private static final String USER_INFO = "USER_INFO";
    private static final String MENUCODE_INFO = "MENUCODE_INFO";
    private static UserInfoSharePreference infoSharePreference = null;

    public static UserInfoSharePreference getIns() {
        if (null == infoSharePreference) {
            infoSharePreference = new UserInfoSharePreference();
        }
        return infoSharePreference;
    }

    public void clear(Context context) {
        save(null, context);
      //  saveMenus(null, context);
    }

    public void save(UserInfo userInfo, Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SP_NAME_HEP, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        if (null == userInfo) {
            editor.putString(USER_INFO, "");
        } else {
            GsonBuilder gsonBuilder = new GsonBuilder();
            Gson gson = gsonBuilder.create();
            String sUserInfo = gson.toJson(userInfo);
            editor.putString(USER_INFO, sUserInfo);
        }
        editor.commit();
    }

    public UserInfo get(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SP_NAME_HEP, Context.MODE_PRIVATE);
        String sUserInfo = sharedPreferences.getString(USER_INFO, "");
        if ("".equals(sUserInfo)) {
            return null;
        } else {
            GsonBuilder gsonBuilder = new GsonBuilder();
            Gson gson = gsonBuilder.create();
            return gson.fromJson(sUserInfo, UserInfo.class);
        }
    }
}
