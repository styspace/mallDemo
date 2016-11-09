/**
 * Package name:com.styspace.mallDemo.utils
 * File name:Md5ToolsUtils.java
 * Date:2016年9月13日-下午5:16:14
 * feiniu.com Inc.Copyright (c) 2013-2015 All Rights Reserved.
 *
 */
package com.styspace.mallDemo.utils;

import java.security.MessageDigest;

import org.apache.commons.lang3.StringUtils;

/**
 * @ClassName Md5ToolsUtils
 * @Description 
 * @date 2016年9月13日 下午5:16:14
 * @author tingyong.song
 * @version 1.0.0
 *
 */
public class Md5ToolsUtils {
	
	// 定义一个char数组，存储16进制的基本字符，大小写都可，只是觉得最后的结果字段是大写还是小写
	public static char[] hexChar = { '0', '1', '2', '3', '4', '5', '6', '7','8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
	
	public static final String KEY = "deadfsgy12142dfhbdhy5632";
	
	public static String md5(String str) {
		if(StringUtils.isEmpty(str)){
			return null;
		}
		
		StringBuffer stringBuffer = new StringBuffer();
		
		try{
			// java自带的md加密类
			MessageDigest md = MessageDigest.getInstance("MD5");
			
			str = str + KEY;
			md.update(str.getBytes());
			
			byte[] hash = md.digest();
			int tmp;// byte是8位，int是16位
			for (int i = 0; i < hash.length; i++) {
				// 转换成16进制
				tmp = hash[i];
                if (tmp < 0){
                	tmp += 256;
                }
                if (tmp < 16){
                	stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(tmp));
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return stringBuffer.toString();
	}
}
