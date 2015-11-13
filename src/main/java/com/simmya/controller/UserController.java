package com.simmya.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
		
		
		return null;
	}
	
	
}
