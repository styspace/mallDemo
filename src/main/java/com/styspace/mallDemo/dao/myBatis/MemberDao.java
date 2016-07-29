/**
 * Package name:com.stysapce.mallDemo.dao.myBatis.member
 * File name:MemberDao.java
 * Date:2016年7月22日-下午4:28:58
 * feiniu.com Inc.Copyright (c) 2013-2015 All Rights Reserved.
 *
 */
package com.styspace.mallDemo.dao.myBatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
}
