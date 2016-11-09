/**
 * Package name:com.stysapce.mallDemo.controller
 * File name:MemberController.java
 * Date:2016年7月21日-下午5:07:50
 * feiniu.com Inc.Copyright (c) 2013-2015 All Rights Reserved.
 *
 */
package com.styspace.mallDemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.styspace.mallDemo.controller.BaseController;
import com.styspace.mallDemo.service.interfaces.MemberService;

/**
 * @ClassName MemberController
 * @Description 
 * @date 2016年7月21日 下午5:07:50
 * @author tingyong.song
 * @version 1.0.0
 *
 */
@Controller
@RequestMapping("/member")
public class MemberController extends BaseController {
	private static final Logger LOGGER = LoggerFactory.getLogger(MemberController.class);
	@Autowired
	private MemberService memberService;
	
	/**
	 * Controller层  用户注册
	 * register
	 * @param data
	 * @return
	 *Object
	 * @exception
	 * @since  1.0.0
	 */
	@RequestMapping(value="/register", method=RequestMethod.POST)
	@ResponseBody
	public Object register(@RequestParam("data") String data) {
		LOGGER.info(data);
		Object result = memberService.register(data);
		return getResponse(result);
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	@ResponseBody
	public Object login(@RequestParam("data") String data){
		LOGGER.info(data);
		Object result = memberService.login(data);
		return getResponse(result);
	}
}
