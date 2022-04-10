package com.enetedu.hep.http;


import org.ksoap2.serialization.SoapObject;

import java.io.Serializable;

/**
 * description: 请求数据基类
 * @ClassName: ReqBase 
 * @author LYJ
 *  
 */
public abstract class ReqBase implements Serializable {
	public static final String ENDPOINT_ANDROID = "android";
	public static final String ENDPOINT_IPAD = "iPad";
	public static final String ENDPOINT_IPHONE = "iPhone";
	public static final String ENDPOINT_WINAPP = "WinApp";
	
	private int timeOut = 6000;//默认6秒超时
	
	/**
	 * description: Ksop访问webService接口方法需要的参数封装
	 * @Title ：addProperty 
	 * @param soapObject 
	 * @author LKY
	 * @return void 返回类型 
	 */
	public abstract void addProperty(SoapObject soapObject);
	
	/** 
	 * description: 获取要调用的webService接口方法名，子类进行实现
	 * @Title ：getMethodName 
	 * @return
	 * @author LKY
	 * @return String 返回类型 
	 */
	public abstract String getMethodName();
	
	protected boolean  isValid() {
		return false;
	}
	
	public String strCheckNull(String source) {
		if (source == null) {
			return "";
		}
		return source;
	}
	
	public int getTimeOut() {
		return timeOut;
	}
	
	public void setTimeOut(int timeOut) {
		this.timeOut = timeOut;
	}

}
