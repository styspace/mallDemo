/**
 * Package name:com.styspace.mallDemo.domain.myBatis
 * File name:BindToken.java
 * Date:2016年9月13日-下午6:54:48
 * feiniu.com Inc.Copyright (c) 2013-2015 All Rights Reserved.
 *
 */
package com.styspace.mallDemo.domain.myBatis;

import java.sql.Timestamp;

import com.styspace.mallDemo.domain.BaseDomain;

/**
 * @ClassName BindToken
 * @Description 
 * @date 2016年9月13日 下午6:54:48
 * @author tingyong.song
 * @version 1.0.0
 *
 */
public class BindToken extends BaseDomain {
	private int id;// 主键id
	private String token;// 用户生成token
	private int isLogin;// 是否登录
	private Timestamp lastLoginTime;// 最近一次登录时间
	private Timestamp cTime;// 创建时间
	private Timestamp mTime;// 最近修改时间
	
	public BindToken(){
		
	}
	
	public BindToken(String token, int isLogin, Timestamp lastLoginTime, Timestamp cTime, Timestamp mTime){
		this.token = token;
		this.isLogin = isLogin;
		this.lastLoginTime = lastLoginTime;
		this.cTime = cTime;
		this.mTime = mTime;
	}
	
	public BindToken(String token, int isLogin, Timestamp lastLoginTime, Timestamp mTime){
		this.token = token;
		this.isLogin = isLogin;
		this.lastLoginTime = lastLoginTime;
		this.mTime = mTime;
	}
	
	public BindToken(String token, int isLogin, Timestamp mTime){
		this.token = token;
		this.isLogin = isLogin;
		this.mTime = mTime;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public int getIsLogin() {
		return isLogin;
	}
	public void setIsLogin(int isLogin) {
		this.isLogin = isLogin;
	}
	public Timestamp getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Timestamp lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public Timestamp getcTime() {
		return cTime;
	}
	public void setcTime(Timestamp cTime) {
		this.cTime = cTime;
	}
	public Timestamp getmTime() {
		return mTime;
	}
	public void setmTime(Timestamp mTime) {
		this.mTime = mTime;
	}
}
