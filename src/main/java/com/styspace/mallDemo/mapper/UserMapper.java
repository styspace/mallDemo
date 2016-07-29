/**
 * Package name:com.stysapce.mallDemo.mapper
 * File name:MemberMapper.java
 * Date:2016年7月22日-下午4:31:18
 * feiniu.com Inc.Copyright (c) 2013-2015 All Rights Reserved.
 *
 */
package com.styspace.mallDemo.mapper;

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
}
