/**
 * Package name:com.stysapce.mallDemo.mapper
 * File name:MemberMapper.java
 * Date:2016年7月22日-下午4:31:18
 * feiniu.com Inc.Copyright (c) 2013-2015 All Rights Reserved.
 *
 */
package com.styspace.mallDemo.mapper;

import java.util.Map;

import com.styspace.mallDemo.domain.myBatis.BindToken;
import com.styspace.mallDemo.domain.myBatis.User;

/**
 * @ClassName MemberMapper
 * @Description 
 * @date 2016年7月22日 下午4:31:18
 * @author tingyong.song
 * @version 1.0.0
 *
 */
public interface UserMapper {
	/**
	 * 注册用户
	 * register
	 * @param user
	 * @return
	 *boolean
	 * @exception
	 * @since  1.0.0
	 */
	public boolean register(User user);
	
	
	/**
	 * 用户名是否存在
	 * isUserExitByUsername
	 * @param user
	 * @return
	 *int
	 * @exception
	 * @since  1.0.0
	 */
	public int isUserExitByUsername(User user);
	
	/**
	 * 用户登录
	 * login
	 * @param param
	 * @return
	 *int
	 * @exception
	 * @since  1.0.0
	 */
	public int login(Map<String, String> param);
	
	/**
	 * 插入新的token信息
	 * insertToken
	 * @param tokenInfo
	 * @return
	 *boolean
	 * @exception
	 * @since  1.0.0
	 */
	public boolean insertToken(BindToken tokenInfo);
	
	/**
	 * 更新token信息
	 * updateToken
	 * @param param
	 * @return
	 *boolean
	 * @exception
	 * @since  1.0.0
	 */
	public boolean updateToken(Map<String, Object> param);
}
