package com.simmya.controller;

import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simmya.constant.ReturnMap;
import com.simmya.pojo.User;
import com.simmya.service.impl.UserService;


@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value= "/user/login", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> doLogin(@RequestParam(value = "name", required = true)String name, @RequestParam(value = "password", required = true)String password) {
		String token = userService.doLogin(name, password);
		Map<String, Object> map = new HashMap<String, Object>();
		if (token == null) {
			//{code:error,desc:"用户名或密码错误",token:null} 
			map.put("code", "error");
			map.put("desc", "用户名或密码错误");
		} else {
			//{code:sucess,desc:"成功",token:"1341234123423"}
			map.put("code", "sucess");
			map.put("desc", "成功");
		}
		map.put("token", token);
		return map;
	}
	
	@RequestMapping(value= "/user/register", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> doRegister(@RequestParam(value = "name", required = true)String name,
										  @RequestParam(value = "code", required = true)String code,
										  @RequestParam(value = "password", required = true)String password) {
		
		/*
		 * 手机号码是否已经注册
		 * 验证码是否正确
		 * 验证码是否超时？？
		 * 完成注册
		 */
		return null;
	}
	
	@RequestMapping(value= "/user/balance", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getBalance(@RequestHeader(value = "token",required = true)String token) {
		if (StringUtils.isBlank(token)) {
			return ReturnMap.BLANK;
		}
		User loginUser = userService.checkLogin(token);
		if (loginUser == null) {
			return ReturnMap.FAULT;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			map = userService.getBalance(loginUser.getId());
		} catch (Exception e) {
			map.put("balance", null);
		}
		return map;
	}
	
	/*
	 * {'nickName':'xxx','gender':'男','birth':'19800909',
	 * 'zodiac':'虎'，‘profession’:‘计算机应用’,
	 * 'headPic':'www.simmay.com/head.pic'}
	 */
	@RequestMapping(value= "/user/personalInfo", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getInfo(@RequestHeader(value = "token",required = true)String token) throws SQLException {
		if (StringUtils.isBlank(token)) {
			return Collections.emptyMap();
		}
		User loginUser = userService.checkLogin(token);
		if (loginUser == null) {
			return Collections.emptyMap();
		}
		return userService.getInfo(loginUser.getId());
	}

	@RequestMapping(value= "/user/password", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updatePassword(@RequestHeader(value = "token",required = true)String token,
			@RequestParam(value = "password", required = true)String password) throws SQLException {
		if (StringUtils.isBlank(token)) {
			return ReturnMap.BLANK;
		}
		User loginUser = userService.checkLogin(token);
		if (loginUser == null) {
			return ReturnMap.FAULT;
		}
		String md5DigestAsHex = DigestUtils.md5DigestAsHex(password.getBytes());
		loginUser.setPassword(md5DigestAsHex);
		return userService.updatePassword(loginUser);
	}
}