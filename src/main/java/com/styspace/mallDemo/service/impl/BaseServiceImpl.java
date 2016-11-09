/**
 * Package name:com.stysapce.mallDemo.service.impl
 * File name:BaseServiceImpl.java
 * Date:2016年7月26日-上午10:48:36
 * feiniu.com Inc.Copyright (c) 2013-2015 All Rights Reserved.
 *
 */
package com.styspace.mallDemo.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.styspace.mallDemo.pojo.ReponseResult;
import com.styspace.mallDemo.utils.Md5ToolsUtils;

/**
 * @ClassName BaseServiceImpl
 * @Description 
 * @date 2016年7月26日 上午10:48:36
 * @author tingyong.song
 * @version 1.0.0
 *
 */
@Service
public class BaseServiceImpl {
	
	/**
	 * 构造返回结果结构
	 * returnObjInfo
	 * @param errorCode 状态码
	 * @param errorDesc 描述信息
	 * @param body 返回结果
	 * @param start 开始时间
	 * @param end 返回时间
	 * @return
	 *Object
	 * @exception
	 * @since  1.0.0
	 */
	public Object returnObjInfo(int errorCode, String errorDesc, Object body, long start, long end) {
		if(body == null){
			body = new JSONObject();
		}
		if(StringUtils.isEmpty(errorDesc)){
			errorDesc = "";
		}
		Object result = new ReponseResult(end - start, errorCode, errorDesc, body);
		return result;
	}
	
	public String createToken(String token, String username, String password) {
		long time = System.currentTimeMillis();
		String seed = time + username + token;
		return Md5ToolsUtils.md5(seed);
	}
}
