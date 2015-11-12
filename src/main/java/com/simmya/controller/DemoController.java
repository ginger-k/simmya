package com.simmya.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.simmya.pojo.User;
import com.simmya.service.DemoService;


@Controller
public class DemoController {

	
	@Resource(name = "demoService")
	private DemoService demoService;
	
	@RequestMapping(value= "/demo额额1", method = RequestMethod.POST)
	@ResponseBody
	public User getUser1(@RequestParam(value = "id", required = true)String id) {
		return demoService.getUsers(id);
	}
	
	@RequestMapping(value= "/demo2", method = RequestMethod.GET)
	public ModelAndView getUser2(@RequestParam(value = "id", required = true)String id) {
		ModelAndView mv = new ModelAndView("jsp/demo");
		User user = demoService.getUsers(id);
		mv.addObject("user", user);
		return mv;
	}
}
