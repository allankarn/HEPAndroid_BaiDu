package com.enetedu.hep.config;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

import android.provider.SyncStateContract;
import android.util.Log;

import com.baidu.mobstat.StatService;
import com.enetedu.hep.utils.Constant;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.tencent.smtt.sdk.QbSdk;

public class MyApp extends Application {
    protected static Context mContext;
    protected static Handler mainHandler;
    public static final String SP_NAME_HEP = "hep.android";
    private static final String TAG = "MyApp";
    public  static IWXAPI wx_api;

    /**
     * 获取全局上下文对象
     *
     * @return
     */
    public static Context getContext() {
        return mContext;
    }

    /**
     * 获取主线程的Handler
     *
     * @return
     */
    public static Handler getMainHandler() {
        return mainHandler;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mContext = this;
        mainHandler = new Handler();

        initX5Web();
        // 通过该接口可以控制隐私权限策略的数据采集，true表示可以采集，false表示不可以采集，请在Application里优先调用
        // 采集这些数据可以帮助App运营人员更好的监控App的使用情况，
        // 建议有用户隐私策略弹窗的App，用户未同意前设置false,同意之后设置true
        StatService.setAuthorizedState(mContext, true);
        registToWX();
    }
    private void registToWX() {
         wx_api= (IWXAPI)WXAPIFactory.createWXAPI(mContext, Constant.APP_ID, false);
         wx_api.registerApp(Constant.APP_ID);

    }
    private void initX5Web() {
        QbSdk.PreInitCallback cb = new QbSdk.PreInitCallback() {
            @Override
            public void onViewInitFinished(boolean arg0) {
                //x5內核初始化完成的回调，为true表示x5内核加载成功，否则表示x5内核加载失败，会自动切换到系统内核。
                Log.d(TAG, "x5WebApp: " + " onViewInitFinished is " + arg0);
            }

            @Override
            public void onCoreInitFinished() {
            }
        };
        //x5内核初始化接口
        QbSdk.initX5Environment(getApplicationContext(), cb);
    }
}
