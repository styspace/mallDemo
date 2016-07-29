/**
 * Package name:com.stysapce.mallDemo.domain
 * File name:BaseDomain.java
 * Date:2016年7月21日-下午3:32:09
 * feiniu.com Inc.Copyright (c) 2013-2015 All Rights Reserved.
 *
 */
package com.styspace.mallDemo.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @ClassName BaseDomain
 * @Description POJO基类
 * @date 2016年7月21日 下午3:32:09
 * @author tingyong.song
 * @version 1.0.0
 *
 */
public class BaseDomain {
	
	public String toString(){
		// ToStringBuilder必须要引入commons-lang.jar，如果一个项目中pojo类很多，每个pojo类都用简单的"+"重写toString会导致性能问题，很占用内存
		return ToStringBuilder.reflectionToString(this);
	}
}
