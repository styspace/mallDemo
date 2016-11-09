/**
 * Package name:com.stysapce.mallDemo.constant
 * File name:ResultDescConstant.java
 * Date:2016年7月21日-下午5:01:07
 * feiniu.com Inc.Copyright (c) 2013-2015 All Rights Reserved.
 *
 */
package com.styspace.mallDemo.constant;

/**
 * @ClassName ResultDescConstant
 * @Description 返回数据中状态说明常量定义
 * @date 2016年7月21日 下午5:01:07
 * @author tingyong.song
 * @version 1.0.0
 *
 */
public class ResultDescConstant {
	/**
	 * 状态说明定义
	 */
	public static String OK = "成功";// 成功
	public static String NORMAL = "网络超时，请重试";// 一般性错误
	public static String BADPARAM = "参数错误";// 参数错误
	public static String LOGGINERROR = "用户名或密码错误";// 登录错误
	public static String NULLTOKEN = "token为空";// 参数token为空
	public static String USERNAMEEXIT = "用户已存在";// 用户已存在
	public static String ILLEGALCHAR = "包含非法字符";// 参数包含非法字符
}
