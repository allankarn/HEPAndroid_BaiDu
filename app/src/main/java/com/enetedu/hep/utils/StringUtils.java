package com.enetedu.hep.utils;

import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    static String REGULAR_EX = "#";

    public StringUtils() {
    }

    public static boolean isEmpty(String string) {
        return string == null || "".equals(string);
    }

    public static boolean isIPCorrect(String ip) {
        Pattern p = Pattern.compile("((?:(?:25[0-5]|2[0-4]\\d|[01]?\\d?\\d)\\.){3}(?:25[0-5]|2[0-4]\\d|[01]?\\d?\\d))");
        Matcher m = p.matcher(ip);
        return m.matches();
    }

    public static List<String> getListStr(SharedPreferences share, String key) {
        if (share != null && !isEmpty(key)) {
            List<String> list = null;
            String[] str = null;
            String values = share.getString(key, "");
            str = values.split(REGULAR_EX);
            if (str != null && str.length > 0) {
                list = new ArrayList(str.length);
                String[] var8 = str;
                int var7 = str.length;

                for(int var6 = 0; var6 < var7; ++var6) {
                    String s = var8[var6];
                    if (!isEmpty(s)) {
                        list.add(s);
                    }
                }
            }

            return list;
        } else {
            return null;
        }
    }

    public static boolean deleteString(SharedPreferences share, String key, String content) {
        List<String> list = getListStr(share, key);
        if (list != null && list.remove(content)) {
            String str = "";

            for(Iterator var6 = list.iterator(); var6.hasNext(); str = str + REGULAR_EX) {
                String s = (String)var6.next();
                str = str + s;
            }

            return share.edit().putString(key, str).commit();
        } else {
            return false;
        }
    }

    public static boolean addStringToPre(SharedPreferences share, String key, String content) {
        if (share != null && !isEmpty(key) && !isEmpty(content)) {
            List<String> list = getListStr(share, key);
            if (list != null && list.contains(content)) {
                return false;
            } else {
                String values = share.getString(key, "");
                values = values + content;
                values = values + REGULAR_EX;
                return share.edit().putString(key, values).commit();
            }
        } else {
            return false;
        }
    }

    public static String toBinary(long n, int target) {
        String s;
        for(s = ""; n != 0L; n /= (long)target) {
            s = n % (long)target + s;
        }

        return s;
    }

    public static String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (src != null && src.length > 0) {
            for(int i = 0; i < src.length; ++i) {
                int v = src[i] & 255;
                String hv = Integer.toHexString(v);
                if (hv.length() < 2) {
                    stringBuilder.append(0);
                }

                stringBuilder.append(hv);
            }

            return stringBuilder.toString();
        } else {
            return null;
        }
    }

    /*public static String hexStringToString(String hexString, int encodeType) {
        String result = "";
        int max = hexString.length() / encodeType;

        for(int i = 0; i < max; ++i) {
            char c = (char)hexStringToAlgorism(hexString.substring(i * encodeType, (i + 1) * encodeType));
            result = result + c;
        }

        return result;
    }*/

    /*public static int hexStringToAlgorism(String hex) {
        hex = hex.toUpperCase();
        int max = hex.length();
        int result = 0;

        for(int i = max; i > 0; --i) {
            char c = hex.charAt(i - 1);
            int algorism = false;
            int algorism;
            if (c >= '0' && c <= '9') {
                algorism = c - 48;
            } else {
                algorism = c - 55;
            }

            result = (int)((double)result + Math.pow(16.0D, (double)(max - i)) * (double)algorism);
        }

        return result;
    }*/
}
