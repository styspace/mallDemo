/**
 * Package name:com.stysapce.mallDemo.controller
 * File name:BaseController.java
 * Date:2016年7月21日-下午4:51:50
 * feiniu.com Inc.Copyright (c) 2013-2015 All Rights Reserved.
 *
 */
package com.styspace.mallDemo.controller;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.styspace.mallDemo.constant.ResultCodeConstant;
import com.styspace.mallDemo.constant.ResultDescConstant;
import com.styspace.mallDemo.domain.hibernate.GlobalResult;

/**
 * @ClassName BaseController
 * @Description 控制层基类
 * @date 2016年7月21日 下午4:51:50
 * @author tingyong.song
 * @version 1.0.0
 *
 */
public class BaseController {
	protected Object getResponse(Object result) {
		// 返回json数据
		ResponseBuilder ok = Response.ok((result == null ? new GlobalResult(ResultCodeConstant.NORMAL, ResultDescConstant.NORMAL) : result),
				MediaType.APPLICATION_JSON);
		
		return ok.build();
	}
}
