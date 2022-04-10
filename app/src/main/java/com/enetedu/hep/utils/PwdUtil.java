package com.enetedu.hep.utils;

import android.text.TextUtils;

public class PwdUtil  {

    //判断是否属于字母加数字格式，true代表不属于
    public static boolean isNotTrue (String str){
        int a = 0;
        for(int i=0 ; i < str.length();i++){
            if(!Character.isDigit(str.charAt(i)) && !Character.isLetter(str.charAt(i))){   //用char包装类中的判断数字的方法判断每一个字符
                a++;
            }
        }
        if (a>0){
            return true;
        }else{
            return false;
        }
    }

    //判断是否是纯数字或纯字母，true代表是纯数字或纯字母
    public static boolean isLetterDigit(String str){
        int isDigit = 0;
        int isLetter = 0;
        for(int i=0 ; i < str.length();i++){
            if(!Character.isDigit(str.charAt(i))){   //用char包装类中的判断数字的方法判断每一个字符
                isDigit ++;
            }
            if (!Character.isLetter(str.charAt(i))){
                isLetter ++;
            }
        }
        if (isDigit ==0 || isLetter==0 ){
            return true;
        }
        return false;
    }
}
