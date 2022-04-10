package com.enetedu.hep.http;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/** 
 * description: 所有响应结果操作的基类，公共操作封装
 * @ClassName: RespBase 
 * @author LYJ
 *  
 */@SuppressWarnings("unused")
public class RespBase {

	//服务端响应的状态值常量
	public static final int RES_CODE_OK = 0;
	public static final int RES_CODE_LOST_PARAM = -10000;// 输入参数不全
	public static final int RES_CODE_USER_UNEXIST = -10001;// 无此用户
	public static final int RES_CODE_PWD_ERR = -10002;// 密码错误
	public static final int RES_CODE_ACCOUNT_DISABLED = -10003;// 账号停用
	public static final int RES_CODE_ACCOUNT_EXPIRED = -10004;// 账号过期
	public static final int RES_CODE_ACCOUNT_UNACTIVE = -10005;// 账号未激活
	public static final int RES_CODE_REGISTER_FAIL = -10006;// 注册失败
	public static final int RES_CODE_USER_DUPLICATE = -10007;// 用户重复

	public static final int RES_CODE_NULL_COURSE = -10008;// 获取成功无课程
	public static final int RES_CODE_NULL_EVENT = -10003;// 获取成功无活动

	public static final int RES_CODE_UPDATE_FAIL = -10009;// 修改失败
	public static final int RES_CODE_TOKEN_DISABLED = -10010;// 用户令牌过期
	public static final int RES_CODE_AUTHORIZE_FAIL = -10011;// 鉴权失败
	public static final int RES_CODE_AUTHORIZE_DEC_ERR = -10012;// 鉴权码解密错误
	public static final int RES_CODE_AUTHORIZE_PWD_NULL = -10013;// 鉴权码未输入(空输入)
	public static final int RES_CODE_LIST_OK = -10020;// 列表成功
	public static final int RES_CODE_LIST_FAIL = -10021;// 列表失败
	public static final int RES_CODE_NO_DATA = -10022;// 无数据
	public static final int RES_CODE_REPLY_FAIL = -10031;// 回复失败
	public static final int RES_CODE_DATA_DUPLICATE = -10032;// 数据重复
	public static final int RES_CODE_UPLOAD_FAIL = -10041;// 传送文件失败
	public static final int RES_CODE_FILE_STREAM_NULL = -10042;// 文件流为空
	public static final int RES_CODE_FILE_WRITE_FAIL = -10043;// 文件写入失败
	public static final int RES_CODE_FILE_DUPLICATE = -10044;// 文件重复
	public static final int RES_CODE_UN_UPGRADE = -20001;// 无更新
	public static final int RES_CODE_UPGRADE = -20002;// 有更新
	public static final int RES_CODE_UNKNOWN = -99999;// 其它错误

	public static final int RES_CODE_ERR_NET = RES_CODE_UNKNOWN + 1;;

	public static final int RES_CODE_ERR_CONNECTION = RES_CODE_UNKNOWN + 2;

	public static final int RES_CODE_ERR_DATA_RESP = RES_CODE_UNKNOWN + 3;
	public static final int RES_CODE_ERR_CONNECT_TIMEOUT = RES_CODE_UNKNOWN + 4;
	private static final String TAG = "RespBase";

	protected static final String KEY_CODE = "Code";
	protected static final String KEY_DESC = "Desc";
	protected static final String KEY_MSG = "Message";
	protected static final String KEY_DATA_COUNT = "DataRecordsCount";
	protected static final String KEY_USERTOKEN = "token";

	private int resCode = RES_CODE_UNKNOWN;
	private String desc = "";
	private String msg = "";
	public int DataRecordsCount = 0;
	public int getResCode() {
		return resCode;
	}

	public void setResCode(int resCode) {
		this.resCode = resCode;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	
	
	public String getMsg() {
		return msg==null?"":this.msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	
	/** 
	 * description: 响应数据的处理，默认转换成json对象
	 * @Title ：onResp 
	 * @param result
	 * @author LKY
	 * @return void 返回类型 
	 */
	public void onResp(String result) {
		converToJson(result);
	}

	public Object getData() {
		return null;
	}

	@Override
	public String toString() {
		return "RespBase [resCode=" + resCode + ", desc=" + desc + ", msg="
				+ msg + "]";
	}

	/*********************************************/

	protected void getRecordCount(JSONObject jsonObject) {
	}

	protected void parseCommon(JSONObject jsonObject) {
		if (jsonObject == null) {
//			GenseeLog.e(TAG, "parseCommon jsonObject is null!");
		}
		resCode = getJSONInt(jsonObject, KEY_CODE, RES_CODE_UNKNOWN);
		desc = getJsonString(jsonObject, KEY_DESC, "");
		msg = getJsonString(jsonObject, KEY_MSG, "");
//		msg = getJsonString(jsonObject, KEY_MSG, "");
		getRecordCount(jsonObject);
	}

	public static int getJSONInt(JSONObject jsonObject, String name, int def) {
		if (jsonObject == null || !jsonObject.has(name)) {
			return def;
		}
		try {
			return jsonObject.getInt(name);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return def;
	}

	
	/** 
	 * description: 字符串转换成json对象
	 * @Title ：converToJson 
	 * @param info
	 * @return
	 * @author LKY
	 * @return JSONObject 返回类型 
	 */
	protected JSONObject converToJson(String info) {
		if (info == null) {
			return null;
		}
		JSONObject jsonObject = null;
		try {
			jsonObject = new JSONObject(info.toString());
			parseCommon(jsonObject);
		} catch (JSONException e) {
//			GenseeLog.e(e);
		}
		return jsonObject; 
	}

	public static JSONObject getJSONObj(JSONObject source, String name) {
		if (source != null) {
			try {
				return source.getJSONObject(name);
			} catch (JSONException e) {
//				GenseeLog.e("getJSONObj " + e.toString());
			}
		}
		return null;
	}

	public static JSONObject getJSONObj(JSONArray array, int idx) {
		if (array != null) {
			try {
				return array.getJSONObject(idx);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static JSONArray getArray(JSONObject jsonObject, String name) {
		try {
			return jsonObject.getJSONArray(name);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 从json中取得name对应的 string value
	 * 
	 * @param jsonObject
	 *            jsonobj
	 * @param name
	 *            tagname
	 * @param def
	 * @return value
	 */
	public static String getJsonString(JSONObject jsonObject, String name, String def) {

		if (jsonObject == null || !jsonObject.has(name)) {
			return def;
		}
		try {
			return jsonObject.getString(name);
		} catch (JSONException e) {
			if (!"data".equals(name)) {
//				GenseeLog.i("getJsonString name = " + name);
//				GenseeLog.e(e);
			}
		}
		return def;
	}

	public static JSONObject getJsonObj(JSONArray jsonArray, int i) {

		try {
			return (JSONObject) jsonArray.get(i);
		} catch (JSONException e) {
//			GenseeLog.d("getJsonObj", e.toString());
		}
		return null;
	}

	public static JSONArray getJsonArray(String data) {
		JSONArray array = null;
		try {
			array = new JSONArray(data);
		} catch (JSONException e) {
//			GenseeLog.e(e);
		}
		return array;
	}

	/**
	 * 从json中取出name对应的long型value
	 * 
	 * @param jsonObject
	 *            jsonobj
	 * @param name
	 *            tagname
	 * @return long型value
	 */
	public static long getJsonLong(JSONObject jsonObject, String name, long def) {
		if (jsonObject == null || !jsonObject.has(name)) {
			return def;
		}
		try {
			return jsonObject.getLong(name);
		} catch (JSONException e) {
//			GenseeLog.e(e);
		}
		return def;
	}

	public static <T> T fromJson(String value, Class<T> class1) {
		T response = null;
		if (value == null) {
			return response;
		}
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.create();
		return gson.fromJson(value, class1);
	}
}
