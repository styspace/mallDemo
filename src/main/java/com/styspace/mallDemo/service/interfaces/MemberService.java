/**
 * Package name:com.stysapce.mallDemo.service.interfaces.member
 * File name:MemberService.java
 * Date:2016年7月21日-下午6:52:24
 * feiniu.com Inc.Copyright (c) 2013-2015 All Rights Reserved.
 *
 */
package com.styspace.mallDemo.service.interfaces;

/**
 * @ClassName MemberService
 * @Description 
 * @date 2016年7月21日 下午6:52:24
 * @author tingyong.song
 * @version 1.0.0
 *
 */
public interface MemberService {
	/**
	 * 注册用户
	 * register
	 * @param data
	 * @return
	 *Object
	 * @exception
	 * @since  1.0.0
	 */
	public Object register(String data);
	
	/**
	 * 用户登录
	 * login
	 * @param data
	 * @return
	 *Object
	 * @exception
	 * @since  1.0.0
	 */
	public Object login(String data);
}
