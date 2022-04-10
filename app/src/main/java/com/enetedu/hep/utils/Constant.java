package com.enetedu.hep.utils;

import android.os.Environment;

import com.tencent.mm.opensdk.openapi.IWXAPI;

import java.io.File;

public interface Constant {
	/**
	 * 3.创建全局的appId 
	 */
	public static final String APP_ID = "wx0e9a703bf4981bd4何莘09:22"; //替换为申请到的app id

	public static
	IWXAPI wx_api = null; //全局的微信api对象
	interface Course {
		int ON_QUERY_LIST_BY_PAGING = 100;
		int ON_QUERY_MICRO_LIST = ON_QUERY_LIST_BY_PAGING + 1;
		
		int ON_SEARCH_LIST_BY_PAGING = 102;
		int ON_SEARCH_MICRO_LIST = ON_SEARCH_LIST_BY_PAGING + 1;
	}

	interface Discipline {
		int ON_DISCIPLINE_LIST = 200;
	}

	interface CommentConstant {
		int ON_COMMENT_REPLAY = 300;
		int ON_COMMENT_GET = 301;
		int ON_COMMENT_QUERY = 302;
	}

	interface DownLoadConstant {
		int DOWNLOAD_PAUSE = 400;
		int DOWNLOAD_SDCARD_ERROR = DOWNLOAD_PAUSE + 1;
		int DOWNLOAD_DATA_ERROR = DOWNLOAD_PAUSE + 2;
		int DOWNLOAD_FINISH = DOWNLOAD_PAUSE + 3;
		int DOWNLOAD_LOADING = DOWNLOAD_PAUSE + 4;
		int SDCARD_NOT_EXIST = DOWNLOAD_PAUSE + 5;
		int SDCARD_NOT_FREE = DOWNLOAD_PAUSE + 6;
		int DOWNLOAD_SHUT_DOWN = DOWNLOAD_PAUSE + 7;
		int DOWNLOAD_DELETE_FILE = DOWNLOAD_PAUSE + 8;
		int DOWNLOAD_NET_ERROR = DOWNLOAD_PAUSE + 9;
		int DOWNLOAD_URL_ERROR = DOWNLOAD_PAUSE + 10;
		int DOWNLOAD_IO_ERROR = DOWNLOAD_PAUSE + 11;
		int DOWNLOAD_TOTAL_SIZE = DOWNLOAD_PAUSE + 12;
	}

	public static final String ACTION_DOWNLOAD_NET_CHANGE = "hep.download.change";
	
	public static final String INTENT_KEY_URL = "key_url";

	public static final String INTENT_KEY_TYPE = "key_type"; // 0: about, 1:
																// function
																// introduce, or
																// edit type
	public static final String INTENT_KEY_TITLE = "key_title";
	public static final String INTENT_KEY_VALUE = "key_value";
	public static final String INTENT_KEY_SETFUN = "key_set_fun";
	public static final String INTENT_KEY_GETFUN = "key_get_fun";
	public static final String INTENT_KEY_LENGTH = "key_length";
	public static final int EDIT_TYPE_BASE = 10;
	public static final int EDIT_TYPE_NICKNAME = EDIT_TYPE_BASE + 1;
	public static final int EDIT_TYPE_FULLNAME = EDIT_TYPE_BASE + 2;
	public static final int EDIT_TYPE_CELLPHONE = EDIT_TYPE_BASE + 3;
	public static final int EDIT_TYPE_SCHOOL = EDIT_TYPE_BASE + 4;
	public static final int EDIT_TYPE_ADDR = EDIT_TYPE_BASE + 5;
	public static final int EDIT_TYPE_SIGNATURE = EDIT_TYPE_BASE + 6;
	public static final int RESP_FAILURE = EDIT_TYPE_BASE + 7;
	public static final int RESP_SEARCH_FAILURE = EDIT_TYPE_BASE + 8;//搜索数据失败或关键字无效
	public static final String DOWN_LOAD_PATH = Environment
			.getExternalStorageDirectory().getAbsolutePath()
			+ File.separator
			+ "HEP" + File.separator + "DownLoad" + File.separator;
	public static final String DOWN_LOAD_TMP_PATH = Environment
			.getExternalStorageDirectory().getAbsolutePath()
			+ File.separator
			+ "HEP" + File.separator + "DownLoad" + File.separator + "tmp" + File.separator;
}
