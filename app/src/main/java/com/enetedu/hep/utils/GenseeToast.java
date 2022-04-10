package com.enetedu.hep.utils;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.enetedu.hep.R;

public class GenseeToast extends Toast {

	private static GenseeToast result;

	public GenseeToast(Context context) {
		super(context);
	}

	public static GenseeToast makeNotification(Context context, CharSequence text, int duration) {
		if(result==null){
			result = new GenseeToast(context);
		}
		LayoutInflater inflate = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View v = inflate.inflate(R.layout.notification_layout, null);
		
		TextView tv = (TextView) v.findViewById(R.id.message);
		tv.setText(text);
		result.setDuration(duration);
		result.setView(v);
		return result;
	}

	public static GenseeToast showLogin(Context context, CharSequence text,
                                        int duration) {
		GenseeToast toast = makeNotification(context, text, duration);
		toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.TOP, 0, 50);
		toast.show();
		return toast;
	}

	public static GenseeToast showLogin(Context context, int resId, int duration) {
		String text = context.getString(resId);
		return showLogin(context, text, duration);
	}

	public static GenseeToast showCenter(Context context, CharSequence text,
                                         int duration) {
		GenseeToast toast = makeNotification(context, text, duration);
		toast.setGravity(Gravity.CENTER, 0, 0);
		toast.show();
		return toast;
	}

	public static GenseeToast showCenter(Context context, int resId,
                                         int duration) {
		String text = context.getString(resId);
		return showCenter(context, text, duration);
	}
	
	public static void hideToast(){
		if(result!=null){
			result.cancel();
		}
	}

}
