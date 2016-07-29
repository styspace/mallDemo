/**
 * Package name:com.stysapce.mallDemo.domain
 * File name:User.java
 * Date:2016年7月21日-下午3:40:30
 * feiniu.com Inc.Copyright (c) 2013-2015 All Rights Reserved.
 *
 */
package com.styspace.mallDemo.domain.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.styspace.mallDemo.domain.BaseDomain;


/**
 * @ClassName User
 * @Description 
 * @date 2016年7月21日 下午3:40:30
 * @author tingyong.song
 * @version 1.0.0
 *
 */
// @Entity表示这个类在数据库中有映射，需要引入ejb3-persistence包
@Entity(name="user")
public class User extends BaseDomain {
	@Id//主键
	@GeneratedValue(strategy = GenerationType.IDENTITY)//主键由数据库自动生成（主要是自动增长型） 
	@Column(name="userId")
	private int uId;
	
//	@
}
