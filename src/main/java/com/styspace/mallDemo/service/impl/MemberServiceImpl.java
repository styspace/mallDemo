/**
 * Package name:com.stysapce.mallDemo.service.impl.member
 * File name:MemberServiceImpl.java
 * Date:2016年7月22日-下午4:25:32
 * feiniu.com Inc.Copyright (c) 2013-2015 All Rights Reserved.
 *
 */
package com.styspace.mallDemo.service.impl;

import java.sql.Timestamp;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.styspace.mallDemo.constant.ResultCodeConstant;
import com.styspace.mallDemo.constant.ResultDescConstant;
import com.styspace.mallDemo.dao.myBatis.MemberDao;
import com.styspace.mallDemo.domain.myBatis.User;
import com.styspace.mallDemo.service.interfaces.MemberService;

/**
 * @ClassName MemberServiceImpl
 * @Description 
 * @date 2016年7月22日 下午4:25:32
 * @author tingyong.song
 * @version 1.0.0
 *
 */
@Service
public class MemberServiceImpl extends BaseServiceImpl implements MemberService {
	private static final Logger Logger = LoggerFactory.getLogger(MemberServiceImpl.class);
	@Autowired
	private MemberDao memberDao;
	

	/* (non-Javadoc)
	 * @see com.stysapce.mallDemo.service.interfaces.member.MemberService#register(java.lang.String)
	 */
	@Override
	public Object register(String data) {
		long start = System.currentTimeMillis();
		
		JSONObject jsonData = JSON.parseObject(data);
		JSONObject reqData = jsonData.getJSONObject("body");
		// 入参
		String username = reqData.getString("username");
		String password = reqData.getString("password");
		String cellphone = reqData.getString("cellphone");
		String email = reqData.getString("email");
		int isVIP = reqData.getIntValue("isVIP");
		
		if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password) || StringUtils.isEmpty(cellphone)){
			return returnObjInfo(ResultCodeConstant.NORMAL, ResultDescConstant.BADPARAM, null, start, System.currentTimeMillis());
		}
		
		long curTime = System.currentTimeMillis();
		User user = new User(username, password, cellphone, email, isVIP, new Timestamp(curTime), new Timestamp(curTime), new Timestamp(curTime));
		
		// 返回数据
		JSONObject result = new JSONObject();
		Logger.info(user.toString());
		boolean isSuccess = memberDao.register(user);
		result.put("isSuccess", isSuccess);
		// 返回
		return returnObjInfo(ResultCodeConstant.OK, "", result, start, System.currentTimeMillis());
	}

}
