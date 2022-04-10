package com.enetedu.hep.utils;

import android.app.Application;
import android.content.Context;
import android.os.Handler;


public class MyApp extends Application {
    protected static Context mContext;
    protected static Handler mainHandler;
    public static final String SP_NAME_HEP = "hep.android";

    /**
     * 获取全局上下文对象
     * @return
     */
    public static Context getContext(){
        return mContext;
    }

    /**
     * 获取主线程的Handler
     * @return
     */
    public static Handler getMainHandler(){
        return mainHandler;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        MessageHandler.initErrMsgHandler();
        mContext = this;
        mainHandler = new Handler();
    }
}
