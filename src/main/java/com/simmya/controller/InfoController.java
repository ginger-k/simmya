package com.simmya.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simmya.pojo.Info;

@Controller
public class InfoController {	
	
	@RequestMapping(value= "/info/list", method = RequestMethod.GET)
	@ResponseBody
	public List<Info> getTop10Info(@RequestParam(value = "limit", required = true)String limit) {

		return null;
	}

}
