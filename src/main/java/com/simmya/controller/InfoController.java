package com.simmya.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simmya.pojo.Info;
import com.simmya.service.impl.InfoService;

@Controller
public class InfoController {	
	
	private static final Logger log = Logger.getLogger(InfoController.class);
	
	@Autowired
	private InfoService infoService;
	
	@RequestMapping(value= "/info/list", method = RequestMethod.GET)
	@ResponseBody
	public List<Info> getTop10InfoOfClickcount(@RequestParam(value = "limit", required = true)String limit) {
		//如果数据好几万，查出来程序中排序，跟order by查询那个快?
		List<Info> list = infoService.selectAll();
		return null;
	}

}
