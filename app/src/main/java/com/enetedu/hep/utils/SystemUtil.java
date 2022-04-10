package com.enetedu.hep.utils;


import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.ResultReceiver;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

public class SystemUtil {
	/**
	 * 隐藏软键盘
	 */
	public static void hideSoftInputmethod(Context context)

	{
		Activity activity = (Activity)context;
		if (null != activity.getCurrentFocus()) {
			InputMethodManager im = (InputMethodManager) activity
					.getSystemService(Context.INPUT_METHOD_SERVICE);
			im.hideSoftInputFromWindow(activity.getCurrentFocus()
					.getApplicationWindowToken(),
					InputMethodManager.HIDE_NOT_ALWAYS);
		}
	}
	
	public static void hideSoftInputmethod(View v, ResultReceiver resultReceiver)
	
	{
//		Activity activity = (Activity)context;
//		if (null != activity.getCurrentFocus()) {
			InputMethodManager im = (InputMethodManager) v.getContext()
					.getSystemService(Context.INPUT_METHOD_SERVICE);
			im.hideSoftInputFromWindow(v
					.getApplicationWindowToken(),
					InputMethodManager.HIDE_NOT_ALWAYS,resultReceiver);
//		}
	}
	
    public static void full(Context context, boolean enable)
    {
    	Activity activity = (Activity)context;
        if (enable)
        {
            WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
            lp.flags |= WindowManager.LayoutParams.FLAG_FULLSCREEN;
            activity.getWindow().setAttributes(lp);
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
        else
        {
            WindowManager.LayoutParams attr = activity.getWindow().getAttributes();
            attr.flags &= (~WindowManager.LayoutParams.FLAG_FULLSCREEN);
            activity.getWindow().setAttributes(attr);
            activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
    }
    
    
	public static String getVersionName(Context context) {
		PackageManager packageManager = context.getPackageManager();
		PackageInfo packInfo = null;
		try {
			packInfo = packageManager.getPackageInfo(context
					.getPackageName(), 0);
			return packInfo.versionName;
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public static boolean isWifi(Context context) {
		ConnectivityManager manager = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = manager
				.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
		if (networkInfo != null) {
			State state = networkInfo.getState();
			if (state == State.CONNECTED /* || state == State.CONNECTING */) {

				return true;
			}
		}

		return false;
	}

	public static boolean isNetEnable(Context context) {

		ConnectivityManager manager = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = manager
				.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
		State state = null;
		if (networkInfo != null) {
			state = networkInfo.getState();
			if (state == State.CONNECTED /* || state == State.CONNECTING */) {

				return true;
			}
		}
	//	GenseeLog.d("isNetEnable", "state : " + state);

		return isWifi(context);
	}
}
