/**
 * Package name:com.stysapce.mallDemo.dao.myBatis.member
 * File name:MemberDao.java
 * Date:2016年7月22日-下午4:28:58
 * feiniu.com Inc.Copyright (c) 2013-2015 All Rights Reserved.
 *
 */
package com.styspace.mallDemo.dao.myBatis;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.styspace.mallDemo.domain.myBatis.BindToken;
import com.styspace.mallDemo.domain.myBatis.User;
import com.styspace.mallDemo.mapper.UserMapper;

/**
 * @ClassName MemberDao
 * @Description 
 * @date 2016年7月22日 下午4:28:58
 * @author tingyong.song
 * @version 1.0.0
 *
 */
@Repository
public class MemberDao {
	@Autowired
	private UserMapper userMapper;
	
	/**
	 * DAO层 注册用户
	 * register
	 * @param user
	 * @return
	 *boolean
	 * @exception
	 * @since  1.0.0
	 */
	public boolean register(User user) {
		return userMapper.register(user);
	}
	
	/**
	 * 判断用户是否已存在
	 * isUserExitByUsername
	 * @param user
	 * @return
	 *int
	 * @exception
	 * @since  1.0.0
	 */
	public int isUserExitByUsername(User user) {
		return userMapper.isUserExitByUsername(user);
	}
	
	/**
	 * DAO层 登录用户
	 * login
	 * @param username
	 * @param password
	 * @return
	 *int
	 * @exception
	 * @since  1.0.0
	 */
	public int login(String username, String password) {
		Map<String, String> param = new HashMap<String, String>();
		param.put("username", username);
		param.put("password", password);
		return userMapper.login(param);
	}
	
	/**
	 * 插入新的token信息
	 * insertToken
	 * @param tokenInfo
	 * @return
	 *boolean
	 * @exception
	 * @since  1.0.0
	 */
	public boolean insertToken(BindToken tokenInfo) {
		return userMapper.insertToken(tokenInfo);
	}
	
	/**
	 * 更新新的token值
	 * updateToken
	 * @param newToken
	 * @param token
	 * @return
	 *boolean
	 * @exception
	 * @since  1.0.0
	 */
	public boolean updateToken(String newToken, String token) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("newToken", newToken);
		param.put("token", token);
		long curTime = System.currentTimeMillis();
		param.put("lastLoginTime", new Timestamp(curTime));
		param.put("mtime", new Timestamp(curTime));
		return userMapper.updateToken(param);
	}
}
