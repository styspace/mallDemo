/**
 * Package name:com.stysapce.mallDemo.domain.myBaits
 * File name:User.java
 * Date:2016年7月22日-下午4:39:14
 * feiniu.com Inc.Copyright (c) 2013-2015 All Rights Reserved.
 *
 */
package com.styspace.mallDemo.domain.myBatis;

import java.sql.Timestamp;

import com.styspace.mallDemo.domain.BaseDomain;

/**
 * @ClassName User
 * @Description 
 * @date 2016年7月22日 下午4:39:14
 * @author tingyong.song
 * @version 1.0.0
 *
 */
public class User extends BaseDomain {
	private int userId;// 用户id
	private String userName;// 用户名
	private String password;// 密码
	private String cellPhone;// 手机
	private String email;// 邮箱
	private int isVIP;// 是否是vip 0：不是 1：是
	private Timestamp cTime;// 注册时间
	private Timestamp mTime;// 修改时间
	private Timestamp lastLogin;// 最后登录时间
	
	public User() {
		
	}
	
	public User(String userName, String password, String cellPhone, String email, int isVIP){
		this.userName = userName;
		this.password = password;
		this.cellPhone = cellPhone;
		this.email = email;
		this.isVIP = isVIP;
	}
	
	public User(String userName, String password, String cellPhone, String email, int isVIP, Timestamp cTime, Timestamp mTime, Timestamp lastLogin ){
		this.userName = userName;
		this.password = password;
		this.cellPhone = cellPhone;
		this.email = email;
		this.isVIP = isVIP;
		this.cTime = cTime;
		this.mTime = mTime;
		this.lastLogin = lastLogin;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCellPhone() {
		return cellPhone;
	}
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getIsVIP() {
		return isVIP;
	}
	public void setIsVIP(int isVIP) {
		this.isVIP = isVIP;
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
	public Timestamp getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}
}
