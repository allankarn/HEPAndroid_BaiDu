package com.enetedu.hep.utils;

import android.content.Context;
import android.os.Handler;

import com.enetedu.hep.R;
import com.enetedu.hep.http.RespBase;




public class MessageHandler {
	private static Handler handler;
	public static void initErrMsgHandler(){
		handler = new Handler();
	}
	
	
	
	/** 
	 * description: 根据响应结果的code值来判断是否失败，进行处理
	 * @Title ：handErrMessage 
	 * @param context
	 * @param resp 响应结果解析封装类
	 * @return
	 * @return boolean 返回类型
	 */
	public static boolean handErrMessage(Context context, RespBase resp){
		if(resp == null){
			return true;
		}
		
		int code = resp.getResCode();
		if(code == RespBase.RES_CODE_OK){
			return false;
		}
		return handErrMsg(context,code, resp.getDesc());
	}

	
	
	/** 
	 * description: 各种失败消息的处理
	 * @Title ：handErrMsg 
	 * @param context
	 * @param code 响应状态值
	 * @param msg
	 * @return
	 * @return boolean 返回类型
	 */
	public static boolean handErrMsg(Context context, int code, String msg){
		int resId =  R.string.err_date_respons;
		switch (code) {
		case RespBase.RES_CODE_USER_UNEXIST:
			resId = R.string.err_user_unexist;
			break;
		case RespBase.RES_CODE_PWD_ERR:
			resId = R.string.err_pwd;
			break;
		case RespBase.RES_CODE_ACCOUNT_DISABLED:
			resId = R.string.err_account_disabled;
			break;
		case RespBase.RES_CODE_ACCOUNT_EXPIRED:
			resId = R.string.err_account_expired;
			break;
		case RespBase.RES_CODE_ACCOUNT_UNACTIVE:
			resId = R.string.err_account_unactive;
			break;
		case RespBase.RES_CODE_REGISTER_FAIL:
			resId = R.string.err_register_fail;
			break;
		case RespBase.RES_CODE_USER_DUPLICATE:
			resId = R.string.err_user_duplicate;
			break;
		case RespBase.RES_CODE_UPDATE_FAIL:
			resId = R.string.err_update_fail;
			break;
		case RespBase.RES_CODE_NO_DATA:
			resId = R.string.err_no_data;
			break;
		case RespBase.RES_CODE_REPLY_FAIL:
			resId = R.string.err_reply_fail;
			break;
		case RespBase.RES_CODE_DATA_DUPLICATE:
			resId = R.string.err_data_duplicate;
			break;
		case RespBase.RES_CODE_UPLOAD_FAIL:
			resId = R.string.err_upload_fail;
			break;
		case RespBase.RES_CODE_ERR_NET:
			resId = SystemUtil.isNetEnable(context) ? R.string.err_server_unconnect
					: R.string.err_net_disable;
			break;
		case RespBase.RES_CODE_ERR_CONNECTION:
			resId = R.string.err_server_unconnect;
			break;
		case RespBase.RES_CODE_ERR_CONNECT_TIMEOUT:
			resId = R.string.err_server_connect_timeout;
			break;
		case RespBase.RES_CODE_ERR_DATA_RESP:
			resId = R.string.err_date_respons;
			break;
		case RespBase.RES_CODE_UNKNOWN:
			resId = R.string.err_server;
			break;

		default:
			break;
		}
		if(msg == null || "".equals(msg)){
			msg = context.getString(resId);
		}
		showMsg(context, msg);
		return true;
	}
	
	public static void showMsg(final Context c, final String msg){
		handler.post(new Runnable() {
			
			@Override
			public void run() {
				GenseeToast.showCenter(c, msg, GenseeToast.LENGTH_SHORT);
			}
		});
	}
	
	public static void removeTask(Runnable runnable){
		if(runnable != null){
			handler.removeCallbacks(runnable);
		}
	}
	
	public static void postTaskDelayed(Runnable task, long delayMillis){
		if(task != null){
			handler.postDelayed(task, delayMillis);
		}
	}
}
