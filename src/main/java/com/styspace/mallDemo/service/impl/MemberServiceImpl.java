/**
 * Package name:com.stysapce.mallDemo.service.impl.member
 * File name:MemberServiceImpl.java
 * Date:2016年7月22日-下午4:25:32
 * feiniu.com Inc.Copyright (c) 2013-2015 All Rights Reserved.
 *
 */
package com.styspace.mallDemo.service.impl;

import java.sql.Timestamp;
import java.util.regex.Pattern;

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
import com.styspace.mallDemo.domain.myBatis.BindToken;
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
		String token = jsonData.getString("token");//由前端随机生成的token，注册成功之后内部接口返回新的token
		JSONObject reqData = jsonData.getJSONObject("body");
		// 入参
		String username = reqData.getString("username");
		String password = reqData.getString("password");
		String cellphone = reqData.getString("cellphone");
		String email = reqData.getString("email");
		int isVIP = reqData.getIntValue("isVIP");
		
		if(StringUtils.isEmpty(token)){
			return returnObjInfo(ResultCodeConstant.NORMAL, ResultDescConstant.NULLTOKEN, null, start, System.currentTimeMillis());
		}
		
		if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password) || StringUtils.isEmpty(cellphone)){
			return returnObjInfo(ResultCodeConstant.NORMAL, ResultDescConstant.BADPARAM, null, start, System.currentTimeMillis());
		}
		
		long curTime = System.currentTimeMillis();
		User user = new User(username, password, cellphone, email, isVIP, new Timestamp(curTime), new Timestamp(curTime), new Timestamp(curTime));
		
		// 返回数据
		JSONObject result = new JSONObject();
		Logger.info(user.toString());
		
		// 判断username是否有重复
		int isExit = memberDao.isUserExitByUsername(user);
		if(isExit == 1){
			return returnObjInfo(ResultCodeConstant.NORMAL, ResultDescConstant.USERNAMEEXIT, null, start, System.currentTimeMillis());
		}
		
		// 生成token
		String newToken = createToken(token, username, password);
		if(StringUtils.isEmpty(newToken)){
			return returnObjInfo(ResultCodeConstant.NORMAL, ResultDescConstant.NORMAL, null, start, System.currentTimeMillis());
		}
		
		boolean isSuccess = memberDao.register(user);
		result.put("isSuccess", isSuccess);
		
		// 插入数据，token数据库
		BindToken tokenInfo = new BindToken(newToken, 1, new Timestamp(curTime), new Timestamp(curTime), new Timestamp(curTime));
		memberDao.insertToken(tokenInfo);
		
		result.put("token", newToken);
		
		// 返回
		return returnObjInfo(ResultCodeConstant.OK, "", result, start, System.currentTimeMillis());
	}


	@Override
	public Object login(String data) {
		long start = System.currentTimeMillis();
		
		JSONObject jsonData = JSON.parseObject(data);
		String token = jsonData.getString("token");
		JSONObject reqData = jsonData.getJSONObject("body");
		// 入参
		String username = reqData.getString("username");
		String password = reqData.getString("password");

		if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
			return returnObjInfo(ResultCodeConstant.NORMAL, ResultDescConstant.BADPARAM, null, start, System.currentTimeMillis());
		}
		
		// 格式判断

		
		// 查找数据库
		int canLogin = memberDao.login(username, password);
		if(canLogin < 1){
			return returnObjInfo(ResultCodeConstant.NORMAL, ResultDescConstant.LOGGINERROR, null, start, System.currentTimeMillis());
		}else{
			// 返回数据
			JSONObject result = new JSONObject();
			result.put("msg", "登录成功");
			
			// 生成新的token
			String newToken = createToken(token, username, password);
			if(StringUtils.isEmpty(newToken)){
				return returnObjInfo(ResultCodeConstant.NORMAL, ResultDescConstant.NORMAL, null, start, System.currentTimeMillis());
			}
			
			// 更新token数据库
			memberDao.updateToken(newToken, token);
			result.put("token", newToken);
			
			return returnObjInfo(ResultCodeConstant.OK, "", result, start, System.currentTimeMillis());
		}
	}
	
}
