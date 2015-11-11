package com.simmya.service;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.simmya.mapper.UserMapper;
import com.simmya.pojo.User;

@Service
public class DemoService {

	@Resource(name = "userMapper")
	private UserMapper demorMapper;
	
	
	public User getUsers(String id) {
		return demorMapper.selectByPrimaryKey(id);
	}
}
