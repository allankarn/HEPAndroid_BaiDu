package com.enetedu.hep.http;


public interface IHEPMSProxy {
	//供演示和正式使用 false 为演示，true为正式   包括演示服务器和界面的控制
	boolean IS_RELEASE = true;

	/**
	 * description: 响应回调接口
	 * @ClassName: OnResp 
	 * @author LKY 
	 *  
	 */
	interface OnResp{
		/**
		 * description: 根据ksoap响应后封装处理后的响应对象进行响应处理
		 * @Title ：onResp 
		 * @param response ksoap响应数据封装处理类
		 * @author LKY
		 * @return void 返回类型 
		 */
		void onResp(RespBase response);
	}
}
