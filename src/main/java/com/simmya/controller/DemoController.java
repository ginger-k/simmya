package com.simmya.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.simmya.pojo.User;
import com.simmya.service.impl.UserService;


@Controller
public class DemoController {

	@Autowired
	private UserService us;
	
	@RequestMapping(value= "/demo额额1", method = RequestMethod.POST)
	@ResponseBody
	public User getUser1(@RequestParam(value = "id", required = true)String id) {
		return us.selectByPrimaryKey(id);
	}
	
	@RequestMapping(value= "/demo2", method = RequestMethod.GET)
	public ModelAndView getUser2(@RequestParam(value = "id", required = true)String id) {
		ModelAndView mv = new ModelAndView("jsp/demo");
		User user = us.selectByPrimaryKey(id);
		mv.addObject("user", user);
		return mv;
	}
}
