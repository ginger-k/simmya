package com.simmya.service.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import com.simmya.pojo.User;
import com.simmya.service.BaseService;

@Service
public class UserService extends BaseService<User>{

	public User checkLogin(String token) {
		User where = new User();
		where.setToken(token);
		return super.selectOneByWhere(where);
	}

	@Transactional
	public String doLogin(String name, String password) {
		User where = new User();
		where.setUsername(name);
		String md5DigestAsHex = DigestUtils.md5DigestAsHex(password.getBytes());
		where.setPassword(password);
		User user = super.selectOneByWhere(where);
		if (user == null)
			return null;
		String token = UUID.randomUUID().toString().replace("-", "");
		user.setToken(token);
		super.updateSelective(user);
		return token;
	}
	
}
