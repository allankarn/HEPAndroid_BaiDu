package com.enetedu.hep.utils;

import android.content.Context;

public class ResourceUtil {
    public static String getString(Context context, int resId) {
        return (context == null | resId == 0) ? "" : context.getString(resId);
    }

    public static String checkNull(String sValue)
    {
        if(null == sValue)
        {
            return "";
        }
        return sValue;
    }
}
